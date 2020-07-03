package proyectoAula.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import proyectoAula.Estancia;

class EstanciaTest {

	private long milisegundosEntrada = 0;
	private long milisegundosSalidaPlano = 120000;
	private long milisegundosSalidaFraccion = 150000;
	private int minutosEstancia = 2;
	
	@Test
	void calcularElTiempoDeEstanciaDelObjetoMinutoExacto() {
		Estancia estancia = new Estancia();
		
		Date entrada = new Date(milisegundosEntrada);
		Date salida = new Date(milisegundosSalidaPlano);
		
		estancia.setHoraEntrada(entrada);
		estancia.setHoraSalida(salida);
		
		int calculoMinutosEstancia = estancia.calcularMinutosEstancia();
		
		
		assertEquals(minutosEstancia, calculoMinutosEstancia);
	}
	
	@Test
	void calcularElTiempoDeEstanciaDelObjetoMinutoFraccion() {
		Estancia estancia = new Estancia();
		
		Date entrada = new Date(milisegundosEntrada);
		Date salida = new Date(milisegundosSalidaFraccion);
		
		estancia.setHoraEntrada(entrada);
		estancia.setHoraSalida(salida);
		
		int calculoMinutosEstancia = estancia.calcularMinutosEstancia();
		
		assertEquals(minutosEstancia, calculoMinutosEstancia);
	}
	
	@Test
	void calcularElTiempoDeEstanciaConParametrosDeEntradaMinutoExacto() {
		Date entrada = new Date(milisegundosEntrada);
		Date salida = new Date(milisegundosSalidaPlano);
		
		int calculoMinutosEstancia = Estancia.calcularMinutosEstancia(salida, entrada);
		
		assertEquals(minutosEstancia, calculoMinutosEstancia);
	}
	
	@Test
	void calcularElTiempoDeEstanciaConParametrosDeEntradaMinutoFraccion() {
		Date entrada = new Date(milisegundosEntrada);
		Date salida = new Date(milisegundosSalidaFraccion);
		
		int calculoMinutosEstancia = Estancia.calcularMinutosEstancia(salida, entrada);
		
		assertEquals(minutosEstancia, calculoMinutosEstancia);
	}

}
