package practico4_Ej5;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class AsignadorDeTareas {
	private ArrayList<Tarea> tareas;
	private ArrayList<Procesador> procesadores;
	
	public AsignadorDeTareas() {
		tareas = new ArrayList<>();
		procesadores = new ArrayList<>();
	}
	
	
	public void addTarea(Tarea t) {
		tareas.add(t);
	}
	
	public void addProcesador(Procesador p) {
		procesadores.add(p);
	}
	
	public Map<Procesador, ArrayList<Tarea>> asignarTareasEficientemente() {
		Map<Procesador, ArrayList<Tarea>> currentSolution = new HashMap<>();
		Map<Procesador, ArrayList<Tarea>> bestSolution = new HashMap<>();
		
		for(Procesador p: procesadores) {
			currentSolution.put(p, new ArrayList<>());
			bestSolution.put(p, new ArrayList<>());
		}
		
		int indice = 0;
		
		backtracking(indice, currentSolution, bestSolution);
		
		return bestSolution;
	}


	private void backtracking(int indice, Map<Procesador, ArrayList<Tarea>> currentSolution, Map<Procesador, ArrayList<Tarea>> bestSolution) {
		if(indice >= tareas.size()) {
			return;
		}
		
		
		for(int i = 0; i < procesadores.size(); i++) {
			Procesador p = procesadores.get(i);
			ArrayList<Tarea> listaTareasP = currentSolution.get(p);
			listaTareasP.add(tareas.get(indice));
			
			if(bestSolution.get(p).isEmpty()) {
				bestSolution.get(p).addAll(listaTareasP);
			}
			else {
				if(getTiempoTareas(listaTareasP) < getTiempoTareas(bestSolution.get(p))) {
					bestSolution.get(p).clear();
					bestSolution.get(p).addAll(listaTareasP);
				}
			}
			
			
			backtracking(indice + 1, currentSolution, bestSolution);
			listaTareasP.remove(listaTareasP.size()-1);
		}
	}


	private int getTiempoTareas(ArrayList<Tarea> tareas) {
		int tiempoTotal = 0;
		for(Tarea t: tareas) {
			tiempoTotal += t.getTiempoEjecucion();
		}
		
		return tiempoTotal;
	}
}
