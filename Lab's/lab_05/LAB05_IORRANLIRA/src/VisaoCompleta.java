/**
 * SubClasse de VisãoCompleta que herda de Visão.
 * @author  Iorran Santos de Lira
 */
public class VisaoCompleta extends Visao {

    /**
     * Cria uma visão completa de um Documento.
     * @param documento o Documento.
     */
    public VisaoCompleta(Documento documento){
        super(documento);
    }

    /**
     * Método Sobrescrito que exibe a visão de um Documento.
     * @return a visão criada;
     */
    @Override
    public String[] exibirVisao() {
        Documento documento1 = super.getDocumento();
        String[] arrayString = new String[documento1.contaElementos()];

        for (int i = 0; i <= documento1.contaElementos()-1; i++){
            arrayString[i] = documento1.getRepresentacaoCompleta(i);
        }
            return arrayString;
    }
}
