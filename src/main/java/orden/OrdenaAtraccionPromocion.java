package orden;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import model.Promocion;
import model.User;
import persistence.Atraccion_promocionDAO;
import persistence.ItinerarioDAO;
import persistence.impl.PromocionDAOImpl;

public class OrdenaAtraccionPromocion {
	private static ArrayList<Attraction> paseos = new ArrayList<Attraction>();

	private static ArrayList<Promocion> listaPromociones = new ArrayList<Promocion>();

	public static void creadorPaseos(List<Attraction> list) {
		paseos.addAll(list);

	}

	public static void creadorPromociones(ArrayList<Promocion> arrayList) {
		listaPromociones.addAll(arrayList);

	}

	public static Attraction obtenerAtraccionPorNombre(String nombre) {
		for (Attraction atraccion : paseos) {
			if (atraccion.getName().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
	}

	public static ArrayList<Attraction> listaAtraccionesOrdenadas(User visitante) throws SQLException {

		ArrayList<Attraction> listaAtraccion = new ArrayList<Attraction>();
		ArrayList<Attraction> atraccionesPreferidas = new ArrayList<Attraction>();
		ArrayList<Attraction> atraccionesNoPreferidas = new ArrayList<Attraction>();

		listaAtraccion.addAll(paseos);

		for (int i = 0; i < listaAtraccion.size(); i++) {
			if (listaAtraccion.get(i).getTipo() == visitante.getAtraccionPreferida()) {
				atraccionesPreferidas.add(listaAtraccion.get(i));

			} else {
				atraccionesNoPreferidas.add(listaAtraccion.get(i));

			}
		}

		Collections.sort(atraccionesPreferidas, new ComparaAtracciones());
		Collections.sort(atraccionesNoPreferidas, new ComparaAtracciones());

		atraccionesPreferidas.addAll(atraccionesNoPreferidas);
		return atraccionesPreferidas;
	}

	public static ArrayList<Attraction> listaAtraccionesfiltrada(User visitante) throws SQLException {

		ArrayList<Attraction> listaAtracciones = new ArrayList<Attraction>();
		ArrayList<Attraction> devolucionAtraccion = new ArrayList<Attraction>();
		ArrayList<Integer> idAtraccionesCompradaPorUsuario = new ArrayList<Integer>();

		listaAtracciones.addAll(listaAtraccionesOrdenadas(visitante));

		// cargo Lista Atracciones compradas por usuario anteriormente

		int[] idAtraccionesEnItinerario = ItinerarioDAO.recuperaIDAtraccionesCompradasPorUsuario(visitante.getId());

		for (int i = 0; i < idAtraccionesEnItinerario.length; i++) {

			idAtraccionesCompradaPorUsuario.add(idAtraccionesEnItinerario[i]);
		}

		// recupera id de las promociones compradas por usuario
		int[] IdPromosEnItinerario = ItinerarioDAO.recuperaIDPromocionesCompradasPorUsuario(visitante.getId());

		for (int i = 0; i < IdPromosEnItinerario.length; i++) {

			// recupera el tipo de atraccion de la promocion
			int tipoAtraccion = PromocionDAOImpl.recuperaTipoAtraccionPorIDPromocion(IdPromosEnItinerario[i]);

			int[] IdAtraccionesPromo = Atraccion_promocionDAO.IDAtraccionesPorPromocion(tipoAtraccion);

			for (int j = 0; j < IdAtraccionesPromo.length; j++) {

				if (!(idAtraccionesCompradaPorUsuario.contains(IdAtraccionesPromo[j]))) {
					idAtraccionesCompradaPorUsuario.add(IdAtraccionesPromo[j]);
				}
			}
		}

		if (idAtraccionesCompradaPorUsuario.size() != 0) {
			devolucionAtraccion.addAll(listaAtracciones);
			for (int i = 0; i < listaAtracciones.size(); i++) {

				for (int j = 0; j < idAtraccionesCompradaPorUsuario.size(); j++) {
					if (listaAtracciones.get(i).getId() == idAtraccionesCompradaPorUsuario.get(j)) {
						if (devolucionAtraccion.contains(listaAtracciones.get(i))) {
							devolucionAtraccion.remove(listaAtracciones.get(i));

						}
					}
				}
			}
		} else {
			devolucionAtraccion.addAll(listaAtracciones);
		}

		return devolucionAtraccion;

	}

	public static ArrayList<Promocion> listaPromocionesOrdenadas(User visitante) throws SQLException {

		ArrayList<Promocion> promoPreferidas = new ArrayList<Promocion>();
		ArrayList<Promocion> promoNoPreferidas = new ArrayList<Promocion>();

		listaPromociones.clear();
		OrdenaAtraccionPromocion.creadorPromociones(PromocionDAOImpl.recuperaPromociones());
		for (int i = 0; i < listaPromociones.size(); i++) {
			if (visitante.getAtraccionPreferida() == (listaPromociones.get(i).getTipoAtraccion())) {
				promoPreferidas.add(listaPromociones.get(i));
			} else {
				promoNoPreferidas.add(listaPromociones.get(i));
			}
		}

		Collections.sort(promoPreferidas, new ComparaPromociones());
		Collections.sort(promoNoPreferidas, new ComparaPromociones());
		promoPreferidas.addAll(promoNoPreferidas);
		return promoPreferidas;

	}

	public static ArrayList<Promocion> listaPromocionesfiltradas(User visitante) throws SQLException {

		ArrayList<Integer> idAtraccionesCompradaPorUsuario = new ArrayList<Integer>();
		ArrayList<Promocion> devolucionPromocion = new ArrayList<Promocion>();
		ArrayList<Promocion> promocionesOrdenadas = new ArrayList<Promocion>();
		ArrayList<Promocion> promocionesNoCompradas = new ArrayList<Promocion>();

		promocionesOrdenadas.addAll(listaPromocionesOrdenadas(visitante));

		// cargo Lista Atracciones compradas por usuario anteriormente

		int[] idAtraccionesIti = ItinerarioDAO.recuperaIDAtraccionesCompradasPorUsuario(visitante.getId());

		for (int i = 0; i < idAtraccionesIti.length; i++) {
			idAtraccionesCompradaPorUsuario.add(idAtraccionesIti[i]);
		}

		int[] promocionesCompradas = ItinerarioDAO.recuperaIDPromocionesCompradasPorUsuario(visitante.getId());

		if (promocionesCompradas.length != 0 || idAtraccionesCompradaPorUsuario.size() != 0) {

			for (int j = 0; j < promocionesCompradas.length; j++) {
				for (int i = 0; i < promocionesOrdenadas.size(); i++) {
					if (promocionesCompradas[j] != promocionesOrdenadas.get(i).getId()) {
						if (!promocionesNoCompradas.contains(promocionesOrdenadas.get(i))) {
							promocionesNoCompradas.add(promocionesOrdenadas.get(i));
						}
					}

				}
			}

			devolucionPromocion.addAll(promocionesNoCompradas);
			for (int i = 0; i < promocionesNoCompradas.size(); i++) {

				int tipoAtraccion = PromocionDAOImpl
						.recuperaTipoAtraccionPorIDPromocion(promocionesNoCompradas.get(i).getId());
				int[] IdAtraccionesPromo = Atraccion_promocionDAO.IDAtraccionesPorPromocion(tipoAtraccion);

				for (int j = 0; j < IdAtraccionesPromo.length; j++) {
					for (int s = 0; s < idAtraccionesCompradaPorUsuario.size(); s++) {

						if (idAtraccionesCompradaPorUsuario.get(s) == IdAtraccionesPromo[j]) {
							if (devolucionPromocion.contains(promocionesNoCompradas.get(i))) {
								devolucionPromocion.remove(promocionesNoCompradas.get(i));
							}

						}
					}
				}
			}
		} else {
			devolucionPromocion.addAll(promocionesOrdenadas);
		}

		return devolucionPromocion;

	}
	
	//PRUEBA
	
	public static LinkedList<Attraction> ordenarAtracciones(User visitante, List<Attraction> atraccionesDesordenadas) throws SQLException {

		//ArrayList<Attraction> listaAtraccion = new ArrayList<Attraction>();
		LinkedList<Attraction> atraccionesPreferidas = new LinkedList<Attraction>();
		LinkedList<Attraction> atraccionesNoPreferidas = new LinkedList<Attraction>();

		//listaAtraccion.addAll(paseos);

		for (int i = 0; i < atraccionesDesordenadas.size(); i++) {
			if (atraccionesDesordenadas.get(i).getTipo() == visitante.getAtraccionPreferida()) {
				atraccionesPreferidas.add(atraccionesDesordenadas.get(i));

			} else {
				atraccionesNoPreferidas.add(atraccionesDesordenadas.get(i));

			}
		}

		Collections.sort(atraccionesPreferidas, new ComparaAtracciones());
		Collections.sort(atraccionesNoPreferidas, new ComparaAtracciones());

		atraccionesPreferidas.addAll(atraccionesNoPreferidas);
		return atraccionesPreferidas;
	}
	
	public static LinkedList<Promocion> ordenarPromociones(User visitante, List<Promocion> promocionesDesordenadas) throws SQLException {

		LinkedList<Promocion> promoPreferidas = new LinkedList<Promocion>();
		LinkedList<Promocion> promoNoPreferidas = new LinkedList<Promocion>();

		//listaPromociones.clear();
		//OrdenaAtraccionPromocion.creadorPromociones(PromocionDAOImpl.recuperaPromociones());
		for (int i = 0; i < promocionesDesordenadas.size(); i++) {
			if (visitante.getAtraccionPreferida() == (promocionesDesordenadas.get(i).getTipoAtraccion())) {
				promoPreferidas.add(promocionesDesordenadas.get(i));
			} else {
				promoNoPreferidas.add(promocionesDesordenadas.get(i));
			}
		}

		Collections.sort(promoPreferidas, new ComparaPromociones());
		Collections.sort(promoNoPreferidas, new ComparaPromociones());
		promoPreferidas.addAll(promoNoPreferidas);
		return promoPreferidas;

	}
}
