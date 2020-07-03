package proyectoAula.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import proyectoAula.Vehiculo;

class VehiculoTest {

	@Test
	void alRegistrarEntradaLaUltimaEstanciaNoEsNullYTieneHoraEntrada() {
		Vehiculo vehiculoMock = getVehiculoMock();
		vehiculoMock.registrarEntrada();
		
		assertAll(
				() -> assertNotNull(vehiculoMock.getUltimaEstancia()),
				() -> assertNotNull(vehiculoMock.getUltimaEstancia().getHoraEntrada())
		);
	}
	
	private Vehiculo getVehiculoMock() {
		return new Vehiculo(0) {
			
			@Override
			public void registrarSalida() {			
			}
			
			@Override
			public long calcularPago() {
				return 0;
			}
		};
	}
}
