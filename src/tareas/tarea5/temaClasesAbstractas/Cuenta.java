package tareas.tarea5.temaClasesAbstractas;

public abstract class Cuenta {
	private double saldo;
	private String snumCta;
	
	abstract void deposita(double cant);
	abstract double retira(double cant);
	
	public Cuenta(double saldo, String snumCta) {
		this.saldo = saldo;
		this.snumCta = snumCta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getSnumCta() {
		return snumCta;
	}
	public void setSnumCta(String snumCta) {
		this.snumCta = snumCta;
	}
}
