package pucrs;
import java.util.Random;

public class App_PesquisaOrdenacao {

	public static void main(String[] args) {
	    Random r = new Random();
	    for(int n=10; n<10000; n++) {
	        int[] vet = new int[n];
	        for(int i=0; i<n; i++)
	            vet[i] = r.nextInt(n*10);
	        // Faz alguma coisa com o vetor
	        // for(int v: vet)
	            // System.out.print(v+" ");
	        // System.out.println();            
	    }
	}
}