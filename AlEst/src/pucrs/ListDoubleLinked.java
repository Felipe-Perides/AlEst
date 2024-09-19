package pucrs;

import java.util.NoSuchElementException;

public class ListDoubleLinked implements ListTADdouble{
	private Node header;
    private Node trailer;
    private int count;

    private class Node {
        public int item;
        public Node next;
        public Node prev;

        public Node(int element) {
            this.item = element;
            this.next = null;
            this.prev = null;
        }
    }

    public ListDoubleLinked() {
        header = new Node(0);
        trailer = new Node(0);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    @Override
    public void add(int element) { //Add na ultima posicao
    	
    	Node n = new Node(element);
    	Node last = trailer.prev;
    	n.prev = last;
    	n.next = trailer;
    	last.next = n;
    	trailer.prev = n;
    	count++;
    	
        /*
        Node n = new Node(element);
        if (count != 0) // lista já tem elems?
            tail.next = n;
        else
            head = n; // não, este é o primeiro
        tail = n;
        count++;
        */
    }

    @Override
    public void add(int index, int element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node n1 = new Node(element);
        if(index == 0) {
        	n1.prev = header;
        	if(header.next!=null) {
        		n1.next = header.next;
        		header.next.prev = n1;
        	}else {
        		n1.next = null;
        	}
        	header.next = n1;
        }else {
        	Node current = header.next;
        	for(int i = 0; i<index-1; i++) {
        		current = current.next;
        	}
        	n1.next = current.next;
            n1.prev = current;
            current.next.prev = n1;
            current.next = n1;
        }
        
        /*
        if (index == 0) { // inserção no início?
            n.next = head;
            head = n;
        } else {
            Node ant = null;
            Node target = head;
            for (int pos = 0; pos < index; pos++) {
                ant = target;
                target = target.next;
            }
            ant.next = n;
            n.next = target;
        }
        */
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * 
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    @Override
    public int get(int index) {
    	Node ptr = header.next;
        if ((index < 0) || (index >= count || ptr == null)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        for(int pos = 0; pos<index; pos++) {
        	ptr = ptr.next;
        }
        return ptr.item;
        /*
        Node ptr = head;
        for (int pos = 0; pos < index; pos++)
            ptr = ptr.next;
        return ptr.element;
        */
    }

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * 
     * @param index   a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    @Override
    public int set(int index, int element) {
    	Node ptr = header.next;
    	if ((index < 0) || (index >= count || ptr == null)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        for(int pos = 0; pos<index;pos++) {
        	ptr = ptr.next;
        }
        int oldValue = ptr.item;
        ptr.item = element;
        return oldValue;
        
        /*
        Node ptr = head;
        for (int pos = 0; pos < index; pos++)
            ptr = ptr.next;
        int temp = ptr.element; // salva o valor armazenado lá...
        ptr.element = element;
        return temp; // ...e retorna ele
        */
    }

    @Override
    public boolean remove(int element) {
        int pos = indexOf(element);
        if (pos == -1)
            return false; // não existe na lista
        removeByIndex(pos);
        return true;
    }

    @Override
    public int removeByIndex(int index) {
    	Node n = header.next;
    	for(int i = 0; i<index-1; i++) {
    		n = n.next;
    	}
    	int value = n.next.item;
    	n.next = n.next.next;
    	return value;
        /*
        Node aux = head;
        // Se for o início, basta avançar o head
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = head;
            aux = head.next;
            for (int pos = 1; pos < index; pos++) {
                prev = aux;
                aux = aux.next;
            }
            // Remove o elemento
            prev.next = aux.next;
            // Se for o final da lista,
            // ajusta o tail
            if (index == count - 1)
                tail = prev;
        }
        count--;
        // Se a lista ficar vazia (count==0),
        // garante que o tail também será NULL
        if (count == 0)
            tail = null;
        return aux.element;
        */
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(int element) {
    	int index = 0;
    	Node n1 = header.next;
    	while(n1!=null) {
    		if(n1.item == element) {
    			return index;
    		}
    		index++;
    	}
    	return -1;
        /*
        Node ptr = head;
        for (int pos = 0; pos < count; pos++) {
            if (ptr.element == element)
                return pos;
            ptr = ptr.next;
        }
        return -1; // não encontrou
        */
    }

    @Override
    public void clear() {
    	Node n1 = header.next;
    	while(n1!=null) {
    		Node n2 = n1.next;
    		n1.item = 0;
    		n1 = n2;
    	}
    	header.next = null;
    	count = 0;
        /*
        head = null;
        tail = null;
        count = 0;
        */
    }

    /**
     * Retorna o conteúdo da lista como uma string
     * 
     * @return uma string com os elementos da lista
     */
    @Override
    public String toString() {
    	
    	Node n = header.next;
    	StringBuilder msg = new StringBuilder("[ ");
    	while(n!=null){
    		msg.append(n.item).append(" ");
    		n = n.next;
    	}
    	msg.append(" ]");
    	return msg.toString();
        /*
        String aux = "[ ";
        Node ptr = head;
        while (ptr != null) {
            aux = aux + ptr.element + " ";
            ptr = ptr.next; // avança para o próximo nodo
        }
        aux += "]";
        return aux;
        */
    }

    public int somaEntreIndex(int index1, int index2) {
    	int sum = 0;
    	Node n = header.next;
    	for(int i = 0; i<index1; i++) {
    		n = n.next;
    	}
    	for(int ii = index1; ii<=index2; ii++) {
    		sum += n.item;
    		n = n.next;
    	}
    	return sum;
    }
    
    
    
	@Override
	public void addFirst(int e) {
		Node n1 = new Node(e);
		n1.prev = header;
    	if(header.next!=null) {
    		n1.next = header.next;
    		header.next.prev = n1;
    	}else {
    		n1.next = null;
    	}
    	header.next = n1;
    	count++;
	}

	@Override
	public int getFirst() {
		  if (header.next == null) {
		        throw new NoSuchElementException("List is empty");
		    }
		int first = header.next.item;
		return first;
	}

	@Override
	public int getLast() {
		if (trailer == null) {
	        throw new NoSuchElementException("List is empty");
	    }
		int last = trailer.item;
		return last;
	}

	@Override
	public int removeFirst() {
		int first = get(0);
		remove(0);
		return first;
	}

	@Override
	public int removeLast() {
		int last = trailer.item;
		remove(size()-1);
		return last;
	}
}
