package practico3_Ej1;

import java.util.*;

public class ServicioDFS<T> {
	private Grafo<T> grafo;
	private Map<Integer, String> colores;
	private Map<Integer, Integer> tiempoDescubrimiento;
	private Map<Integer, Integer> tiempoFinalizacion;
	
	public ServicioDFS(Grafo<T> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.tiempoDescubrimiento = new HashMap<>();
		this.tiempoFinalizacion = new HashMap<>();
	}
	
	public List<Integer> DFS() {
		LinkedList<Integer> ordenDescubrimiento = new LinkedList<>();
		Iterator<Integer> itVertices = this.grafo.obtenerVertices();
		int tiempo;
		
		while(itVertices.hasNext()) {
			this.colores.put(itVertices.next(), "blanco");
		}
		
		tiempo = 0;
		
		for(Integer vertice: this.colores.keySet()) {
			if(colores.get(vertice).equalsIgnoreCase("blanco")) {
				DFSVisit(vertice, tiempo, ordenDescubrimiento);
			}
		}
		
		return ordenDescubrimiento;
	}
	
	private void DFSVisit(int vertice, int tiempo, LinkedList<Integer> orden) {
		this.colores.put(vertice, "amarillo");
		tiempo++;
		this.tiempoDescubrimiento.put(vertice, tiempo);
		orden.add(vertice);
		
		Iterator<Integer> itAdyacentes = this.grafo.obtenerAdyacentes(vertice);
		while(itAdyacentes.hasNext()) {
			Integer vAdyacente = itAdyacentes.next();
			if(this.colores.get(vAdyacente).equalsIgnoreCase("blanco")) {
				DFSVisit(vAdyacente, tiempo, orden);
			}
		}
		
		this.colores.put(vertice, "negro");
		tiempo++;
		this.tiempoFinalizacion.put(vertice, tiempo);
	}
}
