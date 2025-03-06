import java.util.Arrays;

public class casoTeste111 {
    public static void main(String[] args) {
        long inicio = System.nanoTime();

        int n = 111;
        int[] receita = {
            21, 86, 81, 80, 25, 64, 61, 101, 50, 94, 54, 91, 16, 7, 88, 109, 44, 32, 55, 9, 38, 41, 77, 2, 47, 53, 36, 104, 85, 11, 99, 42, 60, 14, 51, 24, 75, 17, 92, 48, 105, 67, 110, 15, 69, 71, 95, 33, 72, 6, 100, 82, 79, 102, 106, 66, 43, 22, 103, 27, 56, 59, 31, 12, 4, 96, 34, 89, 35, 87, 39, 76, 49, 57, 3, 84, 10, 108, 37, 18, 90, 58, 45, 62, 19, 26, 68, 28, 5, 0, 8, 63, 1, 65, 93, 46, 70, 107, 83, 78, 74, 97, 13, 52, 29, 73, 23, 20, 98, 30, 40
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