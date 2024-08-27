package pucrs;

public class AulaContOperator {
	public static void main(String[] args) {
		
		int cont = 0;
		int x = 1;
		for(int i = 1; x<15; i++) {
			System.out.println("conts = "+x+" "+(i+1));
			x = x + (i+1);
			cont++;
			System.out.println("\ni = "+i+"\nCont = "+cont+"\nX = "+x+"\n");
		}
	}
}
