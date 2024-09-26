package pilhas_filas;

import org.w3c.dom.Node;

public class StackLinked implements StackTAD{

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
        }
    }
	
	public StackLinked() {
		clear();
	}
	
	@Override
	public void push(int e) {
		Node n = new Node(e);
		Node pre = trailer.prev;
		n.prev = pre;
		n.next = trailer;
		pre.next = n;
		trailer.prev = n;
		count++;
	}

	@Override
	public int pop() {
		if(count == 0) {
			throw new IndexOutOfBoundsException("Lista vazia");
		}
		Node rem = trailer.prev;
		Node ant = rem.prev;
		ant.next = trailer;
		trailer.prev = ant;
		count--;
		return rem.item;
	}

	@Override
	public int top() {
		Node last = trailer.prev;
		return last.item;
	}

	@Override
	public void clear() {
		header = new Node(0);
        trailer = new Node(0);
        header.next = trailer;
        trailer.prev = header;
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
		Node ptr = header.next;
		while(ptr!=trailer) {
			aux += ptr.item + " ";
			ptr = ptr.next;
		}
		aux += "]";
		return aux;
	}
	
}
