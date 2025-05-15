import java.util.Scanner;

public class GrauSeparacao {
    private static Scanner scan;
    public static void main(String[] args){
        scan = new Scanner(System.in);
        Grafos g = new Grafos("movies.txt");

        System.out.println("Digite o nome do primeiro ator/atriz: ");
        String ator1 = scan.nextLine();

        System.out.println("\nDigite o nome do segundo ator/atriz: ");
        String ator2 = scan.nextLine();

        if (!g.getVerts().contains(ator1) || !g.getVerts().contains(ator2)) {
            System.out.println("Um dos nomes não foi encontrado no grafo.");
            return;
        }

        BreadthFirstSearch bfs = new BreadthFirstSearch(g, ator1);

        if (bfs.hasPathTo(ator2)) {
            System.out.println("Menor caminho entre " + ator1 + " e " + ator2 + ": ");
            for (String v : bfs.pathTo(ator2)) {
                System.out.println(v);
            }
            System.out.println("\nGrau de separação: " + (bfs.distTo(ator2) / 2) + "\n");
        } else {
            System.out.println("\nNão existe caminho entre os dois atores/atrizes.\n");
        }

        scan.close();
    }
}
