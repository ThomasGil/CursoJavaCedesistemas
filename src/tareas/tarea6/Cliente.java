package tareas.tarea6;

public class Cliente {
	
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private String nombre;
	
	public Cliente(String tipoIdentificacion, String numeroIdentificacion, String nombre) {
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
	}
	
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public String getNombre() {
		return nombre;
	}
	
}
