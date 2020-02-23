package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderReceiptTest {
    private final String DAY_IS_NOT_WEDNESDAY = "2020-02-18";
    private final String DAY_IS_WEDNESDAY = "2020-02-19";

    @Test
    public void should_print_line_item_and_sales_tax_information_when_is_not_wednesday() {
        List<OrderItem> orderItems = new ArrayList<OrderItem>() {{
            add(new OrderItem("milk", 10.0, 2));
            add(new OrderItem("biscuits", 5.0, 5));
            add(new OrderItem("chocolate", 20.0, 1));
        }};
        String expectedOutput = "===== 老王超市，值得信赖 ======\n" +
                "\n" +
                "2020年2月18日，星期二\n" +
                "\n" +
                "milk, 10.00 x 2, 20.00\n" +
                "biscuits, 5.00 x 5, 25.00\n" +
                "chocolate, 20.00 x 1, 20.00\n" +
                "-----------------------------------\n" +
                "税额: 6.50\n" +
                "总价: 71.50\n";
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, orderItems, LocalDate.parse(DAY_IS_NOT_WEDNESDAY)));
        String output = receipt.printReceipt();

        assertEquals(expectedOutput, output);
    }

    @Test
    public void should_print_line_item_and_sales_tax_and_discount_information_when_is_wednesday() {
        List<OrderItem> orderItems = new ArrayList<OrderItem>() {{
            add(new OrderItem("milk", 10.0, 2));
            add(new OrderItem("biscuits", 5.0, 5));
            add(new OrderItem("chocolate", 20.0, 1));
        }};
        String expectedOutput = "===== 老王超市，值得信赖 ======\n" +
                "\n" +
                "2020年2月19日，星期三\n" +
                "\n" +
                "milk, 10.00 x 2, 20.00\n" +
                "biscuits, 5.00 x 5, 25.00\n" +
                "chocolate, 20.00 x 1, 20.00\n" +
                "-----------------------------------\n" +
                "税额: 6.50\n" +
                "折扣: 1.43\n" +
                "总价: 70.07\n";
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, orderItems, LocalDate.parse(DAY_IS_WEDNESDAY)));
        String output = receipt.printReceipt();

        assertEquals(expectedOutput, output);
    }
}