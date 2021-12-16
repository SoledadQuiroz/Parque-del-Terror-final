package controller.promotions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Attraction;
import model.Promocion;
import services.PromocionService;

@WebServlet("/promotions/create.do")
public class CreatePromotionServlet extends HttpServlet {

	private static final long serialVersionUID = 7038575974265349292L;
	
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre= req.getParameter("nombre");
		String tipo = req.getParameter("tipo");
		Integer tipoAtraccion = Integer.parseInt(req.getParameter("tipoAtraccion"));
		Attraction[] atracciones = req.getParameter("atracciones");
		Integer descuento = Integer.parseInt(req.getParameter("descuento"));
		
		
		Promocion promocion = promocionService.create(nombre, tipo, tipoAtraccion,atracciones,descuento);

		if (promocion.isValid()) {
			resp.sendRedirect("/parque_de_terror/promotions/index.do");
		} else {
			req.setAttribute("attraction", promocion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/create.jsp");
			dispatcher.forward(req, resp);
		}

	}
	
	/*private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Integer cost = Integer.parseInt(req.getParameter("cost"));
		Integer duration = Integer.parseInt(req.getParameter("duration"));
		Integer capacity = Integer.parseInt(req.getParameter("capacity"));
		Integer tipo = Integer.parseInt(req.getParameter("tipo"));
		
		Promocion promocion = promocionService.create(nombre, tipo, tipoAtraccion, atracciones, descuento);

		if (promocion.isValid()) {
			resp.sendRedirect("/parque_de_terror/promotions/index.do");
		} else {
			req.setAttribute("attraction", promocion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/create.jsp");
			dispatcher.forward(req, resp);
		}

	}*/
}
