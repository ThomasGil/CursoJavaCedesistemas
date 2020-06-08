package tareas.tarea3.vectores;

import java.util.Scanner;

public class VectorNombres {

	private Scanner lectorTeclado;
	private String[] nombres;
	
	public VectorNombres() {
		lectorTeclado = new Scanner(System.in);
		System.out.println("ingrese la cantidad de personas a almacenar");
		int cantidadPersonas = lectorTeclado.nextInt();
		nombres = new String[cantidadPersonas];
		for(int i = 0; i < cantidadPersonas; i++) {
			System.out.println("ingrese un nombre");
			nombres[i] = lectorTeclado.next();
		}
		imprimirVector();
	}
	
	public void mostrarCantidadPersonas() {
		System.out.println("la cantidad de personas almacenadas es: "+nombres.length);
	}
	
	public void contarVecesEnVector() {
		System.out.println("ingrese un nombre para buscar");
		String nombre = lectorTeclado.next();
		int veces = 0;
		for(int i = 0;i < nombres.length; i++) {
			veces += nombre.equals(nombres[i]) ? 1 : 0;
		}
		System.out.println("el nombre "+nombre+ " esta almacenado "+veces+" veces.");
	}
	
	public void actualizarNombre() {
		System.out.println("ingrese un nombre para buscar");
		String nombreAnterior = lectorTeclado.next();
		System.out.println("ingrese un nombre para actualizar");
		String nombreNuevo = lectorTeclado.next();
		for(int i = 0;i < nombres.length; i++) {
			nombres[i] = nombreAnterior.equals(nombres[i]) ? nombreNuevo : nombres[i];
		}
		imprimirVector();
	}
	
	public void imprimirVector() {
		for(int i = 0;i < nombres.length; i++) {
			System.out.println("posicion: " +i+ ", valor: "+nombres[i]);
		}
	}
}
