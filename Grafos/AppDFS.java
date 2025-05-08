public class AppDFS
{
    public static void main(String[] args) {
        Grafos g = new Grafos("tinyG.txt");

        DepthFirstSearch dfs = new DepthFirstSearch(g, "0");     
        
        boolean temCiclo = dfs.containCycle("0");
        System.out.println("Tem ciclo? " + temCiclo);

        for(String v: g.getVerts()) {
            if (dfs.hasPathTo(v)) {
                System.out.print(v + ": ");
                for(String w: dfs.pathTo(v)) {
                    System.out.print(w + " ");
                }
            } else {
                System.out.print(v + ": sem caminho a partir de " + dfs.getSource());
            }
            System.out.println();
        }
        
    }

}