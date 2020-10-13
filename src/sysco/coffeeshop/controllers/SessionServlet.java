package sysco.coffeeshop.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sysco.coffeeshop.session.Session;
import sysco.coffeeshop.session.SessionManager;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/wSession/Session")
public class SessionServlet extends HttpServlet implements ServerValidations {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private SessionManager sessionManager = new SessionManager();

	@Override
	public boolean stringValidation(String chain) {
		return (!chain.equals("") && !chain.equals(null));
	}

	@Override
	public String sendAlert(String Message) {
		String msg = "";
		msg += "<meta http-equiv='refresh' content='3;URL=index.jsp'>";
		msg += "<p style='color:red;'>";
		msg += Message + "\n";
		msg += "</p>";
		return msg;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// response.sendRedirect(request.getContextPath() + "/wSession/Session.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		out = response.getWriter();
		RequestDispatcher requestDispatcher;

		String sessionBut = "";
		String username = "";
		String password = "";

		try {

			sessionBut = request.getParameter("sessionBut");
			System.out.println(sessionBut.toString());

			// IF REGISTER
			if (sessionBut.equals("register")) {
				username = request.getParameter("username");
				password = request.getParameter("password");

				System.out.println(username);
				System.out.println(password);

				if (stringValidation(username) == true && stringValidation(password) == true
						&& !sessionManager.exists(new Session(username, password))) {
					System.out.println("Creating session.");
					Session session = new Session(username, password);
					sessionManager.create(session);
					response.sendRedirect(request.getContextPath() + "/wSession/Session.jsp");
					requestDispatcher = request
							.getRequestDispatcher(request.getContextPath() + "/wSession/Session.jsp");
					return;
				} else {
					System.out.println("Invalid username or password, or session already exists.");
					out.println("<script type=\"text/javascript\">");
					out.println("Invalid username or password, or session already exists.');");
					out.println("location="+request.getContextPath() + "/wSession/Session.jsp");
					out.println("</script>");
				}

				// IF LOGIN
			} else if (sessionBut.equals("login")) {
				System.out.println("Login session.");
				username = request.getParameter("username");
				password = request.getParameter("password");
				Session session = new Session(username, password);

				if (sessionManager.exists(session)) {
					System.out.println("Session Exists");
					response.sendRedirect(request.getContextPath() + "/wHome/Home.jsp");
					//requestDispatcher = request.getRequestDispatcher(request.getContextPath() + "/wHome/Home.jsp");
					requestDispatcher = request.getRequestDispatcher(request.getContextPath() + "/wHome/HomeServlet.jsp");
					return;
				} else {
					System.out.println("The sessions isn't exist.");
					out.println("<script type=\"text/javascript\">");
					out.println("alert('The sessions isn't exist.');");
					//out.println("location="+request.getContextPath() + "/wSession/Session.jsp");
					out.println("location="+request.getContextPath() + "/wHome/HomeOrder");
					out.println("</script>");
				}
			}

		} catch (Exception e) {
			sendAlert(e.toString());
		}
	}

}
