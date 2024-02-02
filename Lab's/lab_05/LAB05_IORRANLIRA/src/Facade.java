public class Facade {
    private VisaoController visaoController;
    private DocumentoController documentoController;

    public Facade() {
        this.documentoController = new DocumentoController();
        this.visaoController = new VisaoController(documentoController);
    }

    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }

    public boolean criarDocumento(String titulo, int tamanho) {
        return this.documentoController.criarDocumento(titulo, tamanho);
    }

    public void removerDocumento(String titulo) {
        this.documentoController.removerDocumento(titulo);
    }

    public int contarElementos(String titulo) {
        return this.documentoController.contarElementos(titulo);
    }

    public String[] exibirDocumento(String titulo){
        return documentoController.exibirDocumento(titulo);
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade){
        return this.documentoController.criarTexto(tituloDoc,valor,prioridade);
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
        return this.documentoController.criarTitulo(tituloDoc,valor,prioridade,nivel,linkavel);
    }

    public int criarLista(String tituloDoc, String valor, int prioridade, String separador, String charLista){
        return this.documentoController.criarLista(tituloDoc,valor,prioridade,separador,charLista);
    }

    public int criarTermos(String tituloDoc, String valor, int prioridade, String separador, String ordem){
        return this.documentoController.criarTermos(tituloDoc, valor, prioridade, separador, ordem);
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao){
        return this.documentoController.pegarRepresentacaoCompleta(tituloDoc,elementoPosicao);
    }

    public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao){
        return this.documentoController.pegarRepresentacaoResumida(tituloDoc,elementoPosicao);
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao){
        return this.documentoController.apagarElemento(tituloDoc,elementoPosicao);
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao){
         this.documentoController.moverParaCima(tituloDoc,elementoPosicao);
    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        this.documentoController.moverParaBaixo(tituloDoc,elementoPosicao);
    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado){
        return this.documentoController.criarAtalho(tituloDoc,tituloDocReferenciado);
    }

    public int criarVisaoCompleta(String tituloDoc){
        return this.visaoController.criarVisaoCompleta(tituloDoc);
    }

    public int criarVisaoResumida(String tituloDoc){
        return this.visaoController.criarVisaoResumida(tituloDoc);
    }

    public int criarVisaoPrioritaria(String tituloDoc, int prioridade){
        return this.visaoController.criarVisaoPrioritaria(tituloDoc,prioridade);
    }

    public int criarVisaoTitulo(String tituloDoc){
        return this.visaoController.criarVisaoTitulo(tituloDoc);
    }

    public String[] exibirVisao(int visaoId){
        return this.visaoController.exibirVisao(visaoId);
    }

}
