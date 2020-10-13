package sysco.coffeeshop.orders;

import java.util.Vector;

public class Order {
	private double createdAt;
	private String user;
	private String id;
	private Vector<OrderDetail> items;
	private double updatedAt;
	private String state;
	
	public Order(double createdAt, String user, String id, Vector<OrderDetail> items, double updatedAt, String state) {
		super();
		this.createdAt = createdAt;
		this.user = user;
		this.id = id;
		this.items = items;
		this.updatedAt = updatedAt;
		this.state = state;
	}
	
	public Order(double createdAt, String user, String id, double updatedAt, String state) {
		this.createdAt = createdAt;
		this.user = user;
		this.id = id;
		this.items = new Vector<OrderDetail>();
		this.updatedAt = updatedAt;
		this.state = state;
	}
	
	public Order(String user, String id, String state) {
		this.user = user;
		this.id = id;
		this.state = state;
	}

	public double getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(double createdAt) {
		this.createdAt = createdAt;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vector<OrderDetail> getItems() {
		return items;
	}

	public void setItems(Vector<OrderDetail> items) {
		this.items = items;
	}

	public double getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(double updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Order [createdAt=" + createdAt + ", user=" + user + ", id=" + id + ", items=" + items + ", updatedAt="
				+ updatedAt + ", state=" + state + "]";
	}

}
