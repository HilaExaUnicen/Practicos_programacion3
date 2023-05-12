package practico3_Ej1;

import java.util.*;

public class ServicioBFS<T> {
	private Grafo<T> grafo;
	private Map<Integer, Boolean> visitado;
	
	public ServicioBFS(Grafo<T> grafo) {
		this.grafo = grafo;
		this.visitado = new HashMap<>();
	}
	
	public List<Integer> BFS() {
		LinkedList<Integer> recorrido = new LinkedList<>();
		
		Iterator<Integer> itVertices = this.grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			int vertice = itVertices.next();
			this.visitado.put(vertice, false);
		}
		
		itVertices = this.grafo.obtenerVertices();//Se reinicia el iterador
		while(itVertices.hasNext()) {
			int vertice = itVertices.next();
			if(this.visitado.get(vertice).equals(false)) {
				BFSVisit(vertice, recorrido);
			}
		}
		
		return recorrido;
	}
	
	private void BFSVisit(Integer vertice, List<Integer> recorrido) {
		LinkedList<Integer> cola = new LinkedList<>();
		this.visitado.put(vertice, true);
		cola.add(vertice);
		
		while(!cola.isEmpty()) {
			Integer verticeActual = cola.poll();
			Iterator<Integer> itAdyacentes = this.grafo.obtenerAdyacentes(verticeActual);
			recorrido.add(verticeActual);
			
			while(itAdyacentes.hasNext()) {
				Integer adyacente = itAdyacentes.next();
				if(this.visitado.get(adyacente).equals(false)) {
					this.visitado.put(adyacente, true);
					cola.add(adyacente);
				}
			}
		}
	}
	
}
