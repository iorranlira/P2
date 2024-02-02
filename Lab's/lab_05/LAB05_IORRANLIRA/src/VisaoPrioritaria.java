/**
 * SubClasse de VisãoPrioritaria que herda de Visão.
 * @author  Iorran Santos de Lira
 */
public class VisaoPrioritaria extends Visao{

    /**
     * Cria uma visão prioritaria de um Documento.
     * @param documento o Documento.
     */
    public VisaoPrioritaria(Documento documento, int prioridade){
        super(documento,prioridade);
    }

    /**
     * Método Sobrescrito que exibe a visão de um Documento.
     * @return a visão criada;
     */
    @Override
    public String[] exibirVisao() {
        Documento documento1 = super.getDocumento();
        int prioridade = super.getPrioridade();
        String[] arrayString = new String[documento1.listaElementosPrioridades(prioridade).size()];

        for (int i = 0; i <= documento1.listaElementosPrioridades(prioridade).size(); i++) {
                arrayString[i] = documento1.listaElementosPrioridades(prioridade).get(i);
            }
                return arrayString;
    }

}
