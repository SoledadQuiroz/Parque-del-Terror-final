package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Attraction;
import persistence.commons.ConnectionProvider;

public class Atraccion_promocionDAO {
	public static int contarTodasAtraccionesPromociones(int id) throws SQLException {
		String sql = "SELECT count(id) from atraccion_promocion WHERE id=?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultados = statement.executeQuery();

		// resultados.next();
		int total = resultados.getInt("count(id)");

		return total;
	}

	public static Attraction buscaAtraccionPorID(int i) throws SQLException {
		String sql = "SELECT * FROM atracciones WHERE id=?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, i);
		ResultSet resultados = statement.executeQuery();

		Attraction paseo = null;

		// if (resultados.next()) {
		paseo = atracciones(resultados);
		// }

		return paseo;
	}

	public static Attraction[] atraccionesPorPromocion(int id) throws SQLException {
		String sql = "SELECT atracciones.id FROM atraccion_promocion\r\n"
				+ "JOIN atracciones ON atracciones.id = atraccion_promocion.fk_atracciones_id\r\n"
				+ "WHERE atraccion_promocion.id=?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultados = statement.executeQuery();

		int x = 0;
		int c = contarTodasAtraccionesPromociones(id);
		Attraction[] favoritas = new Attraction[c];
		while (resultados.next() && x < c) {

			favoritas[x] = buscaAtraccionPorID(resultados.getInt("id"));

			x++;
		}

		return favoritas;
	}

	public static int[] IDAtraccionesPorPromocion(int id) throws SQLException {
		String sql = "SELECT fk_atracciones_id\n" + "FROM atraccion_promocion\n" + "LEFT JOIN itinerarios\n"
				+ "ON itinerarios.fk_promocion=atraccion_promocion.fk_promocion_id\n"
				+ "WHERE atraccion_promocion.fk_promocion_id=?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultados = statement.executeQuery();

		int x = 0;
		int c = contarTodasAtraccionesPromociones(id);
		int[] favoritas = new int[c];
		while (resultados.next() && x < c) {

			favoritas[x] = resultados.getInt("fk_atracciones_id");

			x++;
		}

		return favoritas;
	}

	private static Attraction atracciones(ResultSet resultados) throws SQLException {
		return new Attraction(resultados.getInt("id"), resultados.getString("nombre"), resultados.getInt("costo"),
				resultados.getInt("tiempo"), resultados.getInt("cupo"), resultados.getInt("fk_tipo_de_atraccion"));
	}

}
