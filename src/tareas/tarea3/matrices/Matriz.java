package tareas.tarea3.matrices;

import java.util.Scanner;

public class Matriz {
	private Scanner lectorTeclado = new Scanner(System.in);
	
	public void ejercicio3() {
		int matriz [][] = new int [2][5];
		int suma [] = {0,0};
		for(int i = 0; i < matriz.length; i ++) {
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.println("ingrese un numero");
				matriz[i][j] = lectorTeclado.nextInt();
				suma[i] += matriz[i][j];
			}
		}
		
		for(int i = 0; i < matriz.length; i ++) {
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println(", suma fila: " + suma[i]);
		}
	}

	public void ejercicio5() {
		int matriz [][] = new int [9][9];
		for(int i = 0; i < matriz.length; i ++) {
			for(int j = 0; j < matriz[i].length; j++) {
				int valor = j - i <= 0 ? 1 : j + 1;
				System.out.print(valor);
			}
			System.out.println();
		}
	}
}
