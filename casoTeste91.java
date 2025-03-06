import java.util.Arrays;

public class casoTeste91 {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        int n = 91;
        int[] receita = {
            62, 15, 81, 41, 84, 75, 50, 87, 24, 0, 37, 56, 48, 72, 73, 8, 34, 53, 64, 90, 12, 66, 13, 80, 71, 89, 6, 61, 55, 47, 63, 36, 33, 85, 11, 18, 51, 40, 29, 67, 7, 38, 82, 52, 10, 77, 1, 14, 28, 57, 78, 42, 2, 45, 70, 9, 27, 4, 60, 16, 17, 76, 30, 79, 35, 59, 31, 44, 69, 32, 39, 83, 49, 3, 54, 21, 88, 25, 22, 86, 46, 23, 65, 43, 26, 68, 5, 58, 20, 74, 19
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