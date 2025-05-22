package Aulas.Grafo;
public class Par {
    public String name;
    public double x,y;

    public Par(String Name, double X, double Y){
        this.name = Name;
        this.x = X;
        this.y = Y;
    }

    public double distancia(Par outro){
        double dx = this.x - outro.x;
        double dy = this.y - outro.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
