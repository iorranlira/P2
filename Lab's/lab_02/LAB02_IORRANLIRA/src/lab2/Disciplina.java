package lab2;
import java.util.ArrayList;
import java.util.List;

/**
 * Representação de um sistema que verifica as notas e o horário de estudo
 * de um determinado estudante.
 *
 * @author Iorran Santos de Lira
 */
public class Disciplina {

    /**
     * Variável inteira utilizada para contar as horas da disciplina.
     */
    private int contadorHoras;

    /**
     * String que guarda a qual é a disciplicina.
     */
    private String disciplina;

    /**
     *  Variável inteira utilizada para guardar qual é a nota.
     */
    private int qualProva;

    /**
     * Variável double utilizada para receber o valor de cada nota.
     */
    private double valordaNota;

    /**
     * Variável double utilizada para se calcular a media.
     */
    private double media;

    /**
     * Lista de Arrays que referentes ao valor de cada nota.
     */
    private List<Double> notas = new ArrayList<>();

    /**
     * Constrói o nome da Disciplina que será exposta.
     *
     * @param nomeDisciplina recebe uma String referente ao nome da máteria.
     */
    public Disciplina(String nomeDisciplina){
        this.disciplina = nomeDisciplina;

    }

    /**
     * Método utilizado para cadastrar horas a disciplina.
     *
     * @param horas quantidade de horas que será adicionada ao contador de horas.
     */
    public void cadastraHoras(int horas){
        contadorHoras += horas;
    }

    /**
     * Método utilizada para cadastrar qual é a nota, e o valor dessa nota.
     * Além de também adicionar o valor da nota a lista de Arrays e
     * calcular a média do aluno.
     *
     * @param nota qual é a nota que está sendo recebida.
     * @param valorNota qual é o valor dessa nota.
     */
    public void cadastraNota(int nota, double valorNota){
        this.qualProva = nota;
        this.valordaNota += valorNota;
        notas.add(valorNota);
        media = (valordaNota/4);
    }

    /**
     * Método booleano para verificar se o aluno foi aprovado ou não.
     * Paramêtro utilizado foi a média calculada. Se ela for maior ou igual a 7
     * o aluno está aprovado.
     *
     * @return retorna a condição do aluno.
     */
    public boolean aprovado( ) {
        if (media >= 7.0) {
            return true;
        }
            return false;
    }

    /**
     * Método que retorna uma String formatada contendo a Disciplicina analisada,
     * a quantidade de horas cadastradas, a média obtida e uma lista de Arrays
     * referentes aos valores das notas.
     *
     * @return retorna uma String formatada que expõe todos os parâmetros verificados.
     */
    @Override
    public String toString( ){
        return disciplina + " " + contadorHoras + " " + media + " " + notas;
    }
}
