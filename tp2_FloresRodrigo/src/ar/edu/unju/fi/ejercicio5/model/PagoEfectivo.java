package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago{
	private double montoPagado;
	private LocalDate fechaPago;
	
	public PagoEfectivo() {
		this.fechaPago = LocalDate.now();
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		super();
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	@Override
	public void realizarPago(double montoPagado) {
		this.montoPagado=montoPagado-montoPagado*0.10;
		this.fechaPago=LocalDate.now();
	}
	
	@Override
	public String imprimirRecibo() {
		return  "\n-------------------------" + 
				"\nFecha de pago: " + this.fechaPago + 
				"\n" + "Monto pagado: " + this.montoPagado + 
				"\n-------------------------";
	}
	
}
