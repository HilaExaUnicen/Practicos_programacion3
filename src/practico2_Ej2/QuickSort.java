package practico2_Ej2;

import java.util.Random;
import java.util.Arrays;

public class QuickSort {
    
	public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }
	
    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static int[] crearArregloAleatorio(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n); // Genera un numero aleatorio entre 0 y n-1
        }
        return arr;
    }
    
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
         }
     }
    
    public static void main(String[] args) {
        int [] arrQuick = crearArregloAleatorio(100000);
        int [] arrMerge = crearArregloAleatorio(100000);
        int [] arrBurbujeo = crearArregloAleatorio(100000);
        int [] arr = crearArregloAleatorio(100000);

        
        long inicio = System.currentTimeMillis();
        QuickSort quick = new QuickSort();
        quick.quickSort(arrQuick, 0, arrQuick.length - 1);
        long fin = System.currentTimeMillis();

        long tiempo = fin - inicio;
        System.out.println("El tiempo de ordenamiento con quick fue de " + tiempo + " milisegundos.");
        
        long inicio2 = System.currentTimeMillis();
        MergeSort merge = new MergeSort();
        merge.sort(arrMerge);
        long fin2 = System.currentTimeMillis();

        long tiempo2 = fin2 - inicio2;
        System.out.println("El tiempo de ordenamiento con mergesort fue de " + tiempo2 + " milisegundos.");
        
        long inicio3 = System.currentTimeMillis();
        QuickSort quick2 = new QuickSort();
        quick2.bubbleSort(arrBurbujeo);
        long fin3 = System.currentTimeMillis();

        long tiempo3 = fin3 - inicio3;
        System.out.println("El tiempo de ordenamiento con burbujeo fue de " + tiempo3 + " milisegundos.");
        
        long inicio4 = System.currentTimeMillis();
        Arrays.sort(arr);
        long fin4 = System.currentTimeMillis();

        long tiempo4 = fin4 - inicio4;
        System.out.println("El tiempo de ordenamiento con Array.sort() fue de " + tiempo4 + " milisegundos.");
        

    }
}
