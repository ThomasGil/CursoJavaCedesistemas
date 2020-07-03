package proyectoAula.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;

import proyectoAula.Estancia;
import proyectoAula.TipoVehiculo;
import proyectoAula.Vehiculo;
import proyectoAula.VehiculoNoResidente;

class VehiculoNoResidenteTest {
	
	private long milisegundosSalidaPlano = 120000;
	private long pagoEsperado = 100;

	@Test
	void alRegistrarSalidaDebeActualizarHoraSalidaEnUltimaEstancia() {
		Vehiculo vehiculo = new VehiculoNoResidente(TipoVehiculo.NO_RESIDENTE.getTarifaMinuto());
		Estancia estancia = new Estancia();
		long milisegundosActualMenosDosMinutos = new Date().getTime() - milisegundosSalidaPlano;
		estancia.setHoraEntrada(new Date(milisegundosActualMenosDosMinutos));
		vehiculo.setUltimaEstancia(estancia);
		
		vehiculo.registrarSalida();
		
		assertNotNull(vehiculo.getUltimaEstancia().getHoraSalida());
	}
	
	@Test
	void despuesDeRegistrarSalidaElPagoDeDosMinutosSon100() {
		Vehiculo vehiculo = new VehiculoNoResidente(TipoVehiculo.NO_RESIDENTE.getTarifaMinuto());
		Estancia estancia = new Estancia();
		long milisegundosActualMenosDosMinutos = new Date().getTime() - milisegundosSalidaPlano;
		estancia.setHoraEntrada(new Date(milisegundosActualMenosDosMinutos));
		vehiculo.setUltimaEstancia(estancia);
		
		vehiculo.registrarSalida();
		
		assertEquals(pagoEsperado, vehiculo.calcularPago());
	}

}
