package practico2_1_Ej1;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
		arbol.add(5);
		arbol.add(2);
		arbol.add(1);
		arbol.add(7);
		arbol.add(3);
		arbol.add(8);
		arbol.add(4);

		
		
//		System.out.println("");
//		boolean wtfpaso = arbol.delete(2); //delete re bugeado en eliminar hoja y dos hijos;
//		arbol.print();
//		System.out.println(wtfpaso);
		
		System.out.println("");
		System.out.println("Recorrido En orden:");
		arbol.printInOrder();
				
		System.out.println("");
		System.out.println("Recorrido Pre-orden:");
		arbol.printPreOrder();
		
		System.out.println("");
		System.out.println("Recorrido Pos-orden:");
		arbol.printPosOrder();
		
		System.out.println("");
		System.out.println("");
		int altura = arbol.getHeight();
		System.out.println("La altura del arbol es de " + altura);
		
		System.out.println("");
		ArrayList<Integer> rama = arbol.getLongestBranch();
		System.out.println("Rama mas larga del arbol: ");
		System.out.println(rama);
		
		
		
		
		
		
		System.out.println("");
		int maxElem = arbol.getMaxElem();
		System.out.println("El valor mas alto del arbol es: " + maxElem);
		
		System.out.println("");
		ArrayList<Integer> elements = arbol.getElemAtLevel(1);
		System.out.println("Nivel: " + elements);
	
	}


}
