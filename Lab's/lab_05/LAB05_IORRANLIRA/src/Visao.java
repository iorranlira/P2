/**
 * Super Classe Abstrata de Visao.
 * @author  Iorran Santos de Lira
 */
public abstract class Visao{
    private Documento documento;
    private int prioridade;

    /**
     * Cria uma visão a partir de um Documento.
     * @param documento o Documento.
     */
    public Visao(Documento documento){
        this.documento = documento;
    }

    /**
     * Cria uma visão a partir de um Documento e uma prioridade.
     * @param documento o Documento.
     * @param prioridade a prioridade.
     */
    public Visao(Documento documento, int prioridade){
        this.documento = documento;
        this.prioridade = prioridade;
    }

    /**
     * Método abstrado de exibir uma visão.
     * @return a visão.
     */
    public abstract String[] exibirVisao();

    /**
     * Método Getter que pega um Documento.
     * @return o Documento.
     */
    public Documento getDocumento(){
        return documento;
    }

    /**
     * Método Getter que pega a prioridade.
     * @return a prioridade.
     */
    public int getPrioridade(){
        return prioridade;
    }

}
