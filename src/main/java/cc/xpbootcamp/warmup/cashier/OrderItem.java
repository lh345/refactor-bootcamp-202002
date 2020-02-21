package cc.xpbootcamp.warmup.cashier;

public class OrderItem {
	private String description;
	private double price;
	private int quantity;

	public OrderItem(String description, double price, int quantity) {
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double getTotalAmount() {
        return price * quantity;
    }
}