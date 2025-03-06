import java.util.Arrays;

public class casoTeste101 {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        int n = 101;
        int[] receita = {
            48, 80, 39, 23, 90, 69, 56, 42, 38, 87, 65, 79, 4, 10, 61, 77, 8, 1, 89, 6, 50, 71, 63, 53, 72, 28, 12, 76, 73, 43, 74, 91, 95, 94, 78, 88, 37, 83, 64, 35, 21, 66, 24, 86, 9, 67, 7, 93, 47, 92, 33, 81, 31, 36, 17, 32, 52, 55, 85, 40, 57, 75, 20, 59, 22, 18, 46, 45, 13, 16, 51, 97, 29, 44, 58, 98, 34, 82, 96, 15, 19, 70, 30, 100, 0, 2, 3, 5, 11, 60, 99, 62, 27, 14, 84, 68, 49, 25, 26, 54, 41
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