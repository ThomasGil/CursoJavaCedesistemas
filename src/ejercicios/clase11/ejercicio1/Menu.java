package ejercicios.clase11.ejercicio1;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Curso curso = new Curso();
		
		int opcion = 0;
		do {
			mostrarOpciones();
			System.out.println("Ingrese la opcion a realizar.");
			opcion = scanner.nextInt();
			switch (opcion) {
			case 0:
				System.out.println("Ha salido del menu.");
				break;
			case 1:
				curso.matricular();
				break;
			case 2:
				curso.buscarAlumnoPorDNI();
				break;
			case 3:
				curso.mostrarDatos();
				break;
			default:
				System.out.println("Seleccione una opcion correcta.");
				mostrarOpciones();
				break;
			}
		} while(opcion != 0);
		
		scanner.close();
	}
	
	private static void mostrarOpciones() {
		System.out.println("0. salir.");
		System.out.println("1. matricular alumno.");
		System.out.println("2. buscar alumno por dni.");
		System.out.println("3. ver datos curso.");
	}

}
