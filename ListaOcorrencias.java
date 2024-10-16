package trabalho2;

public class ListaOcorrencias {
	// Classe interna Node
    private class Node {
        public int numeroDaPagina;
        public Node next;    
        public Node(int n) {
            numeroDaPagina = n;
            next = null;
        }
    }
    
    // Atributos
    private Node head;
    private Node tail;
    private int count;

    // Metodos 
    public ListaOcorrencias() {
        head = null;
        tail = null;
        count = 0;
    }
    
    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return (head == null);
    }   
    
    /**
     * Retorna o numero de elementos da lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }  
    
    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Adiciona um numero de pagina ao final da lista, caso ele ainda
     * nao tenha sido adicionado.
     * @param numPagina número da página a ser adicionado ao final da lista
     * @return true se adicionou no final da lista o numero de pagina  
     * recebido por parametro, e false caso contrario.
     */
    public boolean add(int numPagina)  {
    	Node novo = new Node(numPagina);
    	if(count==0) {
    		head = novo;
    		tail = novo;
    	}else {
    		tail.next = novo;
    	}
    	tail = novo;
    	count++;
    	return true;
    }  
    
    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */    
    public Integer get(int index) {
    	if(index < 0 || index >= size()) {
    		throw new IndexOutOfBoundsException("Elemento não encontrado!");
    	}
    	Node aux = head;
    	for(int i = 0; i<index; i++) {
    		aux = aux.next;
    	}
    	return aux.numeroDaPagina;
    }
 
    /**
     * Retorna true se a lista contem o numero de pagina passado
     * por parametro.
     * @param numPagina o elemento a ser procurado
     * @return true se a lista contem o elemento especificado
     */
    public boolean contains(int numPagina) {
    	Node aux = head;
    	for(int i = 0; i<count; i++) {
    		if(numPagina==aux.numeroDaPagina) {
    			return true;
    		}
    		aux = aux.next;
    	}
        return false;
    }    
    
    @Override
    public String toString() {
    	Node aux = head;
    	String lin = "[ ";
    	while(aux!=null) {
    		lin += aux.numeroDaPagina+" ";
    		aux = aux.next;
    	}
    	lin += "]";
        return lin;
    }
}
