package pucrs;

import java.util.Random;

public class BubbleSort {
	
	private int contOp;
	public void zeraOp() {contOp=0;}
	public int getOp() {return contOp;}
	
    public void sort(int[] values) {
        for(int i=0; i<values.length; i++) {
            boolean trocou = false;
            for(int j=0; j<values.length-i-1; j++) {
            	contOp++;
                if(values[j] > values[j+1]) {
                    int temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                    trocou = true;
                }
            }
            if(!trocou) break;
        }
    }

    public static void main(String args[]) {
        Random r = new Random();
        for(int MAX = 10000;MAX<20000;MAX+=1000) {
	        int[] data = new int[MAX];
	        for(int i=0; i<data.length; i++)
	            data[i] = r.nextInt(data.length*10);
	
	        long start = System.nanoTime();
	        BubbleSort bs = new BubbleSort();
	        bs.zeraOp();
	        bs.sort(data);
	        long end = System.nanoTime();
	        //for(int i=0; i<data.length; i++)
	        //    System.out.print(data[i]+" ");
	        //System.out.println();
	        System.out.printf("Tempo para ordenar %d elementos: %d ns\n",MAX,bs.getOp());
        }
    }
}

