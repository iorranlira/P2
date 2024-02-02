import java.util.Objects;

/**
 * Classe utilizada para a implementação de Times ao sistema.
 *
 * @author Iorran Santos de Lira
 */
public class Time {
    private String id;
    private String nome;
    private String mascote;


    /**
     * Cria um Time.
     *
     * @param id String que guarda o identificador do time.
     * @param nome String que guarda o nome do time.
     * @param mascote String que guarda o mascote.
     */
    public Time (String id, String nome, String mascote){
        this.id = id;
        this.nome = nome;
        this.mascote = mascote;
    }

    /**
     * Método ToString utilizado para formatação do Método na Classe de Aposta e de Sistema.
     *
     * @return retorna String formatada.
     */
    public String recuperaTimeToString(){
        return "[" + id + "]" + " " + nome + " / " + mascote;
    }

    /**
     * Método ToString utilizado para formatação do Método na Classe de Sistema.
     *
     * @return retorna String formatada.
     */
    public String exibeToString(){
        return "Campeonatos do " + nome + ":";

}

    /**
     * Métodos Equals e HashCode.
     *
     * @param o objeto a ser verificado.
     *
     * @return retorna resultado da verificação.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(id, time.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
