package Trabalho2;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scan;

    public static void main(String[] args) {
        try {
            scan = new Scanner(System.in);
            int choice = 0;
            String file = "";

            do {
                System.out.println("Qual mapa você deseja?");
                System.out.println("50X50 -> 1\n100X100 -> 2\n200X200 -> 3\n400X400 -> 4\n800X800 -> 5\n1000X1000 -> 6\n1500X1500 -> 7\n2000X2000 -> 8");
                choice = scan.nextInt();

                switch (choice) {
                    case 1: file = "casoTeste50.txt"; break;
                    case 2: file = "casoTeste100.txt"; break;
                    case 3: file = "casoTeste200.txt"; break;
                    case 4: file = "casoTeste400.txt"; break;
                    case 5: file = "casoTeste800.txt"; break;
                    case 6: file = "casoTeste1000.txt"; break;
                    case 7: file = "casoTeste1500.txt"; break;
                    case 8: file = "casoTeste2000.txt"; break;
                    default:
                        System.out.println("Escolha inválida! Digite um número de 1 a 8.");
                        continue;
                }

                In in = new In(file);
                char[][] mapa = PathFinder.lerMapa(in);

                PathFinder.Pos start = PathFinder.encontrarChar(mapa, 'S');
                if (start == null) {
                    System.out.println("Ponto inicial 'S' não encontrado");
                    return;
                }

                // INÍCIO MEDIÇÃO
                long startTime = System.nanoTime();
                Runtime runtime = Runtime.getRuntime();
                runtime.gc(); // Sugere coleta de lixo
                long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

                List<PathFinder.Pos> caminho = PathFinder.bfs(mapa, start, 'z');

                long endTime = System.nanoTime();
                long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
                long duration = endTime - startTime;
                long usedMemory = memoryAfter - memoryBefore;
                // FIM MEDIÇÃO

                if (caminho == null) {
                    System.out.println("Caminho não encontrado");
                } else {
                    for (PathFinder.Pos p : caminho) {
                        System.out.println("(" + p.x + ", " + p.y + ") -> " + mapa[p.x][p.y]);
                    }
                    System.out.println("Caminho encontrado! Tamanho: " + caminho.size());
                }

                System.out.printf("Tempo de execução: %.2f ms%n", duration / 1_000_000.0);
                System.out.printf("Memória utilizada: %.2f KB%n", usedMemory / 1024.0);

            } while (choice >= 1 && choice <= 8);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
