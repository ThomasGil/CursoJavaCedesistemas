package tareas.tarea4;

import java.util.Scanner;

public class MyListadeClaseList {
	
	private Estudiante raiz;
	private int longitudMaxima = 5;

	public boolean isEmpty(){
		return raiz == null;
	}
	
	public void insert(Estudiante estudiante){
		if(this.isEmpty()){
			raiz = estudiante;
		} else {
			Estudiante auxiliar = raiz;
			int posicion = 1;
			while(auxiliar.getSiguiente() != null){
				auxiliar = auxiliar.getSiguiente();
				posicion++;
			}
			if(posicion == longitudMaxima){
				System.out.println("No puede agregar mas estudiantes a la lista.");
				auxiliar.setSiguiente(null);
			} else {
				auxiliar.setSiguiente(estudiante);
			}
			
		}
	}
	
	public Estudiante extract(){
		if(this.isEmpty()){
			return raiz;
		} else {
			Estudiante auxuliar = raiz;
			raiz = raiz.getSiguiente();
			return auxuliar;
		}
	}
	
	public void actualizar(int poscicionEstudiante){
		if(poscicionEstudiante >= longitudMaxima ){
			System.out.println("La posicion ingresada execede el maximo de la lista ("+longitudMaxima+").");
		}
		Scanner lectorTeclado = new Scanner(System.in);
		while(poscicionEstudiante < longitudMaxima){
			Estudiante auxiliar = this.obtenerEstudiante(poscicionEstudiante);
			if(auxiliar != null){
				auxiliar.tomarAsistencia();
			} else {
				System.out.println("no hay un estudiante en la posicion ingresada.");
			}
			System.out.println("para acutalizar otra lista de asistencia ingrese una nueva poscicion. para terminar ingrese un numero mayor a "+longitudMaxima);
			poscicionEstudiante = lectorTeclado.nextInt();
		}
		lectorTeclado.close();
		 
	}
	
	public void print (int posicionImprimir){
		Estudiante auxiliar = this.obtenerEstudiante(posicionImprimir);
		if(auxiliar != null){
			System.out.println("el estudiante numero "+posicionImprimir+" es: "+ auxiliar.getNombre());
			auxiliar.imprimir();
		}
	}
	
	public void print(){
		int posicion = 0;
		Estudiante auxiliar = raiz;
		while(auxiliar.getSiguiente() != null){
			System.out.println("el estudiante numero "+posicion+" es: "+ auxiliar.getNombre());
			auxiliar.imprimir();
			auxiliar = auxiliar.getSiguiente();
			posicion ++;
		}
		System.out.println("el estudiante numero "+ (++posicion) +" es: "+ auxiliar.getNombre());
		auxiliar.imprimir();
	}
	
	private Estudiante obtenerEstudiante(int posicionBuscar) {
		Estudiante auxiliar = raiz;
		if(!this.isEmpty()){
			int posicion = 0;
			while(auxiliar.getSiguiente() != null && posicion < posicionBuscar){
				auxiliar = auxiliar.getSiguiente();
				posicion++;
			}
			if(posicion == posicionBuscar){
				return auxiliar;
			} else {
				return null;
			}
		} 
		return auxiliar;
	}
}
