import java.util.Arrays;

public class casoTeste121 {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        int n = 121;
        int[] receita = {
            59, 23, 78, 15, 68, 101, 69, 1, 13, 8, 4, 61, 42, 47, 12, 43, 31, 28, 21, 35, 22, 11, 96, 104, 111, 5, 81, 58, 73, 107, 63, 20, 71, 52, 105, 120, 79, 64, 18, 87, 117, 37, 29, 50, 99, 119, 0, 26, 93, 45, 84, 10, 3, 85, 116, 77, 24, 118, 44, 94, 53, 80, 82, 102, 32, 100, 67, 95, 112, 60, 110, 46, 27, 6, 106, 76, 72, 16, 86, 30, 55, 108, 36, 90, 33, 66, 114, 91, 103, 56, 7, 92, 41, 88, 109, 51, 98, 62, 97, 54, 49, 113, 115, 75, 65, 89, 40, 17, 74, 19, 39, 83, 25, 2, 14, 38, 48, 9, 57, 34, 70
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