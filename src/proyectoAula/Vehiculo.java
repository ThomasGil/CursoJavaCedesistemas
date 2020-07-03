package proyectoAula;

import java.util.Date;

public abstract class Vehiculo {

	private int tarifaMinuto;
	private String matricula;
	private Estancia ultimaEstancia;
	
	public Vehiculo (int tarifaMinuto) {
		this.tarifaMinuto = tarifaMinuto;
	}
	
	/**
	 * Registra la hora de entrada de una estancia en el parqueadero
	 */
	public void registrarEntrada() {
		this.ultimaEstancia = new Estancia();
		this.ultimaEstancia.setHoraEntrada( new Date() );
	};
	
	/**
	 * Registra la hora de salida de la ultima estancia en el parqueadero
	 */
	public abstract void registrarSalida();
	
	/**
	 * Calcula el monto a pagar segun el tiempo en el parqueadero
	 * @return
	 */
	public abstract long calcularPago();
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Estancia getUltimaEstancia() {
		return ultimaEstancia;
	}
	public void setUltimaEstancia(Estancia ultimaEstancia) {
		this.ultimaEstancia = ultimaEstancia;
	}
	public int getTarifaMinuto() {
		return tarifaMinuto;
	}
}
