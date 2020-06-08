package tareas.tarea2;

import java.util.Random;
import java.util.Scanner;

public class JuegoDados {
	
	private int dadoUno;
	private int dadoDos;
	private int dadoTres;
	
	private Scanner lectorTeclado;
	
	public JuegoDados() {
		this.lectorTeclado = new Scanner(System.in);
		jugarLosDados();
	}
	
	private int generarAleatorioNumeroEntreUnoYSeis() {
		Random generadorAleatorio = new Random();
		return generadorAleatorio.nextInt(6) + 1;
	}
	
	private void tirarLosDados() {
		dadoUno = generarAleatorioNumeroEntreUnoYSeis();
		dadoDos = generarAleatorioNumeroEntreUnoYSeis();
		dadoTres = generarAleatorioNumeroEntreUnoYSeis();
	}
	
	private void mostrarResultado() {
		System.out.println("Dado uno : " +dadoUno);
		System.out.println("Dado dos : " +dadoDos);
		System.out.println("Dado tres: " +dadoTres);
		if(dadoUno == dadoDos && dadoUno == dadoTres) {
			System.out.println("Gano !!");
		} else {
			System.out.println("perdio :(");
		}
	}
	
	public void jugarLosDados() {
		int jugar = 0;
		do {
			tirarLosDados();
			mostrarResultado();
			System.out.println("Para seguir jugando presione 0, para salir 1");
			jugar = lectorTeclado.nextInt(); 
		} while (jugar == 0);
	}
}
