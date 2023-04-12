package practico1_Ej8;

public class Nodo<T> {
	
	Nodo<T> nodoAnterior, nodoSiguiente;
	T valor;
	
	public Nodo(Nodo<T> nodoAnterior, Nodo<T> nodoSiguiente, T valor) {
		this.nodoAnterior = nodoAnterior;
		this.nodoSiguiente = nodoSiguiente;
		this.valor = valor;
	}

	public Nodo<T> getNodoAnterior() {
		return nodoAnterior;
	}

	public void setNodoAnterior(Nodo<T> nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}

	public Nodo<T> getNodoSiguiente() {
		return nodoSiguiente;
	}

	public void setNodoSiguiente(Nodo<T> nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
}
