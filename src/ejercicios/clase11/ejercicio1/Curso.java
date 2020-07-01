package ejercicios.clase11.ejercicio1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Curso {
	
	private static final int MAX_ALUMNOS = 2; 
	
	private Map<String, Alumno> alumnos = new HashMap<String, Alumno>();
	private Scanner scanner = new Scanner(System.in);
	
	public void matricular() {
		Alumno alumno = crearAlumno();
		if(alumnos.containsKey(alumno.getDni())) {
			System.out.println("El alumno ya esta matriculado.");
		} else if(alumnos.size() >= MAX_ALUMNOS) {
			System.out.println("ya no hay cupos para este curso.");
		} 
		else {
			alumnos.put(alumno.getDni(), alumno);
		}
	}
	
	public void buscarAlumnoPorDNI() {
		System.out.println("Ingrese el dni del alumno.");
		String dni = scanner.next();
		Alumno alumno = alumnos.get(dni);
		if(alumno != null) {
			System.out.println(alumno.toString());
		} else {
			System.out.println("El alumno no esta matriculado.");
		}
	}
	
	public void mostrarDatos() {
		System.out.println("Hay "+alumnos.size()+" alumno(s) matriculados en el curso.");
		alumnos.forEach((dni, alumno) -> {System.out.println(alumno.toString());});
	}
	
	private Alumno crearAlumno() {
		System.out.println("Ingrese el nombre del alumno.");
		String nombre = scanner.next();
		System.out.println("Ingrese el dni del alumno.");
		String dni = scanner.next();
		System.out.println("Ingrese la direccion del alumno.");
		String direccion = scanner.next();
		System.out.println("Ingrese el telefono del alumno.");
		String telefono = scanner.next();
		return new Alumno(dni,nombre,direccion,telefono);
	}
}
