package Aulas.Grafo;

public class AppDirectedCycle {

    public static void main(String[] args) {
        Digraph g = new Digraph("tinyG.txt");

        DirectedCycles dc = new DirectedCycles(g);
        System.out.println(dc.containsCycle());
    }
}
