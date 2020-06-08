package ejercicios;

public class Main {

	public static void main(String[] args) {
		ejecutarRutinaEmpleado();

	}
	
	private static void ejecutarRutinaEmpleado() {
		Empleado empleado = new Empleado();
		empleado.agregarInformacion();
		empleado.imprimirDatos();
		empleado.debePagarImpuestos();
	}

}
