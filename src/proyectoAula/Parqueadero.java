package proyectoAula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Parqueadero {
	
	private Map<String, Vehiculo> aparcados = new HashMap<String, Vehiculo>();
	private List<VehiculoOficial> oficiales = new ArrayList<VehiculoOficial>();
	private List<VehiculoResidente> residentes = new ArrayList<VehiculoResidente>();
	private List<Vehiculo> historialVehiculos = new ArrayList<Vehiculo>();
	
	private Scanner lectorTeclado = new Scanner(System.in);
	
	/**
	 * Hace el registro de la entrada de un vehiculo al parqueadero
	 */
	public void registrarEntrada() {
		String matricula = ingresarMatricula();
		if(aparcados.containsKey(matricula)) {
			System.out.println("El vehiculo ya se encuentra aparcado.");
			return;
		}
		Vehiculo vehiculo = buscarEnOficiales(matricula);
		if(vehiculo == null) {
			vehiculo = buscarEnResidentes(matricula);
			if(vehiculo == null) {
				vehiculo = buscarEnHistorial(matricula);
				if(vehiculo == null) {
					vehiculo = registrarNuevoVehiculo(matricula);
					
					if(vehiculo instanceof VehiculoOficial) {
						oficiales.add((VehiculoOficial) vehiculo);
					} else if(vehiculo instanceof VehiculoResidente) {
						residentes.add((VehiculoResidente) vehiculo);
					}
				}
			}
		}
		vehiculo.registrarEntrada();
		aparcados.put(matricula, vehiculo);
	}
	
	/**
	 * Hace el registro de la salida de un vehiculo del parqueadero
	 */
	public void registrarSalida() {
		String matricula = ingresarMatricula();
		if(!aparcados.containsKey(matricula)) {
			System.out.println("El vehiculo NO se encuentra aparcado.");
		} else {
			Vehiculo vehiculo = aparcados.get(matricula);
			vehiculo.registrarSalida();
			aparcados.remove(matricula);
		}
	}
	
	public void darDeAltaVehiculoOficial() {
		String matricula = ingresarMatricula();
		Vehiculo vehiculo = buscarEnOficiales(matricula);
		if(vehiculo != null) {
			System.out.println("El vehiculo ya se encuentra registrado como oficial.");
		} else {
			vehiculo = buscarEnResidentes(matricula);
			boolean eraResidente = vehiculo != null;
			if(vehiculo == null) {
				vehiculo = buscarEnHistorial(matricula);
				if(vehiculo == null) {
					System.out.println("No hay un vehiculo con la matricula ingresada en nuestro historial. porfavor cree el vehiculo y seleccione el tipo oficial.");
					vehiculo = registrarNuevoVehiculo(matricula);
				}
			}
			VehiculoOficial oficial = CreadorVehiculos.cambiarAOficial(vehiculo);
			oficiales.add(oficial);
			
			if(eraResidente) {
				residentes.remove(vehiculo);
			}
			
			if(aparcados.containsKey(matricula)) {
				aparcados.put(matricula, oficial);
			}
		}
	}
	
	public void darDeAltaVehiculoResidente() {
		String matricula = ingresarMatricula();
		Vehiculo vehiculo = buscarEnResidentes(matricula);
		if(vehiculo != null) {
			System.out.println("El vehiculo ya se encuentra registrado como residente.");
		} else {
			vehiculo = buscarEnOficiales(matricula);
			boolean eraOficial = vehiculo != null;
			if(vehiculo == null) {
				vehiculo = buscarEnHistorial(matricula);
				if(vehiculo == null) {
					System.out.println("No hay un vehiculo con la matricula ingresada en nuestro historial. porfavor cree el vehiculo y seleccione el tipo residente.");
					vehiculo = registrarNuevoVehiculo(matricula);
				}
			}
			VehiculoResidente residente = CreadorVehiculos.cambiarAResidente(vehiculo);
			residentes.add(residente);
			
			if(eraOficial) {
				oficiales.remove(vehiculo);
			}
			
			if(aparcados.containsKey(matricula)) {
				aparcados.put(matricula, residente);
			}
		}
	}
	
	public void comenzarMes() {
		oficiales.forEach(oficial -> oficial.limpiarEstancias());
		residentes.forEach(residente -> residente.reiniciarTiempo());
	}
	
	public void generarPagoResidentes() {
		System.out.println("ingrese el nombre del fichero donde generar el informe de residentes");
		String nombreFichero = lectorTeclado.next();
		Fichero.generarInformeResidentes(nombreFichero, residentes);
	}
	
	private Vehiculo registrarNuevoVehiculo(String matricula) {		
		System.out.println("|----------------REGISTRO DE VEHICULO---------------|");
		System.out.println("Seleccione 1 para oficial, 2 para residente, 3 u otro para no residente.");
		TipoVehiculo tipo = TipoVehiculo.getByTipo(lectorTeclado.nextInt());
		Vehiculo vehiculo = CreadorVehiculos.crearVehiculoDeTipo(tipo);
		vehiculo.setMatricula(matricula);
		historialVehiculos.add(vehiculo);
		return vehiculo;
	}
	
	private String ingresarMatricula() {
		System.out.println("Por favor ingrese la matricula del vehiculo.");
		return lectorTeclado.next();
	}
	
	private Vehiculo buscarEnHistorial(String matricula) {
		return historialVehiculos.stream().filter(vehiculo -> { return matricula.equals(vehiculo.getMatricula());}).findFirst().orElse(null);
	}

	private VehiculoOficial buscarEnOficiales(String matricula) {
		return oficiales.stream().filter(vehiculo -> { return matricula.equals(vehiculo.getMatricula());}).findFirst().orElse(null);
	}
	
	private VehiculoResidente buscarEnResidentes(String matricula) {
		return residentes.stream().filter(vehiculo -> { return matricula.equals(vehiculo.getMatricula());}).findFirst().orElse(null);
	}

	public Map<String, Vehiculo> getAparcados() {
		return aparcados;
	}
}
