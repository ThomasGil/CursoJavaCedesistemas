package proyectoAula;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehiculoOficial extends Vehiculo {
	
	public VehiculoOficial(int tarifaMinuto) {
		super(tarifaMinuto);
	}

	private List<Estancia> estancias = new ArrayList<Estancia>();

	@Override
	public void registrarSalida() {
		this.getUltimaEstancia().setHoraSalida( new Date() );
		estancias.add(this.getUltimaEstancia());
		this.setUltimaEstancia(null);
	}

	@Override
	public long calcularPago() {
		return estancias.stream().mapToInt(estancia -> {return estancia.calcularMinutosEstancia() * this.getTarifaMinuto();}).sum();
	}
	
	public void limpiarEstancias() {
		estancias.clear();
	}

	public List<Estancia> getEstancias() {
		return estancias;
	}
}
