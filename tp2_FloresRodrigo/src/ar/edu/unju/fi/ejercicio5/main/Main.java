package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {

	static final Scanner scanner = new Scanner(System.in);
	static final List<Producto> listaProductos = new ArrayList<>();

	public static void main(String[] args) {
		List<Producto> productosCargados = precargarProductos(listaProductos);

		int opcion;

		do {
			mostrarMenu();
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1:
				mostrarProductos(productosCargados);
				pausa();
				break;
			case 2:
				realizarCompra(productosCargados);
				pausa();
				break;
			case 3:
				System.out.println("*SALIENDO DEL PROGRAMA*");
				break;
			default:
				System.out.println("Opcion no valida");
				pausa();
			}
		} while (opcion != 3);
	}

	public static List<Producto> precargarProductos(List<Producto> productos) {
		if (productos.isEmpty()) {
			productos.add(new Producto(1, "Celular Samsung Argentino", 50000f, Producto.OrigenFabricacion.ARGENTINA,
					Producto.Categoria.TELEFONIA, true));
			productos.add(new Producto(2, "Notebook Argentina", 60000f, Producto.OrigenFabricacion.ARGENTINA,
					Producto.Categoria.INFORMATICA, false));
			productos.add(new Producto(3, "Microondas Argentino", 60000f, Producto.OrigenFabricacion.ARGENTINA,
					Producto.Categoria.ELECTROHOGAR, true));
			productos.add(new Producto(4, "Herramientas Argentinas", 60000f, Producto.OrigenFabricacion.ARGENTINA,
					Producto.Categoria.HERRAMIENTAS, false));
			productos.add(new Producto(5, "Celular Motorola Argentino", 60000f, Producto.OrigenFabricacion.ARGENTINA,
					Producto.Categoria.TELEFONIA, true));
			productos.add(new Producto(6, "Celular Nokia Argentino", 50000f, Producto.OrigenFabricacion.ARGENTINA,
					Producto.Categoria.TELEFONIA, false));
			productos.add(new Producto(7, "Celular Samsung Chino", 50000f, Producto.OrigenFabricacion.CHINA,
					Producto.Categoria.TELEFONIA, true));
			productos.add(new Producto(8, "Notebook China", 60000f, Producto.OrigenFabricacion.CHINA,
					Producto.Categoria.INFORMATICA, false));
			productos.add(new Producto(9, "Microondas Chino", 60000f, Producto.OrigenFabricacion.CHINA,
					Producto.Categoria.ELECTROHOGAR, true));
			productos.add(new Producto(10, "Celular Samsung Brasil", 50000f, Producto.OrigenFabricacion.BRASIL,
					Producto.Categoria.TELEFONIA, true));
			productos.add(new Producto(11, "Notebook Brasil", 60000f, Producto.OrigenFabricacion.BRASIL,
					Producto.Categoria.INFORMATICA, false));
			productos.add(new Producto(12, "Microondas Brasil", 60000f, Producto.OrigenFabricacion.BRASIL,
					Producto.Categoria.ELECTROHOGAR, true));
			productos.add(new Producto(13, "Celular Samsung Uruguayo", 50000f, Producto.OrigenFabricacion.URUGUAY,
					Producto.Categoria.TELEFONIA, true));
			productos.add(new Producto(14, "Notebook Uruguaya", 60000f, Producto.OrigenFabricacion.URUGUAY,
					Producto.Categoria.INFORMATICA, false));
			productos.add(new Producto(15, "Microondas Uruguayo", 60000f, Producto.OrigenFabricacion.URUGUAY,
					Producto.Categoria.ELECTROHOGAR, true));
		}
		return productos;
	}

	public static void mostrarMenu() {
		System.out.println("""
				Menu de opciones:
				1 - Mostrar productos
				2 - Realizar compra
				3 - Salir
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

	public static void mostrarProductos(List<Producto> productos) {
		System.out.println("Lista de productos: ");
		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}

	public static void realizarCompra(List<Producto> productos) {
		List<Producto> productosSeleccionados = new ArrayList<>();
		boolean continuar = true;

		while (continuar) {
			System.out.println("Ingrese el codigo del producto que desea comprar (ingrese 0 para terminar): ");
			int codigo;
			try {
				codigo = Integer.parseInt(scanner.nextLine());
				if (codigo == 0) {
					continuar = false;
				} else {
					Producto producto = buscarProductoPorCodigo(productos, codigo);
					if (producto != null) {
						if (producto.isEstado()) {
							productosSeleccionados.add(producto);
							System.out.println("Producto agregado al carro: " + producto.getDescripcion());
						} else {
							System.out.println("No queda stock del producto");
						}
					} else {
						System.out.println("Producto no encontrado");
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Ingrese un numero valido");
			}
		}

		if (!productosSeleccionados.isEmpty()) {
			double montoTotal = productosSeleccionados.stream().mapToDouble(p -> p.getPrecioUnitario()).sum();

			System.out.println("Seleccione el metodo de pago: ");
			System.out.println("1 - Efectivo");
			System.out.println("2 - Tarjeta");

			int metodoPago;
			try {
				metodoPago = Integer.parseInt(scanner.nextLine());
				Pago pago;
				switch (metodoPago) {
				case 1:
					pago = new PagoEfectivo();
					break;
				case 2:
					System.out.println("Ingrese el numero de tarjeta: ");
					String numeroTarjeta = scanner.nextLine();
					pago = new PagoTarjeta(numeroTarjeta, LocalDate.now(), 0);
					break;
				default:
					throw new IllegalArgumentException("Metodo de pago invalido");
				}

				pago.realizarPago(montoTotal);
				System.out.println("\n***RECIBO***");
				System.out.println(pago.imprimirRecibo());

			} catch (Exception e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		} else {
			System.out.println("No se seleccionaron productos");
		}
	}

	public static Producto buscarProductoPorCodigo(List<Producto> productos, int codigo) {
		return productos.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
	}
}
