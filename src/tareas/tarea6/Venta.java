package tareas.tarea6;

import java.util.ArrayList;
import java.util.List;

public class Venta {
	private Cliente cliente;
	private List<ProductoCantidad> items;
	
	public Venta(Cliente cliente){
		this.cliente = cliente;
		items = new ArrayList<>();
	}
	
	public void agregarItem(ProductoCantidad itemEnVenta){
		boolean existeItem = false;
		for(ProductoCantidad itemEnLista: items){
			if(itemEnLista.getProducto().getCodigo() == itemEnVenta.getProducto().getCodigo()){
				existeItem = true;
				itemEnLista.setCantidad(itemEnLista.getCantidad() + itemEnVenta.getCantidad());
			}
		}
		if(!existeItem){
			items.add(itemEnVenta);
		}
	}
	
	public void generarFactura(){
		System.out.println();
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("|------------------------------- FACTURA DE VENTA ---------------------------------|");
		System.out.println("|"
				+llenarConGuiones("----------------------------------------------------------------------------------", "Cliente -> nombre: "+this.cliente.getNombre()+", identificacion: "+this.cliente.getNumeroIdentificacion())
				+"|");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("|---Nombre producto---|---Codigo---|---Valor unitario---|---cantidad---|---total---|");
		double totalVenta = 0;
		for(ProductoCantidad item: items){
			System.out.println("|"+llenarConGuiones("---Nombre producto---", item.getProducto().toString())
					+"|"+llenarConGuiones("---Codigo---", String.valueOf(item.getProducto().getCodigo()))
					+"|"+llenarConGuiones("---Valor unitario---",  "$"+item.getProducto().getValor())
					+"|"+llenarConGuiones("---cantidad---",  String.valueOf(item.getCantidad()))
					+"|"+llenarConGuiones("---total---",  "$"+item.getValorProductoXCantidad())
					+"|"
			);
			totalVenta += item.getValorProductoXCantidad();
		}
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("|El total de la venta es: -----------------------------------"+llenarConGuiones("----------------------", "$"+totalVenta)+"|");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println();
	}
	
	private String llenarConGuiones(String formato, String palabra){
		int espaciosDisponibles = formato.length() - palabra.length();
		int mitadEspacios = espaciosDisponibles / 2;
		StringBuilder palabraConGuiones = new StringBuilder();
		for(int i = 0; i < mitadEspacios; i++){
			palabraConGuiones.append("-");
		}
		palabraConGuiones.append(palabra);
		palabra = palabraConGuiones.toString();
		for(int i = palabra.length(); i < formato.length(); i++){
			palabraConGuiones.append("-");
		}
		return palabraConGuiones.toString();
	}
}
