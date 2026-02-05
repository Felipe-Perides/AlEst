package trabalho2;

public class LinhaTexto {
    private String linha;
    private String palavras[];
    private int contPalavras;
    
    /**
     * Recebe a string da linha que sera armazenada.
     * @param lin String com a linha de texto
     */
    public void setLine(String lin) {
    	String[] stop = {"de", "a", "o", "que", "e", "do", "da", "em", "um", "para", "é", "com", "não", "uma", "os", "no", "se", "na", "por", "mais", "as", "dos", "como", "mas", "foi", "ao", "ele", "das", "tem", "à", "seu", "sua", "ou", "ser", "quando", "muito", "há", "nos", "já", "está", "eu", "também", "só", "pelo", "pela", "até", "isso", "ela", "entre", "era", "depois", "sem", "mesmo", "aos", "ter", "seus", "quem", "nas", "me", "esse", "eles", "estão", "você", "tinha", "foram", "essa", "num", "nem", "suas", "meu", "às", "minha", "têm", "numa", "pelos", "elas", "havia", "seja", "qual", "será", "nós", "tenho", "lhe", "deles", "essas", "esses", "pelas", "este", "fosse", "dele", "tu", "te", "vocês", "vos", "lhes", "meus", "minhas", "teu", "tua", "teus", "tuas", "nosso", "nossa", "nossos", "nossas", "dela", "delas", "esta", "estes", "estas", "aquele", "aquela", "aqueles", "aquelas", "isto", "aquilo", "estou", "está", "estamos", "estão", "estive", "esteve", "estivemos", "estiveram", "estava", "estávamos", "estavam", "estivera", "estivéramos", "esteja", "estejamos", "estejam", "estivesse", "estivéssemos", "estivessem", "estiver", "estivermos", "estiverem", "hei", "há", "havemos", "hão", "houve", "houvemos", "houveram", "houvera", "houvéramos", "haja", "hajamos", "hajam", "houvesse", "houvéssemos", "houvessem", "houver", "houvermos", "houverem", "houverei", "houverá", "houveremos", "houverão", "houveria", "houveríamos", "houveriam", "sou", "somos", "são", "era", "éramos", "eram", "fui", "foi", "fomos", "foram", "fora", "fôramos", "seja", "sejamos", "sejam", "fosse", "fôssemos", "fossem", "for", "formos", "forem", "serei", "será", "seremos", "serão", "seria", "seríamos", "seriam", "tenho", "tem", "temos", "tém", "tinha", "tínhamos", "tinham", "tive", "teve", "tivemos", "tiveram", "tivera", "tivéramos", "tenha", "tenhamos", "tenham", "tivesse", "tivéssemos", "tivessem", "tiver", "tivermos", "tiverem", "terei", "terá", "teremos", "terão", "teria", "teríamos", "teriam"};
    	linha = lin.toLowerCase();
        linha = linha.replaceAll("\\t"," "); // substitui tab por espaco em branco
        linha = linha.replaceAll(",",""); // para remover vírgulas
        linha = linha.replaceAll("\\.",""); // para remover ponto final
        linha = linha.replaceAll("\\?",""); // para remover ponto interrogacao
        linha = linha.replaceAll("\\!",""); // para remover ponto exclamacao
        linha = linha.replaceAll("\\-", " "); // para remover trassos
        linha = linha.replaceAll("\\/", " "); // para remover barras
        linha = linha.replaceAll("\\d", "");
        linha = linha.replaceAll("™", "");
        linha = linha.replaceAll("\\:", "");
        linha = linha.replaceAll("\\$", "");
        linha = linha.replaceAll("\\%", "");
        linha = linha.replaceAll("\\'", "");
        linha = linha.replaceAll("\\(", "");
        linha = linha.replaceAll("\\)", "");
        linha = linha.replaceAll("\\§", "");
        for(String word : stop) {
            linha = linha.replaceAll("\\b" + word + "\\b", "");
        }
        
        palavras = linha.split("\\s+"); // divide a string pelos espaços em branco
        contPalavras = 0;
    }
    
    /**
     * Retorna uma palavra da linha.
     * @return a palavra, ou null caso nao tenha mais palavras.
     */
    public String getNextWord() {
    	// if para tirar '' ""
    	String pal = null;
    	if (contPalavras < palavras.length) {
    		pal = palavras[contPalavras].toLowerCase();
    		contPalavras++;
    	}
    	return pal;
    }
}
