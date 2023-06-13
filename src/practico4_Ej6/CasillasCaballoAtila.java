package practico4_Ej6;

import java.util.ArrayList;

public class CasillasCaballoAtila {
	private Casilla [][] casillas;
	private int n;
	
	public CasillasCaballoAtila(Casilla[][] casillas, int n) {
		this.casillas = new Casilla[n][n];
		this.n = n;
	}
	
	
	public ArrayList<ArrayList<ArrayList<Integer>>> getCaminoCaballo(){
		ArrayList<ArrayList<ArrayList<Integer>>> soluciones = new ArrayList<>();
		ArrayList<ArrayList<Integer>> solucionActual = new ArrayList<>();
		int contadorMovimientos = 0;
		
		backtracking(0, 0, contadorMovimientos, soluciones, solucionActual);
		
		return soluciones;
	}
	
	
	
	
	
	private void backtracking(int x, int y, int contadorMovimientos, ArrayList<ArrayList<ArrayList<Integer>>> soluciones, ArrayList<ArrayList<Integer>> solucionActual) {
		casillas[x][y].marcarVisitadaONo(true);
		
		if(contadorMovimientos == this.getNxN()) {
			ArrayList<Integer> pos = new ArrayList<>();
			pos.add(x);pos.add(y);
			solucionActual.add(pos);
			soluciones.add(new ArrayList<>(solucionActual));
			return;
		}
		
		else {
			if(casillas[x+1][y].fuePisada() && !casillas[x+1][y].fueVisitada()) {
				backtracking(x+1, y, contadorMovimientos+1, soluciones,solucionActual);
				solucionActual.remove(solucionActual.size()-1);
			}
			
			if(casillas[x][y+1].fuePisada() && !casillas[x+1][y].fueVisitada()) {
				backtracking(x, y+1, contadorMovimientos+1, soluciones,solucionActual);
				solucionActual.remove(solucionActual.size()-1);
			}
			
			
			casillas[x][y].marcarVisitadaONo(false);	
		}
	}


	public int getCantCasillasPisadas() {
		return 1;
	}
	
	public int getNxN() {
		return this.n * this.n;
	}
}
