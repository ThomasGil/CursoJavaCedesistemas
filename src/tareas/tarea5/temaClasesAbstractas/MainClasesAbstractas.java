package tareas.tarea5.temaClasesAbstractas;

import java.util.Scanner;

public class MainClasesAbstractas {

	public static void main(String[] args) {
		Scanner lectorTeclado = new Scanner(System.in);
		System.out.println("ingrese numero cuenta.");
		String numeroCuenta = lectorTeclado.next();
		System.out.println("ingrese saldo inicial.");
		Double saldo = lectorTeclado.nextDouble();
		CuentaAhorros cuentaAhorros = new CuentaAhorros(saldo, numeroCuenta);
		
		System.out.println("ingrese saldo a depositar.");
		double cantidadTransaccion = lectorTeclado.nextDouble();
		cuentaAhorros.deposita(cantidadTransaccion);
		
		System.out.println("ingrese saldo a retirar.");
		cantidadTransaccion = lectorTeclado.nextDouble();
		cuentaAhorros.retira(cantidadTransaccion);
		
		lectorTeclado.close();
	}

}
