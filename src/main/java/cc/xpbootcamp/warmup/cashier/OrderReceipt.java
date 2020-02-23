package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
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

        body.append(String.format("\n%s\n\n", order.getCreatedAtDisplay()));
        for (OrderItem orderItem : order.getOrderItems()) {
            body.append(String.format(bodyTemplate,
                    orderItem.getDescription(),
                    orderItem.getPrice(),
                    orderItem.getQuantity(),
                    orderItem.getTotalAmount()));
        }

        return body.toString();
    }

    private String getReceiptFooter() {
        StringBuilder footer = new StringBuilder();
        String footerTemplate = "%s: %.2f\n";
        double salesTax = order.getSalesTax();
        double totalAmount = order.getTotalAmount();
        double discount = order.getDiscount();

        footer.append("-----------------------------------\n");
        footer.append(String.format(footerTemplate, "税额", salesTax));
        if (order.isDiscounted()) {
            footer.append(String.format(footerTemplate, "折扣", discount));
        }
        footer.append(String.format(footerTemplate, "总价", totalAmount - discount));

        return footer.toString();
    }
}
