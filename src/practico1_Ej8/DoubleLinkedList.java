package practico1_Ej8;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {
	
	private Nodo<T> primerNodo;
	private int size;
	
	public DoubleLinkedList(Nodo<T> primerNodo) {
		this.primerNodo = primerNodo;
		this.size = 1;
	}
	
	public DoubleLinkedList() {
		this.primerNodo = null;
		this.size = 0;
	}
	
	public void insertFront(T valor) { //Insertar como primer nodo
		Nodo<T> nuevoNodo = new Nodo<T>(null, null, valor);
		nuevoNodo.setNodoSiguiente(this.primerNodo);
		this.primerNodo.setNodoAnterior(nuevoNodo);
		this.primerNodo = nuevoNodo;
		size++;
	}
	
	public T extractFront() { //Extraer y retornar el primerNodo;
		if(this.primerNodo == null) {
			return null;
		}
		else {
			T valorNodo = this.primerNodo.getValor();
			this.primerNodo = this.primerNodo.getNodoSiguiente();
			size--;
			return valorNodo;
		}	
	}
	
	public boolean isEmpty() {
		return (this.primerNodo == null);
	}
	
	public int getSize() {
		return this.size;
	}
	
	public T get (int index) {
		Nodo<T> nodoActual = this.primerNodo;
		
		if(index <= size-1) {
			for(int i = 0; i < index; i++) {
				nodoActual = nodoActual.getNodoSiguiente();
			}
		}
		else {
			System.out.println("El indice ingresado no existe en la lista");
			}
			
			return nodoActual.getValor();
		}
		
	public int indexOf(T object) {
		Nodo<T> nodoActual = this.primerNodo;
		int pos = 0;
		
		while(nodoActual != null) {
			if(nodoActual.getValor().equals(object)) {
				return pos;
			}
			else {
				pos++;
				nodoActual = nodoActual.getNodoSiguiente();
			}
		}
		
		return -1;
	}
		
	public Nodo<T> getPrimerNodo() {
		return primerNodo;
	}

	@Override
	public Iterator<T> iterator() {
		return new IteradorDoubleLinkedList();
	}
	
	private class IteradorDoubleLinkedList implements Iterator<T>{
		private Nodo<T> nodoActual;
		
		public IteradorDoubleLinkedList() {
			this.nodoActual = getPrimerNodo();
		}
		
		@Override
		public boolean hasNext() {
			if(this.nodoActual != null) {
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public T next() {
			T auxValue = nodoActual.getValor();
			nodoActual = nodoActual.getNodoSiguiente();
			return auxValue;
		}
	}
		

}

