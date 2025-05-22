package Aulas.Grafo;

import java.util.ArrayList;
import java.util.List;

public class AppMSTMapa{

  public static List<Par> readPointsFromCSV(String filename) {
    List<Par> pares = new ArrayList<>();
    In in = new In(filename);  // Usa a classe In já presente no seu projeto

    int count = 0;
    while (in.hasNextLine()) {
        String line = in.readLine().trim();
        if (line.isEmpty() || line.startsWith("#")) continue;
        String[] parts = line.split(";");
        double x = Double.parseDouble(parts[0]);
        double y = Double.parseDouble(parts[1]);
        pares.add(new Par("P" + count++, x, y));
    }

    in.close();
    return pares;
}


  public static void main(String[] args) {

    List<Par> pares = readPointsFromCSV("dados.csv");

    EdgeWeightedGrafo g = new EdgeWeightedGrafo().grafoDePontos(pares);

    Kruskal mst = new Kruskal(g);
    
    System.out.printf("Peso total da MST: %.3f%n", mst.getTotalWeight());

    System.out.println(mst.toDot());

  }
  
}
