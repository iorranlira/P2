/**
 * SubClasse de ElementoTista que herda de Elemento.
 * @author  Iorran Santos de Lira
 */
public class ElementoTexto extends Elemento {

    /**
     * Cria um ElementoTexto com valor e prioridade.
     * @param valor o valor do Elemento.
     * @param prioridade a prioridade do Elemento.
     */
    public ElementoTexto(String valor, int prioridade) {
        super(prioridade, valor);
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
        return getValor();
    }

    /**
     * Método Sobrescrito de uma Representação Resumida.
     * @return Representação Resumida.
     */
    @Override
    public String representacaoResumida(){
        return getValor();
    }

}
