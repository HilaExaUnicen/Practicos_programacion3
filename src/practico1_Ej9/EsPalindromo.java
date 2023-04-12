package practico1_Ej9;

public class EsPalindromo {
	
	public boolean esPalindromo(String palabra) {
		if(palabra.length()<=1) {
			return true;
		}
		else {
			if(palabra.charAt(0) != palabra.charAt(palabra.length()-1)) {
				return false;
			}
		}
		
		return esPalindromo(palabra.substring(1, palabra.length()-1)); //Llamada recursiva
	}
	
	public static void main(String[] args) {
		EsPalindromo xd = new EsPalindromo();
		
		System.out.println(xd.esPalindromo("lol"));
		System.out.println(xd.esPalindromo("JAAJ"));
		System.out.println(xd.esPalindromo("bokita"));
	}
}
