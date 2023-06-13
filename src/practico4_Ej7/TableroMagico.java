package practico4_Ej7;
//
//import java.util.LinkedList;
//
//public class TableroMagico {
//	private int [][] tablero;
//	private int n,k,s;
//	private LinkedList<Integer> arrayNumerosPosibles;
//	
//	public TableroMagico(int n, int k, int s) {
//		this.tablero = new int [n][n];
//		this.n = n;
//		this.k = k;
//		this.s = s;
//		arrayNumerosPosibles = new LinkedList<>();
//	}
//	
//	public void llenarTablero() {
//		if(k > (n*n)) {
//			completarArrayNumerosPosibles();
//			int fila = 0;
//			int columna = 0;
//			boolean encontroSolucion = backtracking(fila,columna);
//			System.out.println(encontroSolucion);
//			//imprimirSolucion();
//		}
//		else {
//			System.out.println("Ingrese un nuevo k...");
//			//BufferedReader entrada =
//			//Integer.valueOf
//		}
//	}
//
//	private boolean backtracking(int fila, int columna) {
//		if((fila == this.n)) {	
//			verificarSuma();
//		}
//		else {	
//			for(int elem: copiaNumerosPosibles) {
//				if(!this.tableroContieneNumero(elem)) {
//					int aux = elem;
//					this.arrayNumerosPosibles.remove(elem);
//					tablero[fila][columna] = aux;
//					boolean encontroSolucion = backtracking(fila, columna+1);
//					if(!encontroSolucion) {
//						encontroSolucion = backtracking(fila+1, 0);
//					}
//					
//					this.arrayNumerosPosibles.add(aux);
//					tablero[fila][columna] = 0;
//
//					if(encontroSolucion) {
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}
//
//	private int getSumaTotalElemsArray(int[] array) {
//		int suma = 0;
//		for(int elem: array) {
//			suma+= elem;
//		}
//		
//		return suma;
//	}
//
//
//	private boolean tableroContieneNumero(int elem) {
//		for(int i = 0; i < this.n; i++) {
//			for(int j = 0; j < this.n; j++) {
//				if(tablero[i][j] == elem) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	
//	private void completarArrayNumerosPosibles() {
//		for(int i = 1; i < k+1; i++) {
//			this.arrayNumerosPosibles.add(i);
//		}
//	}
//	
//	public static void main(String[] args) {
//		TableroMagico tablero = new TableroMagico(3,10,15);
//		
//		tablero.llenarTablero();
//	}
//}

import java.util.Arrays;

public class TableroMagico {
    private int[][] tablero;
    private int[] numeros;
    private int n;
    private int k;
    private int s;

    public TableroMagico(int n, int k, int s) {
        this.n = n;
        this.k = k;
        this.s = s;
        tablero = new int[n][n];
        numeros = new int[k + 1];
    }

    public void resolverTableroMagico() {
        if (backtrack(0, 0)) {
            System.out.println("Se encontró una solución:");
            imprimirTablero();
        } else {
            System.out.println("No se encontró una solución.");
        }
    }

    private boolean backtrack(int fila, int columna) {
        if (fila == n) {
            return verificarSumas();
        }

        for (int num = 1; num <= k; num++) {
            if (numeros[num] == 0) {
                tablero[fila][columna] = num;
                numeros[num] = 1;

                int siguienteFila = fila;
                int siguienteColumna = columna + 1;
                if (siguienteColumna == n) {
                    siguienteFila++;
                    siguienteColumna = 0;
                }

                if (backtrack(siguienteFila, siguienteColumna)) {
                    return true;
                }

                tablero[fila][columna] = 0;
                numeros[num] = 0;
            }
        }

        return false;
    }

    private boolean verificarSumas() {
        int sumaFila;
        int sumaColumna;

        for (int i = 0; i < n; i++) {
            sumaFila = 0;
            sumaColumna = 0;

            for (int j = 0; j < n; j++) {
                sumaFila += tablero[i][j];
                sumaColumna += tablero[j][i];
            }

            if (sumaFila != s || sumaColumna != s) {
                return false;
            }
        }

        return true;
    }

    private void imprimirTablero() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(tablero[i]));
        }
    }

    public static void main(String[] args) {
        TableroMagico tableroMagico = new TableroMagico(3, 10, 15);
        tableroMagico.resolverTableroMagico();
    }
}

