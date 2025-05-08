public class digrafos extends Grafos{
    public digrafos(String arq){
        super(arq);
    }

    @Override
    public void addEdge(String v, String w){ // Adiciona aresta v-w
        addToList(v, w);
    }

    @Override
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph {"+NEWLINE);
        sb.append("rankdir = LR;"+NEWLINE);
        sb.append("node [shape = circle];"+NEWLINE);
        for(String v: getVerts().stream().sorted().toList())
          for (String w: getAdj(v))
            sb.append(v + " -> " + w + NEWLINE);
        sb.append("}" + NEWLINE);
        return sb.toString();
      }
}
