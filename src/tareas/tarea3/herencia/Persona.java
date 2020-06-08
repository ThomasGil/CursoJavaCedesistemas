package tareas.tarea3.herencia;

import java.util.Scanner;

public class Persona {
	
	protected Scanner lectorTeclado = new Scanner(System.in);
	protected String nombre;
	protected int edad;
	
	public Persona () {
		cargarDatos();
	}

	public void cargarDatos() {
		System.out.println("ingrese el nombre");
		nombre = lectorTeclado.next();
		System.out.println("ingrese la edad");
		edad = lectorTeclado.nextInt();
	}
	
	public void imprimirDatos() {
		System.out.println("Su nombre es: "+ nombre);
		System.out.println("Su edad es: "+ edad);
	}
}
