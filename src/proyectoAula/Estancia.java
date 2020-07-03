package proyectoAula;

import java.util.Date;

public class Estancia {
	private static final int CONVERSOR_MILISEGUNDOS_A_MINUTOS = 60000;
	
	private Date horaEntrada;
	private Date horaSalida;
	
	public int calcularMinutosEstancia() {
		long diferencia = horaSalida.getTime() - horaEntrada.getTime(); 
		return (int) (diferencia / CONVERSOR_MILISEGUNDOS_A_MINUTOS  % 60);
	}
	
	public static int calcularMinutosEstancia(Date horaSalida, Date horaEntrada) {
		Estancia estancia = new Estancia();
		estancia.setHoraEntrada(horaEntrada);
		estancia.setHoraSalida(horaSalida);
		return estancia.calcularMinutosEstancia();
	}
	
	public Date getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public Date getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}	
}
