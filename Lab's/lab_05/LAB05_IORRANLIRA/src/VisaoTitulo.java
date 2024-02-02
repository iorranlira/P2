/**
 * SubClasse de VisãoTitulo que herda de Visão.
 * @author  Iorran Santos de Lira
 */
public class VisaoTitulo extends Visao{

    /**
     * Cria uma visão titulo de um Documento.
     * @param documento o Documento.
     */
    public VisaoTitulo(Documento documento){
        super(documento);
    }

    /**
     * Método Sobrescrito que exibe a visão de um Documento.
     * @return a visão criada;
     */
    @Override
    public String[] exibirVisao() {
        Documento documento1 = super.getDocumento();
        String[] arrayString = new String[documento1.listaElementosTitulo().size()];

        for (int i = 0; i <= documento1.listaElementosTitulo().size(); i++){
                arrayString[i] = documento1.listaElementosTitulo().get(i);
        }
                return arrayString;
    }
}
