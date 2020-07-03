package proyectoAula.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;

import proyectoAula.Estancia;
import proyectoAula.TipoVehiculo;
import proyectoAula.VehiculoResidente;

class VehiculoResidenteTest {
	
	private long milisegundosSalidaPlano = 120000;
	private long pagoEsperado = 100;

	@Test
	void alRegistrarSalidaActualizaHoraSalidaUltimaEstanciaYAumentaMinutosParqueado() {
		VehiculoResidente vehiculo = new VehiculoResidente(TipoVehiculo.RESIDENTE.getTarifaMinuto());
		Estancia estancia = new Estancia();
		long milisegundosActualMenosDosMinutos = new Date().getTime() - milisegundosSalidaPlano;
		estancia.setHoraEntrada(new Date(milisegundosActualMenosDosMinutos));
		vehiculo.setUltimaEstancia(estancia);
		
		vehiculo.registrarSalida();
		
		assertNotNull(vehiculo.getUltimaEstancia().getHoraSalida());
		assertNotEquals(0, vehiculo.getMinutosParqueado());
	}
	
	@Test
	void despuesDeRegistrarDosSalidasConCadaEstanciaDeDosMinutosElCobroAPagarEs100() {
		VehiculoResidente vehiculo = new VehiculoResidente(TipoVehiculo.RESIDENTE.getTarifaMinuto());
		Estancia estancia = new Estancia();
		long milisegundosActualMenosDosMinutos = new Date().getTime() - milisegundosSalidaPlano;
		estancia.setHoraEntrada(new Date(milisegundosActualMenosDosMinutos));
		vehiculo.setUltimaEstancia(estancia);
		
		vehiculo.registrarSalida();
		
		Estancia estancia2 = new Estancia();
		milisegundosActualMenosDosMinutos = new Date().getTime() - milisegundosSalidaPlano;
		estancia2.setHoraEntrada(new Date(milisegundosActualMenosDosMinutos));
		vehiculo.setUltimaEstancia(estancia2);
		
		vehiculo.registrarSalida();
		
		assertEquals(pagoEsperado, vehiculo.calcularPago());
	}
	
	@Test
	void alReiniciarTiempoParqueadoEsteDebeQuedarEnCero() {
		VehiculoResidente vehiculo = new VehiculoResidente(TipoVehiculo.RESIDENTE.getTarifaMinuto());
		Estancia estancia = new Estancia();
		long milisegundosActualMenosDosMinutos = new Date().getTime() - milisegundosSalidaPlano;
		estancia.setHoraEntrada(new Date(milisegundosActualMenosDosMinutos));
		vehiculo.setUltimaEstancia(estancia);
		
		vehiculo.registrarSalida();
		
		vehiculo.reiniciarTiempo();
		
		assertEquals(0, vehiculo.getMinutosParqueado());
	}

}
