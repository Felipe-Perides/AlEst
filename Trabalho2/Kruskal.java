package Trabalho2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Kruskal {
    protected static final String NEWLINE = System.getProperty("line.separator");

    private double totalWeight;
    private List<Edge> edges;
    private EdgeWeightedGrafo g;

    public Kruskal(EdgeWeightedGrafo g) {

        this.g = g;
        MinHeap<Edge> pq = new MinHeap<Edge>();
        edges = new LinkedList<>();
        UnionFind uf = new UnionFind();
        totalWeight = 0;

        // Cada vértice é um "conjunto" na estrutura union-find
        for (String v : g.getVerts())
            uf.addSet(v);

        // Insere todas as aresta do grafo original no minheap
        // (fila de prioridade de mínimo)
        for (Edge e : g.getEdges()) {
            pq.put(e);
        }

        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            // System.out.println(e);
            String v = uf.find(e.getV());
            String w = uf.find(e.getW());
            // Se o conj. de v for diferente do
            // conj. de w, v e w não vão formar
            // ciclo!
            if (!v.equals(w)) {
                // Neste caso, une os dois conj.
                // E adiciona a aresta à MST
                uf.union(e.getV(), e.getW());
                edges.add(e);
                totalWeight += e.getWeight();
            }
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("graph {" + NEWLINE);
        sb.append("rankdir = LR;" + NEWLINE);
        sb.append("node [shape = circle];" + NEWLINE);

        for (Edge e : g.getEdges()) {
            int label = edges.contains(e) ? 1 : 0;  // 1 se MST, 0 se não MST
            sb.append(String.format("%s -- %s [label=\"%d\"]\n", e.getV(), e.getW(), label));
        }
        sb.append("}\n");
        return sb.toString();
    }

    /*
     * public static void main(String[] args) {
        EdgeWeightedGrafo g = new EdgeWeightedGrafo("tinyG.txt");
        Kruskal k = new Kruskal(g);

        System.out.println("Peso total: " + k.getTotalWeight());
        for (Edge e : k.getEdges()) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println(k.toDot());
    }
     */
}