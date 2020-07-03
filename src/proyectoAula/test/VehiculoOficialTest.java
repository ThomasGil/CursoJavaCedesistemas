package proyectoAula.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import proyectoAula.Estancia;
import proyectoAula.TipoVehiculo;
import proyectoAula.VehiculoOficial;

class VehiculoOficialTest {
	
	private long milisegundosSalidaPlano = 120000;
	
	@Test
	void alRegistrarSalidaAgregaLaEstanciaAlHistorial() {
		VehiculoOficial vehiculo = new VehiculoOficial(TipoVehiculo.OFICIAL.getTarifaMinuto());
		
		Estancia estancia = new Estancia();
		long milisegundosActualMenosDosMinutos = new Date().getTime() - milisegundosSalidaPlano;
		estancia.setHoraEntrada(new Date(milisegundosActualMenosDosMinutos));
		vehiculo.setUltimaEstancia(estancia);
		
		assertTrue(vehiculo.getEstancias().isEmpty());
		
		vehiculo.registrarSalida();
		
		assertTrue(!vehiculo.getEstancias().isEmpty());
	}
	
	@Test
	void alCalcularElPagoDeUnVehiculoOficialSiempreDebeSerCeroAsiTengaEstanciasRegistradas() {
		VehiculoOficial vehiculo = new VehiculoOficial(TipoVehiculo.OFICIAL.getTarifaMinuto());
		
		Estancia estancia = new Estancia();
		long milisegundosActualMenosDosMinutos = new Date().getTime() - milisegundosSalidaPlano;
		estancia.setHoraEntrada(new Date(milisegundosActualMenosDosMinutos));
		vehiculo.setUltimaEstancia(estancia);
		
		vehiculo.registrarSalida();
		
		assertEquals(0,vehiculo.calcularPago());
	}
	
	@Test
	void alLimpiarEstanciasElHistorialDebeQuedarVacio() {
		VehiculoOficial vehiculo = new VehiculoOficial(TipoVehiculo.OFICIAL.getTarifaMinuto());
		
		Estancia estancia = new Estancia();
		long milisegundosActualMenosDosMinutos = new Date().getTime() - milisegundosSalidaPlano;
		estancia.setHoraEntrada(new Date(milisegundosActualMenosDosMinutos));
		vehiculo.setUltimaEstancia(estancia);
		
		vehiculo.registrarSalida();
		
		assertTrue(!vehiculo.getEstancias().isEmpty());
		
		vehiculo.limpiarEstancias();
		
		assertTrue(vehiculo.getEstancias().isEmpty());
	}

}
