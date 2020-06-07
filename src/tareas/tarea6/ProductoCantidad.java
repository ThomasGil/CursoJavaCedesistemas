package tareas.tarea6;

public class ProductoCantidad {

	private Producto producto;
	private int cantidad;

	public ProductoCantidad(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public double getValorProductoXCantidad(){
		return cantidad * producto.getValor();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
