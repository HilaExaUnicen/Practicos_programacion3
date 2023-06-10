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
		
		System.out.println("Vertices que forman camino a vertice 5 de grafo 2: ");
		System.out.println(grafo2.getVerticesQueFormanCaminoA(5));
		
		
		MapaCiudad<T> ciudad = new MapaCiudad<>();
		ciudad.addEsquina(1);
		ciudad.addEsquina(2);
		ciudad.addEsquina(3);
		ciudad.addEsquina(4);
		ciudad.addEsquina(5);
		ciudad.addEsquina(6);
		ciudad.addEsquina(7);
		ciudad.addEsquina(8);
		ciudad.addEsquina(9);
		ciudad.addEsquina(10);
		ciudad.addEsquina(11);
		ciudad.addEsquina(12);
		
		ciudad.addCalle(1, 4);
		ciudad.addCalle(1, 2);
		ciudad.addCalle(2, 5);
		ciudad.addCalle(2, 3);
		ciudad.addCalle(3, 6);
		ciudad.addCalle(6, 9);
		ciudad.addCalle(9, 10);
		ciudad.addCalle(5, 8);
		ciudad.addCalle(8, 11);
		ciudad.addCalle(4, 7);
		ciudad.addCalle(7, 12);
		ciudad.addCalle(11,12);
		ciudad.addCalle(4, 5);
		ciudad.addCalle(5, 6);
		ciudad.addCalle(7, 8);
		ciudad.addCalle(8, 9);
		ciudad.addCalle(11, 10);
		
		System.out.println(ciudad.getCaminoMasCorto(1, 10));
		
		
		
		
		
		
		

	}

}
