package sysco.coffeeshop.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sysco.coffeeshop.appManager.App;
import sysco.coffeeshop.webservice.JSONManager;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("wHome/HomeOrders")

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private App app = new App();
	
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			app.setOrders(JSONManager.getOrdersVector());
			app.setProducts(JSONManager.getProductsVector());
			
			request.setAttribute("orders", app.getOrders());
			request.getRequestDispatcher(request.getContextPath()+"/wHome/Home").forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
		
		//response.sendRedirect(request.getContextPath()+"/wHome/Home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
