package practico4_Ej3;

import java.util.ArrayList;

public class RepasoEjercicio {
	private ArrayList<Integer> conjunto;
	private int m;
	private ArrayList<ArrayList<Integer>> soluciones;
	
	public RepasoEjercicio(ArrayList<Integer> conjunto, int m) {
		this.conjunto = conjunto;
		this.m = m;
		soluciones = new ArrayList<>();
	}
	
	public void obtenerSoluciones() {
		ArrayList<Integer> solucionActual = new ArrayList<>();
		int indice = 0;
		
		backtracking(indice, solucionActual);
		imprimirSoluciones();
	}
	
	private void backtracking(int indice, ArrayList<Integer> solucionActual) {
		int sumaSolucionActual = getSumaElementosArray(solucionActual);
		if(sumaSolucionActual == m) {
			soluciones.add(new ArrayList<>(solucionActual));
			return;
		}
		else {
			for(int i = indice; i < conjunto.size(); i++) {
				Integer numero = conjunto.get(i);
				if(numero != null) {
					int aux = conjunto.get(i);
					conjunto.remove(i);
					solucionActual.add(aux);
					backtracking(i, solucionActual);
					solucionActual.remove(solucionActual.size()-1);
					conjunto.add(i, aux);
				}
			}
		}
	}
		
	

	private int getSumaElementosArray(ArrayList<Integer> arrayList) {
		int suma = 0;
		for(int i : arrayList) {
			suma += i;
		}
		
		return suma;
		
	}

	private void imprimirSoluciones() {
		for(ArrayList<Integer> arr : this.soluciones) {
			System.out.println(arr);
		}	
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(5);
		arr.add(8);
		arr.add(6);
		arr.add(7);
		arr.add(2);
		arr.add(4);
		
		RepasoEjercicio inst = new RepasoEjercicio(arr, 11);
		inst.obtenerSoluciones();
	}
	
	
	
}
