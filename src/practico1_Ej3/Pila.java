package practico1_Ej3;

import java.util.Iterator;

public class Pila<T> implements Iterable<T> {
	
	private practico1_Ej1_4_5.LinkedList<T> pila;
	
	public Pila() {
		pila = new practico1_Ej1_4_5.LinkedList<T>();
	}
	
	public void push(T object) {
		this.pila.insertFront(object);
	}
	
	public T pop() {
		if(!this.pila.isEmpty()) {
			T elementoExtraido = this.pila.extractFront();
			return elementoExtraido;
		}
		else {
			System.out.println("La pila esta vacia");
			return null;
		}
	}
	
	public T top() {
		if(this.pila.get(0) != null){
			T primerElemento = this.pila.get(0);
			return primerElemento;
		}
		else {
			return null;
		}
	}
	
//	public void reverse() {
//		int inicio = 0;
//		int fin = this.pila.getSize()-1;
//	}
	
	@Override
	public Iterator<T> iterator() {
		return this.pila.iterator();
	}
	
	public static void main(String[] args) {
		Pila<Integer> pila = new Pila<>();
		
		pila.push(5);
		pila.push(6);
		pila.push(4);
		pila.push(2);
		
		for(Integer elemento : pila) {
			System.out.println(elemento);
		}
		
		System.out.println("---------");
		
		System.out.println("Pop:");
		Integer elementoEliminado = pila.pop();
		System.out.println("Se elimino el elemento: " + elementoEliminado);
		
		System.out.println("---------");
		
		for(Integer elemento : pila) {
			System.out.println(elemento);
		}
		System.out.println("---------");
		
		System.out.println("Top:");
		System.out.println(pila.top());
	}
}
