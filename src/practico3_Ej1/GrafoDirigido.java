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
		IteradorVertices itVertices = new IteradorVertices();
		return itVertices;
	}
	
	private class IteradorVertices implements Iterator<Integer>{
		private LinkedList<Integer> vertices = new LinkedList<>(mapa.keySet());//Guarda las claves del mapa en una lista vinculada
		private int puntero = 0;
		
		@Override
		public boolean hasNext() {
			if(vertices.get(puntero) != null) {
				return true;
			}
			else if(vertices.isEmpty()) {
				return false;
			}
			else {
				return false;
			}
		}

		@Override
		public Integer next() {
			Integer vertice = vertices.get(puntero);
			puntero++;
			return vertice;
		}
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		IteradorAdyacentes itAdyacentes = new IteradorAdyacentes(verticeId);
		return itAdyacentes;
	}
	
	private class IteradorAdyacentes implements Iterator<Integer>{
		private LinkedList<Arco<T>> verticesAdyacentes;
		private int puntero;
		
		public IteradorAdyacentes(int verticeId) {
			this.verticesAdyacentes = new LinkedList<Arco<T>>(mapa.get(verticeId));
			this.puntero = 0;
		}
		
		@Override
		public boolean hasNext() {
			if(verticesAdyacentes.get(puntero) != null) {
				return true;
			}
			else if(verticesAdyacentes.isEmpty()) {
				return false;
			}
			else {
				return false;
			}
		}

		@Override
		public Integer next() {
			Integer adyacente = verticesAdyacentes.get(puntero).getVerticeDestino();
			puntero++;
			return adyacente;
		}
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}
}
