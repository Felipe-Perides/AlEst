package pucrs;

public class AppListArray {
	public static void main(String[] args) {
        ListArray lista = new ListArray();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        
        System.out.println(lista);
       
        //System.out.println("Elemento armazenado na "+ "primeira posicao da lista: " +lista.get(0));

        //lista.toString();
        lista.reverse();
        System.out.println(lista);
        System.out.println(lista.countOcurrences(4));
        lista.addIncreaseOrder(10);
        System.out.println(lista);
        lista.remove(8);
        System.out.println(lista);
    }
}
