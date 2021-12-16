package controller.itinerario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Itinerario;
import model.User;
import services.ItinerarioService;

@WebServlet("/itinerarios/itinerario.do")
public class ListItinerarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 985007788312045740L;
	private ItinerarioService itinerarioService;
	private User usuario;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioService = new ItinerarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		usuario = ((User)req.getSession().getAttribute("user"));
		List<Itinerario> itinerario = itinerarioService.list(usuario);
		req.setAttribute("itinerarios", itinerario);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/itinerarios/itinerario.jsp");
		dispatcher.forward(req, resp);

	}
}
