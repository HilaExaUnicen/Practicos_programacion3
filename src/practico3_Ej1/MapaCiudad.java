package practico3_Ej1;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

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
	
	public int getCaminoMasCorto(int esquina1, int esquina2){
		if(mapa.contieneVertice(esquina1) && mapa.contieneVertice(esquina2)) {
			Map<Integer, Boolean> visitado = new HashMap<>();
			Iterator<Integer> itVertices = this.mapa.obtenerVertices();
			while(itVertices.hasNext()) {
				int vertice = itVertices.next();
				visitado.put(vertice, false);
			}
			int getCantCuadras = 0;
			Iterator<Integer> adyacentes = this.mapa.obtenerAdyacentes(esquina1);
			while(adyacentes.hasNext()) {
				
			}
		}
		
		
		
		
		return -1;
	}
	
	
	
}
