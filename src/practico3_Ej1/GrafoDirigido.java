package practico3_Ej1;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
	private Map<Integer, List<Arco<T>>> mapa = new HashMap<>();

	@Override
	public void agregarVertice(int verticeId) {
		this.mapa.put(verticeId, new LinkedList<Arco<T>>()); //Polimorfismo repaso prog2
	}

	@Override
	public void borrarVertice(int verticeId) {
		this.mapa.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(!mapa.containsKey(verticeId1)) {
			this.agregarVertice(verticeId1);
		}
		
		if(!mapa.containsKey(verticeId2)) {
			this.agregarVertice(verticeId2);
		}
		
		Arco<T> nuevoArco = new Arco<T>(verticeId1, verticeId2, etiqueta);
		
		if(!mapa.get(verticeId1).contains(nuevoArco)) {//TODO Habria que redefinir el equals de Arco y especificar cuando dos arcos son considerados iguales
			mapa.get(verticeId1).add(nuevoArco); 
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {//Complejidad O(n^2) o O(n)? creo que O(n) porque no tiene iteradores anidados.
		//this.mapa.get(verticeId1) retorna la lista de arcos a los que apunta el vertice especificado en el parametro
		List<Arco<T>> arcosAsociados = this.mapa.get(verticeId1); 
		for(int i = 0; i < arcosAsociados.size(); i++) {
			if(arcosAsociados.get(i).getVerticeDestino() == verticeId2) {
				arcosAsociados.remove(i);
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.mapa.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		List<Arco<T>> arcosAsociados = this.mapa.get(verticeId1); 
		for(int i = 0; i < arcosAsociados.size(); i++) {
			if(arcosAsociados.get(i).getVerticeDestino() == verticeId2) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		List<Arco<T>> arcosAsociados = this.mapa.get(verticeId1); 
		for(int i = 0; i < arcosAsociados.size(); i++) {
			if(arcosAsociados.get(i).getVerticeDestino() == verticeId2) {
				Arco<T> arcoEncontrado = arcosAsociados.get(i);
				return arcoEncontrado;
			}
		}
		
		return null;//Si no encuentra ninguno retorna null
	}

	@Override
	public int cantidadVertices() {
		return this.mapa.size();
	}

	@Override
	public int cantidadArcos() {
		int cantTotalArcos = 0;
		for(Integer vertice: this.mapa.keySet()) {
			int cantArcosVertice = this.mapa.get(vertice).size();
			cantTotalArcos += cantArcosVertice;
		}
		
		return cantTotalArcos;
	}
	
	@Override
	public Iterator<Integer> obtenerVertices() {
		LinkedList<Integer> vertices = new LinkedList<>(mapa.keySet());
		return vertices.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		LinkedList<Arco<T>> arcosVertice = new LinkedList<Arco<T>>(mapa.get(verticeId));
		LinkedList<Integer> adyacentes = new LinkedList<>();
		
		for(Arco<T> arco: arcosVertice) {
			adyacentes.add(arco.getVerticeDestino());
		}
		
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		IteradorArcos itArcosGrafo = new IteradorArcos();
		return itArcosGrafo;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		IteradorArcos itArcosVertice = new IteradorArcos(verticeId);
		return itArcosVertice;
	}
	
	private LinkedList<Arco<T>> getListaArcos(){// Este metodo es privado porque si no se tendria acceso a los arcos desde afuera
		LinkedList<Arco<T>> arcosGrafo = new LinkedList<>();
		for(Integer vertice: mapa.keySet()) {
			arcosGrafo.addAll(mapa.get(vertice));
		}
		
		return arcosGrafo;
	}
	
	private class IteradorArcos implements Iterator<Arco<T>>{
		private LinkedList<Arco<T>> arcos;
		private int puntero;
		
		public IteradorArcos(Integer verticeId) {//Si se quieren los arcos de un vertice especifico
			this.arcos = new LinkedList<>(mapa.get(verticeId));
			this.puntero = 0;
		}
		
		public IteradorArcos() {//Este constructor es cuando se quieren todos los arcos del grafo
			this.puntero = 0;
			this.arcos = getListaArcos();
		}
		
		@Override
		public boolean hasNext() {
			if(arcos.isEmpty()) {
				return false;
			}
			else if(arcos.get(puntero) != null) {
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public Arco<T> next() {
			Arco<T> arco = this.arcos.get(puntero);
			puntero++;
			return arco;
		}
	}
}
