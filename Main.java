package trabalho2;

public class Main {
    public static void main(String[] args) {
        
    int nLinha = 0;
    int nPagina = 0;
    
    ArquivoTexto arquivo = new ArquivoTexto(); // objeto que gerencia o arquivo
    LinhaTexto linha = new LinhaTexto(); // objeto que gerencia uma linha
    ListaOrdenadaPalavras listaPalavras = new ListaOrdenadaPalavras(); // instância da lista ordenada de palavras
    String l;

    arquivo.open("ArquivoExemplo.txt");
    
    /*
     * do  // laco que passa em cada linha do arquivo
    {
        l = arquivo.getNextLine();
        if (l==null) // acabou o arquivo?
           break;
        nLinha++; // conta mais uma linha lida do arquivo
        if (nLinha == 40) // chegou ao fim da pagina?
        {
            nLinha = 0;
            nPagina++;
        }
        System.out.println("Linha " + nLinha + ":");

        linha.setLine(l); // define o texto da linha
        do // laco que passa em cada palavra de uma linha
        {
            String palavra = linha.getNextWord(); // obtem a proxima palavra da linha
            if (palavra == null) {break;} // acabou a linha
            System.out.println("-" + palavra + "-");
         } while (true);

    } while (true);
     */

	// Laço que passa em cada linha do arquivo
	do {
	    l = arquivo.getNextLine();
	    if (l == null) // acabou o arquivo?
	        break;
	
	    nLinha++; // conta mais uma linha lida do arquivo
	    if (nLinha == 40) { // chegou ao fim da página?
	        nLinha = 0;
	        nPagina++;
	    }
	
	    linha.setLine(l); // define o texto da linha
	    System.out.println("Palavras e suas ocorrências nas páginas:");
	    do {
	        String palavra = linha.getNextWord(); // obtém a próxima palavra da linha
	        if (palavra == null) {
	            break; // acabou a linha
	        }
	        listaPalavras.addPalavra(palavra.toLowerCase(), nPagina);
	        listaPalavras.displayPalavra(palavra.toLowerCase());
	    } while (true);
	
	} while (true);
	
	arquivo.close();        
    }
}