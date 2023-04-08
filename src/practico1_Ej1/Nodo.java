package practico1_Ej1;

public class Nodo<T> {
	
	private T valor;
	private Nodo<T> nodoSiguiente;
	
	public Nodo(T valor, Nodo<T> nodoSiguiente) {
		this.valor = valor;
		this.nodoSiguiente = nodoSiguiente;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public Nodo<T> getNodoSiguiente() {
		return nodoSiguiente;
	}

	public void setNodoSiguiente(Nodo<T> nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	
	
	
	
}
