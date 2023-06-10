package practico4_Ej1;

import java.util.ArrayList;
import java.util.Iterator;
import practico3_Ej1.GrafoDirigido;

public class Salas {
	int entrada, salida;
	private GrafoDirigido<?> salas;
	
	public Salas(int entrada, int salida) {
		this.entrada = entrada;
		this.salida = salida;
		this.salas = new GrafoDirigido<>();
	}
	
	public ArrayList<Integer> getCaminoMasLargo() {
		ArrayList<Integer> caminoMasLargo = new ArrayList<>();
		ArrayList<Integer> caminoActual = new ArrayList<>();
		
		caminoActual.add(this.entrada);
		Iterator<Integer> salasContiguas = this.salas.obtenerAdyacentes(this.entrada);
		
		while(salasContiguas.hasNext()) {
			int sala = salasContiguas.next();
			getCaminoMasLargo(sala, caminoActual, caminoMasLargo);
		}
		
		return caminoMasLargo;
	}

	private void getCaminoMasLargo(int salaAdy, ArrayList<Integer> caminoActual, ArrayList<Integer> caminoMasLargo) {
		caminoActual.add(salaAdy);
		
		if(salaAdy == this.salida) {
			if(caminoActual.size() > caminoMasLargo.size()) {
				caminoMasLargo.addAll(caminoActual);
				caminoActual.remove(caminoActual.size()-1);
				return;
			}
		}
		else {
			Iterator<Integer> salasContiguas = this.salas.obtenerAdyacentes(salaAdy);
			while(salasContiguas.hasNext()) {
				int sala = salasContiguas.next();
				getCaminoMasLargo(sala, caminoActual, caminoMasLargo);
			}
		}
		
		caminoActual.remove(caminoActual.size()-1);
	}
	
	public void agregarSala(int sala) {
		this.salas.agregarVertice(sala);
	}
	
	public void agregarPuerta(int origen, int destino) {
		this.salas.agregarArco(origen, destino, null);
	}
	
	public static void main(String[] args) {
		Salas salas = new Salas(1, 7);
		
		salas.agregarSala(1);
		salas.agregarSala(2);
		salas.agregarSala(3);
		salas.agregarSala(4);
		salas.agregarSala(5);
		salas.agregarSala(6);
		salas.agregarSala(7);
		salas.agregarSala(8);
		salas.agregarSala(9);
		salas.agregarSala(10);
		salas.agregarSala(11);
		salas.agregarSala(12);
		salas.agregarSala(13);
		
		salas.agregarPuerta(1, 2);
		salas.agregarPuerta(1, 5);
		salas.agregarPuerta(1, 8);
		salas.agregarPuerta(2, 3);
		salas.agregarPuerta(2, 4);
		salas.agregarPuerta(5, 12);
		salas.agregarPuerta(5, 6);
		salas.agregarPuerta(6, 7);
		salas.agregarPuerta(8, 9);
		salas.agregarPuerta(8, 10);
		salas.agregarPuerta(10, 11);
		
		ArrayList<Integer> camino = salas.getCaminoMasLargo();
		
		System.out.println(camino);
		
	}
}
