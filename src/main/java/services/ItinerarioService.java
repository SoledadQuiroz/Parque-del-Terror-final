package services;

import java.util.List;

import model.Itinerario;
import model.User;
import persistence.commons.DAOFactory;

public class ItinerarioService {
	
	
	public List<Itinerario> list(User usuario) {
		return DAOFactory.getItinerarioDAO().findAll(usuario);
	}

	
	/*public Itinerario find(Integer id) {
		return DAOFactory.getItinerarioDAO().find(id);
	}*/

}
