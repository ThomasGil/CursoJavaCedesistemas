package proyectoAula;

import java.util.Date;

public class VehiculoResidente extends Vehiculo {
	
	private int minutosParqueado;

	public VehiculoResidente(int tarifaMinuto) {
		super(tarifaMinuto);
	}

	@Override
	public void registrarSalida() {
		this.getUltimaEstancia().setHoraSalida(new Date());
		acumularMinutosUltimaEstancia();
	}

	@Override
	public long calcularPago() {
		return minutosParqueado * this.getTarifaMinuto();
	}
	
	private void acumularMinutosUltimaEstancia() {
		this.minutosParqueado += this.getUltimaEstancia().calcularMinutosEstancia();
	}
	
	public void reiniciarTiempo() {
		minutosParqueado = 0;
	}

	public int getMinutosParqueado() {
		return minutosParqueado;
	}
}
