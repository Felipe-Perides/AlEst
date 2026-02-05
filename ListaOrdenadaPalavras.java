package trabalho2;

public class ListaOrdenadaPalavras {
    // Classe interna
    private class Palavra {
        public String s;
        public ListaOcorrencias listaOcorrencias;
        public Palavra next;
        public Palavra prev;

        public Palavra(String str) {
            s = str;
            next = null;
            prev = null;
            listaOcorrencias = new ListaOcorrencias();
        }
    }

    // Classe interna para armazenar as ocorrências
    private class ListaOcorrencias {
        private class Nodo {
            public int pagina;
            public int contagem;
            public Nodo next;

            public Nodo(int pagina) {
                this.pagina = pagina;
                this.contagem = 1;
                this.next = null;
            }
        }

        private Nodo head;

        public ListaOcorrencias() {
            head = null;
        }

        public void add(int pagina) {
            Nodo current = head;
            Nodo prev = null;

            while (current != null) {
                if (current.pagina == pagina) {
                    current.contagem++;
                    return;
                }
                prev = current;
                current = current.next;
            }

            Nodo novo = new Nodo(pagina);
            if (prev == null) {
                head = novo;
            } else {
                prev.next = novo;
            }
        }

        public int getCount() {
            int total = 0;
            Nodo current = head;
            while (current != null) {
                total += current.contagem;
                current = current.next;
            }
            return total;
        }

        public void printOcorrencias() {
            Nodo current = head;
            while (current != null) {
                System.out.print("("+current.pagina + ", f:" + current.contagem + ") ");
                current = current.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Nodo current = head;
            while (current != null) {
                sb.append(current.pagina).append(" (").append(current.contagem).append(" vezes) ");
                current = current.next;
            }
            return sb.toString();
        }
    }

    // Atributos
    private Palavra head;
    private Palavra tail;
    private int count;

    // Métodos
    public ListaOrdenadaPalavras() {
        head = null;
        tail = null;
        count = 0;
    }

    public void addPalavra(String str, int pagina) {
        Palavra existingPalavra = getPalavra(str);
        if (existingPalavra != null) {
            existingPalavra.listaOcorrencias.add(pagina);
        } else {
            Palavra newPalavra = new Palavra(str);
            if (head == null) { // Lista vazia
                head = newPalavra;
                tail = newPalavra;
            } else if (head.s.compareTo(str) > 0) { // Inserir no início
                newPalavra.next = head;
                head.prev = newPalavra;
                head = newPalavra;
            } else if (tail.s.compareTo(str) < 0) { // Inserir no final
                newPalavra.prev = tail;
                tail.next = newPalavra;
                tail = newPalavra;
            } else { // Inserir no meio
                Palavra current = head;
                while (current.next != null && current.next.s.compareTo(str) < 0) {
                    current = current.next;
                }
                newPalavra.next = current.next;
                if (current.next != null) {
                    current.next.prev = newPalavra;
                }
                newPalavra.prev = current;
                current.next = newPalavra;
            }
            newPalavra.listaOcorrencias.add(pagina);
            count++;
        }
    }

    public Palavra getPalavra(String str) {
        Palavra current = head;
        while (current != null) {
            if (current.s.equals(str)) {
                return current;
            }
            current = current.next;
        }
        return null; // Retornar null se a palavra não for encontrada
    }

    // Método para exibir detalhes sobre uma palavra específica
    public void displayPalavra(String str) {
        Palavra p = getPalavra(str);
        if (p != null) {
            int numOcorrencias = p.listaOcorrencias.getCount();
            System.out.print("A palavra '" + p.s + "' aparece " + numOcorrencias + " vezes nas páginas: ");
            p.listaOcorrencias.printOcorrencias();
            System.out.println();
        } else {
            System.out.println("A palavra '" + str + "' não foi encontrada.");
        }
    }
}
