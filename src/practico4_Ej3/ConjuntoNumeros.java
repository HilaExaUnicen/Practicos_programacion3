package practico4_Ej3;

import java.util.List;
import java.util.ArrayList;
//
//public class ConjuntoNumeros {
//	private List<Integer> n;
//	private int m;
//	
//	public ConjuntoNumeros(List<Integer> n, int m) {
//		this.n = n;
//		this.m = m;
//	}
//	
//	public ArrayList<ArrayList<Integer>> getSoluciones(){
//		ArrayList<ArrayList<Integer>> soluciones = new ArrayList<>();
//		ArrayList<Integer> caminoActual = new ArrayList<>();
//		int indice = 0;
//		getSoluciones(soluciones, caminoActual, indice);
//		
//		return soluciones;
//	}
//	
//	private void getSoluciones(ArrayList<ArrayList<Integer>> soluciones, ArrayList<Integer> caminoActual, int indice) {
//		if(this.getSumaElemLista(caminoActual) == this.m) {
//			soluciones.add(new ArrayList<>(caminoActual));
//			return;
//		}
//		else {
//			while(indice < n.size()) {
//				caminoActual.add(n.get(indice));
//				getSoluciones(soluciones, caminoActual, indice+1);
//				caminoActual.remove(caminoActual.size()-1);
//			}
//		}
//		
//	}
//
//	private int getSumaElemLista(List<Integer> lista) {
//		int suma = 0;
//		for(int i = 0; i < lista.size(); i++) {
//			suma += lista.get(i);
//		}
//		
//		return suma;
//	}

public class ConjuntoNumeros {
    
    private ArrayList<ArrayList<Integer>> soluciones;
    private ArrayList<Integer> conjunto;
    private int m;
    
    public ConjuntoNumeros(ArrayList<Integer> conjunto, int m) {
        this.conjunto = conjunto;
        this.m = m;
        this.soluciones = new ArrayList<>();
    }
    
    public ArrayList<ArrayList<Integer>> encontrarCombinaciones() {
        ArrayList<Integer> combinacionActual = new ArrayList<>();
        backtrack(0, combinacionActual, 0);
        return soluciones;
    }
    
    private void backtrack(int indice, ArrayList<Integer> combinacionActual, int sumaActual) {
        if (sumaActual == m) {
            soluciones.add(new ArrayList<>(combinacionActual));
            return;
        }
        
        for (int i = indice; i < conjunto.size(); i++) {
            int numero = conjunto.get(i);
            if (sumaActual + numero <= m) {
                combinacionActual.add(numero);
                backtrack(i + 1, combinacionActual, sumaActual + numero);
                combinacionActual.remove(combinacionActual.size() - 1);
            }
        }
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> conjunto = new ArrayList<>();
		conjunto.add(7);
		conjunto.add(3);
		conjunto.add(9);
		conjunto.add(5);
		conjunto.add(7);
		int m = 14;
		
		ConjuntoNumeros inst = new ConjuntoNumeros(conjunto, m);
		
		ArrayList<ArrayList<Integer>> sol = inst.encontrarCombinaciones();
		
		for(ArrayList<Integer> item : sol) {
			System.out.println(item);
		}
		
		
		
		
	}
	
}
