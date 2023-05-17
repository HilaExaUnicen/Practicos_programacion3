package practico3_Ej1;

public class Main {

	public static <T> void main(String[] args) {
		GrafoDirigido<T> grafo = new GrafoDirigido<>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		
		grafo.agregarArco(3, 4, null);
		grafo.agregarArco(4, 5, null);
		grafo.agregarArco(1, 4, null);
		grafo.agregarArco(1, 3, null);
		grafo.agregarArco(2, 3, null);
		
	
		System.out.print("Es ciclico: ");
		System.out.println(grafo.esCiclico());
		
		ServicioDFS<T> dfs = new ServicioDFS<>(grafo);
		System.out.println("Recorrido DFS: ");
		System.out.println(dfs.DFS());
		
		System.out.println("Recorrido BFS: ");
		ServicioBFS<T> bfs = new ServicioBFS<>(grafo);
		System.out.println(bfs.BFS());
		
		System.out.println("Camino mas largo entre 1 y 5: ");
		System.out.println(grafo.findLongestPath(1, 5));
		
		
		GrafoDirigido<T> grafo2 = new GrafoDirigido<>();
		grafo2.agregarVertice(1);
		grafo2.agregarVertice(2);
		grafo2.agregarVertice(3);
		grafo2.agregarVertice(4);
		grafo2.agregarVertice(5);
		grafo2.agregarVertice(6);
		grafo2.agregarVertice(7);
		
		grafo2.agregarArco(1, 2, null);
		grafo2.agregarArco(1, 3, null);
		grafo2.agregarArco(2, 5, null);
		grafo2.agregarArco(3, 4, null);
		grafo2.agregarArco(4, 5, null);
		grafo2.agregarArco(4, 5, null);
		grafo2.agregarArco(5, 6, null);
		grafo2.agregarArco(5, 7, null);
		grafo2.agregarArco(5, 1, null);
		
		System.out.println(grafo2.getVerticesQueFormanCaminoA(5));
		
		
		
		
		

	}

}
