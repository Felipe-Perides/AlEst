public class AppBFS {
    public static void main(String[] args) {
        Grafos g = new Grafos("tinyG.txt");

        BreadthFirstSearch bfs = new BreadthFirstSearch(g, "0");

        boolean temCiclo = bfs.containsCycle("0");
        System.out.println("Tem ciclo? " + temCiclo);

        for (String v : g.getVerts()) {
            if (bfs.hasPathTo(v)) {
                System.out.print(v + ": (" + bfs.distTo(v) + ") ");
                for (String w : bfs.pathTo(v)) {
                    System.out.print(w + " ");
                }
                System.out.println();
            } else {
                System.out.println(v + ": sem caminho a partir de " + bfs.getSource());
            }
        }
    }

}