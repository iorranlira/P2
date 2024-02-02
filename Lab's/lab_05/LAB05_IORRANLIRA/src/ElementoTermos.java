import java.util.Arrays;

/**
 * Classe de ElementoTermos que herda de Elemento.
 * @author  Iorran Santos de Lira
 */
public class ElementoTermos extends Elemento {

    /**
     * SubClasse um ElementoTermos com valor, prioridade, separador e ordem.
     * @param valor o valor do Elemento.
     * @param prioridade a prioridade do Elemento.
     * @param separador a String separador do Elemento.
     * @param ordem a ordem do Elemento.
     */
    public ElementoTermos(String valor, int prioridade, String separador, String ordem) {
        super(prioridade, valor);
        propriedades.put("separador", separador);
        propriedades.put("ordem", ordem);
    }

    /**
     * Método que conta os termos de um valor e que retorna a quantidade.
     * @return quantidade de termos.
     */
    public int contaTermos() {
        String[] lista = getValor().split(getSeparador());
        return lista.length;
    }

    /**
     * Método de ordenar elementos de uma lista a partir de sua ordem.
     * @return a lista.
     */
    public String[] ordenaLista() {
        String[] lista = getValor().split(" " + getSeparador());
        if (getOrdem().equals("TAMANHO")) {
            Arrays.sort(lista, new CompararTamanho());
            return lista;
        }
        if (getOrdem().equals("ALFABÉTICA")) {
            Arrays.sort(lista);
            return lista;
        }
            return lista;
    }

    /**
     * Método Sobrescrito para verificar se é Titulo.
     * @return retorna false se não for.
     */
    @Override
    public boolean eTitulo() {
        return false;
    }

    /**
     * Método Sobrescrito de uma Representação Completa.
     * @return Representação Completa.
     */
    @Override
        public String representacaoCompleta(){
            return "Total termos: " + contaTermos() + "\n" + "- " + String.join(",",ordenaLista()) ;

    }

    /**
     * Método Sobrescrito de uma Representação Resumida.
     * @return Representação Resumida.
     */
        @Override
        public String representacaoResumida(){
            return String.join(" " + getSeparador(),ordenaLista());
        }

    /**
     * Método Getter para pegar a ordem do Elemento.
     * @return a ordem do Elemento.
     */
        public String getOrdem(){
            return propriedades.get("ordem");

    }

    /**
     * Método Getter para pegar o separador do Elemento.
     * @return o separador do Elemento.
     */
        public String getSeparador(){
        return propriedades.get("separador");
    }

}
