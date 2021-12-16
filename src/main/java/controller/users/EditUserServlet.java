package controller.users;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import services.UserService;

@WebServlet("/users/edit.do")
public class EditUserServlet extends HttpServlet {

	private static final long serialVersionUID = -2721174701174059225L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		User user = userService.find(id);
		req.setAttribute("user", user);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Integer cost = Integer.parseInt(req.getParameter("coins"));
		Integer time = Integer.parseInt(req.getParameter("time"));
		Integer atraccionFavorita = Integer.parseInt(req.getParameter("atraccionFavorita"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null :
		// Integer.parseInt(req.getParameter("cost"));

		User user = userService.update(id, name, cost, time, atraccionFavorita);

		if (user.isValid()) {
			resp.sendRedirect("/parque_de_terror/users/index.do");
		} else {
			req.setAttribute("user", user);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/edit.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
