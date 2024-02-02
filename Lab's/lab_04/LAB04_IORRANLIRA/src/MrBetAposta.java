/**
 * Classe utilizada para a implementação de Apostas ao sistema.
 *
 * @author Iorran Santos de Lira
 */
public class MrBetAposta {
    private int colocacao;
    private double valorAposta;
    private Campeonato campeonato;
    private Time time;

    /**
     * Cria uma aposta
     *
     * @param time Objeto time da classe Time.
     * @param campeonato Objeto campeonato da classe Campeonato.
     * @param colocacao int colocação da aposta.
     * @param valorAposta double valor da aposta.
     */
    public MrBetAposta(Time time, Campeonato campeonato, int colocacao, double valorAposta){
        this.time = time;
        this.campeonato = campeonato;
        this.colocacao = colocacao;
        this.valorAposta = valorAposta;
    }

    /**
     * Método ToString utilizado para formatação do Método na Classe de Sistema.
     *
     * @return retorna String formatada.
     */
    public String apostaToString(){
       return  time.recuperaTimeToString() + "\n"
                + campeonato.toString2() + "\n"
                + "R$ " + valorAposta;
    }
}

