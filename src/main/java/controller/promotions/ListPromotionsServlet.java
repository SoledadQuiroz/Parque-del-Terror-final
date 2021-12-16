package controller.promotions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import model.User;
import services.PromocionService;

@WebServlet("/promotions/index.do")
public class ListPromotionsServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private PromocionService promocionService;
	private User usuario;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		usuario = ((User) req.getSession().getAttribute("user"));
		List<Promocion> promotions;
		try {
			promotions = promocionService.list(usuario);
			req.setAttribute("promotions", promotions);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/index.jsp");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
