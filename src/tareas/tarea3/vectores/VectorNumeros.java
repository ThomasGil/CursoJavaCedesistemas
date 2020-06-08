package tareas.tarea3.vectores;

import java.util.Scanner;

public class VectorNumeros{

	private int numeros[];
	private Scanner lectorTeclado;
	
	public VectorNumeros() {
		lectorTeclado = new Scanner(System.in);
		numeros = new int [10];
		for(int i = 0; i < numeros.length ; i++) {
			numeros[i] = i;
		}
		imprimirVector();
	}
	
	public void cambiarValor() {
		System.out.println("ingrese una posicion del vector");
		int posicion = lectorTeclado.nextInt();
		System.out.println("Ingrese el nuevo valor");
		int valor = lectorTeclado.nextInt();
		numeros[posicion] = valor;
		imprimirVector();
	}
	
	private void imprimirVector() {
		for(int i = 0; i < numeros.length; i++) {
			System.out.println("posicion: " +i+ ", valor: "+numeros[i]);
		}
	}
		
}
