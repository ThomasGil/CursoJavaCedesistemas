package proyectoAula;

import java.util.Date;

public class VehiculoNoResidente extends Vehiculo {

	public VehiculoNoResidente(int tarifaMinuto) {
		super(tarifaMinuto);
	}

	@Override
	public void registrarSalida() {
		this.getUltimaEstancia().setHoraSalida( new Date() );
		Fichero.generarInformeNoResidente(this);
	}

	@Override
	public long calcularPago() {
		return this.getUltimaEstancia().calcularMinutosEstancia() * this.getTarifaMinuto();
	}

}
