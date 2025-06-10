package Aulas.Grafo;
public class AppCaminhosMinimosT2
{
    public static void main(String[] args) {
        EdgeWeightedDigrafo g = new EdgeWeightedDigrafo();
        In arq = new In(args[0]);

        while(arq.hasNextLine()) {
            // Implemente a leitura do grafo
            // ...
        }

        System.out.println(g.toDot());
        
        System.out.println("Vértices: "+g.getTotalVerts());
        System.out.println("Arestas: "+g.getTotalEdges());

        Dijkstra d = new Dijkstra(g, "hidrogenio");

        for(Edge e: d.pathTo("ouro")) {
            System.out.println(e);
        }


    }
}