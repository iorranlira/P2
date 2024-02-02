package lab2;

/**
 * Representação de uma classe que Registra o tempo online de um determinado estudante.
 *
 * @Author Iorran Santos de Lira
 */
public class RegistroTempoOnline {
    /**
     * String utilizada para guardar o nome da disciplina a ser analisada.
     */
    private String nomeDisciplina;

    /**
     * Variável inteira que representa o tempo online.
     */
    private int tempoOnline;

    /**
     * Variável inteira que representa o tempo esperado.
     */
    private int tempoEsperado;

    /**
     * Construtor que atribui o nome da disciplina.
     * O tempo esperado padrão é definido como 120 horas.
     *
     * @param nomeDisciplina recebe o nome da disciplina.
     */
    public RegistroTempoOnline (String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        tempoEsperado = 120;
    }

    /**
     * Construtor que recebe o nome da disciplina e o tempo esperado de uso online para essa disciplina.
     * Além de atribuir valor as variáveis correspondentes.
     *
     * @param nomeDisciplina recebe o nome da disciplina.
     * @param tempoOnlineEsperado recebe o tempo online esperado para a disciplina.
     */
    public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoOnlineEsperado;
    }

    /**
     * Método que adiciona o tempo online.
     *
     * @param tempo quantidade de tempo online.
     */
    public void adicionaTempoOnline(int tempo){
        tempoOnline += tempo;
    }

    /**
     * Método Booleano utilizado para verificar se o aluno atingiu ou não o tempo esperado
     * da disciplina.
     * Caso o tempo online seja maior ou igual o tempo esperado, o aluno cumpre a condição.
     *
     * @return retorna a condição do aluno.
     */
    public boolean atingiuMetaTempoOnline(){
        if (tempoOnline >=  tempoEsperado){
            return true;
        }
            return false;
    }

    /**
     * Método que retorna uma String formatada referente as parâmetros utilizados.
     *
     * @return retorna qual é disciplicina analisada, além do tempo online obtido pelo estudando
     * e qual é o tempo esperado pra essa disciplina especifica.
     */
    @Override
    public String toString(){
        return nomeDisciplina + " " + tempoOnline + "/" + tempoEsperado;
    }
}
