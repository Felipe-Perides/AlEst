package pucrs;

import java.util.Random;

public class Insertionsort
{
    private int[] data;
    private int contOp;
    public void zeraOp() {contOp=0;}
	public int getOp() {return contOp;}

    public Insertionsort(int[] data) {
        this.data = data;
    }

    public void sort() {
        int temp, j;
        int n = data.length;
        for(int i=0; i<n; i++) {
            temp = data[i];
            j = i;
            while(j>0 && temp < data[j-1]) {
            	contOp++;
                data[j] = data[j-1];
                j--;
            }
            data[j] = temp;
        }
    }

    public static void main(String args[]) {
        /*
         * Random r = new Random();
        for(int MAX = 1000; MAX<=25000;MAX+=1000) {
	        int[] data = new int[MAX];
	        for(int i=0; i<data.length; i++)
	            data[i] = r.nextInt(data.length*10);
         */
	       for(int MAX = 1000; MAX<=25000; MAX+=1000) {
		    	int[] data = new int[MAX];
		    	for(int i = 0; i<data.length; i++)
		    		data[i] = MAX - i - 1;
	        Insertionsort is = new Insertionsort(data);
	        long start = System.nanoTime();
	        is.zeraOp();
	        is.sort();
	        long end = System.nanoTime();
	        System.out.printf("Tempo para ordenar %d elementos: %d ns, Operações: %d\n",MAX,(end-start),is.getOp());
        }
    }
}

