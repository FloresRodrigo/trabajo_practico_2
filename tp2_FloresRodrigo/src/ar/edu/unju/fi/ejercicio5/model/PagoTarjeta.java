package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;

	public PagoTarjeta() {
		super();
	}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	@Override
	public void realizarPago(double montoPagado) {
		this.montoPagado = montoPagado + montoPagado * 0.15;
	}

	@Override
	public String imprimirRecibo() {
		return "\n-------------------------" + "\nNumero de tarjeta: " + this.numeroTarjeta + "\n" + "Fecha de pago: "
				+ this.fechaPago + "\n" + "Monto pagado: " + this.montoPagado + "\n-------------------------";
	}
}
