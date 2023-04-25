package practico2_1_Ej1;

import java.util.ArrayList;
import java.util.Collections;

public class ArbolBinarioBusqueda {
	
	private NodoArbol raiz;
	
	public ArbolBinarioBusqueda() {
		this.raiz = null;
	}

	public ArbolBinarioBusqueda(NodoArbol raiz) {
		this.raiz = raiz;
	}
	
	public void add(int valor) {
		if(this.raiz == null) {
			NodoArbol nuevoNodo = new NodoArbol(valor);
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
			delete(this.raiz, valor);
			return true;
		}
	}
	
	public void delete(NodoArbol nodo, int valor) {
		if(nodo != null && nodo.getValor() == valor) {
			if(nodo.getIzquierda() == null && nodo.getDerecha() == null) {
				nodo = null;
			}
			else if(nodo.getIzquierda() != null && nodo.getDerecha() == null) {
				nodo.setValor(nodo.getIzquierda().getValor());
				nodo.setIzquierda(null);
			}
			else if(nodo.getIzquierda() == null && nodo.getDerecha()!= null) {
				nodo.setValor(nodo.getDerecha().getValor());
				nodo.setDerecha(nodo);
			}
			else {
				//TODO CUANDO TIENE LOS DOS NODOS
				//METODO QUE DEVUELVA NODO MAS IZQUIERDO DE SU SUBARBOL DERECHO
				NodoArbol nmiSubArbolDerecho = buscarNMISubArbolDerecho(nodo.getDerecha());
				int nuevoValorNodo = nmiSubArbolDerecho.getValor();
				//Borrar nodo mas izquierdo 
				delete(nmiSubArbolDerecho, valor);
				//Eliminamos el nodo a borrar reemplazando su valor por el de el NMI de su subarbol derecho
				nodo.setValor(nuevoValorNodo);
			}
		}
		else if (nodo.getValor() < valor) {
			delete(nodo.getDerecha(), valor);
		}
		else {
			delete(nodo.getIzquierda(), valor);
		}
	
	}
	
	
	
	private NodoArbol buscarNMISubArbolDerecho(NodoArbol nodoDerecha) {
		NodoArbol temp = nodoDerecha;
		while(temp.getIzquierda() != null) {
			temp = temp.getIzquierda();
		}
		
		return temp;
	}
	
	public int getHeight(){
	    if(this.isEmpty()){
	        return 0;
	    }
	    else{
	        NodoArbol node = this.raiz;
	        return getHeight(node);
	    }
	}
	private int getHeight(NodoArbol aNode){
	    int heightLeft = 0;
	    int heightRight = 0;
	    
	    if(aNode.getIzquierda() != null) {
	    	heightLeft = getHeight(aNode.getIzquierda());
	    }

	    if(aNode.getDerecha() != null) {
	    	heightRight = getHeight(aNode.getDerecha());
	    }
	        
	    if(heightLeft > heightRight){
	        return heightLeft+1;
	    }
	    else if(heightRight > heightLeft){
	        return heightRight+1;
	    }
	    else {
	    	return heightRight-1; //La altura es la cantidad de saltos desde el nodoRaiz hasta su hoja mas lejana
	    }
	}
	
	public void printPreOrder() {
		if(this.raiz != null) {
			printPreOrder(this.raiz);
		}
		else {
			System.out.println("El arbol esta vacio");
		}
	}
	
	private void printPreOrder(NodoArbol nodo) {
		
		System.out.print(nodo.getValor() + " ");
		
		if(nodo.getIzquierda()!= null) {
			printPreOrder(nodo.getIzquierda());
		}
		
		if(nodo.getDerecha() != null) {
			printPreOrder(nodo.getDerecha());
		}
	}
	
	public void printPosOrder() {
		if(this.raiz != null) {
			printPosOrder(this.raiz);
		}
		else {
			System.out.println("El arbol esta vacio");
		}
	}
	
	private void printPosOrder(NodoArbol nodo) {
		
		if(nodo.getIzquierda() != null) {
			printPosOrder(nodo.getIzquierda());
		}
		
		if(nodo.getDerecha() != null) {
			printPosOrder(nodo.getDerecha());
		}
		
		System.out.print(nodo.getValor() + " ");
	}
	
	public void printInOrder() {
		if(this.raiz != null) {
			printInOrder(this.raiz);
		}
		else {
			System.out.println("El arbol esta vacio");
		}
	}

	private void printInOrder(NodoArbol nodo) {
		if(nodo.getIzquierda()!= null) {
			printInOrder(nodo.getIzquierda());
		}
		System.out.print(nodo.getValor() + " ");
		if(nodo.getDerecha() != null) {
			printInOrder(nodo.getDerecha());
		}
	}
	
	public ArrayList<Integer> getLongestBranch(){
		if(this.raiz == null) {
			ArrayList<Integer> listaVacia = new ArrayList<>();
			return listaVacia;
		}
		else {
			ArrayList<Integer> longestBranch = new ArrayList<>();
			longestBranch = getLongestBranch(this.raiz);
			Collections.reverse(longestBranch);//Revertimos la lista ya que si no se muestra de arriba a abajo por la recursion
			return longestBranch;
		}
	}

	private ArrayList<Integer> getLongestBranch(NodoArbol nodo) {//TOREVIEW
		ArrayList<Integer> longestBranch, leftBranch, rightBranch;
		longestBranch = new ArrayList<>();	
		leftBranch = new ArrayList<>();
		rightBranch = new ArrayList<>();
		
		if(nodo != null) {
			leftBranch = getLongestBranch(nodo.getIzquierda());
			leftBranch.add(nodo.getValor());
		}
		
		if(nodo != null) {
			rightBranch = getLongestBranch(nodo.getDerecha());
			rightBranch.add(nodo.getValor());
		}
		
		if(leftBranch.size() > rightBranch.size()) {
			longestBranch.addAll(leftBranch);
		}
		else {
			longestBranch.addAll(rightBranch);
		}
		
		return longestBranch;
	}
	
<<<<<<< HEAD
	public int getMaxElem() {
		if(this.raiz == null) {
			return 0;
		}
		else {
			int maxElem;
			maxElem = getMaxElem(this.raiz);
			return maxElem;
		}
	}
	
	private int getMaxElem(NodoArbol nodo) {
		int maxElem = 0;
		maxElem = nodo.getValor();
		
		if(nodo.getDerecha() != null) {
			maxElem = getMaxElem(nodo.getDerecha());
		}
		
		return maxElem;
	}
	
	public ArrayList<Integer> getElemAtLevel(int level) {
		if(raiz == null || level < 0) {
			return new ArrayList<Integer>();
		}
		else if(level == 0) {
			ArrayList<Integer> arr = new ArrayList<>(1);
			arr.add(this.raiz.getValor());
			return arr;
		}
		else {
			ArrayList<Integer> elementsAtLevel = new ArrayList<>();
			elementsAtLevel = getElemAtLevel(level, this.raiz);
			return elementsAtLevel;
		}
	}

	private ArrayList<Integer> getElemAtLevel(int level, NodoArbol nodo) {
		ArrayList<Integer> elements = new ArrayList<>();
		int contador = 0;
		
		while(contador < level) {
			elements = getElemAtLevel(level, nodo.getIzquierda());
			elements = getElemAtLevel(level, nodo.getDerecha());
			contador++;
		}
			
	
		
		if(contador == level) {
			elements.add(nodo.getValor());
		}
		
		return elements;
=======
	public ArrayList<Integer> getFrontera(){
		if(this.raiz == null) {
			return new ArrayList<Integer>();
		}
		else {
			ArrayList<Integer> frontera = new ArrayList<>();
			frontera = getFrontera(this.raiz, frontera);
			return frontera;
		}
	}
	
	private ArrayList<Integer> getFrontera(NodoArbol nodo, ArrayList<Integer> frontera){
		if(nodo != null) {
			if(nodo.getIzquierda() == null && nodo.getDerecha() == null) {
				frontera.add(nodo.getValor());
			}
			else {
				frontera = getFrontera(nodo.getIzquierda(), frontera);
				frontera = getFrontera(nodo.getDerecha(), frontera);		
			}
		}
		
		return frontera;
>>>>>>> c0d9ab6b481d775189b4a5e263ce5cdaf3e0ab84
	}

	public boolean isEmpty() {
		return this.raiz == null;
	}
	
	public int getRoot() {
		return this.raiz.getValor();
	}
	
	
}
