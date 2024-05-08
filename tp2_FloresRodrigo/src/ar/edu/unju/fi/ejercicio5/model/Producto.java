package ar.edu.unju.fi.ejercicio5.model;

public class Producto {
	private int codigo;
	private String descripcion;
	private float precioUnitario;
	private OrigenFabricacion origen;
	private Categoria categoria;
	private boolean estado;

	public enum OrigenFabricacion {
		ARGENTINA, CHINA, BRASIL, URUGUAY;
	}

	public enum Categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
	}

	public Producto() {
		super();
	}

	public Producto(int codigo, String descripcion, float precioUnitario, OrigenFabricacion origen, Categoria categoria,
			boolean estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origen = origen;
		this.categoria = categoria;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrigenFabricacion getOrigen() {
		return origen;
	}

	public void setOrigen(OrigenFabricacion origen) {
		this.origen = origen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "\n" + "-------------------------" + "\nCodigo: " + this.getCodigo() + "\n" + "Descripcion: "
				+ this.getDescripcion() + "\n" + "Precio unitario: " + this.getPrecioUnitario() + "\n"
				+ "Origen de fabricacion: " + this.getOrigen() + "\n" + "Categoria: " + this.getCategoria() + "\n"
				+ "Estado: " + ((this.isEstado()) ? "Disponible" : "Agotado") + "\n-------------------------";
	}
}
