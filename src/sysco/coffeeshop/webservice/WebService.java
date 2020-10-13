package sysco.coffeeshop.webservice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import sysco.coffeeshop.orders.Order;
import sysco.coffeeshop.products.Product;

public class WebService {
	// TEMPLEATE FOR THE RESPONSE
	private RestTemplate restTemplate;
	private String msg;
	
	//CONSTRUCTOR
	public WebService() {
		this.restTemplate = new RestTemplate();
	}
	
	private String msgRefractor(String chain) {
		chain = chain.replace("<200,", "");
		chain = chain.replace(">", "");
		chain = chain.replace("{\"items\":", "");
		int place = chain.indexOf(",\"status\":200}");
		chain = chain.replace(chain.substring(place,chain.length()),"");		
		return chain;
	}

	//PRODUCTS
	public String getAllProducts() {
		msg = "";
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> httpEntity = new HttpEntity<>("parameters", headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(EnumAPIRestService.GET_ALL_PRODUCTS.getServiceLink(), HttpMethod.GET, httpEntity, String.class);
			msg = responseEntity.toString();
		} catch (Exception e) {
			if (e.toString().contains("Error"))
				System.out.println("Object Not Found");
		}
		return msgRefractor(msg);
	}

	// CREATE PRODUCT
	public void createPruoduct(String name, double price, String image) {
		try {
			Product product = new Product(name, price, image);
			ResponseEntity<Product> api_product = restTemplate.postForEntity(EnumAPIRestService.CREATE_PRODUCT.getServiceLink(), product, Product.class);
			System.out.println(api_product.getBody());

		} catch (Exception e) {
			if (e.toString().contains("Error"))
				System.out.println("Object Not Found");
		}
	}

	// UPDATE PRODUCT
	public void updateProduct(String id, String name, double price, String image) {
		try {
			Product product = new Product(id, name, price, image);
			ResponseEntity<Product> api_product = restTemplate.postForEntity(EnumAPIRestService.UPDATE_PRODUCT.getServiceLink(), product, Product.class);
			System.out.println(api_product.getBody());

		} catch (Exception e) {
			if (e.toString().contains("Error"))
				System.out.println("Object Not Found");
		}
	}

	// DELETE PRODUCT
	public void deleteProduct(String id) {
		try {
			Map<String, String> param = new HashMap<>();
			param.put("id", id);
			restTemplate.delete(EnumAPIRestService.DELETE_PRODUCT.getServiceLink(), param);
		} catch (Exception e) {
			if (e.toString().contains("Error"))
				System.out.println("Object Not Found");
		}
	}

	/**
	 * GET ALL ORDERS
	 */
	public String getAllOrders() {
		msg ="";
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> httpEntity = new HttpEntity<>("parameters", headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(EnumAPIRestService.GET_ALL_ORDERS.getServiceLink(), HttpMethod.GET, httpEntity, String.class);
			msg = responseEntity.toString();
		} catch (Exception e) {
			if (e.toString().contains("Error"))
				System.out.println("Object Not Found");
		}
		return msgRefractor(msg);
	}

	public void updateOrder(String id, String session, String state) {
		try {
			Order order = new Order(id, session, state);
			ResponseEntity<Order> api_order = restTemplate.postForEntity(EnumAPIRestService.UPDATE_ORDER.getServiceLink(), order, Order.class);
			System.out.println(api_order.getBody());

		} catch (Exception e) {
			if (e.toString().contains("Error"))
				System.out.println("Object Not Found");
		}
	}
}
