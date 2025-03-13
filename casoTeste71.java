import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class casoTeste71 {

    public static void main(String[] args) {

        List<Integer> receita = List.of(58, 20, 65, 9, 25, 63, 53, 12, 55, 52, 14, 27, 54, 48, 17, 56, 21, 70, 22, 36, 43, 67, 37, 7, 40, 62, 3, 47, 32, 44, 26, 45, 33, 8, 39, 24, 50, 49, 60, 34, 0, 19, 29, 28, 64, 1, 31, 16, 41, 6, 46, 5, 51, 10, 38, 13, 68, 2, 35, 4, 15, 18, 11, 61, 23, 30, 57, 69, 42, 59, 66);
        System.out.println("Analisando ciclos para uma receita de tamanho " + receita.size());

        long inicio = System.currentTimeMillis();

        List<Map<String, Object>> resultados = analisarTodosCiclos(receita);

        Map<Long, List<Long>> tamanhosCiclos = new TreeMap<>();

        for (Map<String, Object> resultado : resultados) {
            long tamanho = (long) resultado.get("ciclo_completo");

            if (!tamanhosCiclos.containsKey(tamanho)) {
                tamanhosCiclos.put(tamanho, new ArrayList<>());
            }

            tamanhosCiclos.get(tamanho).add(((Number) resultado.get("posicao_inicial")).longValue());

        }

        List<Long> ciclosCompletos = new ArrayList<>();
        for (Map<String, Object> resultado : resultados) {
            ciclosCompletos.add((long) resultado.get("ciclo_completo"));
        }

        String mmcCiclos;
        try {
            long mmc = calcularMMC(ciclosCompletos);
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
        long iteracao = 0;

        Set<Integer> posicoes = new HashSet<>();
        posicoes.add(posicaoInicial);

        while (true) {
            posicaoAtual = receita.get(posicaoAtual);
            iteracao ++;

            // Se a posição já foi visitada, parar imediatamente
            if (posicoes.contains(posicaoAtual)) {
                break;
            }

            posicoes.add(posicaoAtual);

            if (iteracao > receita.size() * 2) {
                System.out.println("Aviso: Possível ciclo infinito detectado para o número na posição " + posicaoInicial);
                break;
            }
        }

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("posicao_inicial", posicaoInicial);
        resultado.put("ciclo_completo", iteracao);
        resultado.put("posição repetida", posicaoAtual);

        return resultado;
    }

    private static List<Map<String, Object>> analisarTodosCiclos(List<Integer> receita) {
        List<Map<String, Object>> resultados = new ArrayList<>();

        for (int i = 0; i < receita.size(); i++) {
            resultados.add(aplicarReceita(receita, i));
        }

        return resultados;
    }

    private static long calcularMMC(List<Long> numeros) {
        long resultado = numeros.get(0);

        for (int i = 1; i < numeros.size(); i++) {
            resultado = mmcDoisNumeros(resultado, numeros.get(i));
        }

        return resultado;
    }

    private static long mdc(long a, long b) {
        while (b != 0) {
            long temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    private static long mmcDoisNumeros(long a, long b) {
        return a * b / mdc(a, b);
    }
}