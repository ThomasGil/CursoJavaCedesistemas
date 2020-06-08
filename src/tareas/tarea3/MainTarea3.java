package tareas.tarea3;

import tareas.tarea3.herencia.Cuenta;
import tareas.tarea3.herencia.Empleado;
import tareas.tarea3.herencia.Persona;
import tareas.tarea3.matrices.Matriz;
import tareas.tarea3.vectores.VectorNombres;
import tareas.tarea3.vectores.VectorNumeros;

public class MainTarea3 {

	public static void main(String[] args) {
		ejercicio1Herencia();
		ejercicio2Herencia();
		ejercicio4Vectores();
		ejercicio5Vectores();
		ejercicio3Matrices();
		ejercicio5Matrices();
	}

	private static void ejercicio1Herencia() {
		Persona persona = new Persona();
		persona.imprimirDatos();
		Empleado empleado = new Empleado();
		empleado.imprimirDatosEmpleado();
	}
	
	private static void ejercicio2Herencia() {
		Cuenta cuenta = new Cuenta();
		cuenta.consignar();
		cuenta.retirar();
	}
	
	private static void ejercicio4Vectores() {
		VectorNumeros vector = new VectorNumeros();
		vector.cambiarValor();
	}
	
	private static void ejercicio5Vectores() {
		VectorNombres nombres = new VectorNombres();
		nombres.mostrarCantidadPersonas();
		nombres.contarVecesEnVector();
		nombres.actualizarNombre();
	}
	
	private static void ejercicio3Matrices() {
		Matriz matriz = new Matriz();
		matriz.ejercicio3();
	}
	
	private static void ejercicio5Matrices() {
		Matriz matriz = new Matriz();
		matriz.ejercicio5();
	}
}
