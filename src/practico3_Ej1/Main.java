package practico3_Ej1;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> arcos = new LinkedList<>();
		
		LinkedList<Integer> v1 = new LinkedList<>();
		v1.add(1);
		v1.add(2);
		v1.add(3);
		LinkedList<Integer> v2 = new LinkedList<>();
		v2.add(2);
		v2.add(8);
		v2.add(9);
		
		arcos.addAll(v1);
		
		System.out.println(arcos);
		
		arcos.addAll(v2);
		
		System.out.println(arcos);
		

	}

}
