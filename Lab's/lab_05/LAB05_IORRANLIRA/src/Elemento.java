import java.util.HashMap;
import java.util.Map;

/**
 * Super Classe Abstrata de Elemento.
 * @author  Iorran Santos de Lira
 */

public abstract class Elemento {
    private int prioridade;
    private String valor;
    protected Map<String, String> propriedades;

    /**
     * Cria um Elemento com prioridade e valor.
     * @param prioridade Prioridade do Elemento.
     * @param valor String do Elemento.
     */
    public Elemento(int prioridade, String valor){
        this.propriedades = new HashMap<String, String>();
        this.prioridade = prioridade;
        this.valor = valor;
    }

    /**
     * Método abstrato para verificar se é Titulo.
     * @return retorna false se não for.
     */
    public abstract boolean eTitulo();

    /**
     * Método abstrato de uma Representação Completa.
     * @return Representação Completa.
     */
    public abstract String representacaoCompleta();

    /**
     * Método abstrato de uma Representação Resumida.
     * @return Representação Resumida.
     */
    public abstract String representacaoResumida();

    /**
     * Método Getter que retorna o valor do elemento.
     * @return retorna o valor.
     */
    public String getValor() {
        return valor;
    }

    /**
     * Método Getter que retorna a prioridade do elemento.
     * @return retorna a prioridade.
     */
    public int getPrioridade() {
        return prioridade;
    }

}
