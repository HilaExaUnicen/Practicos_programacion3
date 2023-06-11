package practico4_Ej2;

public class Casilla {
	private int valor;
	private boolean arriba, derecha, abajo, izquierda, visitada;
	
	public Casilla(int valor, boolean arriba, boolean derecha, boolean abajo, boolean izquierda) {
		this.valor = valor;
		this.arriba = arriba;
		this.derecha = derecha;
		this.abajo = abajo;
		this.izquierda = izquierda;
		this.visitada = false;
	}
	
	public void marcarComoVisitada() {
		this.visitada = true;
	}
	
	public boolean puedoIrDerecha() {
		return derecha;
	}
	
	public boolean puedoIrIzquierda() {
		return izquierda;
	}
	
	public boolean puedoIrArriba() {
		return arriba;
	}
	
	public boolean puedoIrAbajo() {
		return abajo;
	}
	
	public boolean estaBloqueada() {
		if(arriba == false && abajo == false && izquierda == false && derecha == false) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getValor() {
		return this.valor;
	}
	
	
	
}
