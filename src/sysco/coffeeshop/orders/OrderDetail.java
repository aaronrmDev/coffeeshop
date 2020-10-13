package sysco.coffeeshop.orders;

public class OrderDetail {
	private String id;
	private int qty;
	public OrderDetail(String id, int qty) {
		super();
		this.id = id;
		this.qty = qty;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", qty=" + qty + "]";
	}



}
