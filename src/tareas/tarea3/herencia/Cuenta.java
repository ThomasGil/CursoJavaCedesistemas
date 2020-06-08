package tareas.tarea3.herencia;

public class Cuenta extends Persona {

	private String tipoCuenta;
	private int saldo;
	
	public Cuenta () {
		System.out.println("Ingrese el tipo de cuenta");
		tipoCuenta = lectorTeclado.next();
		System.out.println("Ingrese el saldo");
		saldo = lectorTeclado.nextInt();
		consultarTipoDeCuenta();
		consultarSaldo();
	}

	public void consultarTipoDeCuenta() {
		System.out.println("el tipo de la cuenta es: " + tipoCuenta);
	}
	
	public void consultarSaldo() {
		System.out.println("su saldo es: " + saldo);
	}
	
	public void consignar() {
		System.out.println("Ingrese el monto a consignar");
		int monto = lectorTeclado.nextInt();
		saldo += monto;
		imprimirResultadoTransaccion(monto, true);
	}
	
	public void retirar() {
		System.out.println("Ingrese el monto a retirar");
		int monto = lectorTeclado.nextInt();
		if(saldo - monto > 0) {
			saldo -= monto;
			imprimirResultadoTransaccion(monto, false);
		} else {
			System.out.println("No posee el saldo suficiente para relizar la transaccion");
		}
		
	}
	
	private void imprimirResultadoTransaccion(int cantidad, boolean consignacion) {
		System.out.println("Cliente : "+ nombre);
		System.out.println("Se realizo una transaccion en su cuenta " + tipoCuenta);
		if(consignacion) {
			System.out.println("El monto a consignar fue: " + cantidad);
		} else {
			System.out.println("El monto a retirar fue: " + cantidad);
		}
		System.out.println("Su saldo actual es: "+ saldo);
	}
}
