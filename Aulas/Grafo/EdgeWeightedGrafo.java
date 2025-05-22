package Aulas.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EdgeWeightedGrafo {
  protected static final String NEWLINE = System.getProperty("line.separator");

  protected Map<String, List<Edge>> graph;
  protected Set<String> vertices;
  protected int totalVertices;
  protected int totalEdges;

  public EdgeWeightedGrafo() {
    graph = new HashMap<>();
    vertices = new HashSet<>();
    totalVertices = totalEdges = 0;
  }

  public EdgeWeightedGrafo(String filename) {
    this();
    In in = new In(filename);
    String line;
    while ((line = in.readLine()) != null) {
      if (line.trim().isEmpty() || line.startsWith("#")) continue;
      String[] edge = line.split(";");
      addEdge(edge[0], edge[1], Double.parseDouble(edge[2]));
    }
    in.close();
  }

  public EdgeWeightedGrafo grafoDePontos(List<Par> pares){
    EdgeWeightedGrafo g = new EdgeWeightedGrafo();

    for (Par p1 : pares) {
        List<Edge> closestEdges = new ArrayList<>();

        for (Par p2 : pares) {
            if (!p1.name.equals(p2.name)) {
                double distance = p1.distancia(p2);
                closestEdges.add(new Edge(p1.name, p2.name, distance));
            }
        }

        closestEdges.sort(Edge::compareTo);
        int count = 0;
        for (Edge e : closestEdges) {
            if (count++ >= 3) break;
            g.addEdge(e.getV(), e.getW(), e.getWeight());
        }
    }

    return g;
  }

  public void addEdge(String v, String w, double weight) {
    Edge e = new Edge(v, w, weight);
    addToList(v, e);
    addToList(w, e);
    if(!vertices.contains(v)) {
      vertices.add(v);
      totalVertices++;
    }
    if(!vertices.contains(w)) {
      vertices.add(w);
      totalVertices++;
    }
    totalEdges += 2;
  }

  public Iterable<Edge> getAdj(String v) {
    List<Edge> res = graph.get(v);
    if (res == null) res = new LinkedList<>();
    return res;
  }

  public int getTotalVerts() { return totalVertices; }
  
  public int getTotalEdges() { return totalEdges; }

  public Set<String> getVerts() {
    return vertices;
  }

  public Iterable<Edge> getEdges() {
    Set<Edge> ed = new HashSet<>();
    for (String v : getVerts().stream().sorted().toList()) {
      for (Edge e : getAdj(v)) {
        if (!ed.contains(e)) {
          ed.add(e);
        }
      }
    }
    return ed;
  }

  public String toDot() {
    StringBuilder sb = new StringBuilder();
    sb.append("graph {" + NEWLINE);
    sb.append("rankdir = LR;" + NEWLINE);
    sb.append("node [shape = circle];" + NEWLINE);
    for (Edge e : getEdges())
      sb.append(String.format("%s -- %s [label=\"%.3f\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }

  // Adiciona um vértice adjacente a outro, criando a lista
  // de adjacências caso ainda não exista no dicionário
  protected List<Edge> addToList(String v, Edge e) {
    List<Edge> list = graph.get(v);
    if (list == null)
      list = new LinkedList<>();
    list.add(e);
    graph.put(v, list);
    return list;
  }
}
