package tareas.tarea6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tienda {
	
	private static Scanner lectorTeclado = new Scanner(System.in);
	private static List<Cliente> clientes = new ArrayList<>();
	private static List<Venta> ventas = new ArrayList<>();

	public static void main(String[] args) {
		generarVenta();
	}
	
	private static Cliente registrarCliente(String numeroId){
		System.out.println("ingrese el nombre del cliente.");
		String nombre = lectorTeclado.next();
		System.out.println("ingrese el tipo de documento del cliente (CC, TI, PASAPORTE)");
		String tipoId = lectorTeclado.next();
		Cliente cliente = new Cliente(tipoId, numeroId, nombre);
		clientes.add(cliente);
		return cliente;
	}
	
	private static void mostrarProductos(){
		for(Producto producto: Producto.values()){
			System.out.println("Codigo: "+producto.getCodigo()+", nombre: "+producto.toString()+", valor unitario: "+producto.getValor());
		}
	}
	
	private static void generarVenta(){
		boolean continuar = true;
		do {
			System.out.println("ingrese la identificacion del cliente.");
			String identificacion = lectorTeclado.next();
			Cliente cliente = obtenerClientePorIdentificacion(identificacion);
			if(cliente == null){
				cliente = registrarCliente(identificacion);
			}
			Venta venta = new Venta(cliente);
			seleccionarProductos(venta);
			venta.generarFactura();
			ventas.add(venta);
			System.out.println("Si quiere realizar otra venta ingrese 1, otro numero para salir");
			int opcion = lectorTeclado.nextInt();
			continuar = opcion == 1;
		} while (continuar);
	}
	
	private static void seleccionarProductos(Venta venta){
		mostrarProductos();
		int codigoProducto = 0;
		do {
			System.out.println("ingrese el codigo del producto seleccionado, 0 para salir o otro numero para ver productos");
			codigoProducto = lectorTeclado.nextInt();
			if(codigoProducto != 0){
				Producto producto = Producto.getByCodigo(codigoProducto);
				if(producto != null){
					System.out.println("ingrese la cantidad del producto seleccionado.");
					int cantidad = lectorTeclado.nextInt();
					while(cantidad < 1){
						System.out.println("ingrese una cantidad mayor a 0.");
						cantidad = lectorTeclado.nextInt();
					}
					ProductoCantidad item = new ProductoCantidad(producto, cantidad);
					System.out.println("valor cantidad seleccionada: $"+ item.getValorProductoXCantidad());
					venta.agregarItem(item);
					
				} else {
					mostrarProductos();
				}
			}
			
		} while (codigoProducto != 0);
		
	}
	
	private static Cliente obtenerClientePorIdentificacion(String identificacion){
		for(Cliente cliente: clientes){
			if(identificacion.equals(cliente.getNumeroIdentificacion())){
				return cliente;
			}
		}
		return null;
	}

}
