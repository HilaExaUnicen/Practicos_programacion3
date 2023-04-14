package practico1_Ej10;

//Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
//1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
//2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
//3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?

public class Ejercicio10 {
	
	public boolean arregloEstaOrdenado(int [] arr, int inicio) {
		if(arr[inicio] > arr[inicio+1]) {
			return false;
		}
		else if(inicio>=arr.length-2) { //Hacemos arr.length-2, para que el ultimo elemento del array no se compare ya que no tiene un siguiente
			return true;
		}
		
		return arregloEstaOrdenado(arr, inicio+1);
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
		Ejercicio10 comprobadorEstaOrdenado = new Ejercicio10();
		
		boolean resultado = comprobadorEstaOrdenado.arregloEstaOrdenado(arr, 0);
		System.out.println(resultado);
	
	}
}
