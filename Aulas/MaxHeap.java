package Aulas;

public class MaxHeap {

    private int v[];
    private Integer size;
  
    public MaxHeap(int tam) {
      size = 1;
      v = new int[tam];
      v[1] = 0;
    }
  
    public MaxHeap(int[] values) {
      v = values;
      size = values.length;
    }
  
    /*
     * private int left ( int i )   { return 2 * i; }
    private int right ( int i )  { return 2 * i + 1; }
    private int parent ( int i ) { return i / 2; }
     */
  
    private void swim ( int k ) {
        while (k>1 && less(k/2, k)) {
           System.out.println("Swap "+v[k]+" with "+v[k/2]+" "+k);
           exch(k, k/2);
           k = k / 2;
        } 
    }

    private boolean less(int p, int f){
        if(v[p]<v[f]){
            return true;
        }else{
            return false;
        }
    }

    private void exch(int f, int p){
        int tmp = v[f];
        v[f] = v[p];
        v[p] = tmp;
    }
  
    public void put(int data) {
      if (size >= v.length) { // Se o array estiver cheio, redimensiona
          int[] novoV = new int[v.length * 2];
          System.arraycopy(v, 0, novoV, 0, v.length);
          v = novoV;
      }
      v[size] = data;
      swim(size);
      size++;
  }
  
    private void sink ( int i, int n ) {
        while (2*i <= n) {
          int j = 2 * i; // Filho esquerdo
          if (j < n && less(j, j + 1)) j++; // Escolhe o maior filho
          if (!less(i, j)) break;
          exch(i, j); // Troca pai e maior filho
          i = j; // Continua descendo
        }
    }
  
    public int get() {
      if (size == 1)
          throw new UnsupportedOperationException("MaxHeap vazio!");
      int res = v[1];
      v[1] = v[--size];
      sink(1, size - 1); // Aqui deve ser `size - 1`
      return res;
  }
  
    private void print( int b, int elem, int sp )  {
      int i, j;
  
      System.out.println( "" );
      for( j = 0; j < size; j++ ) System.out.print( v[j] + " " );
      System.out.println( "" );
  
      while ( true ) {
        for( j = 0; j <= sp / 2; j++ ) System.out.print( " " );
        for( i = b; i < b + elem; i++ ) {
          if ( i == size ) return;
          System.out.print( v[i] );
          for( j = 0; j < sp; j++ ) System.out.print( " " );
        }
        System.out.println( "" );
        b = b + elem;
        elem = 2 * elem;
        sp = sp / 2;
      }
    }
  
    public void print( )  {
      System.out.println( "" );
      print( 1, 1, 32 );
      System.out.println( "" );
    }
  
    public void printArray() {
      for(int i=0; i<size; i++)
         System.out.print(v[i]+" ");
      System.out.println();
    }
  
    public void sort() {
        int n = size - 1;
        for(int k = n/2; k >= 1; k--){
          sink(k, n);
        }
        while(n > 1){
            exch(1, n--);
            sink(1,n);
        }
    }
  }  
