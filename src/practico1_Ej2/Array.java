package practico1_Ej2;
import java.util.Random;

public class Array {
	private int [] array = new int [5];
	
	public void llenarArray() {
		Random rand = new Random();
		for(int i = 0; i < 5; i++) {
			array[i] = rand.nextInt(10);
		}
	}
	
	public void imprimir() {
		for(int i = 0; i < 5; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) {
		Array nuevo = new Array();
		
		nuevo.llenarArray();
		nuevo.imprimir();
	}
	
	
}
