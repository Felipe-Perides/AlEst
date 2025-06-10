package Trabalho2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathFinder {
    static class Pos {
        int x, y;
        Pos(int x, int y) { this.x = x; this.y = y; }
    }

    public static char[][] lerMapa(In in) throws IOException {
        if (in == null) throw new IllegalArgumentException("input is null");
        int linhas = in.readInt();
        int colunas = in.readInt();

        char[][] mapa = new char[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            String linha = in.readString(); // lendo a linha inteira (sem espaços)
            if (linha.length() != colunas) {
                throw new IllegalArgumentException("Linha " + i + " com tamanho incorreto");
            }
            mapa[i] = linha.toCharArray();
        }
        in.close();
        return mapa;
    }

    public static Pos encontrarChar(char[][] mapa, char alvo) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == alvo) return new Pos(i, j);
            }
        }
        return null;
    }

    public static List<Pos> bfs(char[][] mapa, Pos start, char destino) {
        int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};

        int linhas = mapa.length;
        int colunas = mapa[0].length;

        boolean[][] visitado = new boolean[linhas][colunas];
        Pos[][] pai = new Pos[linhas][colunas];

        Queue<Pos> fila = new LinkedList<>();
        fila.add(start);
        visitado[start.x][start.y] = true;

        while (!fila.isEmpty()) {
            Pos atual = fila.poll();

            if (mapa[atual.x][atual.y] == destino) {
                // Reconstruir caminho
                List<Pos> caminho = new ArrayList<>();
                for (Pos p = atual; p != null; p = pai[p.x][p.y]) {
                    caminho.add(p);
                }
                Collections.reverse(caminho);
                return caminho;
            }

            for (int dir = 0; dir < 8; dir++) {
                int nx = atual.x + dx[dir];
                int ny = atual.y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < linhas && ny < colunas) {
                    if (!visitado[nx][ny]) {
                        // Trata 'S' como 'a' e 'z' como 'z' para a comparação
                        int custoAtual = (mapa[atual.x][atual.y] == 'S') ? 'a' : mapa[atual.x][atual.y];
                        int custoVizinho = (mapa[nx][ny] == 'z') ? 'z' : mapa[nx][ny];

                        if (custoVizinho - custoAtual <= 1) {
                            visitado[nx][ny] = true;
                            pai[nx][ny] = atual;
                            fila.add(new Pos(nx, ny));
                        }
                    }
                }
            }
        }

        return null; // caminho não encontrado
    }

}
