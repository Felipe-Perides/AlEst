import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        List<Integer> receita = null;
        String option;
        boolean state = false;

        do{
            System.out.println("Escolha qual receita você deseja analisar:");
            System.out.print("As opções são: 71, 81, 91, 101, 111, 121, 131, 141, 151, 161, 171, 181, 191\n");
            option = input.nextLine();
            switch (option) {
                case "71":
                    receita = List.of(58, 20, 65, 9, 25, 63, 53, 12, 55, 52, 14, 27, 54, 48, 17, 56, 21, 70, 22, 36, 43, 67, 37, 7, 40, 62, 3, 47, 32, 44, 26, 45, 33, 8, 39, 24, 50, 49, 60, 34, 0, 19, 29, 28, 64, 1, 31, 16, 41, 6, 46, 5, 51, 10, 38, 13, 68, 2, 35, 4, 15, 18, 11, 61, 23, 30, 57, 69, 42, 59, 66);
                    state = true;
                    break;
                case "81":
                    receita = List.of(55, 9, 42, 8, 21, 79, 34, 67, 31, 15, 43, 37, 63, 73, 40, 16, 72, 25, 80, 51, 3, 12, 30, 20, 60, 62, 78, 19, 6, 14, 57, 45, 48, 58, 52, 44, 28, 11, 36, 61, 54, 2, 50, 5, 71, 77, 0, 64, 1, 18, 39, 46, 23, 65, 56, 74, 53, 22, 7, 41, 47, 59, 27, 69, 38, 35, 70, 76, 32, 4, 68, 13, 75, 10, 33, 66, 26, 24, 29, 49, 17);
                    state = true;
                    break;
                case "91":
                    receita = List.of(62, 15, 81, 41, 84, 75, 50, 87, 24, 0, 37, 56, 48, 72, 73, 8, 34, 53, 64, 90, 12, 66, 13, 80, 71, 89, 6, 61, 55, 47, 63, 36, 33, 85, 11, 18, 51, 40, 29, 67, 7, 38, 82, 52, 10, 77, 1, 14, 28, 57, 78, 42, 2, 45, 70, 9, 27, 4, 60, 16, 17, 76, 30, 79, 35, 59, 31, 44, 69, 32, 39, 83, 49, 3, 54, 21, 88, 25, 22, 86, 46, 23, 65, 43, 26, 68, 5, 58, 20, 74, 19);
                    state = true;
                    break;
                case "101":
                    receita = List.of(48, 80, 39, 23, 90, 69, 56, 42, 38, 87, 65, 79, 4, 10, 61, 77, 8, 1, 89, 6, 50, 71, 63, 53, 72, 28, 12, 76, 73, 43, 74, 91, 95, 94, 78, 88, 37, 83, 64, 35, 21, 66, 24, 86, 9, 67, 7, 93, 47, 92, 33, 81, 31, 36, 17, 32, 52, 55, 85, 40, 57, 75, 20, 59, 22, 18, 46, 45, 13, 16, 51, 97, 29, 44, 58, 98, 34, 82, 96, 15, 19, 70, 30, 100, 0, 2, 3, 5, 11, 60, 99, 62, 27, 14, 84, 68, 49, 25, 26, 54, 41);
                    state = true;
                    break;
                case "111":
                    receita = List.of(21, 86, 81, 80, 25, 64, 61, 101, 50, 94, 54, 91, 16, 7, 88, 109, 44, 32, 55, 9, 38, 41, 77, 2, 47, 53, 36, 104, 85, 11, 99, 42, 60, 14, 51, 24, 75, 17, 92, 48, 105, 67, 110, 15, 69, 71, 95, 33, 72, 6, 100, 82, 79, 102, 106, 66, 43, 22, 103, 27, 56, 59, 31, 12, 4, 96, 34, 89, 35, 87, 39, 76, 49, 57, 3, 84, 10, 108, 37, 18, 90, 58, 45, 62, 19, 26, 68, 28, 5, 0, 8, 63, 1, 65, 93, 46, 70, 107, 83, 78, 74, 97, 13, 52, 29, 73, 23, 20, 98, 30, 40);
                    state = true;
                    break;
                case "121":
                    receita = List.of(59, 23, 78, 15, 68, 101, 69, 1, 13, 8, 4, 61, 42, 47, 12, 43, 31, 28, 21, 35, 22, 11, 96, 104, 111, 5, 81, 58, 73, 107, 63, 20, 71, 52, 105, 120, 79, 64, 18, 87, 117, 37, 29, 50, 99, 119, 0, 26, 93, 45, 84, 10, 3, 85, 116, 77, 24, 118, 44, 94, 53, 80, 82, 102, 32, 100, 67, 95, 112, 60, 110, 46, 27, 6, 106, 76, 72, 16, 86, 30, 55, 108, 36, 90, 33, 66, 114, 91, 103, 56, 7, 92, 41, 88, 109, 51, 98, 62, 97, 54, 49, 113, 115, 75, 65, 89, 40, 17, 74, 19, 39, 83, 25, 2, 14, 38, 48, 9, 57, 34, 70);
                    state = true;
                    break;
                case "131":
                    receita = List.of(86, 109, 79, 126, 31, 62, 72, 54, 85, 33, 99, 123, 50, 115, 77, 10, 38, 2, 42, 119, 66, 108, 121, 124, 93, 76, 25, 102, 70, 36, 117, 116, 113, 3, 39, 114, 7, 0, 107, 12, 51, 94,43, 127, 73, 28, 81, 20, 87, 63, 56, 129, 105, 5, 49, 98, 40, 34, 101, 78, 128, 17, 22, 23, 83, 41, 9, 21, 4, 106, 60, 75, 71, 95, 91, 118, 57, 96, 74, 32, 104, 6, 47, 44, 29, 84, 89, 16, 15, 125, 18, 52, 120, 112, 45, 30, 14, 100, 19, 80, 103, 67, 27, 13, 110, 11, 82, 37, 65, 111, 48, 24, 69, 35, 55, 26, 90, 64, 1, 130, 88, 53, 58, 68, 8, 92, 46, 122, 59, 97, 61);
                    state = true;
                    break;
                case "141":
                    receita = List.of(9, 110, 95, 46, 61, 12, 27, 135, 89, 11, 17, 56, 123, 69, 3, 52, 79, 31, 47, 105, 28, 40, 75, 134, 133, 39, 88, 116, 120, 49, 33, 67, 57, 76, 53, 111, 14, 20, 81, 136, 18, 108, 92, 129, 90, 106, 63, 127, 1, 131, 114, 85, 112, 13, 83, 25, 62, 32, 66, 43, 48, 101, 109, 37, 15, 71, 41, 139, 7, 54, 2, 45, 115, 97, 80, 42, 93, 78, 100, 140, 137, 126, 102, 70, 121, 5, 73, 84, 58, 99, 0, 50, 82, 29, 44, 24, 74, 98, 64, 51, 94, 22, 65, 122, 107, 59, 36, 119, 132, 96, 103, 10, 87, 118, 23, 4, 21, 77, 128, 124, 138, 16, 117, 91, 130, 113, 26, 19, 72, 6, 104, 30, 86, 34, 55, 68, 8, 60, 125, 38, 35);
                    state = true;
                    break;
                case "151":
                    receita = List.of(140, 27, 141, 146, 25, 32, 67, 109, 63, 126, 80, 33, 35, 91, 93, 39, 135, 47, 95, 88, 21, 8, 103, 110, 42, 104, 139, 16, 131, 36, 52, 107, 70, 89, 2, 98, 19, 132, 66, 87, 100, 85, 147, 14, 45, 92, 6, 31, 54, 113, 97, 102, 138, 117, 53, 26, 127, 129, 15, 22, 58, 24, 72, 148, 118, 115, 38, 144, 61, 133, 68, 73, 43, 96, 122, 40, 30, 1, 123, 94, 84, 65, 11, 130, 44, 17, 48, 116, 82, 101, 108, 134, 142, 62, 9, 69, 76, 71, 112, 51, 34, 4, 7, 149, 5, 23, 29, 78, 86, 137, 60, 56, 81, 28, 57, 0, 99, 121, 145, 79, 46, 18, 106, 119, 75, 136, 41, 90, 12, 120, 50, 124, 128, 37, 20, 111, 49, 143, 83, 55, 59, 3, 10, 64, 13, 105, 114, 74, 125, 150, 77);
                    state = true;
                    break;
                case "161":
                    receita = List.of(12, 43, 117, 93, 91, 22, 124, 84, 49, 132, 2, 138, 57, 42, 104, 64, 48, 51, 10, 128, 94, 85, 41, 136, 158, 147, 65, 88, 63, 98, 131, 118, 16, 156, 114, 107, 149, 58, 59, 153, 108, 152, 140, 89, 77, 4, 72, 80, 150, 73, 75, 96, 69, 70, 159, 38, 3, 26, 95, 146, 92, 71, 5, 115, 126, 68, 123, 19, 27, 151, 135, 47, 97, 78, 113, 141, 134, 99, 7, 14, 46, 119, 129, 139, 143, 17, 105, 35, 25, 53, 116, 56, 79, 81, 40, 120, 0, 8, 102, 111, 50, 106, 83, 66, 67, 122, 109, 60, 145, 121, 29, 33, 13, 45, 32, 39, 110, 160, 31, 24, 52, 37, 21, 157, 154, 55, 15, 62, 87, 61, 82, 23, 11, 155, 100, 144, 90, 6, 112, 130, 20, 125, 36, 142, 1, 9, 44, 54, 34, 28, 137, 127, 101, 30, 74, 76, 133, 18, 148, 103, 86);
                    state = true;
                    break;
                case "171":
                    receita = List.of(145, 99, 125, 27, 101, 161, 124, 33, 89, 17, 20, 42, 146, 54, 40, 84, 113, 50, 151, 169, 10, 9, 76, 7, 140, 21, 144, 59, 47, 8, 96, 41, 36, 88, 43, 71, 39, 116, 166, 92, 110, 15, 119, 19, 93, 143, 62, 78, 127, 112, 120, 149, 79, 38, 98, 128, 142, 30, 49, 48, 135, 74, 109, 141, 102, 4, 138, 46, 115, 97, 100, 111, 6, 60, 152, 130, 32, 80, 139, 126, 1, 132, 12, 25, 129, 159, 72, 114, 56, 170, 28, 11, 121, 75, 66, 86, 157, 31, 117, 44, 2, 133, 104, 108, 55, 58, 13, 154, 87, 52, 61, 118, 77, 57, 22, 156, 164, 160, 69, 82, 167, 103, 123, 158, 105, 150, 63, 94, 90, 18, 3, 14, 134, 153, 35, 85, 165, 45, 34, 91, 131, 0, 147, 16, 51, 107, 64, 26, 162, 122, 148, 136, 29, 68, 37, 81, 53, 106, 83, 73, 67, 168, 70, 5, 137, 155, 23, 163, 65, 95, 24);
                    state = true;
                    break;
                case "181":
                    receita = List.of(73, 57, 125, 106, 109, 169, 66, 37, 124, 118, 67, 102, 94, 133, 81, 134, 5, 10, 60, 113, 122, 137, 123, 138, 38, 148, 143, 30, 128, 77, 168, 139, 44, 24, 69, 36, 166, 127, 126, 1, 141, 83, 15, 55, 135, 132, 87, 19, 177, 71, 18, 157, 117, 4, 45, 70, 40, 89, 114, 163, 78, 21, 107, 22, 119, 108, 172, 92, 86, 99, 105, 65, 167, 20, 7, 53, 156, 101, 56, 68, 155, 164, 26, 111, 178, 176, 95, 158, 150, 96, 145, 173, 97, 98, 42, 61, 121, 76, 74, 146, 3, 2, 115, 50, 8, 35, 49, 149, 171, 29, 41, 17, 59, 11, 130, 28, 79, 85, 116, 23, 6, 12, 129, 47, 52, 51, 104, 142, 93, 64, 162, 159, 153, 175, 147, 72, 90, 112, 151, 48, 179, 27, 43, 13, 180, 75, 103, 63, 136, 152, 88, 174, 160, 58, 144, 32, 161, 16, 91, 110, 62, 46, 25, 165, 9, 14, 39, 80, 100, 84, 154, 34, 82, 120, 0, 131, 170, 33, 140, 54, 31);
                    state = true;
                    break;
                case "191":
                    receita = List.of(190, 151, 189, 31, 129, 101, 121, 118, 66, 183, 145, 99, 49, 153, 71, 43, 67, 44, 177, 15, 1, 75, 69, 82, 45, 37, 42, 150, 38, 135, 27, 4, 78, 11, 8, 65, 173, 33, 174, 168, 79, 172, 157, 170, 83, 21, 111, 34, 102, 20, 70, 137, 103, 161, 127, 119, 5, 24, 114, 125, 48, 122, 85, 160, 72, 58, 109, 106, 81, 184, 52, 156, 110, 152, 88, 108, 126, 113, 91, 63, 51, 120, 154, 143, 57, 140, 181, 90, 182, 158, 86, 29, 3, 16, 54, 171, 12, 149, 128, 25, 40, 32, 188, 167, 17, 39, 166, 116, 186, 117, 133, 179, 155, 0, 148, 105, 59, 87, 123, 28, 23, 89, 104, 165, 180, 22, 178, 26, 175, 56, 2, 139, 19, 46, 107, 92, 147, 96, 76, 55, 47, 130, 6, 35, 134, 7, 95, 141, 136, 13, 98, 10, 53, 77, 80, 185, 132, 100, 14, 61, 94, 115, 187, 93, 144, 84, 9, 36, 138, 64, 162, 30, 169, 176, 50, 164, 97, 18, 159, 62, 60, 41, 124, 74, 146, 142, 68, 131, 163, 73, 112);
                    state = true;
                    break;
                default:
                    System.out.println("Nenhuma das opções foi escolhida! Escolha novamente.");
                    System.out.println();
                    break;
            }
        }while(!state);
        input.close();


        System.out.println("\nAnalisando ciclos para uma receita de tamanho " + receita.size()+": ");

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
        System.out.println("Número de iterações: " + mmcCiclos);
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
