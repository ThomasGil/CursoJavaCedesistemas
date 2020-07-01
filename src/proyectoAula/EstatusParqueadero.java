package proyectoAula;

import java.util.Date;

public class EstatusParqueadero extends Thread {

	private Parqueadero parqueadero;
	private boolean ejecutar;
	
	public EstatusParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
		this.start();
	}
	
	@Override
	public void run() {
		ejecutar = true;
		while(ejecutar) {
			try {
				mostrarVehiculosAparcados();
				sleep(30000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void terminar() {
		ejecutar = false;
	}
	
	private void mostrarVehiculosAparcados() {
		final Date horaActual = new Date();
		System.out.println();
		System.out.println("VEHICULOS APARCADOS ACTUALMENTE");
		this.parqueadero.getAparcados().forEach((matricula, vehiculo) -> {
			System.out.println(obtenerTipoVehiculo(vehiculo)+": "+matricula+" -> "+Estancia.calcularMinutosEstancia(horaActual, vehiculo.getUltimaEstancia().getHoraEntrada()) +" min.");
		}); 
		System.out.println();
	}
	
	private String obtenerTipoVehiculo(Vehiculo vehiculo) {
		String tipo = TipoVehiculo.NO_RESIDENTE.name();
		if(vehiculo instanceof VehiculoOficial) {
			tipo = TipoVehiculo.OFICIAL.name();
		} else if(vehiculo instanceof VehiculoResidente) {
			tipo = TipoVehiculo.RESIDENTE.name();
		}
		return tipo;
	}
}
