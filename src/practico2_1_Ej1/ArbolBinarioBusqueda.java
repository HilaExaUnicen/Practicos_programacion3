package practico2_1_Ej1;

public class ArbolBinarioBusqueda {
	
	private NodoArbol raiz;
	
	public ArbolBinarioBusqueda() {
		this.raiz = null;
	}

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
		
	public boolean hasElem(int valor) {
		if(this.raiz.getValor() == valor) {
			return true;
		}
		else {
			return hasElem(this.raiz, valor);
		}
	}
	
	public boolean hasElem(NodoArbol nodo, int valor) {
		if(nodo.getValor() == valor) {
			return true;
		}
		else if(nodo.getValor() < valor) {
			if(nodo.getDerecha() != null) {
				return hasElem(nodo.getDerecha(), valor);
			}
			else {
				return false;
			}
		}
		else {
			if(nodo.getIzquierda() != null) {
				return hasElem(nodo.getIzquierda(), valor);
			}
			else {
				return false;
			}
		}
	}
	
	public boolean delete(int valor) {
		if(!this.hasElem(valor)) {
			return false;
		}
		else {
			return delete(this.raiz, valor);
		}
	}
	
	public boolean delete(NodoArbol nodo, int valor) {
		if(nodo != null && nodo.getValor() == valor) {
			if(nodo.getIzquierda() == null && nodo.getDerecha() == null) {
				nodo = null;
			}
			else if(nodo.getIzquierda() != null && nodo.getDerecha() == null) {
				NodoArbol aux = nodo.getIzquierda();
				nodo = aux;
			}
			else if(nodo.getIzquierda() == null && nodo.getDerecha()!= null) {
				NodoArbol aux = nodo.getDerecha();
				nodo = aux;
			}
			else {
				//TODO CUANDO TIENE LOS DOS NODOS
				//METODO QUE DEVUELVA NODO MAS IZQUIERDO DE SU SUBARBOL DERECHO
				NodoArbol nmiSubArbolDerecho = buscarNMISubArbolDerecho(nodo.getDerecha());
				int nuevoValorNodo = nmiSubArbolDerecho.getValor();
				//Borrar nodo mas izquierdo 
				delete(nmiSubArbolDerecho, valor);
				//Borramos el nodo a eliminar actualizando su valor
				nodo.setValor(nuevoValorNodo);
			}
		}
		else if (nodo.getValor() < valor) {
			delete(nodo.getDerecha(), valor);
		}
		else {
			delete(nodo.getIzquierda(), valor);
		}
		
		return true; //Siempre devuelve true porque se supone que si entra a este metodo el valor a borrar existe en el arbol y se borra
	}
	
	
	
	private NodoArbol buscarNMISubArbolDerecho(NodoArbol nodoDerecha) {
		NodoArbol temp = nodoDerecha;
		while(temp.getIzquierda() != null) {
			temp = temp.getIzquierda();
		}
		
		return temp;
	}
	
//	public int getHeight() {
//		//TODO	
//	}

	public boolean isEmpty() {
		return this.raiz == null;
	}
	
	public int getRoot() {
		return this.raiz.getValor();
	}
}
