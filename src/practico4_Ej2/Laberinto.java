package practico4_Ej2;

public class Laberinto {
	private Casilla[][] casillas;
	private int punteroFila;
	private int punteroColumna;
	private final int TAMANIO;
	public Laberinto(int tamanio) {
		this.casillas = new Casilla[tamanio][tamanio];
		this.TAMANIO = tamanio;
	}
	
	public void addCasilla(Casilla nuevaCasilla) {
		if(punteroFila <= TAMANIO) {
			this.casillas[punteroFila][punteroColumna] = nuevaCasilla;
			punteroFila++;
			punteroColumna++;
		}
	}
	
	public int getCaminoLongitudMinima(Casilla entrada, Casilla salida) {
		if(!entrada.estaBloqueada() && !salida.estaBloqueada()) {
			int caminoMinimo = 0;
			int caminoActual = 0;
			
			getCaminoLongitudMaxima(entrada, salida, caminoActual, caminoMinimo);
			
			return caminoMinimo;
		}
		else {
			return -1;//Alguno de las casillas ingresadas esta bloqueada
		}
	}

	private void getCaminoLongitudMaxima(Casilla casillaActual, Casilla salida, int caminoActual, int caminoMinimo) {
		caminoActual = caminoActual + casillaActual.getValor();
		if(casillaActual.equals(salida)) {
			
		}
		
	}
}
