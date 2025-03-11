import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class casoTeste131 {

    public static void main(String[] args) {

        List<Integer> receita = List.of(86, 109, 79, 126, 31, 62, 72, 54, 85, 33, 99, 123, 50, 115, 77, 10, 38, 2, 42, 119, 66,
                108, 121, 124, 93, 76, 25, 102, 70, 36, 117, 116, 113, 3, 39, 114, 7, 0, 107, 12, 51, 94,
                43, 127, 73, 28, 81, 20, 87, 63, 56, 129, 105, 5, 49, 98, 40, 34, 101, 78, 128, 17, 22, 23,
                83, 41, 9, 21, 4, 106, 60, 75, 71, 95, 91, 118, 57, 96, 74, 32, 104, 6, 47, 44, 29, 84, 89,
                16, 15, 125, 18, 52, 120, 112, 45, 30, 14, 100, 19, 80, 103, 67, 27, 13, 110, 11, 82, 37,
                65, 111, 48, 24, 69, 35, 55, 26, 90, 64, 1, 130, 88, 53, 58, 68, 8, 92, 46, 122, 59, 97, 61);
        System.out.println("Analisando ciclos para uma receita de tamanho " + receita.size());

        long inicio = System.currentTimeMillis();

        List<Map<String, Object>> resultados = analisarTodosCiclos(receita);

        Map<Integer, List<Integer>> tamanhosCiclos = new TreeMap<>();

        for (Map<String, Object> resultado : resultados) {
            int tamanho = (int) resultado.get("ciclo_completo");

            if (!tamanhosCiclos.containsKey(tamanho)) {
                tamanhosCiclos.put(tamanho, new ArrayList<>());
            }

            tamanhosCiclos.get(tamanho).add((int) resultado.get("posicao_inicial"));
        }

        List<Integer> ciclosCompletos = new ArrayList<>();
        for (Map<String, Object> resultado : resultados) {
            ciclosCompletos.add((int) resultado.get("ciclo_completo"));
        }

        String mmcCiclos;
        try {
            int mmc = calcularMMC(ciclosCompletos);
            mmcCiclos = String.valueOf(mmc);
        } catch (Exception e) {
            mmcCiclos = "Não foi possível calcular (número muito grande)";
        }

        long fim = System.currentTimeMillis();
        double tempoExecucao = (fim - inicio) / 1000.0;

        System.out.println("\nTempo de execução: " + String.format("%.6f", tempoExecucao) + " segundos");

        System.out.println("\nNúmero de iterações: " + mmcCiclos);
    }

    // Aplica a receita de dança a uma configuração
    private static Map<String, Object> aplicarReceita(List<Integer> receita, int posicaoInicial) {
        int posicaoAtual = posicaoInicial;
        int iteracao = 0;

        List<Integer> posicoes = new ArrayList<>();
        posicoes.add(posicaoInicial);

        while (true) {
            posicaoAtual = receita.get(posicaoAtual);
            iteracao += 1;
            posicoes.add(posicaoAtual);

            if (posicaoAtual == posicaoInicial) {
                break;
            }

            if (iteracao > receita.size() * 2) {
                System.out.println("Aviso: Possível ciclo infinito detectado para o número na posição " + posicaoInicial);
                break;
            }
        }

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("posicao_inicial", posicaoInicial);
        resultado.put("ciclo_completo", iteracao);
        resultado.put("caminho", posicoes);

        return resultado;
    }

    private static List<Map<String, Object>> analisarTodosCiclos(List<Integer> receita) {
        List<Map<String, Object>> resultados = new ArrayList<>();

        for (int i = 0; i < receita.size(); i++) {
            resultados.add(aplicarReceita(receita, i));
        }

        return resultados;
    }

    private static int calcularMMC(List<Integer> numeros) {
        int resultado = numeros.get(0);

        for (int i = 1; i < numeros.size(); i++) {
            resultado = mmcDoisNumeros(resultado, numeros.get(i));
        }

        return resultado;
    }

    private static int mdc(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    private static int mmcDoisNumeros(int a, int b) {
        return a * b / mdc(a, b);
    }
}