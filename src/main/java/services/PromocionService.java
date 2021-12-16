package services;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import model.Promocion;
import model.PromocionAbsoluta;
import model.User;
import orden.OrdenaAtraccionPromocion;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;

public class PromocionService {
	
	public List<Promocion> list(User usuario) throws SQLException {
		List<Promocion> promociones = new LinkedList<Promocion>();
		promociones = DAOFactory.getPromocionDAO().findAll();
		
		return OrdenaAtraccionPromocion.ordenarPromociones(usuario, promociones);

	}

	public List<Promocion> list() {
		return DAOFactory.getPromocionDAO().findAll();
	}
//TODO ojo, solo funciona con promocion absoluta
	public Promocion create(int id, String nombre, String tipo, Integer tipoAtraccion, Attraction[] atracciones,
			Integer descuento) {

		Promocion promocion = new PromocionAbsoluta(id, nombre, tipo, tipoAtraccion, atracciones, descuento);

		if (promocion.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promocion;
	}

	public Promocion update(int id, String nombre, String tipo, Integer tipoAtraccion, Attraction[] atracciones,
			int descuento) {

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Promocion promocion = promocionDAO.find(id);

		promocion.setNombre(nombre);
		promocion.setTipo(tipo);
		promocion.setTipoAtraccion(tipoAtraccion);

		if (promocion.isValid()) {
			promocionDAO.update(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promocion;
	}

	public void delete(Integer id) {
		Promocion promocion = new PromocionAbsoluta(id, null, null, null, null, null);

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promocionDAO.delete(promocion);
	}

	public Attraction find(Integer id) {
		return DAOFactory.getAttractionDAO().find(id);
	}

}
