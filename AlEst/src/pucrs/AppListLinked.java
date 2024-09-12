package pucrs;

public class AppListLinked {
	
	public static void main(String[] args) {
	    System.out.println();

	    ListSingleLinked lista;
	    lista  = new ListSingleLinked();
	    lista.show();
	    lista.insereFim(10);
	    lista.add(5);
	    lista.add(7);
	    lista.show();
	    lista.insereFim(3);
	    lista.insereFim(4);
	    lista.show();
	    System.out.println();
	    lista.show();
	    System.out.println();
	    lista.add(0, 8);
	    System.out.println();
	    lista.show();
	    lista.add(lista.indexOf(), 50);
	    System.out.println();
	    lista.show();
	    lista.add(2, 6);
	    System.out.println();
	    lista.show();
	    System.out.println();
	    System.out.printf("indexOf(6): %d\n", lista.indexOf(6));
	    System.out.printf("indexOf(8): %d\n", lista.indexOf(8));
	    System.out.printf("indexOf(8): %d\n", lista.indexOf());
	    
	    lista.showReverse();
	  }
}
