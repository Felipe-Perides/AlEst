package Trabalho2;

public class Graph {
    protected static final String NEWLINE = System.getProperty("line.separator");
    
    private String[][] mapa;

    public Graph(String arq){
        In in = new In(arq);
        String line;
        while((line = in.readLine()) != null){
            String[] edge = line.split(" ");
        }
        in.close();
    }


}