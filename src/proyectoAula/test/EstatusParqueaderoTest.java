package proyectoAula.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import proyectoAula.EstatusParqueadero;
import proyectoAula.Parqueadero;

class EstatusParqueaderoTest {
	
	private final long TASA_REFRESCO_ESTATUS_PARQUEADERO = 500;

	@Test
	void elHiloSeEjecutaCorrectamente() throws InterruptedException {
		EstatusParqueadero estatus = new EstatusParqueadero(new Parqueadero(), TASA_REFRESCO_ESTATUS_PARQUEADERO);
		
		assertTrue(estatus.isAlive());
		estatus.terminar();
	}
	
	@Test
	void elHiloSeTerminaDeEjecutarCorrectamente() throws InterruptedException {
		EstatusParqueadero estatus = new EstatusParqueadero(new Parqueadero(), TASA_REFRESCO_ESTATUS_PARQUEADERO);
		
		assertTrue(estatus.isAlive());
		estatus.terminar();

		assertFalse(estatus.isAlive());
	}

}
