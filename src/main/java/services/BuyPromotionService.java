package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Attraction;
import model.Promocion;
import model.User;
import persistence.AttractionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class BuyPromotionService {

	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	UserDAO userDAO = DAOFactory.getUserDAO();
	AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
	
	public Map<String, String> buy(Integer userId, Integer promocionId) throws SQLException {
		Map<String, String> errors = new HashMap<String, String>();

		User user = userDAO.find(userId);
		Promocion promocion = promocionDAO.find(promocionId);

		if (!user.canAffordPromocion(promocion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.canAttendPromocion(promocion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.addToItineraryPromocion(promocion);

			for (Attraction atraccion : promocion.getAtraccion()) {
				atraccion.host(1);
				attractionDAO.update(atraccion);
				
			}

			ItinerarioDAO.insertPromociones(user, promocion);
			userDAO.update(user);
		}

		return errors;

	}

}
