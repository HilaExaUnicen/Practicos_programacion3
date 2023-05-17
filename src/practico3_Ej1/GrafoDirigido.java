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
		LinkedList<Arco<T>> arcos = this.getListaArcos();
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		LinkedList<Arco<T>> arcos = new LinkedList<>(mapa.get(verticeId));
		return arcos.iterator();
	}
	
	private LinkedList<Arco<T>> getListaArcos(){// Este metodo es privado porque si no se tendria acceso a los arcos desde afuera
		LinkedList<Arco<T>> arcosGrafo = new LinkedList<>();
		for(Integer vertice: mapa.keySet()) {
			arcosGrafo.addAll(mapa.get(vertice));
		}
		
		return arcosGrafo;
	}
	
	
	//Ejercicio 3
	public boolean esCiclico() {
		Map<Integer, String> colores = new HashMap<>();
		Iterator<Integer> vertices = this.obtenerVertices();
		while(vertices.hasNext()) {
			colores.put(vertices.next(), "blanco");
		}
		
		vertices = this.obtenerVertices();
		
		while(vertices.hasNext()) {
			int vertice = vertices.next();
			boolean esCiclico = this.esCiclico(vertice, colores);
			if(esCiclico){
				return true;
			}
		}
		
		return false;
	}

	private boolean esCiclico(int vertice, Map<Integer, String> colores) {
		colores.put(vertice, "amarillo");
		
		Iterator<Integer> itAdyacentes = this.obtenerAdyacentes(vertice);
		while(itAdyacentes.hasNext()) {
			Integer vAdyacente = itAdyacentes.next();
			if(colores.get(vAdyacente).equalsIgnoreCase("amarillo")) {
				return true;
			}
			else if(colores.get(vAdyacente).equalsIgnoreCase("blanco")) {
				esCiclico(vAdyacente, colores);
			}
		}
		
		colores.put(vertice, "negro");//Si ya no tiene adyacentes lo marcamos como negro
		return false;
	}
	
	//Ejercicio 4
	public List<Integer> findLongestPath(int start, int end) {
        if(this.contieneVertice(start) && this.contieneVertice(end)) {
        	boolean[] visited = new boolean[this.cantidadVertices()+1];
            Stack<Integer> stack = new Stack<>();
            List<Integer> longestPath = new ArrayList<>();

            // Realiza una búsqueda en profundidad modificada desde el vértice de inicio
           findLongestPath(start, visited, stack);

           while (!stack.isEmpty()) {
    	        int vertex = stack.pop();
    	        longestPath.add(vertex);
    	
    	        if (vertex == end) {
    	        	return longestPath;
    	        }
            }
        }
        
		return null;
    }

    private void findLongestPath(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        Iterator<Integer> neighbors = this.obtenerAdyacentes(vertex);
        while(neighbors.hasNext()) {
            int neighbor = neighbors.next();
        	if (!visited[neighbor]) {
        		findLongestPath(neighbor, visited, stack);
            }
        }

        stack.push(vertex);
    }
    
    public List<Integer> getVerticesQueFormanCaminoA(int vObjetivo){
    	List<Integer> verticesParticipantes = new LinkedList<>();
    	LinkedList<Integer> caminoAuxiliar = new LinkedList<>();
    	
    	Iterator<Integer> vertices = this.obtenerVertices();
    	
    	while(vertices.hasNext()) {
    		int vertice = vertices.next();
    		if(vertice != vObjetivo) {
    			buscarCamino(vertice, vObjetivo, caminoAuxiliar);
    		}
    		
    		if(caminoAuxiliar.contains(vObjetivo)) {
    			verticesParticipantes.add(vertice);
    		}
    		
    		caminoAuxiliar.clear();
    	}
    	
    	return verticesParticipantes;
    }
    
    private void buscarCamino(int vertice, int vObjetivo, LinkedList<Integer> caminoAux) {
    	caminoAux.add(vertice);
    	Iterator<Integer> listaAdyacencia = this.obtenerAdyacentes(vertice);
    	
    	while(listaAdyacencia.hasNext()) {
    		int adyacenteActual = listaAdyacencia.next();
    		if(adyacenteActual == vObjetivo) {
    			caminoAux.add(vObjetivo);
    			return;
    		}
    		else {
    			buscarCamino(adyacenteActual, vObjetivo, caminoAux);
    		}
    	}
    }
    
}
