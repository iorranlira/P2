import java.util.HashMap;
import java.util.Map;

/**
 * A Classe DocumentoController responsável por os documentos.
 * @author Iorran Santos de Lira
 */
public class DocumentoController {
    private Verificador verificador = new Verificador();
    private Map<String, Documento> documentos = new HashMap<>();

    /**
     * Cria um novo documento com o título e o tamanho máximo determinado, além de verificar o título.
     *
     * @param titulo o título do documento.
     * @param tamanho tamanho máximo do documento.
     * @return true se o documento foi criado.
     */
    public boolean criarDocumento(String titulo, int tamanho) {
        this.verificador.testaTitulo(titulo);

        Documento documento = new Documento(titulo, tamanho);
        documentos.put(titulo, documento);
        return true;
    }

    /**
     * Cria um novo documento com o título especificado e sem tamanho máximo determinado, além de verificar o título.
     *
     * @param titulo o título do documento.
     * @return true se o documento foi criado.
     */
    public boolean criarDocumento(String titulo) {
        this.verificador.testaTitulo(titulo);

        Documento documento = new Documento(titulo);
        documentos.put(titulo, documento);
        return true;
    }

    /**
     * Método que exclui um Documento com o título especificado do Map de Documentos, além de verificar o título.
     *
     * @param titulo o título do Documento a ser removido.
     */
    public void removerDocumento(String titulo) {
        this.verificador.testaTitulo(titulo);

        documentos.remove(titulo);
    }

    /**
     * Retorna a quantidade de Elementos no Documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento.
     * @return a quantidade de elementos no documento.
     */
    public int contarElementos(String titulo){
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento1 = documentos.get(titulo);
        return documento1.contaElementos();
    }

    /**
     * Apaga o Elemento na posição especificada no documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento.
     * @param posicao a posição do Elemento a ser apagado.
     * @return true se o Elemento foi apagado com sucesso, false se a posição do Elemento é inválida.
     */
    public boolean apagarElemento(String titulo, int posicao) {
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento1 = documentos.get(titulo);
        return documento1.apagarElemento(posicao-1);
    }

    /**
     * Move o elemento para cima no Documento com o título especificado.
     *
     * @param titulo o título do Documento.
     * @param posicao a posição do Elemento a ser movido para cima.
     */
    public void moverParaCima(String titulo,int posicao){
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento1 = documentos.get(titulo);
        documento1.moverParaCima(posicao);
    }

    /**
     * Move o Elemento para baixo no Documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento.
     * @param posicao a posição do Elemento a ser movido para baixo.
     */
    public void moverParaBaixo(String titulo,int posicao){
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento1 = documentos.get(titulo);
        documento1.moverParaBaixo(posicao);
    }

    /**
     * Retorna a representação do Documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento.
     * @return um Array de Strings que representa o Documento.
     */
    public String[] exibirDocumento(String titulo){
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento = documentos.get(titulo);
        return documento.representacao();
    }

    /**
     * Cria um Elemento de texto no Documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento.
     * @param valor o valor do Elemento.
     * @param prioridade a prioridade do Elemento.
     * @return o índice do Elemento criado.
     */
    public int criarTexto(String titulo, String valor, int prioridade) {
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento = documentos.get(titulo);
        Elemento elemento = new ElementoTexto(valor, prioridade);
        return documento.criarElemento(elemento);
    }

    /**
     * Cria um elemento de título no documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento.
     * @param valor o valor do Elemento.
     * @param prioridade a prioridade do Elemento.
     * @param nivel o nível do título.
     * @param linkavel indica se o título é linkável.
     * @return o índice do elemento criado.
     */
    public int criarTitulo(String titulo, String valor, int prioridade, int nivel, boolean linkavel) {
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento = documentos.get(titulo);
        Elemento elemento = new ElementoTitulo(valor, prioridade, nivel, linkavel);
        return documento.criarElemento(elemento);
    }

    /**
     * Cria um Elemento de Lista no Documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento.
     * @param valor o valor da Lista.
     * @param prioridade a prioridade do Elemento.
     * @param separador o separador dos itens da Lista.
     * @param charLista o caractere que representa a Lista.
     * @return o índice do Elemento criado.
     */
    public int criarLista(String titulo, String valor, int prioridade, String separador, String charLista) {
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento = documentos.get(titulo);
        Elemento elemento = new ElementoLista(valor, prioridade, separador, charLista);
        return documento.criarElemento(elemento);
    }

    /**
     * Cria um Elemento de termos no Documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento.
     * @param valor os termos separados por um separador espeficificado.
     * @param prioridade a prioridade do Elemento.
     * @param separador o separador dos Termos.
     * @param ordem a organização da ordem que os Termos serão apresentados.
     * @return o índice do Elemento criado.
     */
    public int criarTermos(String titulo, String valor, int prioridade, String separador, String ordem) {
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento = documentos.get(titulo);
        Elemento elemento = new ElementoTermos(valor, prioridade, separador, ordem);
        return documento.criarElemento(elemento);
    }

    /**
     * Retorna a Representação Resumida do Elemento na posição especificada no Documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento.
     * @param posicao a posição do Elemento.
     * @return a Representação Resumida do Elemento.
     */
    public String pegarRepresentacaoResumida(String titulo, int posicao) {
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento1 = documentos.get(titulo);
        return documento1.getRepresentacaoResumida(posicao);
    }

    /**
     * Retorna a Representação Completo do Elemento na posição especificada no Documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento.
     * @param posicao a posição do Elemento.
     * @return a Representação Completo do Elemento.
     */
    public String pegarRepresentacaoCompleta(String titulo, int posicao) {
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento1 = documentos.get(titulo);
        return documento1.getRepresentacaoCompleta(posicao);
    }

    /**
     * Cria um Atalho para o Documento com o título especificado, verificando o título e se o Documento já está cadastrado.
     *
     * @param titulo o título do Documento
     * @param tituloReferenciado o título do Documento de referência para o Atalho.
     * @return o índice do Atalho criado.
     */
    public int criarAtalho(String titulo, String tituloReferenciado) {
        this.verificador.testaTitulo(titulo);
        this.verificador.testaCadastro(documentos.containsKey(titulo));

        Documento documento1 = documentos.get(titulo);
        Documento documento2 = documentos.get(tituloReferenciado);
        Elemento documentoAtalho = documento2.serAtalho();
        return documento1.criarAtalho(documentoAtalho);
    }

    /**
     * Método Getter que pega um Documento a partir do seu titulo.
     * @param tituloDoc o titulo.
     * @return o Documento.
     */
    public Documento getDocumento (String tituloDoc) {
        return documentos.get(tituloDoc);
            }

}





