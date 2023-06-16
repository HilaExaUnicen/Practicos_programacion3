package practico5_Ej1;

public class CajeroGreedy {
	private int[] conjuntoMonedas;

	public CajeroGreedy(int[] conjuntoMonedas) {
		this.conjuntoMonedas = conjuntoMonedas;
	}
	
	public void retirarDinero(int m){
		int [] cantidadMonedas = new int [conjuntoMonedas.length];
		int indice = 0;
		if(m > 0) {
			int saldoRestante = m;
			while(saldoRestante != 0) {
				while(conjuntoMonedas[indice] <= saldoRestante) {
					saldoRestante = saldoRestante - conjuntoMonedas[indice];
					cantidadMonedas[indice] = cantidadMonedas[indice] + 1;
				}
				
				indice++;
				
			}
			
			imprimirResultado(cantidadMonedas);	
		}
		else {
			System.out.println("Ingrese un valor positivo");
		}
			
	}
		
		

	private void imprimirResultado(int [] cantMonedasUsadas) {
		for(int i = 0; i < conjuntoMonedas.length; i++) {
			System.out.println("Se retiraron " + cantMonedasUsadas[i] + " monedas de $" + conjuntoMonedas[i]);
		}
	}
	
	public static void main(String[] args) {
		int [] arr = new int [5];
		arr[0] = 100;
		arr[1] = 25;
		arr[2] = 10;
		arr[3] = 5;
		arr[4] = 1;
		
		CajeroGreedy cajero = new CajeroGreedy(arr);
		cajero.retirarDinero(289);
	}
	
	
	
	
	
}
