import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class casoTeste181 {

    public static void main(String[] args) {

        List<Integer> receita = List.of(73, 57, 125, 106, 109, 169, 66, 37, 124, 118, 67, 102, 94, 133, 81, 134, 5, 10, 60, 113, 122, 137, 123, 138, 38, 148, 143, 30, 128, 77, 168, 139, 44, 24, 69, 36, 166, 127, 126, 1, 141, 83, 15, 55, 135, 132, 87, 19, 177, 71, 18, 157, 117, 4, 45, 70, 40, 89, 114, 163, 78, 21, 107, 22, 119, 108, 172, 92, 86, 99, 105, 65, 167, 20, 7, 53, 156, 101, 56, 68, 155, 164, 26, 111, 178, 176, 95, 158, 150, 96, 145, 173, 97, 98, 42, 61, 121, 76, 74, 146, 3, 2, 115, 50, 8, 35, 49, 149, 171, 29, 41, 17, 59, 11, 130, 28, 79, 85, 116, 23, 6, 12, 129, 47, 52, 51, 104, 142, 93, 64, 162, 159, 153, 175, 147, 72, 90, 112, 151, 48, 179, 27, 43, 13, 180, 75, 103, 63, 136, 152, 88, 174, 160, 58, 144, 32, 161, 16, 91, 110, 62, 46, 25, 165, 9, 14, 39, 80, 100, 84, 154, 34, 82, 120, 0, 131, 170, 33, 140, 54, 31);
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