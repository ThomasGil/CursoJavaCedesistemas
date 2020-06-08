package tareas.tarea3.herencia;

public class Empleado extends Persona{

	private int sueldo;
	
	public Empleado() {
		cargarDatosEmpleado();
	}
	
	public void cargarDatosEmpleado() {
		System.out.println("Ingrese su sueldo:");
		sueldo = lectorTeclado.nextInt();
	}
	
	public void imprimirDatosEmpleado() {
		this.imprimirDatos();
		System.out.println("Su sueldo es: " + sueldo);
	}
	
}
