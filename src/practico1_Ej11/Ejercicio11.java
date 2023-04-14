package practico1_Ej11;
//Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado ascendentemente

import practico1_Ej10.Ejercicio10;

public class Ejercicio11 {
	public int buscarPosElementoEnArrayOrdenado(int [] arr, int inicio, int elemento) {
		
		if(arr[inicio] == elemento) {
			return inicio;
		}
		else if(arr[inicio] > elemento || inicio >= arr.length-1) {
			return -1;
		}
		
		return buscarPosElementoEnArrayOrdenado(arr, inicio+1, elemento);
	}
	
	public static void main(String[] args) {
		int [] arr = new int [10];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		arr[5] = 6;
		arr[6] = 7;
		arr[7] = 8;
		arr[8] = 9;
		arr[9] = 10;
		
		
		System.out.println(arr.length);
		Ejercicio11 ej11 = new Ejercicio11();
		
		int pos = ej11.buscarPosElementoEnArrayOrdenado(arr, 0, 8);
		if(pos==-1) {
			System.out.println("El elemento buscado no se encuentra en el array");
		}
		else {
			System.out.println("El elemento buscado se encuentra el la pos " + pos);
		}

	}
}
