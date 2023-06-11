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
			int caminoMinimo = Integer.MAX_VALUE;
			int caminoActual = 0;
			
			getCaminoLongitudMaxima(entrada, salida, caminoActual, caminoMinimo);
			
			return caminoMinimo;
		}
		else {
			return -1;//Alguna de las casillas ingresadas esta bloqueada
		}
	}

	private void getCaminoLongitudMaxima(Casilla casillaActual, Casilla salida, int caminoActual, int caminoMinimo) {
		caminoActual = caminoActual + casillaActual.getValor();
		if(casillaActual.equals(salida)) {
			if(caminoActual < caminoMinimo) {
				int aux = caminoActual;
				caminoMinimo = aux;
				caminoActual = caminoActual - casillaActual.getValor();
			}
		}
		else {
//			if(casillaActual.puedoIrArriba()) {
//				if(!casillaActual.getArriba().fueVisitada()) {
//					//getCaminoLongitudMaxima(casillaActual.getArriba(), salida, caminoActual, caminoMinimo);
//				}
//			}
//			else if(casillaActual.puedoIrDerecha()) {
//				if(!casillaActual.getDerecha().fueVisitada()) {
//					//getCaminoLongitudMaxima(casillaActual.getDerecha(), salida, caminoActual, caminoMinimo);
//				}
//			}
//			else if(casillaActual.puedoIrAbajo()) {
//				if(!casillaActual.getAbajo().fueVisitada()) {
//					//getCaminoLongitudMaxima(casillaActual.getAbajo(), salida, caminoActual, caminoMinimo);
//				}
//			}
//			else if(casillaActual.puedoIrIzquierda()) {
//				if(!casillaActual.getIzquierda().fueVisitada()) {
//					//getCaminoLongitudMaxima(casillaActual.getIzquierda(), salida, caminoActual, caminoMinimo);
//				}
//			}
		}		
		casillaActual.marcarComoVisitada();
		caminoActual = caminoActual - casillaActual.getValor();
	}
}
