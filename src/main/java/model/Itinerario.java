package model;

public class Itinerario {

	private int usuario;
	private int atracciones;
	private int promociones;

	public Itinerario(int usuario, int atracciones, int promociones) {
		this.usuario = usuario;
		this.atracciones = atracciones;
		this.promociones = promociones;
	}

	public int getUsuario() {
		return usuario;
	}

	public int getAtracciones() {
		return atracciones;
	}

	public int getPromociones() {
		return promociones;
	}

}
