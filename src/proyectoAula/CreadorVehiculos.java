package proyectoAula;

public class CreadorVehiculos {
	
	public static VehiculoOficial cambiarAOficial(Vehiculo vehiculo) {
		VehiculoOficial oficial = new VehiculoOficial(TipoVehiculo.OFICIAL.getTarifaMinuto());
		oficial.setMatricula(vehiculo.getMatricula());
		oficial.setUltimaEstancia(vehiculo.getUltimaEstancia());
		return oficial;
	}
	
	public static VehiculoResidente cambiarAResidente(Vehiculo vehiculo) {
		VehiculoResidente residente = new VehiculoResidente(TipoVehiculo.RESIDENTE.getTarifaMinuto());
		residente.setMatricula(vehiculo.getMatricula());
		residente.setUltimaEstancia(vehiculo.getUltimaEstancia());
		return residente;
	}
	
	public static Vehiculo crearVehiculoDeTipo(TipoVehiculo tipo) {
		switch (tipo) {
		case OFICIAL:
			return new VehiculoOficial(tipo.getTarifaMinuto());
		case RESIDENTE:
			return new VehiculoResidente(tipo.getTarifaMinuto());
		case NO_RESIDENTE:
		default:
			return new VehiculoNoResidente(tipo.getTarifaMinuto());
		}
	}
}
