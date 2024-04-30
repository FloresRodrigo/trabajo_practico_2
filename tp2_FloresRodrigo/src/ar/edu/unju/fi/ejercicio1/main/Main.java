package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {

	static final Scanner scanner = new Scanner(System.in);
	static final List<Producto> listaProductos = new ArrayList<>();

	public static void main(String[] args) {

		int opcion;

		do {
			mostrarMenu();
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1:
				crearProducto();
				pausa();
				break;
			case 2:
				mostrarProductos();
				pausa();
				break;
			case 3:
				modificarProducto();
				pausa();
				break;
			case 4:
				System.out.println("*SALIENDO DEL PROGRAMA*");
				break;
			default:
				System.out.println("Opcion no valida");
				pausa();
			}
		} while (opcion != 4);

	}

	public static void mostrarMenu() {
		System.out.println("""
				Menu de opciones:
				1 - Crear producto
				2 - Mostrar productos
				3 - Modificar producto
				4 - Salir
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

	public static void crearProducto() {
		try {
			System.out.println("Creando nuevo producto");

			System.out.print("Ingrese el codigo del producto (un numero entero): ");
			int codigo = Integer.parseInt(scanner.nextLine());

			System.out.print("Ingrese la descripcion del producto: ");
			String descripcion = scanner.nextLine();

			System.out.print("Ingrese el precio unitario del producto: ");
			float precioUnitario = Float.parseFloat(scanner.nextLine());

			System.out.println("Seleccione el origen de fabricacion: ");
			for (int i = 0; i < OrigenFabricacion.values().length; i++) {
				System.out.println((i + 1) + " - " + OrigenFabricacion.values()[i]);
			}
			System.out.print("Elija una opcion: ");
			int opcionOrigen = Integer.parseInt(scanner.nextLine());
			OrigenFabricacion origen = OrigenFabricacion.values()[opcionOrigen - 1];

			System.out.println("Seleccione la categoria del producto: ");
			for (int i = 0; i < Categoria.values().length; i++) {
				System.out.println((i + 1) + " - " + Categoria.values()[i]);
			}
			System.out.print("Elija opcion: ");
			int opcionCategoria = Integer.parseInt(scanner.nextLine());
			Categoria categoria = Categoria.values()[opcionCategoria - 1];

			Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, origen, categoria);
			listaProductos.add(nuevoProducto);

			System.out.println("Producto creado");

		} catch (NumberFormatException | InputMismatchException e) {
			System.out.println("ERROR: Por favor, ingrese valores validos");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("ERROR: Opcion invalida");
		}
	}

	public static void mostrarProductos() {
		if (listaProductos.isEmpty()) {
			System.out.println("No hay productos");
		} else {
			System.out.println("Lista de productos: ");
			for (Producto producto : listaProductos) {
				System.out.println(producto.toString());
			}
		}
	}

	public static void modificarProducto() {
		if (listaProductos.isEmpty()) {
			System.out.println("No hay productos para modificar");
			return;
		} else {
			try {
				System.out.println("Productos disponibles para modificar: ");
				for (int i = 0; i < listaProductos.size(); i++) {
					System.out.println((i + 1) + " - " + listaProductos.get(i).toString());
				}

				System.out.print("Seleccione el numero del producto que desea modificar: ");
				int indiceProducto = Integer.parseInt(scanner.nextLine()) - 1;

				if (indiceProducto < 0 || indiceProducto >= listaProductos.size()) {
					System.out.println("ERROR: Seleccion fuera de rango.");
					return;
				}

				Producto producto = listaProductos.get(indiceProducto);

				System.out.print("Ingrese la nueva descripcion (si no escribe nada este no cambia): ");
				String nuevaDescripcion = scanner.nextLine();
				if (!nuevaDescripcion.isEmpty()) {
					producto.setDescripcion(nuevaDescripcion);
				}

				System.out.print("Ingrese el nuevo precio unitario (si no escribe nada este no cambia): ");
				String nuevoPrecio = scanner.nextLine();
				if (!nuevoPrecio.isEmpty()) {
					producto.setPrecioUnitario(Float.parseFloat(nuevoPrecio));
				}

				System.out.println("Seleccione el nuevo origen de fabricacion (si no escribe nada este no cambia): ");
				for (int i = 0; i < Producto.OrigenFabricacion.values().length; i++) {
					System.out.println((i + 1) + " - " + Producto.OrigenFabricacion.values()[i]);
				}
				String nuevaOpcionOrigen = scanner.nextLine();
				if (!nuevaOpcionOrigen.isEmpty()) {
					int opcionOrigen = Integer.parseInt(nuevaOpcionOrigen);
					producto.setOrigen(Producto.OrigenFabricacion.values()[opcionOrigen - 1]);
				}

				System.out.println("Seleccione la nueva categoria (si no escribe nada este no cambia): ");
				for (int i = 0; i < Producto.Categoria.values().length; i++) {
					System.out.println((i + 1) + " - " + Producto.Categoria.values()[i]);
				}
				String nuevaOpcionCategoria = scanner.nextLine();
				if (!nuevaOpcionCategoria.isEmpty()) {
					int opcionCategoria = Integer.parseInt(nuevaOpcionCategoria);
					producto.setCategoria(Producto.Categoria.values()[opcionCategoria - 1]);
				}

				System.out.println("Producto modificado");

			} catch (NumberFormatException e) {
				System.out.println("ERROR: Por favor, ingrese un valor valido");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("ERROR: Opcion ivalida");
			}
		}
	}
}
