package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private LocalDate date;
    private final double WED_DISCOUNT_PERCENT = 0.98;

    public OrderReceipt(Order order, LocalDate date) {
        this.order = order;
        this.date = date;
    }

    public String printReceipt() {
        return getReceiptHeader() +
                getReceiptBody() +
                getReceiptFooter();
    }

    private String getReceiptHeader() {
        return "===== 老王超市，值得信赖 ======\n";
    }

    private String getReceiptBody() {
        StringBuilder body = new StringBuilder();
        String bodyTemplate = "%s, %.2f x %d, %.2f\n";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月dd日，E", Locale.CHINESE);

        body.append(String.format("\n%s\n\n", date.format(formatter)));
        for (LineItem lineItem : order.getLineItems()) {
            body.append(String.format(bodyTemplate,
                    lineItem.getDescription(),
                    lineItem.getPrice(),
                    lineItem.getQuantity(),
                    lineItem.getTotalAmount()));
        }
        body.append("-----------------------------------\n");

        return body.toString();
    }

    private String getReceiptFooter() {
        StringBuilder footer = new StringBuilder();
        String footerTemplate = "%s: %.2f\n";
        double salesTax = order.getSalesTax();
        double totalAmount = order.getTotalAmount();
        double discount = 0d;

        footer.append(String.format(footerTemplate, "税额", salesTax));
        if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            discount = totalAmount * (1.0 - WED_DISCOUNT_PERCENT);

            footer.append(String.format(footerTemplate, "折扣", discount));
        }
        footer.append(String.format(footerTemplate, "总价", totalAmount - discount));

        return footer.toString();
    }
}
