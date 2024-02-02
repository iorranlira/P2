import java.util.*;

/**
 * SubClasse de ElementoTitulo que herda de Elemento.
 * @author Iorran Santos de Lira
 */
public class ElementoTitulo extends Elemento {

    /**
     * Cria um ElementoTitulo com valor, prioridade, nivel e linkavel.
     * @param valor o valor do Elemento.
     * @param prioridade a prioridade do Elemento.
     * @param nivel o nivel do Elemento.
     * @param linkavel se o elemento é linkável ou não.
     */
    public ElementoTitulo(String valor, int prioridade, int nivel, boolean linkavel){
        super(prioridade,valor);
        String nivelString = Integer.toString(nivel);
        String linkavelString = Boolean.toString(linkavel);
        propriedades.put("nivel", nivelString);
        propriedades.put("linkavel", linkavelString);

    }

    /**
     * Método Sobrescrito para verificar se é Titulo.
     * @return retorna verdade se for.
     */
    @Override
        public boolean eTitulo() {
        return true;
    }

    /**
     * Método Sobrescrito de uma Representação Completa.
     * @return Representação Completa.
     */
    @Override
    public String representacaoCompleta(){
        return getNivel() + ". " + getValor() + " -- " + getNivel() + "-" + getValor().replaceAll("\\s","").toUpperCase();
    }

    /**
     * Método Sobrescrito de uma Representação Resumida.
     * @return Representação Resumida.
     */
    @Override
    public String representacaoResumida(){
        return getNivel() + ". " + getValor();
    }

    /**
     * Método Getter para pegar o nivel do Elemento.
     * @return o nivel do Elemento.
     */
    public String getNivel(){
        return propriedades.get("nivel");
    }

}

