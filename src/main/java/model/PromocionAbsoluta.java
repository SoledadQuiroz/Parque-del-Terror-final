package model;

public class PromocionAbsoluta extends Promocion {

	private Integer precioPromocion;

	public PromocionAbsoluta(int id, String nombre, String tipo, Integer tipoAtraccion, Attraction[] atracciones,
			Integer precioPromocion) {
		super(id, nombre, tipo, tipoAtraccion, atracciones);
		this.precioPromocion = precioPromocion;
	}

	public int calculoPromocion() {
		return precioPromocion;
	}

	public int getPrecioPromocion() {
		return precioPromocion;
	}
}