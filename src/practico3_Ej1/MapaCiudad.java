package practico3_Ej1;

import java.util.Iterator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class MapaCiudad<T> {
	private GrafoNoDirigido<T> mapa;
	
	public MapaCiudad() {
		mapa = new GrafoNoDirigido<>();
	}
	
	public void addEsquina(int valor) {
		mapa.agregarVertice(valor);
	}
	
	public void addCalle(int esquina1, int esquina2) {
		mapa.agregarArco(esquina1, esquina2, null);
	}
	
	public int getCaminoMasCorto(int esquinaOrigen, int esquinaDestino){
		if(mapa.contieneVertice(esquinaOrigen) && mapa.contieneVertice(esquinaDestino)) {
			Map<Integer, Boolean> visitado = new HashMap<>();
			int[] distancias = new int [this.mapa.cantidadVertices()+1];//+1 porque los vertices comienzan desde el 1, el 0 en este array no se va a usar, tambien se podria hacer con Map 
			Arrays.fill(distancias, Integer.MAX_VALUE);
			
			Iterator<Integer> itVertices = this.mapa.obtenerVertices();
			while(itVertices.hasNext()) {
				int vertice = itVertices.next();
				visitado.put(vertice, false);
			}
			
			Queue<Integer> cola = new LinkedList<>();
			cola.add(esquinaOrigen);
			visitado.put(esquinaOrigen, true);
			distancias[esquinaOrigen] = 0;
			
			while(!cola.isEmpty()) {
				int verticeActual = cola.poll();
				
				Iterator<Integer> adyacentes = this.mapa.obtenerAdyacentes(verticeActual);
				while(adyacentes.hasNext()) {
					int adyacente = adyacentes.next();
					if(adyacente == esquinaDestino) {
						return distancias[verticeActual] + 1;
					}
					else if(visitado.get(adyacente) == false) {
						visitado.put(adyacente, true);
						cola.add(adyacente);
						distancias[adyacente] = distancias[verticeActual] + 1;
					}
				}
			}

		}
		return -1; //Si no existe alguna de las dos esquinas ingresadas
	}
	
	
	
}
