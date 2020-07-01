package proyectoAula;

public enum TipoVehiculo {
	OFICIAL(1, 0),
	RESIDENTE(2, 25),
	NO_RESIDENTE(3, 50);
	
	private final int tipo;
	private final int tarifaMinuto;
	
	public static TipoVehiculo getByTipo(int tipo) {
		for(TipoVehiculo tipoVehiculo: TipoVehiculo.values()) {
			if(tipoVehiculo.getTipo() == tipo) {
				return tipoVehiculo;
			}
		}
		return NO_RESIDENTE;
	}
	
	private TipoVehiculo(int tipo, int tarifaMinuto) {
		this.tipo = tipo;
		this.tarifaMinuto = tarifaMinuto;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public int getTarifaMinuto() {
		return tarifaMinuto;
	}
}
