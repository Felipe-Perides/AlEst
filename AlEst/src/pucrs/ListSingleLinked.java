package pucrs;

import java.security.InvalidParameterException;

public class ListSingleLinked implements ListTAD{
	private class Node {
	    public int element ;
	    public Node next ;
	   
	    public Node(int e) {
	       element = e ;
	      next = null ;
	    }
	  }

	  private Node head ;
	  private Node tail ;
	  private int count ;
	  
	  // Construtor
	  public ListSingleLinked ( ) {
	      head = null ;
	      tail = null ;
	      count = 0;
	  }

	  //
	  // insere no início da lista
	  //
	  public void add(int valor) {
	    Node novo;
	    novo = new Node(valor);

	    novo.next = head;
	    head = novo;

	    if (count == 0)
	      tail = novo;
	    
	    count++;
	  }

	  public void insereFim(int valor) {
	    Node novo;
	    novo = new Node(valor);

	    if (count == 0)  {
	       head = novo;
	    } else {
	         tail.next = novo;
	    }

	    tail = novo;
	    count++;

	  }

	  public void show() {
		  Node aux = head;
	    System.out.print("[ ");
	    while(aux!=null) {
	    	System.out.print(aux.element+" ");
	    	aux = aux.next;
	    }
	    System.out.print(" ]");
	  }
	  
	  public void showReverse() {
		  System.out.print("[");
		  for(int i = indexOf()+1; i>=0; i--) {
			  System.out.print(get(i)+" "); 
		  }
		  System.out.print("]");
	  }

	// insere no fim, supondo que nao tem tail

	  public void insereF(int val) {
	    Node novo = new Node(val);
	    Node aux = head;
	    if(count==0) {
	    	head=novo;
	    }else {
	    	while(aux.next!=null) {
		    	 aux=aux.next;
		     }
		     aux.next = novo;
	    }
	    count++;
	  }

	  public void add(int index , int element ) {
	     if (index <0 || index >= count) {
	        throw new InvalidParameterException("indice invalido");
	     }
	     if(index==0||count==0) {
	    	 add(element);
	     }else if(count==indexOf()||index==indexOf()) {
	    	 insereF(element);
	     }else {
	    	 Node novo = new Node(element);
		     Node aux = head;
		     for(int i = 0; i<index-1;i++) {
		    	 aux=aux.next;
		     }
		     novo.next=aux.next;
		     aux.next=novo;
		     count++;
	     }
	    }

	  public int indexOf(int valor) {
		  Node aux = head;
		  for(int i = 0; i<count;i++) {
		    	if(valor==aux.element) {
		    		return i;
		    	}
		    	aux=aux.next;
		    }
		  return -1;
	  }
	  // retorna o index do ultimo elemento
	  public int indexOf() {
		  Node aux = head;
		  for(int i = 0; i<count;i++) {
		    	if(tail.element==aux.element) {
		    		return i;
		    	}
		    	aux=aux.next;
		    }
		  return -1;
	  }
	  
	  public int get(int index) {
	     if (index <0 || index >= count) {
	         throw new InvalidParameterException("indice invalido");
	     }

	     Node aux = head;
	     for (int i = 0; i<index; i++) {
	         aux = aux.next;
	     }
	     return aux.element;



	  }

	@Override
	public int set(int index, int element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(int element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int removeByIndex(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		int cont = 0;
		for(int i = 0; i<count; i++) {
			cont++;
		}
		return cont;
	}

	@Override
	public boolean contains(int element) {
		Node aux = head;
		for(int i = 0; i<count; i++) {
			if(element==aux.element) {
				return true;
			}
			aux = aux.next;
		}
		return false;
	}

	@Override
	public void clear() {
		
	}
}
