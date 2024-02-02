package lab2;

/**
 * Representação de uma classe que analisa o descanso de um determinado estudante.
 *
 * @author Iorran Santos de Lira
 */
public class Descanso {

    /**
     * Variável inteira utilizada para medir a quantidade de horas de descanso.
     */
    private int horasDescanso = 0;

    /**
     * Variável inteira utilizada para medir a quantidade de semanas.
     */
    private int numeroSemanas = 0;

    /**
     * Método utilizado para definir a quantidade de horas de descanso.
     *
     * @param valor define a quantidade de horas.
     */
    public void defineHorasDescanso(int valor) {
            horasDescanso = valor;
        }

    /**
     *  Método utilizado para definir a quantidade de semanas.
     *
     * @param valor define a quantidade de semanas.
     */
    public void defineNumeroSemanas(int valor) {
            numeroSemanas = valor;

    }

    /**
     * Método utilizada para retornar se o estudante está cansado ou descansado
     * baseado na premissa que o aluno deve descansar 26 horas por semana ou mais.
     * Se o aluno descansou mais de 26 horas semais ele está descansado.
     *
     * @return retorna a condição do aluno.
     */
    public String getStatusGeral(){
        if (horasDescanso == 0 || numeroSemanas == 0){
            return "cansado";
        }
        if ((horasDescanso/numeroSemanas) >= 26){
            return "descansado";
        }
            return "cansado";
    }
}