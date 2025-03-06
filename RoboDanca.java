import java.util.Arrays;

public class RoboDanca {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        int n = 7;
        int[] receita = {
            5, 6, 0, 4, 2, 3, 1
        };

        // Configuração inicial
        int[] configuracaoInicial = new int[n];
        for (int i = 0; i < n; i++) {
            configuracaoInicial[i] = i;
        }

        // Algoritmo de Floyd para detecção de ciclo
        int[] tartaruga = configuracaoInicial.clone();
        int[] lebre = configuracaoInicial.clone();
        
        // Fase 1: Encontrar um ponto de encontro
        int indice = 0;
        do {
            tartaruga = aplicarReceita(tartaruga, receita);
            lebre = aplicarReceita(lebre, receita);
            lebre = aplicarReceita(lebre, receita);
            System.out.println("Lebre: "+Arrays.toString(lebre));
            System.out.println("Tartaruga: "+Arrays.toString(tartaruga));
            indice++;
        } while (!Arrays.equals(tartaruga, lebre));
        
        
        // Pronto! O índice é o valor que queremos
        System.out.println("Configuração repetida encontrada!");
        System.out.println("Índice da primeira repetição: " + indice);


        long fim = System.nanoTime();
        long duracao = fim - inicio;
        System.out.println("Tempo de execução: " + duracao + " nanosegundos");
        System.out.println("Tempo de execução aproximado: " + (duracao / 1_000_000.0) + " milissegundos");
    }

    // Aplica a receita de dança a uma configuração
    private static int[] aplicarReceita(int[] configuracao, int[] receita) {
        int[] novaConfiguracao = new int[configuracao.length];
        for (int i = 0; i < configuracao.length; i++) {
            novaConfiguracao[i] = configuracao[receita[i]];
        }
        return novaConfiguracao;
    }
}