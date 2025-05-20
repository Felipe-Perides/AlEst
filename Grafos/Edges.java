public class Edges implements Comparable<Edges> {
    private final int v, w, weight;

    Edges(int V, int W, int Weight){
        this.v = V;
        this.w = W;
        this.weight = Weight;
    }

    public int either(){return v;}

    public int other(int vertex){
        if(vertex == v) return w;
        else return v;
    }

    public int compareTo(Edges that){
        if(this.weight < that.weight) return -1;
        else if(this.weight > that.weight) return 1;
        else return 0;
    }

    public int weight(){return weight;}

    public String toString() {
        return String.format("%d-%d %d", v, w, weight);
    }
}
