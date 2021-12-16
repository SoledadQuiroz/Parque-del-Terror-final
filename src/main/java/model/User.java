package model;

import java.util.HashMap;
import java.util.Map;

import utils.Crypt;

public class User {

	private Integer id;
	private String nombre, contraseña;
	private Integer presupuesto;
	private Integer tiempo;
	private Integer atraccionPreferida;
	private Boolean admin;
	private HashMap<String, String> errors;

	public User(Integer id, String username, String password, Integer coins, Integer time, Integer atraccionPreferida,
			Boolean admin) {
		super();
		this.id = id;
		this.nombre = username;
		this.contraseña = password;
		this.presupuesto = coins;
		this.tiempo = time;
		this.admin = admin;
		this.atraccionPreferida = atraccionPreferida;
	}

	public void addToItinerary(Attraction attraction) {
		this.presupuesto -= attraction.getCost();
		this.tiempo -= attraction.getDuration();
		// TODO agregar a su lista
	}
	
	public void addToItineraryPromocion(Promocion promocion) {
		this.presupuesto -= promocion.calculoPromocion();
		this.tiempo -= promocion.getTiempoPromedio();
		// TODO agregar a su lista
	}

	public boolean canAfford(Attraction attraction) {
		return attraction.getCost() <= this.presupuesto;
	}

	public boolean canAttend(Attraction attraction) {
		return attraction.getDuration() <= this.tiempo;
	}
	
	public boolean canAffordPromocion(Promocion promocion) {
		return promocion.calculoPromocion() <= this.presupuesto;
	}

	public boolean canAttendPromocion(Promocion promocion) {
		return promocion.getTiempoPromedio() <= this.tiempo;
	}


	public boolean checkPassword(String password) {
		// this.password en realidad es el hash del password
		return Crypt.match(password, this.contraseña);
	}

	public Boolean getAdmin() {
		return admin;
	}

	public Integer getCoins() {
		return presupuesto;
	}

	public Integer getId() {
		return id;
	}

	public String getPassword() {
		return contraseña;
	}

	public Integer getTime() {
		return tiempo;
	}

	public String getUsername() {
		return nombre;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public boolean isNull() {
		return false;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public void setCoins(Integer coins) {
		this.presupuesto = coins;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.contraseña = Crypt.hash(password);
	}

	public void setTime(Integer time) {
		this.tiempo = time;
	}

	public void setUsername(String username) {
		this.nombre = username;
	}

	public Integer getAtraccionPreferida() {
		return atraccionPreferida;
	}

	public void setAtraccionPreferida(Integer atraccionPreferida) {
		this.atraccionPreferida = atraccionPreferida;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (presupuesto < 0) {
			errors.put("coins", "No debe ser negativo");
		}
		if (tiempo < 0) {
			errors.put("time", "No debe ser negativo");
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + nombre + ", password=" + contraseña + ", admin=" + admin + "]";
	}

}
