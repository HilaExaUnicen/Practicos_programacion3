package practico4_Ej6;

public class Casilla {
	private boolean visitada, pisada;

	public Casilla(boolean visitada, boolean pisada) {
		super();
		this.visitada = visitada;
		this.pisada = pisada;
	}

	public boolean fueVisitada() {
		return visitada;
	}

	public void marcarVisitadaONo(boolean visitada) {
		this.visitada = visitada;
	}

	public boolean fuePisada() {
		return pisada;
	}
	
	
}
