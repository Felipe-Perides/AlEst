import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class casoTeste121 {

    public static void main(String[] args) {

        List<Integer> receita = List.of(59, 23, 78, 15, 68, 101, 69, 1, 13, 8, 4, 61, 42, 47, 12, 43, 31, 28, 21, 35, 22, 11, 96, 104, 111, 5, 81, 58, 73, 107, 63, 20, 71, 52, 105, 120, 79, 64, 18, 87, 117, 37, 29, 50, 99, 119, 0, 26, 93, 45, 84, 10, 3, 85, 116, 77, 24, 118, 44, 94, 53, 80, 82, 102, 32, 100, 67, 95, 112, 60, 110, 46, 27, 6, 106, 76, 72, 16, 86, 30, 55, 108, 36, 90, 33, 66, 114, 91, 103, 56, 7, 92, 41, 88, 109, 51, 98, 62, 97, 54, 49, 113, 115, 75, 65, 89, 40, 17, 74, 19, 39, 83, 25, 2, 14, 38, 48, 9, 57, 34, 70);
        System.out.println("Analisando ciclos para uma receita de tamanho " + receita.size());

        long inicio = System.currentTimeMillis();

        List<Map<String, Object>> resultados = analisarTodosCiclos(receita);

        Map<Long, List<Long>> tamanhosCiclos = new TreeMap<>();

        for (Map<String, Object> resultado : resultados) {
            long tamanho = ((Number) resultado.get("ciclo_completo")).longValue();

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

        List<Integer> posicoes = new ArrayList<>();
        posicoes.add(posicaoInicial);

        Set<Integer> visitados = new HashSet<>();

    while (true) {
        if (!visitados.add(posicaoAtual)) { // Se já foi visitado, temos um ciclo
            System.out.println("Aviso: Ciclo detectado para o número na posição " + posicaoInicial);
            break;
        }

        posicaoAtual = receita.get(posicaoAtual);
        iteracao++;
        posicoes.add(posicaoAtual);

        if (posicaoAtual == posicaoInicial) {
            break;
        }

        if (iteracao > receita.size()) { // Reduzi o limite de iterações
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