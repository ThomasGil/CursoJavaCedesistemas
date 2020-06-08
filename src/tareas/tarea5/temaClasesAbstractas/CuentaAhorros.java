package tareas.tarea5.temaClasesAbstractas;

public class CuentaAhorros extends Cuenta {

	public CuentaAhorros(double saldo, String snumCta) {
		super(saldo, snumCta);
	}

	@Override
	void deposita(double cant) {
		this.setSaldo(this.getSaldo() + cant);
		System.out.println("Saldo actual despues de transaccion: $"+ this.getSaldo());
	}

	@Override
	double retira(double cant) {
		if(this.getSaldo() - cant < 0){
			System.out.println("no tiene fondos suficientes para realizar la transaccion");
		} else {
			this.setSaldo(this.getSaldo() - cant);
			System.out.println("Saldo actual despues de transaccion: $"+ this.getSaldo());
		}
		return cant;
	}

}
