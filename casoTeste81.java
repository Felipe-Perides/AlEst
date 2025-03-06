import java.util.Arrays;

public class casoTeste81 {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        int n = 81;
        int[] receita = {
            55, 9, 42, 8, 21, 79, 34, 67, 31, 15, 43, 37, 63, 73, 40, 16, 72, 25, 80, 51, 3, 12, 30, 20, 60, 62, 78, 19, 6, 14, 57, 45, 48, 58, 52, 44, 28, 11, 36, 61, 54, 2, 50, 55, 71, 77, 0, 64, 1, 18, 39, 46, 23, 65, 56, 74, 53, 22, 7, 41, 47, 59, 27, 69, 38, 35, 70, 76, 32, 4, 68, 13, 75, 10, 33, 66, 26, 24, 29, 49, 17
        };

        // Configuração inicial
        int[] configuracaoInicial = new int[n];
        for (int i = 0; i < n; i++) {
            configuracaoInicial[i] = i;
        }

        // Algoritmo de Floyd para detecção de ciclo
        int[] tartaruga = configuracaoInicial.clone();
        int[] lebre = configuracaoInicial.clone();
        
        int indice = 0;
        do {
            tartaruga = aplicarReceita(tartaruga, receita);
            lebre = aplicarReceita(lebre, receita);
            lebre = aplicarReceita(lebre, receita);
            indice++;
        } while (!Arrays.equals(tartaruga, lebre));
        
        // Pronto! O índice é o valor que queremos
        System.out.println("Configuração repetida encontrada!");
        System.out.println("Configuração: "+Arrays.toString(lebre));
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