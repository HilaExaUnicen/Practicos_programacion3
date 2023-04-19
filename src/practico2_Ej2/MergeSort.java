package practico2_Ej2;
public class MergeSort {
	private int[] numbers;
	private int[] helper;
	private int size;
	
	public void sort(int[] values) {
		this.numbers = values;
		size = values.length;
		this.helper = new int[size];
		mergesort(0, size - 1);
	}
	
	private void mergesort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
		}
	}
	
	private void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		
		// copiar de manera ordenada al array original los valores de la
		// mitad izquierda o de la derecha
		while (i <= middle && j <= high) {
			if (helper[ i ] <= helper[ j ]) {
				numbers[ k ] = helper[ i ];
				i++;
			} 
			else {
				numbers[ k ] = helper[ j ];
				j++;
			}
			
			k++;
		}
		// si quedaron elementos copiarlos al array original
		while (i <= middle) {
			numbers[ k ] = helper[ i ];
			k++;
			i++;
		}
		
		while (j <= high) {
			numbers[ k ] = helper[ j ];
			k++;
			j++;
		}
	}
	
	public static void main(String[] args) {
		MergeSort merges = new MergeSort();
		
		int [] arr = new int [10];
		arr[0] = 1;
		arr[1] = 4;
		arr[2] = 2;
		arr[3] = 9;
		arr[4] = 8;
		arr[5] = 8;
		arr[6] = 2;
		arr[7] = 6;
		arr[8] = 7;
		arr[9] = 10;
		
		merges.sort(arr);
		
		for(int item : arr) {
			System.out.println(item);
		}
	}
}

