package t2;

public class ListaOrdenadaPalavras {

    // Classe interna 
    private class Palavra {
        public String s;
        public ListaDeOcorrencias listaOcorrencias;
        public Palavra next;    
        public Palavra(String str) {
            s = str;
            next = null;
            listaOcorrencias = new ListaDeOcorrencias();
        }
        
        // Metodos

    }
    
    // Atributos
    
    // Metodos

}