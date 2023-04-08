package practico1_Ej1;

public class LinkedList<T> {
	
	private Nodo<T> primerNodo;
	private int size;
	
	public LinkedList(Nodo<T> primerNodo) {
		this.primerNodo = primerNodo;
		this.size = 1;
	}
	
	public LinkedList() {
		this.primerNodo = null;
		this.size = 0;
	}
	
	public void insertFront(T valor) { //Insertar como primer nodo
		Nodo<T> nuevoNodo = new Nodo<T>(valor, null);
		nuevoNodo.setNodoSiguiente(this.primerNodo);
		this.primerNodo = nuevoNodo;
		size++;
	}
	
	public T extractFront() { //Obtener primerNodo
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
		return this.primerNodo == null;
	}
	
	public int getSize() {
		return this.size;
	}
	
//	@Override
//	public String toString() {
//			
//	}
	
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
	

}
