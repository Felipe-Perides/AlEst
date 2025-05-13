import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BreadthFirstSearch{
    private Grafos g;

    private Map<String, Boolean> marked;
    private Map<String, String> edgeTo;
    private Map<String, Integer> distTo;
    private String s;
    
    public BreadthFirstSearch(Grafos g, String s){
        this.g = g;
        this.s = s;
        marked = new HashMap<>();
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        bfs(g,s);
    }

    public boolean hasPathTo(String v){
        return marked.containsKey(v);
    }

    public int distTo(String v){
        if(hasPathTo(v))
            return distTo.get(v);
        return -1;
    }

    public String getSource() {
        return s;
    }

    public Iterable<String> pathTo(String v){
        List<String> path = new LinkedList<>();
        if(hasPathTo(v)){
            while(!v.equals(s)){
                path.add(0, v);
                v = edgeTo.get(v);
            }
            path.add(0, s);
        }
        return path;
    }

    private void bfs(Grafos g, String v) {
        List<String> fila = new LinkedList<>();
        fila.add(v);
        marked.put(v, true);
        distTo.put(v, 0);
        while (!fila.isEmpty()) {
            String x = fila.remove(0);
            // marked.add(x);
            int dist = distTo.get(x);
            // System.out.println("Visitando " + x);
            for (String w : g.getAdj(x)) {
                if (!marked.containsKey(w)) {
                    edgeTo.put(w, x);
                    distTo.put(w, dist + 1);
                    // System.out.println(" >> adicionando " + w);
                    fila.add(w);
                    marked.put(w, true);
                }
            }
        }
    }

    public boolean containsCycle(String v){
        marked.clear();
        Map<String, String> parent = new HashMap<>();
        Set<String> edgeSet = new HashSet<>(); 
        LinkedList<String> queue = new LinkedList<>();

        queue.add(v);
        marked.put(v, true);
        parent.put(v, null);

        while(!queue.isEmpty()){
            String u = queue.poll();
            for(String adj : g.getAdj(u)){
                String edge = makeEdgeKey(u, adj);

                if(!marked.containsKey(adj)){
                    marked.put(adj, true);
                    parent.put(adj, u);
                    edgeSet.add(edge);
                    queue.add(adj);
                }else{
                    // Se o vértice já foi visitado, e não é o pai direto
                    if(!adj.equals(parent.get(u)) && !edgeSet.contains(edge)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    private String makeEdgeKey(String a, String b){
        return a.compareTo(b) < 0 ? a + "-" + b : b + "-" + a;
    }
}
