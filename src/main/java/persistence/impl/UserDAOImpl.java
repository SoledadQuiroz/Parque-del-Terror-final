package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.User;
import model.nullobjects.NullUser;
import persistence.UserDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class UserDAOImpl implements UserDAO {

	public int insert(User user) {
		try {
			String sql = "INSERT INTO usuarios (nombre, contraseña, presupuesto, tiempo, fk_atraccion_favorita) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setInt(3, user.getCoins());
			statement.setInt(4, user.getTime());
			statement.setInt(5, user.getAtraccionPreferida());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(User user) {
		try {
			String sql = "UPDATE usuarios SET presupuesto = ?, tiempo = ?, fk_atraccion_favorita = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getCoins());
			statement.setInt(2, user.getTime());
			statement.setInt(3, user.getAtraccionPreferida());
			statement.setInt(4, user.getId());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(User user) {
		try {
			String sql = "DELETE FROM usuarios WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

//MODIFICADO
	public User findByUsername(String username) {
		try {
			String sql = "SELECT * FROM usuarios WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet resultados = statement.executeQuery();

			User user = NullUser.build();

			if (resultados.next()) {
				user = toUser(resultados);
			}

			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}

	public User find(Integer id) {
		try {
			String sql = "SELECT * FROM usuarios WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			User user = NullUser.build();

			if (resultados.next()) {
				user = toUser(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM usuarios";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<User> findAll() {
		try {
			String sql = "SELECT * FROM usuarios";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<User> usuarios = new LinkedList<User>();
			while (resultados.next()) {
				usuarios.add(toUser(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private User toUser(ResultSet userRegister) throws SQLException {
		return new User(userRegister.getInt(1), userRegister.getString(2), userRegister.getString(3),
				userRegister.getInt(5), userRegister.getInt(6), userRegister.getInt(7), userRegister.getBoolean(4));
	}

	/*
	 * por las dudas private User toUser(ResultSet userRegister) throws SQLException
	 * { return new User(userRegister.getInt(1), userRegister.getString(2),
	 * userRegister.getString(3), userRegister.getInt(5), userRegister.getInt(6),
	 * userRegister.getBoolean(4)); }
	 */

}
