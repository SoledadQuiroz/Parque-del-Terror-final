package services;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import model.User;
import orden.OrdenaAtraccionPromocion;
import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class AttractionService {

	public List<Attraction> list(User usuario) throws SQLException {
		List<Attraction> atracciones = new LinkedList<Attraction>();
		atracciones = DAOFactory.getAttractionDAO().findAll();
		
		return OrdenaAtraccionPromocion.ordenarAtracciones(usuario, atracciones);

	}

	public Attraction create(String name, Integer cost, Integer duration, Integer capacity, Integer tipo) {

		Attraction attraction = new Attraction(name, cost, duration, capacity, tipo);

		if (attraction.isValid()) {
			AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
			attractionDAO.insert(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public Attraction update(Integer id, String name, Integer cost, Integer duration, Integer capacity, Integer tipo) {

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Attraction attraction = attractionDAO.find(id);

		attraction.setName(name);
		attraction.setCost(cost);
		attraction.setDuration(duration);
		attraction.setCapacity(capacity);
		attraction.setTipo(tipo);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public void delete(Integer id) {
		Attraction attraction = new Attraction(id, null, null, null, null, null);

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}

	public Attraction find(Integer id) {
		return DAOFactory.getAttractionDAO().find(id);
	}

}
