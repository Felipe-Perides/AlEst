package Aulas.Grafo;

public class AppDFS
{
    public static void main(String[] args) {
        Graph g = new Graph("tinyG.txt");

        DepthFirstSearches dfs = new DepthFirstSearches(g, "0");        

        for(String v: g.getVerts()) {
            System.out.print(v+ ": ");  
            for(String w: dfs.pathTo(v)) {
                System.out.print(w+" ");
            }
            System.out.println();
        }
    }

}