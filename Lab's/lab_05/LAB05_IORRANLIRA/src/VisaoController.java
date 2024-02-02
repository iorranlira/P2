import java.util.ArrayList;

/**
 * A Classe VisaoController responsável pela Visão.
 * @author  Iorran Santos de Lira
 */
public class VisaoController {
    private DocumentoController documentoController;
    private ArrayList<Visao> visoes = new ArrayList<>();

    /**
     * Constroi uma VisaoController.
     * @param documentoController parâmetro utilizado.
     */
    public VisaoController(DocumentoController documentoController){
        this.documentoController = documentoController;
    }

    /**
     * Método que cria uma VisãoCompleta a partir do seu título.
     * @param tituloDoc parâmetro utilizado para pegar o Documento.
     * @return índice em que foi salva.
     */
    public int criarVisaoCompleta(String tituloDoc){
        Documento documento = documentoController.getDocumento(tituloDoc);
        Visao visao = new VisaoCompleta(documento);
        visoes.add(visao);
        return visoes.indexOf(visao);

    }

    /**
     * Método que cria uma VisãoResumida a partir do seu título.
     * @param tituloDoc parâmetro utilizado para pegar o Documento.
     * @return índice em que foi salva.
     */
   public int criarVisaoResumida(String tituloDoc){
        Documento documento = documentoController.getDocumento(tituloDoc);
        Visao visao = new VisaoResumida(documento);
        visoes.add(visao);
        return visoes.indexOf(visao);
   }

    /**
     * Método que cria uma VisãoPriotaria a partir do seu título e da prioridade.
     * @param tituloDoc parâmetro utilizado para pegar o Documento.
     * @param prioridade prioridade da visão.
     * @return índice em que foi salva.
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade){
        Documento documento = documentoController.getDocumento(tituloDoc);
        Visao visao = new VisaoPrioritaria(documento,prioridade);
        visoes.add(visao);
        return visoes.indexOf(visao);
    }

    /**
     * Método que cria uma VisãoTitulo partir do seu título.
     * @param tituloDoc parâmetro utilizado para pegar o Documento.
     * @return índice em que foi salva.
     */
    public int criarVisaoTitulo(String tituloDoc){
        Documento documento = documentoController.getDocumento(tituloDoc);
        Visao visao = new VisaoTitulo(documento);
        visoes.add(visao);
        return visoes.indexOf(visao);
    }

    /**
     * Método que exibe uma visão.
     * @param visaoId índice da visão.
     * @return a visão pronta para visualização.
     */
    public String[] exibirVisao(int visaoId){
      Visao visao = visoes.get(visaoId);
      return visao.exibirVisao();
    }

}
