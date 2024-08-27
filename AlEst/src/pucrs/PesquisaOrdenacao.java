package pucrs;

public class PesquisaOrdenacao {
	private static int i,j,aux;
	
	//  bubble Sort
	public static void bubbleSort(int array[], int n) {  // O(n²)
		for(i=0;i<array.length;i++) {
			System.out.print(array[i]);
		}
		System.out.println();
		for(i=0;i<n;i++) {
			for(j=0;j<n-1;j++) {
				if(array[j]>array[j+1]) {
					aux = array[j+1];
					array[j+1]=array[j];
					array[j]=aux;
				}
			}
		}
		for(i=0;i<array.length;i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}
	
	// pesquisa sequencial desordenada
	public static void pesquisaSequencialDesord(int array[], int num) {  // O(n)
		for(i=0;i<array.length;i++) {
			if(array[i]==num) {
				System.out.println("O número "+num+" foi encontrado na posição "+(i+1));
				break;
			}else {
				System.out.println("O numero "+num+" nao foi encontrado!");
			}
		}
	}
	
	// pesquisa sequencial ordenada
	public static void pesquisaSequencialOrd(int array[], int num) {  // O(n)
		bubbleSort(array,array.length);
		System.out.println();
		for(i=0; i<array.length;i++) {
			if(array[i]==num||array[i]>num) {
				System.out.println("Um valor igual ou maior que "+num+" foi encontrado na posição "+(i+1));
				break;
			}else {
				System.out.println("O numero "+num+" nao foi encontrado!");
			}
		}
		
	}
	
	// pesquisa binaria com um array já ordenado
	public static void pesquisaBinaria(int array[], int Low, int High, int numDesejado) { 
		// A pesquisa binaria tem complexidade O(log n), mas como iniciei o codigo com o metodo bubbleSort, a complexidade total ficou em O(n²)
		bubbleSort(array,array.length);
		System.out.println();
		int low=Low,high=High-1,mid;
		while(low<=high) {
			mid=(low+high)/2;
			if(numDesejado==array[mid]) {
				System.out.println("O número "+numDesejado+" foi encontrado na posição "+(mid+1));
				return;
			}else if(numDesejado<array[mid]) {
				high=mid-1;
			}else if(numDesejado>array[mid]) {
				low=mid+1;
			}
		}
	}

	// Main
	public static void main(String[] args) {
		// bubble sort
		int[] array1 = {5,3,1,2,0,4};
		bubbleSort(array1,array1.length);
		System.out.println("\n");
		// sequencial desordenada
		int[] array2 = {3,5,4,0,2,1};
		pesquisaSequencialDesord(array2, 0);
		System.out.println("\n");
		// sequencial ordenada
		pesquisaSequencialOrd(array2, 4);
		System.out.println("\n");
		// binaria
		int min = 0, max = array2.length;
		pesquisaBinaria(array2, min, max, 2);
		int[] array3 = {1};
		int min2 = 0, max2 = array3.length;
		pesquisaBinaria(array3, min2, max2, 1);
		int[] array4 = {0,2,1,4,3};
		int min3 = 0, max3 = array4.length;
		pesquisaBinaria(array4, min3, max3, 3);
		pesquisaBinaria(array4, min3, max3, 4);
	}
}