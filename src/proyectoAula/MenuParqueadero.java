package proyectoAula;

import java.util.Scanner;

public class MenuParqueadero {
	
	private static final long TASA_REFRESCO_ESTATUS_PARQUEADERO = 30000;
	private static final int SALIR = 0;
	private static final int REGISTRAR_ENTRADA = 1;
	private static final int REGISTRAR_SALIDA = 2;
	private static final int DAR_DE_ALTA_OFICIAL = 3;
	private static final int DAR_DE_ALTA_RESIDENTE= 4;
	private static final int COMENZAR_MES = 5;
	private static final int GENERAR_PAGO_RESIDENTES = 6;
	

	public static void main(String[] args) {
		menu(new Parqueadero());
	}
	
	private static void menu(Parqueadero parqueadero) {
		Scanner lectorTeclado = new Scanner(System.in);
		EstatusParqueadero estatus = new EstatusParqueadero(parqueadero, TASA_REFRESCO_ESTATUS_PARQUEADERO);
		
		int opcion = 0;
		do {
			mostrarOpciones();
			opcion = lectorTeclado.nextInt();
			manejarOpcion(opcion, parqueadero);
			System.out.println("\n");
		} while(opcion != 0);
		
		estatus.terminar();
		lectorTeclado.close();
	}
	
	private static void manejarOpcion(int opcion, Parqueadero parqueadero) {
		switch (opcion) {
		case SALIR:
			System.out.println("ha salido del sistema del parqueadero.");
			break;
		case REGISTRAR_ENTRADA:
			parqueadero.registrarEntrada();
			break;
		case REGISTRAR_SALIDA:
			parqueadero.registrarSalida();
			break;
		case DAR_DE_ALTA_OFICIAL:
			parqueadero.darDeAltaVehiculoOficial();
			break;
		case DAR_DE_ALTA_RESIDENTE:
			parqueadero.darDeAltaVehiculoResidente();
			break;
		case COMENZAR_MES:
			parqueadero.comenzarMes();
			break;
		case GENERAR_PAGO_RESIDENTES:
			parqueadero.generarPagoResidentes();
			break;
		default:
			System.out.println("Seleccione una opcion valida.");
			break;
		}
	}

	private static void mostrarOpciones() {
		System.out.println("Bienvenido al sistema del parqueadero, por favor seleccione la opcion a realizar");
		System.out.println("0. Salir del sistema");
		System.out.println("1. Registrar entrada vehiculo.");
		System.out.println("2. Registrar salida vehiculo.");
		System.out.println("3. Dar de alta vehiculo oficial.");
		System.out.println("4. Dar de alta vehiculo residente.");
		System.out.println("5. Comenzar mes");
		System.out.println("6. Generar pago residentes.");
	}
}
