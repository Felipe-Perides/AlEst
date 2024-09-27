package t2;

public class LinkedListOfString {
    // Classe interna Node
    private class Node {
        public String element;
        public Node next;
        public Node prev;
        public Node(String element) {
            this.element = element;
            next = null;
        }
    }

    // Referência para o primeiro elemento da lista encadeada.
    private Node header;
    // Referência para o último elemento da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente.
    private Node current;      
    // Contador para a quantidade de elementos que a lista contem.
    private int count;

    
    /**
     * Construtor da lista.
     */
    public LinkedListOfString() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }
    
    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
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
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }    

    /**
     * Adiciona um elemento mantendo a lista ordenada.
     * @param element elemento a ser adicionado ao arquivo
     */
    public void orderedAdd (String element)  { 
        // aqui tens de fazer, não está inserindo ordenada
        Node n = new Node(element);
        
        n.prev = header;
        n.next = header.next;
        header.next.prev = n;
        header.next = n;


        count++;

    }
    
    /**
     * AVerifica se um elemento pertence a lista
     * @param element elemento a ser pesquisado
     */
    private Node containsElement(String element) {
        Node aux = header.next;
        
        while (aux != trailer) {
            if (aux.element.equals(element)) {
                return aux;
            }
            aux = aux.next;
        }
        
        return null;
    }    
    
    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public String get(int index) { 
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.element;
    }
    
    // Metodo que tem como objetivo retornar uma referencia
    // para o nodo da posicao "index" recebida como parametro.
    // Por exemplo, se index for 2, ele retorna a referencia
    // para o nodo da posicao 2.
    private Node getNodeIndex(int index) {
        Node aux = null;
        if (index < count/2) { // caminha do inicio para o meio
            aux = header.next;
            for(int i=0; i<index; i++)
                aux = aux.next;
        }
        else { // caminha do fim para o meio
            aux = trailer.prev;
            for(int i=count-1; i>index; i--)
                aux = aux.prev;
        }
        return aux;
    }
    
    /**
     * Inicializa o current na primeira posicao (para percorrer do inicio para o fim).
     */
    public void reset() {
        current = header.next;
    }

    /**
     * Retorna o elemento da posicao corrente e faz current apontar para o proximo
     * elemento da lista.
     * @return elemento da posicao corrente
     */
    public String next() {
        if (current != trailer) {
            String str = current.element;
            current = current.next;
            return str;
        }
        return null;
    }         
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element);
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }    
    

}