package model;

import java.util.HashMap;
import java.util.Map;

public abstract class Promocion {

	private int id;
	private String nombre;
	private String tipo;
	private Integer tipoAtraccion;
	protected Attraction[] atracciones;
	
	private Map<String, String> errors;

	public Promocion(int id, String nombre, String tipo, Integer tipoAtraccion, Attraction[] atracciones) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.tipoAtraccion = tipoAtraccion;
		this.atracciones = atracciones;
	}

	public Integer getTipoAtraccion() {
		return tipoAtraccion;
	}

	public String getTipo() {
		return tipo;
	}

	public int getTiempoPromedio() {
		int devolucionTiempo = 0;

		for (int c = 0; c < atracciones.length; c++) {
			devolucionTiempo += atracciones[c].getDuration();
		}

		return devolucionTiempo;
	}

	public abstract int calculoPromocion();

	@Override
	public String toString() {
		String nombreAtracciones = "";

		for (int i = 0; i < atracciones.length; i++) {
			nombreAtracciones += atracciones[i].getName();

			if (!(i == atracciones.length - 1)) {
				nombreAtracciones += ", ";
			} else {
				nombreAtracciones += ".";
			}
		}
		return "Id: " + id + ", Nombre de Promocion: " + nombre + ", de tipo: " + tipo + ", atracciones: "
				+ nombreAtracciones + "\n\t\ttiempo promedio: " + getTiempoPromedio() + " minutos, costo: "
				+ calculoPromocion() + " monedas.\n";
	}

	public String getNombre() {
		return nombre;
	}

	public Attraction getAtraccionElemento(int i) {
		return atracciones[i];
	}

	public Attraction[] getAtraccion() {
		return atracciones;
	}

	public int getId() {
		return id;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (calculoPromocion() <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (getTiempoPromedio() <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
	}

	public Attraction[] getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(Attraction[] atracciones) {
		this.atracciones = atracciones;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setTipoAtraccion(Integer tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

}