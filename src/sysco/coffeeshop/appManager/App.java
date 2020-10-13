package sysco.coffeeshop.appManager;

import java.util.List;
import java.util.Vector;

import sysco.coffeeshop.orders.*;
import sysco.coffeeshop.products.Product;
import sysco.coffeeshop.session.*;

public class App {
	// VARIABLES
	private List<Session> sessions;
	private List<Order> orders;
	private List<Product> products;

	private Session actualSession;
	private String errorMessage;

	// GETTERS AND SETTERS
	public Session getActualSession() {
		return actualSession;
	}

	public void setActualSession(Session actualSession) {
		this.actualSession = actualSession;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "App [sessions=" + sessions.toString() + ", orders=" + orders.toString() + "]";
	}

	// CONSTRUCTOR WITSH NO SESSION
	public App() {
		this.sessions = new Vector<Session>();
		this.orders = new Vector<Order>();
		this.products = new Vector<Product>();
	}

	// CONSTRUCTOR WITH SESSION
	public App(Session actualSession) {
		this.orders = new Vector<Order>();
		this.products = new Vector<Product>();
		this.actualSession = actualSession;
	}

	// CREATE A NEW SESSION REGISTRY
	public String createSession(Session session) {
		errorMessage = "";
		if (isValidString(session.getUsername())==true && sessions.contains(session)==false) {
			sessions.add(session);
		} else {
			errorMessage = "Session already exists.";
		}
		return errorMessage;
	}

	// LOAD SESSION
	public String validateSession(Session session) {
		errorMessage = "";
		if (isValidString(session.getUsername())==true && isSession(session)==true) {
			actualSession = sessions.get(sessions.indexOf(session));
		}
		return errorMessage;
	}

	// Validate if is error
	private boolean isError(String msg) {
		return (!msg.equals(""));
	}

	// validates if is a correct String
	private boolean isValidString(String chain) {
		return (!chain.equals("") & !chain.equals(null));
	}

	// validates if session exists
	private boolean isSession(Session session) {
		return (sessions.contains(session));
	}
	
	
}
