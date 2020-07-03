package proyectoAula.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


import proyectoAula.CreadorVehiculos;
import proyectoAula.TipoVehiculo;
import proyectoAula.Vehiculo;
import proyectoAula.VehiculoNoResidente;
import proyectoAula.VehiculoOficial;
import proyectoAula.VehiculoResidente;

public class CreadorVehiculosTest {
	
	@Test
	public void cambiarVehiculosATipoResidente() {
		Vehiculo[] vehiculos = {
				CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.NO_RESIDENTE),
				CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.RESIDENTE),
				CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.OFICIAL)
		};
		
		for(int i = 0; i < vehiculos.length; i++) {
			vehiculos[i] = CreadorVehiculos.cambiarAResidente(vehiculos[i]);
		}
		
		assertAll("cambiar a residentes", 
				() -> assertTrue(vehiculos[0] instanceof VehiculoResidente),
				() -> assertTrue(vehiculos[1] instanceof VehiculoResidente),
				() -> assertTrue(vehiculos[2] instanceof VehiculoResidente)	
		);
	}
	
	@Test
	public void cambiarVehiculosATipoOficial() {
		Vehiculo[] vehiculos = {
				CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.NO_RESIDENTE),
				CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.RESIDENTE),
				CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.OFICIAL)
		};

		for(int i = 0; i < vehiculos.length; i++) {
			vehiculos[i] = CreadorVehiculos.cambiarAOficial(vehiculos[i]);
		}
		
		assertAll("cambiar a oficial", 
				() -> assertTrue(vehiculos[0] instanceof VehiculoOficial),
				() -> assertTrue(vehiculos[1] instanceof VehiculoOficial),
				() -> assertTrue(vehiculos[2] instanceof VehiculoOficial)	
		);
	}
	
	@Test 
	public void lanzaNullPointerExceptionAlCambiarAResidenteCuandoElParametroEsNull() {
		assertThrows(NullPointerException.class, () -> {CreadorVehiculos.cambiarAResidente(null);});
	}
	
	@Test 
	public void lanzaNullPointerExceptionAlCambiarAOficialCuandoElParametroEsNull() {
		assertThrows(NullPointerException.class, () -> {CreadorVehiculos.cambiarAOficial(null);});
	}

	@Test
	public void crearUnVehiculoDeTipoNoResidente() {
		Vehiculo vehiculo = CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.NO_RESIDENTE);
		assertTrue(vehiculo instanceof VehiculoNoResidente);
	}
	
	@Test
	public void crearUnVehiculoDeTipoResidente() {
		Vehiculo vehiculo = CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.RESIDENTE);
		assertTrue(vehiculo instanceof VehiculoResidente);
	}
	
	@Test
	public void crearUnVehiculoDeTipoOficial() {
		Vehiculo vehiculo = CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.OFICIAL);
		assertTrue(vehiculo instanceof VehiculoOficial);
	}
	
	@Test
	public void lanzaUnNullPointerExceptionAlCrearUnVehiculoCuandoElTipoIngresadoEsNull() {
		assertThrows(NullPointerException.class, () -> {CreadorVehiculos.crearVehiculoDeTipo(null);});
	}
}
