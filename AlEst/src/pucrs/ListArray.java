package pucrs;

import java.util.Arrays;

public class ListArray {

    private static final int TAM_DEFAULT = 10;
    private Integer[] data;
    private int count;

    public ListArray() {
        this(TAM_DEFAULT);
    }

    public ListArray(int tam) {
        if (tam <= 0) {
            tam = TAM_DEFAULT;
        }
        data = new Integer[tam];
        count = 0;
    }

    public void clear() {
        data = new Integer[TAM_DEFAULT];
        count = 0;
    }
    public boolean isEmpty() {
        if(count==0) {
        	return true;
        }
        return false;
    }

    public int size() {
        return count;
    }

    public void add(Integer element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }


    @Override
    public String toString() {
    	if(isEmpty()) {return "";}
    	else {
    		for(int i =0; i<count; i++) {
        		System.out.print("["+data[i]+"] ");
        	}
    		return "";
    	}
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public int set(int index, Integer element) {
    	if(index<0 || (index>=count)) {
    		throw new IndexOutOfBoundsException();
    	}
    	int temp = data[index];
 	   data[index] = element;
 	   return temp;
    }

    public boolean contains(Integer element) {
       boolean contem = false;
       for(int i = 0; i<count; i++) {
    	   if(data[i]==element) {
    		   contem = true;
    	   }
       }
        return contem;
    }
    public int indexOf(int elem) {
    	for (int i = 0; i < count; i++) {
            if (data[i] == elem) {
                return i;
            }
        }
        return -1; // Elemento não encontrado
    }
    public boolean remove(int elem) {
    	int index = indexOf(elem);
    	boolean verifica = false;
    	if(index<0 || (index>=count)) {
    		throw new IndexOutOfBoundsException();
    	}
    	for(int i = index; i<count;i++) {
    		data[i]=data[i+1]; verifica = true;
    	}
    	count--;
    	return verifica;
    }
    public void reverse(){ // O(n)
    	reverse(data,0,count-1);
    }
    private void reverse(Integer[] Data, int ini, int fin){
    	if(ini<=fin){
    		int temp = data[ini];
    		data[ini] = data[fin];
    		data[fin] = temp;
    		reverse(Data,ini+1,fin-1);
    	}
    }
    public int countOcurrences(Integer elem) { // O(n)
    	int cont = 0;
    	for(int i = 0; i<count; i++) {
    		if(data[i]==elem) {
    			cont++;
    		}
    	}
    	return cont;
    }
    public void addIncreaseOrder(Integer elem) { 
    	 add(elem);

         for (int i = 1; i < count; i++) {
             Integer temp = data[i];
             int j = i - 1;
             while (j >= 0 && data[j] > temp) {
                 data[j + 1] = data[j];
                 j--;
             }
             data[j + 1] = temp;
         }
    }
}
