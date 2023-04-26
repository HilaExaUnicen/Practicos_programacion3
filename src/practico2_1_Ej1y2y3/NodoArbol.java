package practico2_1_Ej1y2y3;

public class NodoArbol {
	
	private int valor;
	private NodoArbol izquierda, derecha;
	
	
	public NodoArbol(int valor, NodoArbol izquierda, NodoArbol derecha) {
		this.valor = valor;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}
	
	public NodoArbol(int valor) {
		this.valor = valor;
		this.izquierda = null;
		this.derecha = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public NodoArbol getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(NodoArbol izquierda) {
		this.izquierda = izquierda;
	}

	public NodoArbol getDerecha() {
		return derecha;
	}

	public void setDerecha(NodoArbol derecha) {
		this.derecha = derecha;
	}
}
