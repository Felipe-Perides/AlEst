public class Compara {

    public static void main(String[] args) {

        SeparateChainingHashST<String, Integer> dic = new SeparateChainingHashST<>();
        //LinearProbingHashST<String, Integer> dic = new LinearProbingHashST<>();

        In arq = new In("DomCasmurro_utf8.txt");
        String[] words = arq.readAllStrings();
        arq.close();


        long start1 = System.nanoTime();
        for (String word : words) {
            
            
        }
        long end1 = System.nanoTime();
        double delta = end1 - start1;

        System.out.println("Tempo de execução: "+delta);
    }
}
