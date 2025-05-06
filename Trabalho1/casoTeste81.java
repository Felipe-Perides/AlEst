import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class casoTeste81 {

    public static void main(String[] args) {

        List<Integer> receita = List.of(55, 9, 42, 8, 21, 79, 34, 67, 31, 15, 43, 37, 63, 73, 40, 16, 72, 25, 80, 51, 3, 12, 30, 20, 60, 62, 78, 19, 6, 14, 57, 45, 48, 58, 52, 44, 28, 11, 36, 61, 54, 2, 50, 5, 71, 77, 0, 64, 1, 18, 39, 46, 23, 65, 56, 74, 53, 22, 7, 41, 47, 59, 27, 69, 38, 35, 70, 76, 32, 4, 68, 13, 75, 10, 33, 66, 26, 24, 29, 49, 17);
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