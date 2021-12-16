package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import model.Itinerario;
import model.Promocion;
import model.User;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ItinerarioDAO {

	public static int insertAtracciones(User visitante, Attraction atraccion) throws SQLException {
		String sql = "INSERT INTO itinerarios (fk_usuario, fk_atraccion, fk_promocion) VALUES (?, ?, ?)";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setInt(1, visitante.getId());
		statement.setInt(2, atraccion.getId());

		int rows = statement.executeUpdate();

		return rows;
	}

	public static int insertPromociones(User visitante, Promocion promocion) throws SQLException {
		String sql = "INSERT INTO itinerarios (fk_usuario, fk_atraccion, fk_promocion) VALUES (?, ?, ?)";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);

		statement.setInt(1, visitante.getId());
		statement.setInt(3, promocion.getId());

		int rows = statement.executeUpdate();

		return rows;
	}

	public static int contadorPromocionesItinerarioPorUsuario(int id) throws SQLException {
		String sql = "SELECT count(fk_promocion) AS 'total' FROM itinerarios	WHERE fk_usuario=?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultados = statement.executeQuery();

		resultados.next();
		int total = resultados.getInt("total");

		return total;
	}

	public static int[] recuperaIDPromocionesCompradasPorUsuario(int idUsuario) throws SQLException {
		String sql = "SELECT fk_promocion FROM itinerarios WHERE fk_usuario=? AND fk_promocion IS NOT NULL";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, idUsuario);
		ResultSet resultados = statement.executeQuery();

		int c = contadorPromocionesItinerarioPorUsuario(idUsuario);
		int[] idPromociones = new int[c];
		for (int i = 0; i < c; i++) {
			if (resultados.next()) {
				idPromociones[i] = resultados.getInt("fk_promocion");
			}

		}

		return idPromociones;

	}

	public static int contadorAtraccionesItinerarioPorUsuario(int id) throws SQLException {
		String sql = "SELECT count(fk_atraccion) AS 'total' FROM itinerarios	WHERE fk_usuario=?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultados = statement.executeQuery();

		resultados.next();
		int total = resultados.getInt("total");

		return total;
	}

	public static int[] recuperaIDAtraccionesCompradasPorUsuario(int idUsuario) throws SQLException {
		String sql = "SELECT fk_atraccion FROM itinerarios WHERE fk_usuario=? AND fk_atraccion IS NOT NULL";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, idUsuario);
		ResultSet resultados = statement.executeQuery();

		int c = contadorAtraccionesItinerarioPorUsuario(idUsuario);
		int[] idPromociones = new int[c];
		for (int i = 0; i < c; i++) {
			if (resultados.next()) {
				idPromociones[i] = resultados.getInt("fk_atraccion");
			}

		}

		return idPromociones;

	}

	public List<Itinerario> findAll(User usuario) {
		try {
			String sql = "SELECT * FROM itinerarios WHERE fk_usuario = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, usuario.getId());
			ResultSet resultados = statement.executeQuery();

			List<Itinerario> itinerario = new LinkedList<Itinerario>();
			while (resultados.next()) {
				itinerario.add(toItinerario(resultados));
			}

			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}


	private Itinerario toItinerario(ResultSet resultados) throws SQLException {
		return new Itinerario(resultados.getInt("fk_usuario"), resultados.getInt("fk_atraccion"), resultados.getInt("fk_promocion"));
	}

}