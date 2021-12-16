package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.User;
import persistence.Atraccion_promocionDAO;
import persistence.PromocionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class PromocionDAOImpl implements PromocionDAO {

	@Override
	public Promocion find(Integer id) {
		try {
			String sql = "SELECT * FROM promociones WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Promocion promocion = null;
			if (resultados.next()) {
				if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("AxB"))
					promocion = promocionAxB(resultados);

				if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("porcentual"))
					promocion = promocionPorcentual(resultados);

				if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("Absoluta"))
					promocion = promocionAbsoluta(resultados);
			}

			return promocion;
		} catch (

		Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Promocion> findAll() {
		try {
			String sql = "SELECT * FROM promociones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet resultados = statement.executeQuery();

			int c = contadorTotalpromociones();

			List<Promocion> promociones = new LinkedList<Promocion>();
			for (int i = 0; i < c; i++) {
				if (resultados.next()) {
					if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("AxB"))
						promociones.add(promocionAxB(resultados));

					if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("porcentual"))
						promociones.add(promocionPorcentual(resultados));

					if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("Absoluta"))
						promociones.add(promocionAbsoluta(resultados));
				}
			}

			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Promocion promocion) {
		try {

			if (promocion.getTipo().equals("Porcentual")) {
				String sql = "INSERT INTO promociones (nombre, tipo_de_promocion, descuento, fk_tipo_de_atraccion) VALUES (?, ?, ?, ?)";

				Connection conn = ConnectionProvider.getConnection();

				PreparedStatement statement = conn.prepareStatement(sql);
				int i = 1;
				statement.setString(i++, promocion.getNombre());
				statement.setString(i++, promocion.getTipo());
				statement.setInt(i++, ((PromocionPorcentual) promocion).getDescuento());
				statement.setInt(i++, promocion.getTipoAtraccion());

				int rows = statement.executeUpdate();

				for (Attraction atraccion : promocion.getAtraccion()) {
					String sql1 = "INSERT INTO atraccion_promocion (fk_promocion_id, fk_atracciones_id) VALUES (?,?)";
					// Connection conn1 = ConnectionProvider.getConnection();

					PreparedStatement statement1 = conn.prepareStatement(sql1);

					statement1.setInt(1, promocion.getId());
					statement1.setInt(2, atraccion.getId());

					int rows1 = statement1.executeUpdate();

				}

				return rows;
			}

			if (promocion.getTipo().equals("Absoluta")) {
				String sql = "INSERT INTO promociones (nombre, tipo_de_promocion, descuento, fk_tipo_de_atraccion) VALUES (?, ?, ?, ?)";
				Connection conn = ConnectionProvider.getConnection();

				PreparedStatement statement = conn.prepareStatement(sql);
				int i = 1;
				statement.setString(i++, promocion.getNombre());
				statement.setString(i++, promocion.getTipo());
				statement.setInt(i++, ((PromocionAbsoluta) promocion).getPrecioPromocion());
				statement.setInt(i++, promocion.getTipoAtraccion());

				int rows = statement.executeUpdate();

				for (Attraction atraccion : promocion.getAtraccion()) {
					String sql1 = "INSERT INTO atraccion_promocion (fk_promocion_id, fk_atracciones_id) VALUES (?,?)";
					// Connection conn1 = ConnectionProvider.getConnection();

					PreparedStatement statement1 = conn.prepareStatement(sql1);

					statement1.setInt(1, promocion.getId());
					statement1.setInt(2, atraccion.getId());

					int rows1 = statement1.executeUpdate();

				}

				return rows;
			}

			if (promocion.getTipo().equals("AxB")) {
				String sql = "INSERT INTO promociones (nombre, tipo_de_promocion, fk_tipo_de_atraccion) VALUES (?, ?, ?)";

				Connection conn = ConnectionProvider.getConnection();

				PreparedStatement statement = conn.prepareStatement(sql);
				int i = 1;
				statement.setString(i++, promocion.getNombre());
				statement.setString(i++, promocion.getTipo());
				statement.setInt(i++, promocion.getTipoAtraccion());

				int rows = statement.executeUpdate();

				for (Attraction atraccion : promocion.getAtraccion()) {
					String sql1 = "INSERT INTO atraccion_promocion (fk_promocion_id, fk_atracciones_id) VALUES (?,?)";
					// Connection conn1 = ConnectionProvider.getConnection();

					PreparedStatement statement1 = conn.prepareStatement(sql1);

					statement1.setInt(1, promocion.getId());
					statement1.setInt(2, atraccion.getId());

					int rows1 = statement1.executeUpdate();

				}

				return rows;
			}

			return 0;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public static void main(String[] args) {
		Attraction a = new Attraction(13, "Paco", 2, 2, 2, 2);
		Attraction a2 = new Attraction(14, "Paco2", 2, 2, 2, 2);
		Attraction a3 = new Attraction(15, "Paco3", 2, 2, 2, 2);
		Attraction[] atracciones = new Attraction[] { a, a2, a3 };
		Promocion t = new PromocionAbsoluta(00, "yy", "Absoluta", 2, atracciones, 100);
		// Promocion t2 = new PromocionAxB(01, "yy", "AxB", 2, atracciones);
		// Promocion t3 = new PromocionPorcentual(02, "yy", "Porcentual", 2,
		// atracciones, 100);

		PromocionDAOImpl promocionDAOImpl = new PromocionDAOImpl();
		promocionDAOImpl.insert(t);
		// promocionDAOImpl.insert(t2);
		// promocionDAOImpl.insert(t3);
	}

	@Override
	public int update(Promocion promocion) {
		try {

			if (promocion.getTipo().equals("Porcentual")) {
				String sql = "UPDATE promociones SET nombre = ?, tipo_de_promocion = ?, descuento = ?, fk_tipo_de_atraccion = ?";

				Connection conn = ConnectionProvider.getConnection();

				PreparedStatement statement = conn.prepareStatement(sql);
				int i = 1;
				statement.setString(i++, promocion.getNombre());
				statement.setString(i++, promocion.getTipo());
				statement.setInt(i++, ((PromocionPorcentual) promocion).getDescuento());
				statement.setInt(i++, promocion.getTipoAtraccion());

				int rows = statement.executeUpdate();

				for (Attraction atraccion : promocion.getAtraccion()) {
					String sql1 = "UPDATE promociones SET nombre = ?, tipo_de_promocion = ?, descuento = ?, fk_tipo_de_atraccion = ?";
					// Connection conn1 = ConnectionProvider.getConnection();

					PreparedStatement statement1 = conn.prepareStatement(sql1);

					statement1.setInt(1, promocion.getId());
					statement1.setInt(2, atraccion.getId());

					int rows1 = statement1.executeUpdate();

				}

				return rows;
			}

			if (promocion.getTipo().equals("Absoluta")) {
				String sql = "UPDATE promociones SET nombre = ?, tipo_de_promocion = ?, descuento = ?, fk_tipo_de_atraccion = ?";
				Connection conn = ConnectionProvider.getConnection();

				PreparedStatement statement = conn.prepareStatement(sql);
				int i = 1;
				statement.setString(i++, promocion.getNombre());
				statement.setString(i++, promocion.getTipo());
				statement.setInt(i++, ((PromocionAbsoluta) promocion).getPrecioPromocion());
				statement.setInt(i++, promocion.getTipoAtraccion());

				int rows = statement.executeUpdate();

				for (Attraction atraccion : promocion.getAtraccion()) {
					String sql1 = "INSERT INTO atraccion_promocion (fk_promocion_id, fk_atracciones_id) VALUES (?,?)";
					// Connection conn1 = ConnectionProvider.getConnection();

					PreparedStatement statement1 = conn.prepareStatement(sql1);

					statement1.setInt(1, promocion.getId());
					statement1.setInt(2, atraccion.getId());

					int rows1 = statement1.executeUpdate();

				}

				return rows;
			}

			if (promocion.getTipo().equals("AxB")) {
				String sql = "INSERT INTO promociones (nombre, tipo_de_promocion, fk_tipo_de_atraccion) VALUES (?, ?, ?)";

				Connection conn = ConnectionProvider.getConnection();

				PreparedStatement statement = conn.prepareStatement(sql);
				int i = 1;
				statement.setString(i++, promocion.getNombre());
				statement.setString(i++, promocion.getTipo());
				statement.setInt(i++, promocion.getTipoAtraccion());

				int rows = statement.executeUpdate();

				for (Attraction atraccion : promocion.getAtraccion()) {
					String sql1 = "INSERT INTO atraccion_promocion (fk_promocion_id, fk_atracciones_id) VALUES (?,?)";
					// Connection conn1 = ConnectionProvider.getConnection();

					PreparedStatement statement1 = conn.prepareStatement(sql1);

					statement1.setInt(1, promocion.getId());
					statement1.setInt(2, atraccion.getId());

					int rows1 = statement1.executeUpdate();

				}

				return rows;
			}

			return 0;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Promocion promocion) {
		try {
			String sql = "DELETE FROM promociones WHERE id = ?;DELETE FROM atraccion_promocion WHERE fk_promocion_id =? ";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, promocion.getId());
			statement.setInt(1, promocion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public static int contadorTotalpromociones() throws SQLException {
		String sql = "SELECT count(id) AS 'total' FROM promociones";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		resultados.next();
		int total = resultados.getInt("total");

		return total;
	}

	public static ArrayList<Promocion> recuperaPromociones() throws SQLException {
		String sql = "SELECT * FROM promociones";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);

		ResultSet resultados = statement.executeQuery();

		int c = contadorTotalpromociones();

		ArrayList<Promocion> arregloPromociones = new ArrayList<Promocion>();
		for (int i = 0; i < c; i++) {
			if (resultados.next()) {
				if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("AxB"))
					arregloPromociones.add(promocionAxB(resultados));

				if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("porcentual"))
					arregloPromociones.add(promocionPorcentual(resultados));

				if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("Absoluta"))
					arregloPromociones.add(promocionAbsoluta(resultados));
			}
		}

		return arregloPromociones;

	}

	// NO ENTIENDO PORQUE TRAE EL MAX
	public static int recuperaTipoAtraccionPorIDPromocion(int id) throws SQLException {
		String sql = "SELECT MAX(fk_tipo_de_atraccion) AS 'tipo'\n" + "FROM promociones\n" + "WHERE id=?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultados = statement.executeQuery();

		resultados.next();
		int c = resultados.getInt("tipo");
		return c;
	}

	private static PromocionAbsoluta promocionAbsoluta(ResultSet resultados) throws SQLException {
		return new PromocionAbsoluta(resultados.getInt("id"), resultados.getString("nombre"),
				resultados.getString("tipo_de_promocion"), resultados.getInt("fk_tipo_de_atraccion"),
				Atraccion_promocionDAO.atraccionesPorPromocion(resultados.getInt("fk_tipo_de_atraccion")),
				resultados.getInt("descuento"));
	}

	private static PromocionPorcentual promocionPorcentual(ResultSet resultados) throws SQLException {
		return new PromocionPorcentual(resultados.getInt("id"), resultados.getString("nombre"),
				resultados.getString("tipo_de_promocion"), resultados.getInt("fk_tipo_de_atraccion"),
				Atraccion_promocionDAO.atraccionesPorPromocion(resultados.getInt("fk_tipo_de_atraccion")),
				resultados.getInt("descuento"));
	}

	private static PromocionAxB promocionAxB(ResultSet resultados) throws SQLException {
		return new PromocionAxB(resultados.getInt("id"), resultados.getString("nombre"),
				resultados.getString("tipo_de_promocion"), (resultados.getInt("fk_tipo_de_atraccion")),
				Atraccion_promocionDAO.atraccionesPorPromocion(resultados.getInt("fk_tipo_de_atraccion")));
	}
//TODO Prueba
	public List<Promocion> findAllOrdenado(User usuario) {
		try {
			String sql = "SELECT * FROM promociones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet resultados = statement.executeQuery();

			int c = contadorTotalpromociones();

			List<Promocion> promociones = new LinkedList<Promocion>();
			for (int i = 0; i < c; i++) {
				if (resultados.next()) {
					if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("AxB"))
						promociones.add(promocionAxB(resultados));

					if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("porcentual"))
						promociones.add(promocionPorcentual(resultados));

					if (resultados.getString("tipo_de_promocion").equalsIgnoreCase("Absoluta"))
						promociones.add(promocionAbsoluta(resultados));
				}
			}
			//listaPromocionesOrdenadas(promociones);
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

}
