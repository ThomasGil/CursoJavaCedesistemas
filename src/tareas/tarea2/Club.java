package tareas.tarea2;

import java.util.Scanner;

public class Club {

	private Socio socioA;
	private Socio socioB;
	private Socio socioC;
	private Scanner lectorTeclado;
	
	public Club() {
		this.lectorTeclado = new Scanner(System.in);
		socioA = obtenerInformacionSocio();
		socioB = obtenerInformacionSocio();
		socioC = obtenerInformacionSocio();
		buscarSocioMasAntiguo();
	}
	
	private Socio obtenerInformacionSocio() {
		System.out.println("Ingrese el nombre del socio");
		String nombre = lectorTeclado.nextLine();
		System.out.println("Ingrese la antiguedad del socio");
		int antiguedad = lectorTeclado.nextInt();
		lectorTeclado.nextLine();
		return new Socio(nombre, antiguedad);
	}
	
	private void buscarSocioMasAntiguo() {
		String nombre = socioC.nombre;
		if(socioA.antiguedad > socioB.antiguedad && socioA.antiguedad > socioC.antiguedad) {
			nombre = socioA.nombre;
		} else if(socioB.antiguedad > socioA.antiguedad && socioB.antiguedad > socioC.antiguedad) {
			nombre = socioB.nombre;
		}
		System.out.println("El socio mas antiguo del club es " + nombre);
	}
}
