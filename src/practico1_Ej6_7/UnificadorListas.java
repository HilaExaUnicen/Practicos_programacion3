package practico1_Ej6_7;

public class UnificadorListas<T> {

	
	
	
	public void crearNuevaListaOrdenada(practico1_Ej1_4_5.LinkedList<Integer> lista1, practico1_Ej1_4_5.LinkedList<Integer> lista2) {
		practico1_Ej1_4_5.LinkedList<T> nuevaLista = new practico1_Ej1_4_5.LinkedList<T>();
		
		
	}
	
	
	//7)
	public void crearNuevaListaConElementosPrimera(practico1_Ej1_4_5.LinkedList<T> l1, practico1_Ej1_4_5.LinkedList<T> l2) {
		practico1_Ej1_4_5.LinkedList<T> nuevaLista = new practico1_Ej1_4_5.LinkedList<T>();
		for(T object : l1) {
			nuevaLista.insertFront(object);
		}
	}
	
	
}
