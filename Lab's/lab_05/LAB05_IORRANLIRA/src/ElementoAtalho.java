/**
 * Classe de ElementoAtalho que herda de Elemento.
 * @author  Iorran Santos de Lira
 */
public class ElementoAtalho extends Elemento {
    private DocumentoController documento;
    private String representacaoCompleta;
    private String representacaoResumida;

    /**
     * SubClasse um ElementoAtalho com prioridade, valor, representação completa e resumoda.
     * @param prioridade prioridade do Elemento.
     * @param valor valor do Elemento.
     * @param representacaoCompleta representação completa do Elemento.
     * @param representacaoResumida representação Resumida do Elemento.
     */
    public ElementoAtalho(int prioridade, String valor, String representacaoCompleta, String representacaoResumida) {
    super(prioridade,valor);
    this.representacaoCompleta = representacaoCompleta;
    this.representacaoResumida = representacaoResumida;
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
    public String representacaoCompleta() {
        return representacaoCompleta;
    }

    /**
     * Método Sobrescrito de uma Representação Resumida.
     * @return Representação Resumida.
     */
    @Override
    public String representacaoResumida() {
        return representacaoResumida;
    }

}
