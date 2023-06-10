package practico3_Ej1;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class RedDeComputadoras<T> {
	private Grafo<T> red;
	private Map<Integer, Boolean> estado;
	
	public RedDeComputadoras() {
		red = new GrafoNoDirigido<>();
		estado = new HashMap<>();
	}
	
	public void encenderComputadoras() {
		if(!estado.isEmpty()) {
			for(int nodo: this.estado.keySet()) {
				this.estado.put(nodo, true);
			}
		}
		else {
			Iterator<Integer> vertices = this.red.obtenerVertices();
			while(vertices.hasNext()) {
				estado.put(vertices.next(), true);
			}
		}
	}
	
	public void apagarComputadora(int vertice) {
		this.estado.put(vertice, false);
	}
	
	public void apagarComputadoras() {
		Iterator<Integer> vertices = this.red.obtenerVertices();
		while(vertices.hasNext()) {
			estado.put(vertices.next(), false);
		}
	}
	
	public boolean estaEncendida(int pc) {
		return (this.estado.get(pc) == true);
	}
	
	//Si las computadoras no encuentran un camino ya sea porque no existe
	//un camino entre ellas, o una pc del camino esta apagada, se crea
	//una conexion directa entre ellas COMO ULTIMO RECURSO.
	public void conectarComputadoras(int pc1, int pc2) {
		if(estaEncendida(pc1) && estaEncendida(pc2)) {
			if(!estanConectadas(pc1,pc2)) {
				this.red.agregarArco(pc1, pc2, null);
			}										 
		}											 
	}
	
	public boolean estanConectadas(int pc1, int pc2) {
		Iterator<Integer> itAdyacentes = this.red.obtenerAdyacentes(pc1);
		while(itAdyacentes.hasNext()) {
			int adyacente = itAdyacentes.next();
			if(estaEncendida(adyacente)) {
				if(adyacente == pc2) {
					return true;
				}
				else {
					estanConectadas(adyacente, pc2);
				}
			}
		}
		
		return false;
	}
}
