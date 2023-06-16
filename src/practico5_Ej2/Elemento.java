package practico5_Ej2;

public class Elemento {
	private String descripcion;
	private int valor;
	private int peso;
	
	public Elemento(String desc, int valor, int peso) {
		this.valor = valor;
		this.peso = peso;
		this.descripcion = desc;
	}

	public int getValor() {
		return valor;
	}

	public int getPeso() {
		return peso;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
