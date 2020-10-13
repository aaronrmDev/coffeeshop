package sysco.coffeeshop.webservice;

import java.util.Vector;

import com.google.gson.Gson;

import sysco.coffeeshop.orders.Order;
import sysco.coffeeshop.products.Product;

public class JSONManager {
	private static Gson gson;
	private static WebService ws = new WebService();
	private static Vector<Product> products;
	private static Vector<Order> orders;

	// MAIN
	public static void main(String[] args) {
		getProductsVector();
		getOrdersVector();

	}

	//PRODUCTS to OBJECTS
	public static Vector<Product> getProductsVector() {
		gson = new Gson();
		products = new Vector<Product>();
		try {
			String JSON = ws.getAllProducts();
			Product[] productArray = gson.fromJson(JSON, Product[].class);
			for (Product product : productArray) {
				System.out.println(product);
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return products;
	}

	//ORDERS to OBJECTS
	public static Vector<Order> getOrdersVector() {
		gson = new Gson();
		orders = new Vector<Order>();
		try {
			String JSON = ws.getAllOrders();
			Order[] orderArray = gson.fromJson(JSON, Order[].class); 
			for (Order order : orderArray) {
				System.out.println(order);
				orders.add(order);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return orders;
	}
}

