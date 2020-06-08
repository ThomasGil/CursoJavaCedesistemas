package ejercicios;

import java.util.Scanner;

public class Empleado {

	private String nombre;
	private int sueldo;
	
	public void agregarInformacion() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("ingresar el nombre del empleado.");
		this.nombre = entrada.nextLine();
		System.out.println("ingresar el salario del empleado.");
		this.sueldo = entrada.nextInt();
		entrada.close();
	}
	
	public void imprimirDatos() {
		System.out.println("El empleado " +this.nombre+ " tiene un sueldo de $"+this.sueldo);
	}
	
	public void debePagarImpuestos() {
		String pagaImpuestos = sueldo > 3000000 ? "si" : "no";
		System.out.println("El empleado " +this.nombre+ " "+pagaImpuestos+ " debe pagar impuestos.");
	}
}
