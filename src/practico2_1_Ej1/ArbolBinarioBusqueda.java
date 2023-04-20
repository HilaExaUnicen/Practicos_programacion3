package practico2_1_Ej1;

public class ArbolBinarioBusqueda {
	
	private NodoArbol raiz;

	public ArbolBinarioBusqueda(NodoArbol raiz) {
		this.raiz = raiz;
	}
	
	public void add(int valor) {
		NodoArbol nuevoNodo = new NodoArbol(valor);
		if(this.raiz == null) {
			this.raiz = nuevoNodo;
		}
		else {
			add(this.raiz, valor);
		}
	}
	
	public void add(NodoArbol nodo, int valor) {
		if(nodo.getValor() > valor) {
			if(nodo.getIzquierda() == null) {
				NodoArbol nuevoNodo = new NodoArbol(valor);
				nodo.setIzquierda(nuevoNodo);
			}
			else {
				add(nodo.getIzquierda(), valor);
			}
		}
		else if(nodo.getValor() < valor) {
			if(nodo.getDerecha() == null) {
				NodoArbol nuevoNodo = new NodoArbol(valor);
				nodo.setDerecha(nuevoNodo);
			}
			else {
				add(nodo.getDerecha(), valor);
			}
		}
	}
	
	public int getRoot() {
		return this.raiz.getValor();
	}
	
	public boolean hasElem(int valor) {
		
	}
	
	public boolean isEmpty() {
		return this.raiz == null;
	}
}
