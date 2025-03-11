import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class casoTeste191 {

    public static void main(String[] args) {

        List<Integer> receita = List.of(190, 151, 189, 31, 129, 101, 121, 118, 66, 183, 145, 99, 49, 153, 71, 43, 67, 44, 177, 15, 1, 75, 69, 82, 45, 37, 42, 150, 38, 135, 27, 4, 78, 11, 8, 65, 173, 33, 174, 168, 79, 172, 157, 170, 83, 21, 111, 34, 102, 20, 70, 137, 103, 161, 127, 119, 5, 24, 114, 125, 48, 122, 85, 160, 72, 58, 109, 106, 81, 184, 52, 156, 110, 152, 88, 108, 126, 113, 91, 63, 51, 120, 154, 143, 57, 140, 181, 90, 182, 158, 86, 29, 3, 16, 54, 171, 12, 149, 128, 25, 40, 32, 188, 167, 17, 39, 166, 116, 186, 117, 133, 179, 155, 0, 148, 105, 59, 87, 123, 28, 23, 89, 104, 165, 180, 22, 178, 26, 175, 56, 2, 139, 19, 46, 107, 92, 147, 96, 76, 55, 47, 130, 6, 35, 134, 7, 95, 141, 136, 13, 98, 10, 53, 77, 80, 185, 132, 100, 14, 61, 94, 115, 187, 93, 144, 84, 9, 36, 138, 64, 162, 30, 169, 176, 50, 164, 97, 18, 159, 62, 60, 41, 124, 74, 146, 142, 68, 131, 163, 73, 112);
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