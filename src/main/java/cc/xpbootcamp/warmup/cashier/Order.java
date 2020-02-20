package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItemList;
    LocalDate createAt;

    public Order(String customerName, String address, List<LineItem> lineItemList, LocalDate createAt) {
        this.customerName = customerName;
        this.address = address;
        this.lineItemList = lineItemList;
        this.createAt = createAt;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public double getSalesTax() {
        return lineItemList.stream().mapToDouble(lineItem -> lineItem.getTotalAmount() * .10).sum();
    }

    public double getTotalAmount() {
        return lineItemList.stream().mapToDouble(LineItem::getTotalAmount).sum() + getSalesTax();
    }
}
