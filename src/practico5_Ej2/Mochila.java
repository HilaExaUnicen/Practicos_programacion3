package practico5_Ej2;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Mochila {
	private int p;
	private Map<Elemento, Double> elementosFraccionados;
	
	public Mochila(int p) {
		this.p = p;
		elementosFraccionados = new HashMap<>();
	}
	
	public void guardarElementos(ArrayList<Elemento> elementos) {
		int pesoActual = 0;
		while(pesoActual < this.p) {
			Elemento elem = this.elegirElementoSegunCriterio(elementos);
			
			if(pesoActual + elem.getPeso() < this.p) {
				this.elementosFraccionados.put(elem, 1.0);
				pesoActual = pesoActual + elem.getPeso();
			}
			else {
				double fraccion = ((this.p - pesoActual) / elem.getPeso());
				this.elementosFraccionados.put(elem, fraccion);
				pesoActual = p;
			}
		}
	}

	private Elemento elegirElementoSegunCriterio(ArrayList<Elemento> elementos) {
		Elemento elemMenorPeso = elementos.get(0);
		
		for(Elemento elem : elementos) {
			if(elem.getPeso() > elemMenorPeso.getPeso()) {
				elemMenorPeso = elem;
			}
		}
		
		elementos.remove(elemMenorPeso);
		return elemMenorPeso;
	}
	
	
}
