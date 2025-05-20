import java.util.HashMap;
import java.util.Map;

public class DirectedDFS {
    private Map<String, Boolean> marked;  // marked[v] = true iff v is reachable from source(s)
    private int count;         // number of vertices reachable from source(s)

    public DirectedDFS(digrafos G, String s) {
        marked = new HashMap<>();
        validateVertex(G,s);
        dfs(G, s);
    }

    public DirectedDFS(digrafos G, Iterable<String> sources) {
        marked = new HashMap<>();
        validateVertices(G, sources);
        for (String v : sources) {
            if (!marked.getOrDefault(v, false)) dfs(G, v);
        }
    }

    private void dfs(digrafos G, String v) {
        marked.put(v, true);
        count++;
        for (String w : G.getAdj(v)) {
            if (!marked.getOrDefault(w, false)) dfs(G, w);
        }
    }

    public boolean marked(String v) {
        validateVertex(marked, v);
        return marked.getOrDefault(v, false);
    }

    public int count() {
        return count;
    }

    private void validateVertex(digrafos G, String v) {
        if (!G.getVerts().contains(v)) {
            throw new IllegalArgumentException("vertex " + v + " is not in the graph");
        }
    }

    private void validateVertex(Map<String, Boolean> map, String v) {
        if (v == null) {
            throw new IllegalArgumentException("vertex is null");
        }
    }

    private void validateVertices(digrafos G, Iterable<String> vertices) {
        if (vertices == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int vertexCount = 0;
        for (String v : vertices) {
            vertexCount++;
            if (v == null) {
                throw new IllegalArgumentException("vertex is null");
            }
            validateVertex(G, v);
        }
        if (vertexCount == 0) {
            throw new IllegalArgumentException("zero vertices");
        }
    }
}
