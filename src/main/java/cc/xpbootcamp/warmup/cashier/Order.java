package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class Order {
    private final String CREATED_AT_DISPLAY_PATTERN = "yyyy年M月dd日，E";
    private final double WED_DISCOUNT_PERCENT = 0.98;
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

    public boolean isDiscounted() {
        return createAt.getDayOfWeek() == DayOfWeek.WEDNESDAY;
    }

    public double getDiscount() {
        if (isDiscounted()) {
            return getTotalAmount() * (1.0 - WED_DISCOUNT_PERCENT);
        }
        return 0d;
    }

    public String getCreatedAtDisplay() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CREATED_AT_DISPLAY_PATTERN, Locale.CHINESE);

        return getCreateAt().format(formatter);
    }
}
