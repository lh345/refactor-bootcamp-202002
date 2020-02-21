package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.List;

public class Order {
    String customerName;
    String address;
    List<OrderItem> orderItemList;
    LocalDate createAt;

    public Order(String customerName, String address, List<OrderItem> orderItemList, LocalDate createAt) {
        this.customerName = customerName;
        this.address = address;
        this.orderItemList = orderItemList;
        this.createAt = createAt;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<OrderItem> getOrderItems() {
        return orderItemList;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public double getSalesTax() {
        return orderItemList.stream().mapToDouble(orderItem -> orderItem.getTotalAmount() * .10).sum();
    }

    public double getTotalAmount() {
        return orderItemList.stream().mapToDouble(OrderItem::getTotalAmount).sum() + getSalesTax();
    }
}
