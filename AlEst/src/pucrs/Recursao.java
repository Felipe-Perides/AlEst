package pucrs;

public class Recursao {
	
	//potencia
	public static int potRecursao(int num, int pot) {
		if(pot==0) {return 1;}
		if(pot==1) {return num;}
		return num*potRecursao(num,pot-1);
	}
	
	//print array
	public static void printA(int[] array) {
		System.out.print("[");
		for(int i : array) {
			System.out.print(i+" ");
		}
		System.out.print("]");
	}
	
	//inversao
	public static void inverterA(int[] array) {
		inverterA(array, 0, array.length-1);
	}
	private static void inverterA(int[] array, int ini, int fin) {
		if(ini<=fin) {
			int temp = array[ini];
			array[ini] = array[fin];
			array[fin] = temp;
			inverterA(array, ini+1, fin-1);
		}
	}
	
	//soma de elementos num array
	public static int somaElementA(int[] array) {
		return somaElementA(array, array.length-1);
	}
	private static int somaElementA(int[] array, int pos) {
		if(pos==0) {
			return array[0];
		}else {
			return array[pos]+somaElementA(array,pos-1);
		}
	}
	
	//palindromo
	public static boolean palindromo(String word) {
		return palindromo(word, 0, word.length()-1);
	}
	private static boolean palindromo(String word, int ini, int fin) {
		if(ini>=fin) {
			return true;
		}else if(word.charAt(ini) != word.charAt(fin)) {
			return false;
		}else {
			return palindromo(word,ini+1,fin-1);
		}
	}
	
	public static void main(String args[]) {
		System.out.println("2^5 = "+ potRecursao(2,5));
		System.out.println();
		
		int[] array = new int[] {1,3,5,7,9};
		System.out.println("Array: ");
		printA(array);
		inverterA(array);
		System.out.println();
		System.out.println("\nArray invertido: ");
		printA(array);
		
		System.out.println();
		int soma = somaElementA(array);
		System.out.println("\nSoma dos elementos: "+soma);
		System.out.println();
		
		System.out.println("A palavra 'reNner' é um palindromo?\n "+palindromo("reNner"));
		System.out.println("A palavra 'Renner' é um palindromo?\n "+palindromo("Renner"));
		System.out.println("A palavra 'RENNER' é um palindromo?\n "+palindromo("renner"));
	}
}
