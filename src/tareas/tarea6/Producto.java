package tareas.tarea6;

public enum Producto {
	BANANO (	1,	1000),
	MANZANA(	2,	1500),
	GRANADILLA(	3,	850),
	PERA(	4,	1300),
	UVA(	5,	950),
	MORA(	6,	1450),
	MARACUYA(	7,	1600),
	NARANJA(	8,	1100),
	KIWI(	9,	1300),
	GUANABANA(	10,	2000);
	
	private final int codigo;
	private final double valor;
	
	private Producto(int codigo, double valor){
		this.codigo = codigo;
		this.valor = valor;
	}
	
	public static Producto getByCodigo(int codigo){
		for(Producto producto: Producto.values()){
			if(producto.codigo == codigo){
				return producto;
			}
		}
		return null;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getValor() {
		return valor;
	}
}
