package tareas.tarea4;

import java.util.Scanner;

public class Estudiante {

	private String nombre;
	private Estudiante siguiente;
	private boolean[] asistencia = new boolean[5];
	private Scanner lectorTeclado = new Scanner(System.in);

	public Estudiante (){
		System.out.println("ingrese el nombre del estudiante.");
		this.nombre = lectorTeclado.next();
		tomarAsistencia();
	}
	
	public Estudiante getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Estudiante siguiente) {
		this.siguiente = siguiente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void tomarAsistencia(){
		boolean seguirPreguntando = true;
		System.out.println("ingrese 1 para confirmar asistencia, 0 para confirmar falta, otro numero para llenar de faltas.");
		for(int i = 0; i < asistencia.length; i++){
			if(seguirPreguntando){
				System.out.println("¿El estudiante "+this.nombre+" asistio a la clase "+i+"?");
				int asistioAClase = lectorTeclado.nextInt();
				if(asistioAClase == 1){
					asistencia[i] = true;
				} else {
					if(asistioAClase != 0 && asistioAClase != 1){
						seguirPreguntando = false;
					}
					asistencia[i] = false;
				}
			} else {
				asistencia[i] = false;
			}
		}
	}
	
	public void imprimir(){
		System.out.println("Soy el estudiante "+ this.nombre + " y mi asistencia es la siguiente:");
		for(int i = 0; i < asistencia.length; i++){
			System.out.print("clase "+i+" ("+asistencia[i]+"), ");
		}
		System.out.println();
		System.out.println();
	}
}
