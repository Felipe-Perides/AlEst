package pilhas_filas;

public class App {
	public static void main(String[] args) {
        // Cria uma fila
        // QueueTAD fila = new QueueArray();
        QueueTAD lFila = new QueueLinked();
        QueueTAD aFila = new QueueArray();
        
        StackTAD lPilha = new StackLinked();
        StackTAD aPilha = new StackArray();
        // Insere alguns números
        lFila.enqueue(0);
        lFila.enqueue(2);
        lFila.enqueue(4);
        lFila.enqueue(6);
        lFila.enqueue(8);
        lFila.enqueue(10);
        
        aFila.enqueue(1);
        aFila.enqueue(3);
        aFila.enqueue(5);
        aFila.enqueue(7);
        aFila.enqueue(9);
        
        lPilha.push(0);
        lPilha.push(2);
        lPilha.push(4);
        lPilha.push(6);
        lPilha.push(8);
        lPilha.push(10);
        
        aPilha.push(1);
        aPilha.push(3);
        aPilha.push(5);
        aPilha.push(7);
        aPilha.push(9);
        // Remove e vai mostrando na tela
        // até ficar vazia
        while (!lFila.isEmpty()) {
            System.out.println("Linked Fila: "+lFila);
            System.out.println("Elemento retirado: "+lFila.dequeue());
        }
        System.out.println();
        while(!aFila.isEmpty()) {
        	System.out.println("Array Fila: "+aFila);
            System.out.println("Elemento retirado: "+aFila.dequeue());
        }
        System.out.println();
        while(!aPilha.isEmpty()) {
        	System.out.println("Array Pilha: "+aPilha);
        	System.out.println("Elemento retirado: "+aPilha.pop());
        }
        System.out.println();
        while(!lPilha.isEmpty()) {
        	System.out.println("Linked Pilha: "+lPilha);
        	System.out.println("Elemento retirado: "+lPilha.pop());
        }
    }
}
