package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611, 53219), SALTA(1441351, 155488), TUCUMAN(1731820, 22524), CATAMARCA(429562, 102602),
	LA_RIOJA(383865, 89680), SANTIAGO_DEL_ESTERO(1060906, 136351);

	private int poblacion;
	private float superficie;

	private Provincia() {
	}

	private Provincia(int poblacion, float superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public float calcularDensidadPoblacion() {
		return poblacion / superficie;
	}
}
