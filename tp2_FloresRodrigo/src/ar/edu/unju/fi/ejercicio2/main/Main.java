package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	static final Scanner scanner = new Scanner(System.in);
	static final List<Efemeride> listaEfemeride = new ArrayList<>();

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1:
				crearEfemeride();
				pausa();
				break;
			case 2:
				mostrarEfemerides();
				pausa();
				break;
			case 3:
				eliminarEfemeride();
				pausa();
				break;
			case 4:
				modificarEfemeride();
				pausa();
				break;
			case 5:
				System.out.println("*SALIENDO DEL PROGRAMA*");
				break;
			default:
				System.out.println("Opcion no valida");
				pausa();
			}
		} while (opcion != 5);
	}

	public static void mostrarMenu() {
		System.out.println("""
				Menu de opciones:
				1 - Crear efemeride
				2 - Mostrar efemerides
				3 - Elimiar efemeride
				4 - Modificar efemeride
				5 - Salir
				""");
	}

	public static int seleccionarOpcion() {
		int op;

		while (true) {
			try {
				System.out.print("Seleccione una opcion: ");
				op = Integer.parseInt(scanner.nextLine());
				return op;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Solo se permite el ingreso de numeros. Ingrese un numero de la lista");
			}
		}
	}

	public static void pausa() {
		System.out.println("Presione enter para continuar");
		scanner.nextLine();
	}

	public static void crearEfemeride() {
		try {
			System.out.println("Crear efemeride");

			System.out.print("Ingrese el codigo de la efemeride: ");
			int codigo = Integer.parseInt(scanner.nextLine());

			System.out.print("Ingrese el numero correspondiente al mes (1-12): ");
			int mesNumero = Integer.parseInt(scanner.nextLine());

			if (mesNumero < 1 || mesNumero > 12) {
				System.out.println("El mes ingresado debe ser un numero entre 1 y 12");
				return;
			}

			Mes mes = Mes.values()[mesNumero - 1];

			System.out.print("Ingrese el dia: ");
			int dia = Integer.parseInt(scanner.nextLine());

			if (dia < 1 || dia > 31) {
				System.out.println("El dia ingresado debe ser un numero entre 1 y 31");
				return;
			}

			System.out.print("Ingrese el detalle de la efemeride: ");
			String detalle = scanner.nextLine();

			Efemeride nuevaEfemeride = new Efemeride(codigo, mes, dia, detalle);
			listaEfemeride.add(nuevaEfemeride);

			System.out.println("Efemeride creada");

		} catch (NumberFormatException e) {
			System.out.println("ERROR: Entrada no valida. Ingrese solo numeros");
		}
	}

	public static void mostrarEfemerides() {
		if (listaEfemeride.isEmpty()) {
			System.out.println("No hay efemerides");
		} else {
			System.out.println("Lista de efemerides: ");
			for (Efemeride efemeride : listaEfemeride) {
				System.out.println(efemeride.toString());
			}
		}
	}

	public static void eliminarEfemeride() {
		if (listaEfemeride.isEmpty()) {
			System.out.println("No hay efemerides");
			return;
		} else {
			try {
				System.out.println("Efemerides disponibles para eliminar: ");
				for (int i = 0; i < listaEfemeride.size(); i++) {
					System.out.println((i + 1) + " - " + listaEfemeride.get(i).toString());
				}

				System.out.print("Seleccione el numero de la efemeride que desea eliminar: ");
				int indice = Integer.parseInt(scanner.nextLine()) - 1;

				if (indice < 0 || indice >= listaEfemeride.size()) {
					System.out.println("ERROR: Seleccion fuera de rango");
					return;
				}

				listaEfemeride.remove(indice);
				System.out.println("Efemeride eliminada");

			} catch (NumberFormatException e) {
				System.out.println("ERROR: Entrada no valida. Ingrese solo numeros");
			}
		}
	}

	public static void modificarEfemeride() {
		if (listaEfemeride.isEmpty()) {
	        System.out.println("No hay efemerides");
	        return;
	    } else {
		    try {    
		        System.out.println("Efemerides disponibles para modificar: ");
		        for (int i = 0; i < listaEfemeride.size(); i++) {
		            System.out.println((i + 1) + " - " + listaEfemeride.get(i).toString());
		        }
	
		        System.out.print("Seleccione el numero de la efemeride que desea modificar: ");
		        int indice = Integer.parseInt(scanner.nextLine()) - 1;
	
		        if (indice < 0 || indice >= listaEfemeride.size()) {
		            System.out.println("ERROR: Seleccion fuera de rango.");
		            return;
		        }
	
		        Efemeride efemeride = listaEfemeride.get(indice);
	
		        System.out.print("Ingrese el nuevo mes (1-12, si no coloca nada este no cambia): ");
		        String nuevoMesStr = scanner.nextLine();
		        if (!nuevoMesStr.isEmpty()) {
		            int nuevoMes = Integer.parseInt(nuevoMesStr);
		            if (nuevoMes >= 1 && nuevoMes <= 12) {
		                efemeride.setMes(Mes.values()[nuevoMes - 1]);
		            } else {
		                System.out.println("ERROR: Mes fuera de rango. Este dato no se modificara");
		            }
		        }
	
		        System.out.print("Ingrese el nuevo dia (si no coloca nada este no cambia): ");
		        String nuevoDiaStr = scanner.nextLine();
		        if (!nuevoDiaStr.isEmpty()) {
		            int nuevoDia = Integer.parseInt(nuevoDiaStr);
		            if (nuevoDia >= 1 && nuevoDia <= 31) {
		                efemeride.setDia(nuevoDia);
		            } else {
		                System.out.println("ERROR: Dia fuera de rango. Este dato no se modificara");
		            }
		        }
	
		        System.out.print("Ingrese el nuevo detalle (si no coloca nada este no cambia): ");
		        String nuevoDetalle = scanner.nextLine();
		        if (!nuevoDetalle.isEmpty()) {
		            efemeride.setDetalle(nuevoDetalle);
		        }
	
		        System.out.println("Efemeride modificada");
	
		    } catch (NumberFormatException e) {
		        System.out.println("ERROR: Ingrese numeros validos. Los datos modificados hasta ahora permaneceran");
		    }
		}
	}
}
