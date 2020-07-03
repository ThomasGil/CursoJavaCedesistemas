package proyectoAula.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import proyectoAula.TipoVehiculo;

class TipoVehiculoTest {

	@Test
	void obtenerTipoVehiculoNoResidenteCuandoTipoIngresadoNoExiste() {
		TipoVehiculo tipoVehiculo = TipoVehiculo.getByTipo(0);
		assertEquals(tipoVehiculo, TipoVehiculo.NO_RESIDENTE);
	}

	@Test
	void obtenerTipoVehiculoCorrectoParaCasosExistentes() {
		assertAll(
				() -> assertEquals(TipoVehiculo.NO_RESIDENTE, TipoVehiculo.getByTipo(TipoVehiculo.NO_RESIDENTE.getTipo())),
				() -> assertEquals(TipoVehiculo.RESIDENTE, TipoVehiculo.getByTipo(TipoVehiculo.RESIDENTE.getTipo())),
				() -> assertEquals(TipoVehiculo.OFICIAL, TipoVehiculo.getByTipo(TipoVehiculo.OFICIAL.getTipo()))
				);
	}
	
}
