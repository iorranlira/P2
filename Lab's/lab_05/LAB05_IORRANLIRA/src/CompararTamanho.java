import java.util.Comparator;

/**
 * Classe comparate feita para comparar o tamanho de duas palavras.
 * @author Iorran Santos de Lira
 */
public class CompararTamanho implements Comparator<String> {

    /**
     * Método que compara.
     * @param palavra1 primeira palavra a ser comparada.
     * @param palavra2 segunda palavra a ser comparada.
     * @return comparação.
     */
    public int compare(String palavra1, String palavra2){
        return Integer.compare(palavra2.length(), palavra1.length());
        }
    }

