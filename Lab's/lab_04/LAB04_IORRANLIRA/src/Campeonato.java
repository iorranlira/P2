import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe utilizada para a implementação de Campeonatos ao sistema.
 *
 * @author Iorran Santos de Lira
 */
public class Campeonato {
    private String nomeCampeonato;
    private int qtdParticipantes;
    private ArrayList<Time> listaTimes = new ArrayList<>();

    /**
     * Cria um Campeonato.
     *
     *
     * @param nomeCampeonato String que guarda o nome do campeonato a ser criado.
     * @param qtdParticipantes String que guarda a quantidade de participantes a esse campaoenato;
     */
    public Campeonato (String nomeCampeonato, int qtdParticipantes){
        this.nomeCampeonato = nomeCampeonato;
        this.qtdParticipantes = qtdParticipantes;
    }

    /**
     * Método Booleano para adicionar times ao ArrayList de times, recebe um Objeto Time como paramêtro e verifica em
     * relação a sua quantidade de participantes, se a condição for atendida o time é adicionado.
     *
     * @param time objeto time a ser instanciado.
     *
     * @return o resultado do método.
     */
    public boolean adicionaTime(Time time) {
        if (listaTimes.size() > qtdParticipantes) {
            return false;
        }
            listaTimes.add(time);
            return true;
    }

    /**
     * Método Booleano que verifica se um determinado time está presente no ArrayList de times, recebe um Objeto time como
     * parâmetro.
     *
     * @param time objeto time a ser instanciado.
     *
     * @return o resultado do método.
     */
    public boolean verificaTime(Time time) {
        if (listaTimes.contains(time)) {
            return true;
        }
            return false;
    }

    /**
     * Método ToString utilizado para formatação de Métodos da Classe Sistema.
     *
     * @return retorna uma String formatada.
     */
    public String toString() {
        return "* " + nomeCampeonato + " - " + (listaTimes.size()-1) + "/" + qtdParticipantes;
    }

    /**
     * Método ToString utilizada para formatação de Métodos Da Classe de Aposta.
     *
     * @return retorna uma String formada.
     */
    public String toString2(){
        return nomeCampeonato + "\n" + (listaTimes.size()-1) + "/" + qtdParticipantes;
    }

    /**
     * Método Get utilizado para retornar um int.
     *
     * @return retorna um int referente a quantidade de participantes.
     */
    public int getQtdParticipantes(){
        return qtdParticipantes;
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
        Campeonato that = (Campeonato) o;
        return Objects.equals(nomeCampeonato.toUpperCase(   ), that.nomeCampeonato.toUpperCase());
    }
    @Override
    public int hashCode() {
        return Objects.hash(nomeCampeonato);
    }
}
