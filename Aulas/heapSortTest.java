package Aulas;

import java.util.Random;

public class heapSortTest {
    public static void main(String args[]) {

        int MAX = 100;
        Random r = new Random();
        int[] data = new int[MAX];
        long clock;

        data[0] = 0;
        for(int i=1; i<MAX; i++)
           data[i] = r.nextInt(MAX*10);

        MaxHeap my = new MaxHeap(data);
        long start = System.nanoTime();
        my.sort();
        long end = System.nanoTime();
        clock = (end-start);
        System.out.printf("Tempo para ordenar %d elementos: %d ns\n", MAX, clock);
        my.printArray();
    }
}