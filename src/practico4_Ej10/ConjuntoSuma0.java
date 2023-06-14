package practico4_Ej10;
import java.util.ArrayList;

public class ConjuntoSuma0 {
	private ArrayList<Integer> conjunto;
	private ArrayList<ArrayList<Integer>> soluciones;
	private int n;
	
	public ConjuntoSuma0(ArrayList<Integer> conjunto, int n) {
		this.conjunto = conjunto;
		this.soluciones = new ArrayList<>();
		this.n = n;
	}
	
	public void getSoluciones() {
		if(conjunto.size() > this.n) {
			ArrayList<Integer> solucionActual = new ArrayList<>();
			int indice = 0;
			
			getSoluciones(indice, solucionActual);
			imprimirSoluciones();
		}
		else {
			System.out.println("Ingrese otro n ....");
		}
	}

	private void getSoluciones(int indice, ArrayList<Integer> solucionActual) {
		if(solucionActual.size() == this.n) {
			if(solucionEsValida(solucionActual)) {
				soluciones.add(new ArrayList<>(solucionActual));
				return;
			}
		}
		else {
			for(int i = indice; i < conjunto.size(); i++) {
				int elemento = conjunto.get(i);
					int aux = elemento;
					conjunto.remove(i);
					solucionActual.add(aux);
					getSoluciones(i, solucionActual);
					solucionActual.remove(solucionActual.size()-1);
					conjunto.add(i, aux);
			}
		}
	}

	private boolean solucionEsValida(ArrayList<Integer> solucionActual) {
		if(!solucionActual.isEmpty()) {
			int suma = 0;
			for(int element : solucionActual) {
				suma = (suma + (element));
			}
			
			if(suma == 0) {
				return true;
			}
			
			return false;
		}
		
		return false;
	}
	
	private void imprimirSoluciones() {
		if(!this.soluciones.isEmpty()) {
			for(ArrayList<Integer> arr : this.soluciones) {
				System.out.println(arr);
			}
		}
		else {
			System.out.println("No se han encontrado soluciones validas");
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		arr.add(-7);
		arr.add(-3);
		arr.add(-2);
		arr.add(-1);
		arr.add(5);
		arr.add(8);
		
		System.out.println(arr);
		ConjuntoSuma0 conj = new ConjuntoSuma0(arr, 3);
		conj.getSoluciones();
	}
}
