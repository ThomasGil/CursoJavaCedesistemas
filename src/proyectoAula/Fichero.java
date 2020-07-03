package proyectoAula;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class Fichero {
	
	private static final int LONGUITUD_CAMPO = 40;
	private static final String MATRICULA = "Matricula";
	private static final String TIEMPO_ESTACIONADO = "Tiempo estacionado (min)";
	private static final String VALOR_PAGAR = "Valor a pagar";
	private static final String SALTO_LINEA = "\n";

	public static void generarInformeResidentes(String nombreFichero, List<VehiculoResidente> residentes) {
		StringBuilder informe = new StringBuilder();
		informe.append(SALTO_LINEA)
		.append(generarSeparador())
		.append(generarCabecera());
		
		for(VehiculoResidente vehiculo: residentes) {
			String matricula = vehiculo.getMatricula();
			String tiempo = String.valueOf(vehiculo.getMinutosParqueado());
			String valorPagar = String.valueOf(vehiculo.calcularPago());
			
			informe.append(generarLinea(matricula, tiempo, valorPagar));
		}
		
		informe.append(generarSeparador());
		
		System.out.println(informe.toString());
		if(!residentes.isEmpty()) guardarInformeEnFichero(nombreFichero, informe.toString());
	}
	
	public static void generarInformeNoResidente(VehiculoNoResidente vehiculo) {
		String matricula = vehiculo.getMatricula();
		String tiempo = String.valueOf(vehiculo.getUltimaEstancia().calcularMinutosEstancia());
		String valorPagar = String.valueOf(vehiculo.calcularPago());
		
		StringBuilder informe = new StringBuilder();
		informe.append(SALTO_LINEA)
		.append(generarSeparador())
		.append(generarCabecera())
		.append(generarLinea(matricula, tiempo, valorPagar))
		.append(generarSeparador());
		
		System.out.println(informe.toString());	
	}
	
	private static String generarSeparador() {
		StringBuilder separador = new StringBuilder();
		int tamanoSeparador = LONGUITUD_CAMPO * 3;
		for (int i = 0; i < tamanoSeparador; i++) {
			separador.append("-");
		}
		separador.append(SALTO_LINEA);
		return separador.toString();
	}
	
	private static String generarCabecera() {
		return generarLinea(MATRICULA, TIEMPO_ESTACIONADO, VALOR_PAGAR);
	}
	
	private static String generarLinea(String matricula, String tiempo, String valorPagar) {
		return llenarEspacios(matricula) + llenarEspacios(tiempo)+llenarEspacios(valorPagar)+SALTO_LINEA;
	}
	
	public static String llenarEspacios(String campo) {
		return String.format("%-" + LONGUITUD_CAMPO + "." + LONGUITUD_CAMPO + "s", campo);
	}
	
	private static void guardarInformeEnFichero(String nombreFichero, String informe) {
		int indexExtension = nombreFichero.lastIndexOf(".");
		nombreFichero = indexExtension == -1 ? nombreFichero : nombreFichero.substring(0, indexExtension);
		nombreFichero += ".txt";

		File fichero = new File(nombreFichero);
		try (OutputStream os = new FileOutputStream(fichero)) {
			os.write(informe.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
