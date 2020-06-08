package tareas.tarea2;

import java.util.Scanner;

public class Operaciones {
	private Scanner lectorTeclado;
	private int primerNumero;
	private int segundoNumero;
	
	public Operaciones() {
		this.lectorTeclado = new Scanner(System.in);
		System.out.println("Ingrese un numero.");
		this.primerNumero = lectorTeclado.nextInt();
		System.out.println("Ingrese otro numero.");
		this.segundoNumero = lectorTeclado.nextInt();
		sumar();
		restar();
		multiplicar();
		dividir();
	}
	
	private void sumar() {
		int suma = primerNumero + segundoNumero;
		System.out.println("la suma de los 2 numeros ingresados es: " +primerNumero+ " + " +segundoNumero+ " = " + suma);
	}
	private void restar() {
		int resta = primerNumero - segundoNumero;
		System.out.println("la resta de los 2 numeros ingresados es: " +primerNumero+ " - " +segundoNumero+ " = " + resta);
	}
	private void multiplicar() {
		int producto = primerNumero * segundoNumero;
		System.out.println("el producto de los 2 numeros ingresados es: " +primerNumero+ " * " +segundoNumero+ " = " + producto);
	}
	private void dividir() {
		int cociente = 0;
		int residuo = 0;
		if(segundoNumero == 0) {
			if(primerNumero == 0) {
				System.out.println("La division 0/0 esta indeterminada.");
			} else {
				System.out.println("No puede realizar division por 0");
			}			
		} else {
			cociente = primerNumero / segundoNumero;
			if(primerNumero < segundoNumero) {
				residuo = primerNumero % segundoNumero;
				System.out.println("el cociente de los 2 numeros ingresados es: " +primerNumero+ " / " +segundoNumero+ " = " +cociente+ " y el residuo = " +residuo);
			} else {
				System.out.println("el cociente de los 2 numeros ingresados es: " +primerNumero+ " / " +segundoNumero+ " = " + cociente);
			}
		}
		
	}
}
