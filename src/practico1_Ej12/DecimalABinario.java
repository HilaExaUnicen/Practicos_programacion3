package practico1_Ej12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Implemente un algoritmo recursivo que convierta un número en notación decimal a su
//equivalente en notación binaria

public class DecimalABinario {
	
	public final int DIVISOR = 2; //Lo establecemos como constante, ya que si quisieramos hacer de decimal a octal, solo deberiamos actualizarla por un 8, constantes en codigo RED FLAG
	
	public String decimalABinario(int numero, String resultado) {
		int cociente, resto;
		
		if(numero <= this.DIVISOR-1) {// cuando ya no sea divisible por dos						
			resultado = (resultado+numero); // el ultimo resultado va a ser 0 o 1 y como no se va a calcular el resto de dividirlos por dos se lo identamos al resultado final
			String resultadoFinal = revertirString(resultado); //durante la ejecucion los 0 y 1 de resto se van identando secuencialmente, pero los necesitamos desde "abajo para arriba" como si lo hicieramos en papel, ṕr eso lo revertimos
			
			return resultadoFinal;
		}
		else {
			cociente = (numero/DIVISOR);
			resto = (numero%=DIVISOR);
			
			resultado = (resultado + resto);
		}
		
		return decimalABinario(cociente, resultado);		
	}
	
	private String revertirString(String s) {
		String resultado = "";
		for(int i = s.length()-1; i >= 0; i--) {
			resultado = resultado + s.charAt(i);
		}
		
		return resultado;
	}

	public static void main(String[] args) {
		DecimalABinario convertidor = new DecimalABinario();
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Convertidor de decimal a binario de forma recursiva");
		try {
			System.out.println("Ingrese el numero a convertir: ");
			int numeroDecimal = Integer.valueOf(entrada.readLine());
			String numeroBinario = convertidor.decimalABinario(numeroDecimal, "");
			System.out.println("<--------------------------->");
			System.out.println("Decimal: " + numeroDecimal);
			System.out.println("Binario: " + numeroBinario);
			System.out.println("<--------------------------->");
		} 
		catch (Exception e) {
			System.out.println("No ha ingresado un numero valido. Intentelo de nuevo");
		}
	
		
	}
}
