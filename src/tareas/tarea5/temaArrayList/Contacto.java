package tareas.tarea5.temaArrayList;

import java.util.Scanner;

public class Contacto {

	private Scanner lectorTeclado = new Scanner(System.in);
	private String nombre;
	private String telefono;
	private String direccion;
	
	
	
	public Contacto() {
		ingresarNombre();
		ingresarTelefono();
		ingresarDireccion();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void modificar(){
		int opcion = 0;
		do {
			System.out.println("ingrese 1 para editar nombre, 2 para editar telefono, 3 para editar direccion o 0 para salir.");
			opcion = lectorTeclado.nextInt();
			switch (opcion) {
			case 0:
				break;
			case 1:
				ingresarNombre();
				break;

			case 2:
				ingresarTelefono();
				break;
			case 3:
				ingresarDireccion();
				break;
			default:
				System.out.println("ingrese una opcion correcta.");
				break;
			}
		} while(opcion != 0);
	}
	
	public void imprimir(){
		System.out.println("Nombre: "+this.nombre+", telefono: "+this.telefono+", direccion: "+ this.direccion);
	}
	
	private void ingresarTelefono(){
		System.out.println("ingrese el telefono del contacto");
		this.telefono = lectorTeclado.next();
	}
	private void ingresarDireccion(){
		System.out.println("ingrese la direccion del contacto");
		this.direccion = lectorTeclado.next();
	}
	private void ingresarNombre(){
		System.out.println("ingrese el nombre del contacto");
		this.nombre = lectorTeclado.next();
	}
	
}
