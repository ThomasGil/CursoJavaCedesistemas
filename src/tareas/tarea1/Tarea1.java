package tareas.tarea1;

import java.util.Scanner;

public class Tarea1 {
	
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		ejercicio1();
		System.out.println("\n ---------- \n");
		ejercicio4();
		System.out.println("\n ---------- \n");
		ejercicio5();
		System.out.println("\n ---------- \n");
		ejercicio7();
		System.out.println("\n ---------- \n");
		ejercicio10();
	}
	/**
	 * cribir un programa en el cual se ingresen cuatro números, calcular e informar la suma de los dos primeros y el producto del tercero y el cuarto.
	 */
	private static void ejercicio1() {
		int [] numeros = new int[4];
		for(int i = 0, n = numeros.length; i < n; i++) {
			System.out.println("Ingrese un numero.");
			numeros[i] = lector.nextInt();
		}
		
		System.out.println("la suma de los dos primeros numeros ingresados es "+numeros[0]+" + " +numeros[1]+" = " +(numeros[0] + numeros[1]));
		System.out.println("la suma de los dos ultimos numeros ingresados es "+numeros[2]+" x " +numeros[3]+" = " +(numeros[2] * numeros[3]));
		
	}
	
	/**
	 * Se debe desarrollar un programa que pida el ingreso del precio de un artículo y la cantidad que lleva el cliente. Mostrar lo que debe abonar el comprador.
	 */
	private static void ejercicio4(){
		System.out.println("Ingrese el valor unitario del producto.");
		int valorUnitario = lector.nextInt();
		System.out.println("Ingrese la cantidad de unidades vendidas del producto.");
		int unidadesVendidas = lector.nextInt();
		System.out.println("La cantidad de dinero a abonar es: $" + (valorUnitario * unidadesVendidas));
		
	}
	
	/**
	 * Un postulante a un empleo, realiza un test de capacitación, se obtuvo la siguiente información: cantidad total de preguntas que se le realizaron y la cantidad de preguntas que contestó correctamente. Se pide confeccionar un programa que ingrese los dos datos por teclado e informe el nivel del mismo según el porcentaje de respuestas correctas que ha obtenido, y sabiendo que:
	 * Nivel máximo:	Porcentaje>=90%.
	 * Nivel medio:	Porcentaje>=75% y <90%.
	 * Nivel regular:	Porcentaje>=50% y <75%.
	 * Fuera de nivel:	Porcentaje<50%.	
	 */
	private static void ejercicio5() {
		System.out.println("Ingrese el total de preguntas realizadas.");
		float preguntasRealizadas = lector.nextFloat();
		System.out.println("Ingrese el total de preguntas respondidas correctamente.");
		float preguntasCorrectas = lector.nextFloat();
		float porcentajeAcierto = (preguntasCorrectas / preguntasRealizadas) * 100;
		String nivel = "nivel maximo";
		if(porcentajeAcierto < 50) {
			nivel = "fuera de nivel";
		} else if(porcentajeAcierto < 75) {
			nivel = "nivel regular";
		} else if(porcentajeAcierto < 90) {
			nivel = "nivel medio";
		}
		System.out.println("El postulante al empleo esta en " + nivel);
		
	}
	
	/**
	 * Se ingresan un conjunto de n alturas de personas por teclado. Mostrar la altura promedio de las personas
	 */
	private static void ejercicio7() {
		float altura = -1;
		float acomuladoAlturas = 0;
		int cantidadAlturas = 0;
		
		System.out.println("Para salir presione 0 + Enter, los decimales van despues de una coma (,)");
		do {
			System.out.println("Ingrese la altura de la persona");
			altura = lector.nextFloat();
			if(altura != 0) {
				acomuladoAlturas += altura;
				cantidadAlturas++;
			}
		} while (altura != 0);
		float promedioAltura = acomuladoAlturas == 0 && cantidadAlturas == 0 ? 0 : acomuladoAlturas/cantidadAlturas;
		System.out.println("El promedio de las alturas ingresadas fue: " +promedioAltura);
	}
	
	/**
	 * Desarrollar un programa que muestre la tabla de multiplicar del 5 (del 5 al 50)
	 */
	private static void ejercicio10() {
		System.out.println("tabla de multiplicar del 5 (del 5 al 50)");
		for(int i = 5, n = 50; i <= n; i++) {
			int producto = 5 * i;
			System.out.println("5x" +i+ " = " +producto );
		}
	}
}
