import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepthFirstSearch{
    private Grafos g;

    private Map<String, Boolean> marked;
    private Map<String, String> edgeTo;
    private String s;

    public DepthFirstSearch(Grafos g, String s) {
        this.s = s;
        marked = new HashMap<>();
        edgeTo = new HashMap<>();
        dfs(g, s);
    }

    public boolean hasPathTo(String v) {
        return marked.containsKey(v);
    }

    public Iterable<String> pathTo(String v) {
        List<String> path = new LinkedList<>();
        if (hasPathTo(v)) {
            while (!v.equals(s)) {
                path.add(0, v);
                v = edgeTo.get(v);
            }
            path.add(0, s);
        }
        return path;
    }

    private void dfs(Grafos g, String v) {
        marked.put(v, true);
        for (String w : g.getAdj(v)) {
            if (!marked.containsKey(w)) {
                edgeTo.put(w, v);
                dfs(g, w);
            }
        }
    }

    public boolean containCycle(String v){
        Set<String> edgeSet = new HashSet<>();
        marked.clear();
        return containCycleDFS(v, null, edgeSet);
    }
    private boolean containCycleDFS(String v, String parent, Set<String> edgeSet){
        marked.put(v, true);
        for(String u : g.getAdj(v)){
            String edge = makeEdgeKey(v,u);

            if(!marked.containsKey(u)){
                edgeSet.add(edge);
                if(containCycleDFS(u, v, edgeSet)) return true;
            }else{
                if(!edgeSet.contains(edge)){
                    // Detecção de ciclo
                    return true;
                }
            }
        }

        return false;
    }
    private String makeEdgeKey(String a, String b){
        // Garante que a chave seja a mesma para (a,b) e (b,a)
        return a.compareTo(b) < 0 ? a + "-" + b : b + "-" + a;
    }

    public String getSource() {
        return s;
    }
}