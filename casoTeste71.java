import java.util.Arrays;

public class casoTeste71 {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        int n = 71;
        int[] receita = {
            58, 20, 65, 9, 25, 63, 53, 12, 55, 52, 14, 27, 54, 48, 17, 56, 21, 70, 22, 36, 43, 67, 37, 7, 40, 62, 3, 47, 32, 44, 26, 45, 33, 8, 39, 24, 50, 49, 60, 34, 0, 19, 29, 28, 64, 1, 31, 16, 41, 6, 46, 5, 51, 10, 38, 13, 68, 2, 35, 4, 15, 18, 11, 61, 23, 30, 57, 69, 42, 59, 66
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