package pilhas_filas;

public class StackArray implements StackTAD{
	// Atributos
    private static final int TAM_PADRAO = 10;
    private int[] data;
    private int count;
    
    public StackArray() {
    	this(TAM_PADRAO);
    }
    
    public StackArray(int tam) {
        if (tam <= 0) {
            tam = TAM_PADRAO;
        }
        data = new int[tam];
        count = 0;
    }

	@Override
	public void push(int e) {
		if(count == data.length) {
			setCapacity(data.length*2);
		}
		data[count] = e;
		count++;
	}

	@Override
	public int pop() {
		int aux = data[count-1];
		int[] popped = new int[count-1];
		for(int i = 0; i < count-1; i++) {
			popped[i] = data[i];
		}
		data = popped;
		count--;
		return aux;
	}

	@Override
	public int top() {
		return data[count-1];
	}

	@Override
	public void clear() {
		data = new int[TAM_PADRAO];
        count = 0;
	}

	@Override
	public boolean isEmpty() {
		return count==0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public String toString() {
		String aux = "[ ";
		for(int i = 0; i<count; i++) {
			aux += data[i] + " ";
		}
		aux += "]";
		return aux;
	}

	private void setCapacity(int newCapacity) {
		if (newCapacity != data.length) {
            int min = 0;
            int[] newData = new int[newCapacity];
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
	
}
