package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    private final String DAY_IS_NOT_WEDNESDAY = "2020-02-18";
    private final String DAY_IS_WEDNESDAY = "2020-02-19";

    @Test
    public void should_print_line_item_and_sales_tax_information_when_is_not_wednesday() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems),
                LocalDate.parse(DAY_IS_NOT_WEDNESDAY));
        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年2月18日，星期二"));
        assertThat(output, containsString("milk, 10.00 x 2, 20.00"));
        assertThat(output, containsString("biscuits, 5.00 x 5, 25.00"));
        assertThat(output, containsString("chocolate, 20.00 x 1, 20.00"));
        assertThat(output, containsString("税额: 6.50"));
        assertThat(output, containsString("总价: 71.50"));
    }

    @Test
    public void should_print_line_item_and_sales_tax_and_discount_information_when_is_wednesday() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems),
                LocalDate.parse(DAY_IS_WEDNESDAY));
        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年2月19日，星期三"));
        assertThat(output, containsString("milk, 10.00 x 2, 20.00"));
        assertThat(output, containsString("biscuits, 5.00 x 5, 25.00"));
        assertThat(output, containsString("chocolate, 20.00 x 1, 20.00"));
        assertThat(output, containsString("税额: 6.50"));
        assertThat(output, containsString("折扣: 1.43"));
        assertThat(output, containsString("总价: 70.07"));
    }
}