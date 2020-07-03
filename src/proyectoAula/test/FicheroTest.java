package proyectoAula.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import proyectoAula.CreadorVehiculos;
import proyectoAula.Fichero;
import proyectoAula.TipoVehiculo;
import proyectoAula.VehiculoResidente;

class FicheroTest {
	
	private final String nombreFichero = "D:\\informeTest.txt";

	@Test
	void lanzaNullPointerExceptionAlGenerarInformeDeNoResidenteConVehiculoNull() {
		assertThrows(NullPointerException.class, () -> Fichero.generarInformeNoResidente(null));
	}
	
	@Test
	void generaElFicheroConElInformeDeResidentes() {
		List<VehiculoResidente> residentes = new ArrayList<VehiculoResidente>();
		residentes.add((VehiculoResidente) CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.RESIDENTE));
		
		Fichero.generarInformeResidentes(nombreFichero, residentes);
		
		File fichero = new File(nombreFichero);
		assertTrue(fichero.exists());
		fichero.delete();
	}
	
	@Test
	void generaElFicheroConElInformeDeResidentesSinExtencionPuntoTXT() {
		List<VehiculoResidente> residentes = new ArrayList<VehiculoResidente>();
		residentes.add((VehiculoResidente) CreadorVehiculos.crearVehiculoDeTipo(TipoVehiculo.RESIDENTE));
		
		Fichero.generarInformeResidentes(nombreFichero.substring(0,nombreFichero.lastIndexOf(".")), residentes);
		
		File fichero = new File(nombreFichero);
		assertTrue(fichero.exists());
		fichero.delete();
	}
	
	@Test
	void noGeneraElFicheroConElInformeDeResidentesCuandoLaListaEstaVacia() {
		List<VehiculoResidente> residentes = new ArrayList<VehiculoResidente>();
		
		Fichero.generarInformeResidentes(nombreFichero, residentes);
		
		File fichero = new File(nombreFichero);
		assertTrue(!fichero.exists());
		fichero.delete();
	}
	
	@Test
	void lanzaNullPointerExceptionGeneraElFicheroConElInformeDeResidentesCuandoLaListaEsNull() {		
		assertThrows(NullPointerException.class, () -> Fichero.generarInformeResidentes(nombreFichero, null));	
	}

}
