public class AppDirectedCycle {

    public static void main(String[] args) {
        digrafos d = new digrafos("tinyG.txt");

        DirectedCycle dc = new DirectedCycle(d);
        System.out.println(dc.containsCycle());
        
        System.out.println();
    }
}