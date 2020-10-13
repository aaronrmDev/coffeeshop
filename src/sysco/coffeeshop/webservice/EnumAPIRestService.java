package sysco.coffeeshop.webservice;

public enum EnumAPIRestService {
	
	GET_ALL_PRODUCTS ("https://iitd7euw75.execute-api.us-east-1.amazonaws.com/services/products/getProducts"),
	CREATE_PRODUCT ("https://iitd7euw75.execute-api.us-east-1.amazonaws.com/services/products/createProduct"),
	UPDATE_PRODUCT ("https://iitd7euw75.execute-api.us-east-1.amazonaws.com/services/products/updateProduct"),
	DELETE_PRODUCT ("https://iitd7euw75.execute-api.us-east-1.amazonaws.com/services/products/deleteProduct"),
	GET_ALL_ORDERS ("https://iitd7euw75.execute-api.us-east-1.amazonaws.com/services/orders/getOrders"),
	UPDATE_ORDER ("https://iitd7euw75.execute-api.us-east-1.amazonaws.com/services/orders/updateOrder");
	
	private final String serviceLink;
	
	public String getServiceLink() {
		return serviceLink;
	}

	private EnumAPIRestService(String pServiceLink) {
		this.serviceLink = pServiceLink;
	}
}
