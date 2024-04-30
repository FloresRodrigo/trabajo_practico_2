package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincias = Provincia.values();

		System.out.println("Informacion de las provincias: ");

		for (Provincia provincia : provincias) {
			System.out.println("--------------------");
			System.out.println("Provincia: " + provincia.name());
			System.out.println("Poblacion: " + provincia.getPoblacion());
			System.out.println("Superficie: " + provincia.getSuperficie());
			System.out.println("Densidad de la poblacion: " + provincia.calcularDensidadPoblacion());
			System.out.println("--------------------");
		}
	}

}
