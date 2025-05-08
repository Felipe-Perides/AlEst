public class appGrafos {
    public static void main(String[] args){
        /* 
        grafos g = new grafos();
        g.addEdge("0", "1");
        g.addEdge("0", "2");
        g.addEdge("2", "1");
        */

        Grafos g = new Grafos("tinyG.txt");

        for(String v : g.getVerts()){
            System.out.print(v + ": ");
            for(String w : g.getAdj(v)){
                System.out.print(w + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(g.toDot());
    }
}
