package pucrs;

import java.util.Random;

public class Quicksort
{
    private int[] data;
    private int contOp;

    public Quicksort(int[] data) {
        this.data = data;
    }
    public void zeraOp() { contOp = 0; }
    public int getOp() { return contOp; }
    
    public void sort() {
        sort(0, data.length-1);
    }

    public void sort(int start, int end) {

        if(start < end) {
            int pivot_pos = partition(start, end);
            sort(start, pivot_pos-1);
            sort(pivot_pos+1, end);
        }
    }

    private int partition(int start, int end) {
    	int mid = start + (end - start) / 2;
        swap(start, mid);  // Move o pivô para o início
        int i = start+1;
        int pivot = data[start];
        for(int j=start+1; j<=end; j++) {
        	contOp++;
            if(data[j] < pivot) {
                swap(i,j);
                i++;
            }
        }
        swap(start,i-1);
        return i-1;
    }

    private void swap(int p1, int p2) {
    	contOp++;
        int tmp = data[p1];
        data[p1] = data[p2];
        data[p2] = tmp;
    }

    public static void main(String args[]) {
        Random r = new Random();
        for(int MAX = 1000;MAX<=10000;MAX+=1000) {
	        int[] data = new int[MAX];
	        for(int i=0; i<data.length; i++)
	            data[i] = r.nextInt(data.length*10);

	        Quicksort qs = new Quicksort(data);
	        qs.zeraOp();
	        long start = System.nanoTime();
	        qs.sort();
	        long end = System.nanoTime();
	        //for(int i=0; i<data.length; i++)
	        //    System.out.print(data[i]+" ");
	        //System.out.println();
	        System.out.printf("Tempo para ordenar %d elementos: %d ns, Operações: %d\n", MAX, end - start, qs.getOp());
        }
    }
}

