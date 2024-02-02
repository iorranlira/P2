import java.util.*;
 /**
  * Classe Documento representando um Documento com um ArrayList de Elemento.
  * @author Iorran Santos de Lira
  */

public class Documento {
    private String titulo;
    private int tamanho;
    protected ArrayList<Elemento> elementos;


     /**
      * Construtor que cria um novo Documento com titulo e tamanho máximo.
      * @param titulo o titulo do Documento.
      * @param tamanho o tamanho do Documento.
      */
    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.elementos = new ArrayList<>(tamanho);
    }

     /**
      * Construtor que cria um novo Documento com titulo e sem tamanho máximo.
      * @param titulo o titulo do Documento.
      */

    public Documento(String titulo) {
        this.titulo = titulo;
        this.elementos = new ArrayList<>();
    }

     /**
      * Método que cria um Elemento qualquer e retorna um inteiro.
      * @param elemento representação de Elemento.
      * @return posição onde foi adicionado + 1.
      */
    public int criarElemento(Elemento elemento){
        elementos.add(elemento);
        return elementos.indexOf(elemento)+1;
    }

     /**
      * Método booleano de apagar um Elemento do ArrayList elementos pela posição.
      * @param posicao posição a ser acessada.
      * @return retorna false se a posição não for vazia.
      */
    public boolean apagarElemento(int posicao) {
        if (elementos.get(posicao) != null) {
            elementos.set(posicao, null);
            return true;
        }
            return false;
    }

     /**
      * Método de mover um Elemento para uma posição abaixo no ArrayList elementos.
      * @param posicao posição do Elemento a ser movido.
      */
    public void moverParaBaixo(int posicao){
        if (posicao+1 > contaElementos()) {
            throw new IndexOutOfBoundsException("Não tem elementos acima");
        }
        Collections.swap(elementos,posicao,posicao+1);
    }

     /**
      * * Método de mover um Elemento para uma posição acima no ArrayList elementos.
      * @param posicao posição do Elemento a ser movido.
      */
    public void moverParaCima(int posicao) {
        if (posicao - 1 > contaElementos()) {
            throw new IndexOutOfBoundsException("Não tem elementos abaixo");
        }
            Collections.swap(elementos, posicao, posicao-1);
        }

     /**
      * Método que conta a quantidade de Elementos.
      * @return quantidade de Elementos.
      */

    public int contaElementos() {
        if (elementos.isEmpty()) {
            return 0;
        }
        return elementos.size();
    }

     /** Método que retorna um ElementoAtalho para o Documento em consideração ser.
      *  @return retorna o DocumentoAtalho.
      */
    public Elemento serAtalho() {
        int soma = 0;
        for (Elemento elemento: elementos) {
            soma += elemento.getPrioridade();
        }
            int prioridade = soma/elementos.size();
            Elemento documentoAtalho = new ElementoAtalho(prioridade, titulo, representacaoCompleta(), representacaoResumida());
            return documentoAtalho;
    }

     /**
      * Método de criação de DocumentoAtalho que retorna um inteiro
      * @param documentoAtalho representação do Documento Atalho.
      * @return posição do Elemento adicionado a ao ArrayList de Elementos +1.
      */
    public int criarAtalho(Elemento documentoAtalho) {
        elementos.add(documentoAtalho);
        return elementos.indexOf(documentoAtalho)+1;
    }

     /**
      * Método Getter para pegar a Representação Resumida de um Elemento acessado pela sua posição.
      * @param posicao Utilizado para pegar a posição do Elemento no Array.
      * @return Representação Resumida do Elemento.
      */
    public String getRepresentacaoResumida(int posicao){
        return elementos.get(posicao-1).representacaoCompleta();
    }
     /**
      * Método Getter para pegar a Representação Completa de um Elemento acessado pela sua posição.
      * @param posicao Utilizado para pegar a posição do Elemento no Array.
      * @return Representação Completa do Elemento.
      */
     public String getRepresentacaoCompleta(int posicao){
        return elementos.get(posicao-1).representacaoResumida();
    }

     /**
      * Método que retorna um ArrayList de Elementos.
      * @return ArrayList de Elementos
      */
    public ArrayList<Elemento> getElementos() {
        return this.elementos;
    }


    /**
     * Retorna a representacao completa do atalho do tipo de documento.
     * @return representacao completa do elemento.
     */
    public String representacaoCompleta(){
        String retorno = "";
        for (Elemento elemento : elementos) {
            if (elemento.getPrioridade() > 3){
                retorno += elemento.representacaoCompleta() + "\n";
            }
        }       return retorno;
    }
    /**
     * Retorna a representacao resumida do atalho do tipo de documento.
     * @return representacao resumida do elemento.
     */
    public String representacaoResumida(){
        String retorno = "";
        for (Elemento elemento : elementos){
            if(elemento.getPrioridade() > 3){
                retorno += elemento.representacaoResumida() + "\n";
            }
        }       return retorno;
    }

     /**
      Retorna o ArrayList de Elementos com prioridade igual ou maior que a especificada.
      @param prioridade a prioridade mínima dos elementos.
      @return o ArrayList de Elementos com a prioridade especificada ou maior.
      */
    public ArrayList<String> listaElementosPrioridades(int prioridade) {
        ArrayList<String> elementosPrioridade = new ArrayList<>();
        for (Elemento elemento: elementos) {
            if (elemento.getPrioridade() >= prioridade) {
                String representacao = elemento.representacaoCompleta();
                elementosPrioridade.add(representacao);
            }
        }       return elementosPrioridade;
    }

     /**
      Retorna o ArrayList de Elementos do tipo DocumentoTitulo do Documento.
      @return a lista de elementos título.
      */
    public ArrayList<String> listaElementosTitulo() {
        ArrayList<String> elementosTitulo = new ArrayList<>();
        for (Elemento elemento: elementos) {
            if (elemento.eTitulo()) {
                elementosTitulo.add(elemento.representacaoResumida());
            }
        }       return elementosTitulo;
    }

     /**
      Retorna a representação dos elementos do Documento como um Array de Strings.
      @return a representação dos elementos do Documento.
      */
    public String[] representacao() {
        String[] s = new String[elementos.size()];
        int i = 0;
        for (Elemento elemento: elementos) {
            if (elemento != null) {
                s[i++] = elemento.toString();
            }
        }   return s;
    }

     /**
      * Método equals para comparar Documentos utilizando o seu titulo.
      * @param o parâmetro do método.
      * @return se são iguais ou não.
      */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Documento documento)) return false;
        return Objects.equals(titulo, documento.titulo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

}
