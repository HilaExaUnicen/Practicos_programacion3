package practico4_Ej11;

import java.util.ArrayList;
import java.util.Arrays;

public class CaminoRobot {
	public static void main(String[] args) {

		
		CaminoRobot r = new CaminoRobot(2,2);
		r.llenarMat();
		r.imprimirTablero();
		//ArrayList<Integer> camino = r.getCaminoMasCorto();
		
		
	}
	
	private int [][] mat = new int [3][3];
	private int n; 
	private int posFilaCarga;
	private int posColumnaCarga;

	public CaminoRobot(int posFilaCarga, int posColumnaCarga) {
		this.posFilaCarga = posFilaCarga;
		this.posColumnaCarga = posColumnaCarga;
	}

	public ArrayList<Integer> getCaminoMasCorto() {//Se deberia poder ingresar una pos inicial por parametro.
		ArrayList<Integer> caminoActual = new ArrayList<>();
		ArrayList<Integer> caminoMasCorto = new ArrayList<>();
		int fila = 0;
		int columna = 0;
		
		this.llenarMat();
		this.imprimirTablero();
		
		backtracking(fila, columna, caminoActual, caminoMasCorto);
		
		return caminoMasCorto;
	}

	private void backtracking(int fila, int columna, ArrayList<Integer> caminoActual, ArrayList<Integer> caminoMasCorto) {
		if(fila == posFilaCarga && columna == posColumnaCarga) {
			if(caminoActual.size() > caminoMasCorto.size()) {
				caminoMasCorto = new ArrayList<>(caminoActual);
				return;
			}
		}
		else {
			if((fila >= 0 && fila < this.n) && (columna >= 0 && columna < this.n) && mat[fila][columna] == 0 ) {//Si es 1 esta bloqueada, si es 2 fue visitada;
				caminoActual.add(fila);
				caminoActual.add(columna);
				mat[fila][columna] = 2;//La marcamos como visitada
				
				backtracking(fila-1, columna, caminoActual, caminoMasCorto);//arriba
				backtracking(fila, columna+1, caminoActual, caminoMasCorto);//derecha
				backtracking(fila+1, columna, caminoActual, caminoMasCorto);//abajo
				backtracking(fila, columna-1, caminoActual, caminoMasCorto);//izquierda
				
				caminoActual.remove(caminoActual.size()-1);
				caminoActual.remove(caminoActual.size()-1);
				mat[fila][columna] = 0;
			}
			else {
				return;
			}
		}
	}
	
    private void imprimirTablero() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }
    
    private void llenarMat() {
    	mat[0][0] = 0;
    	mat[0][1] = 0;
    	mat[0][2] = 1;
    	mat[1][0] = 1;
    	mat[1][1] = 0;
    	mat[1][2] = 1;
    	mat[2][0] = 0;
    	mat[2][1] = 0;
    }
    
    
	
	
}