import java.sql.Array;
/**
 * SubClasse de VisãoResumida que herda de Visão.
 * @author  Iorran Santos de Lira
 */
public class VisaoResumida extends Visao{

    /**
     * Cria uma visão resumida de um Documento.
     * @param documento o Documento.
     */
    public VisaoResumida(Documento documento){
        super(documento);
    }

    /**
     * Método Sobrescrito que exibe a visão de um Documento.
     * @return a visão criada;
     */
    @Override
    public String[] exibirVisao() {
        Documento documento = super.getDocumento();
        String[] arrayString = new String[documento.contaElementos()];

        for(int i = 0; i <= documento.contaElementos()-1; i++){
            arrayString[i] = documento.getRepresentacaoResumida(i);
        }
           return arrayString;
    }
}
