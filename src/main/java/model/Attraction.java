package model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import persistence.impl.AttractionDAOImpl;

public class Attraction {

	private Integer id;
	private String nombre;
	private Integer costo;
	private Integer duracion;
	private Integer cupo;
	private Integer tipo;

	private Map<String, String> errors;

	public Attraction(String name, Integer cost, Integer duration, Integer capacity, Integer tipo) {
		super();
		this.nombre = name;
		this.costo = cost;
		this.duracion = duration;
		this.cupo = capacity;
		this.tipo = tipo;
	}

	public Attraction(Integer id, String name, Integer cost, Integer duration, Integer capacity, Integer tipo) {
		this(name, cost, duration, capacity, tipo);
		this.id = id;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (costo <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (duracion <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (duracion > 500) {
			errors.put("duration", "Excede el tiempo máximo");
		}
		if (cupo <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public Integer getCost() {
		return costo;
	}

	public void setCost(Integer cost) {
		this.costo = cost;
	}

	public Integer getDuration() {
		return duracion;
	}

	public void setDuration(Integer duration) {
		this.duracion = duration;
	}

	public Integer getCapacity() {
		return cupo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setCapacity(Integer capacity) {
		this.cupo = capacity;
	}

	@Override
	public String toString() {
		return "Attraction [id=" + id + ", name=" + nombre + ", cost=" + costo + ", duration=" + duracion
				+ ", capacity=" + cupo + "]";
	}

	public boolean canHost(int i) {
		return cupo >= i;
	}

	public void host(int i) {
		this.cupo -= i;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getDescrip() throws SQLException {

		String descrip = AttractionDAOImpl.descripDeAtracciones(id);

		return descrip;
	}

}