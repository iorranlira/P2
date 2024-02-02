import java.util.regex.Pattern;

/**
 * SubClasse de ElementoLista que herda de Elemento.
 * @author  Iorran Santos de Lira
 */
public class ElementoLista extends Elemento {

    /**
     * Cria um Elemento lista com valor, prioridade, separador e charlista.
     * @param valor o valor do Elemento.
     * @param prioridade a prioridade do Elemento.
     * @param separador a String separador do Elemento.
     * @param charLista a String charLista do Elemento.
     */
    public ElementoLista(String valor, int prioridade ,String separador, String charLista){
        super(prioridade,valor);
        propriedades.put("separador",separador);
        propriedades.put("caractere", charLista);
    }

    /**
     * Método que retorna o valor completo de um Elemento.
     * @return valor completo do Elemento.
     */
    private String processaValorCompleto(){
        String[] lista = getValor().split(Pattern.quote(" " + getSeparador() + " "));
        return getCharLista() + " " + String.join("\n" + getCharLista() + " ", lista);
    }

    /**
     * Método que retorna o valor resumido de um Elemento.
     * @return valor resumido do Elemento.
     */
    private String processaValorResumido(){
        String[] lista = getValor().split(Pattern.quote(" " + getSeparador() + " "));
        return String.join(getSeparador() + " ",lista);
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
        return processaValorCompleto();
    }

    /**
     * Método Sobrescrito de uma Representação Resumida.
     * @return Representação Resumida.
     */
    @Override
    public String representacaoResumida(){
        return processaValorResumido();
    }

    /**
     * Método Getter para pegar o separador do Elemento.
     * @return o separador do Elemento.
     */
    public String getSeparador(){
        return propriedades.get("separador");
    }

    /**
     * Método Getter para pegar o charLista do Elemento.
     * @return o charLista do Elemento.
     */
    public String getCharLista(){
        return propriedades.get("caractere");
    }

}

