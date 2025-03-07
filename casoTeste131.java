import java.util.Arrays;

public class casoTeste131 {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        int n = 131;
        int[] receita = {
            86, 109, 79, 126, 31, 62, 72, 54, 85, 33, 99, 123, 50, 115, 77, 10, 38, 2, 42, 119, 66, 108, 121, 124, 93, 76, 25, 102, 70, 36, 117, 116, 113, 3, 39, 114, 7, 0, 107, 12, 51, 94, 43, 127, 73, 28, 81, 20, 87, 63, 56, 129, 105, 5, 49, 98, 40, 34, 101, 78, 128, 17, 22, 23, 83, 41, 9, 21, 4, 106, 60, 75, 71, 95, 91, 118, 57, 96, 74, 32, 104, 6, 47, 44, 29, 84, 89, 16, 15, 125, 18, 52, 120, 112, 45, 30, 14, 100, 19, 80, 103, 67, 27, 13, 110, 11, 82, 37, 65, 111, 48, 24, 69, 35, 55, 26, 90, 64, 1, 130, 88, 53, 58, 68, 8, 92, 46, 122, 59, 97, 61
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