import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe utilizada para a implementação do sistema.
 *
 * @author Iorran Santos de Lira
 */
public class MrBetSistema {
    private HashMap<String, Time> times = new HashMap();
    private HashMap<String, Campeonato> campeonatos = new HashMap();
    private ArrayList<MrBetAposta> listaApostas = new ArrayList<>();

    /**
     * Método de adicionar times ao HashMap times, recebe três Strings como parâmetro,
     * se utiliza de verificadores de identificador e caracteres de entrada.
     *
     @param id String de identificação/chave.
     @param nome String que guarda o nome do time.
     @param mascote String que guarda o nome do mascote.

     @return retorna status do cadastro.
     */
    public String adicionaTimes(String id, String nome, String mascote) {
        if (times.containsKey(id.toLowerCase())) {
            return "TIME JÁ EXISTE!";
        }
        Time time = new Time(id, nome, mascote);
        times.put(id.toLowerCase(), time);
        return "INCLUSÃO REALIZADA!";
    }


    /**
     * Método de consulta de times, recebe o identificador como parâmetro everifica
     * se o time está cadastrado no HashMap de times.
     *
     * @param id String de identificação/chave.
     *
     * @return retorna status da consulta.
     */
    public String consultaTimes(String id) {
        if (times.containsKey(id.toLowerCase())) {
            return times.get(id).recuperaTimeToString();
        }
        return "TIME NÃO EXISTE!";
    }

    /**
     * Método de cria campeonatos, recebe uma String e um int de parâmetro, antes de adicionar o Campeonato ao HashMap
     * de campeonatos, verifica se o Campeonato já existe.
     *
     * @param nomeCampeonato String de identificação/chave.
     * @param qtdParticipantes int que guarda a quantidades de participantes.
     *
     * @return retorna status da adição.
     *
     */    public String adicionaCampeonato(String nomeCampeonato, int qtdParticipantes) {
        if (campeonatos.containsKey(nomeCampeonato.toLowerCase())){
            return "CAMPEONATO JÁ EXISTE!";
        }
            Campeonato campeonato = new Campeonato(nomeCampeonato, qtdParticipantes);
            campeonatos.put(nomeCampeonato.toLowerCase(), campeonato);
            return "CAMPEONATO ADICIONADO!";
     }

    /**
     * Método que adiciona times a um Campeonato, recebe duas Strings de parâmetro, utilizasse dois métodos Get para
     * puxar os dois Objetos, ocorre uma série de Métodos Verificadores em relação a ambos.
     *
     * @param id String de identificação/chave de Time.
     * @param nomeCampeonato String de identificação/chave de Campeonato.
     *
     * @return retorna status da inclusão.
     */
    public String incluirTimeEmCampeonato(String id, String nomeCampeonato) {
        Campeonato campeonato = campeonatos.get(nomeCampeonato.toLowerCase());
        Time time = times.get(id.toLowerCase());

        if (!times.containsKey(id.toLowerCase())) {
            return "TIME NÃO EXISTE!";
        }
        if (!campeonatos.containsKey(nomeCampeonato.toLowerCase())) {
            return "CAMPEONATO NÃO EXISTE!";
        }
        if (!campeonato.adicionaTime(time)) {
            return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
        }
            campeonato.adicionaTime(time);
            return "TIME INCLUÍDO NO CAMPEONATO!";
    }

    /**
     * Método que verifica se um Time está em um Campeonato, recebe duas Strings como parâmetro e dois métodos Get que
     * puxam dois Objetos referentes as classes do programa.
     *
     * @param id String de identificação/chave de Time.
     * @param nomeCampeonato String de identificação/chave de Campeonato.
     *
     * @return retorna status da verificação.
     */
    public String verificarTimeEmCampeonato(String id, String nomeCampeonato) {
        Campeonato campeonato = campeonatos.get(nomeCampeonato.toLowerCase());
        Time time = times.get(id.toLowerCase());

        if (!times.containsKey(id.toLowerCase())) {
            return "TIME NÃO EXISTE!";
        }
        if (!campeonatos.containsKey(nomeCampeonato.toLowerCase())) {
            return "CAMPEONATO NÃO EXISTE!";
        }
        if (!campeonato.verificaTime(time)) {
            return "O TIME NÃO ESTÁ NO CAMPEONATO!";
        }
            return "O TIME ESTÁ NO CAMPEONATO!";
    }


    /**
     * Método de exibir Campeonatos que recebe uma String como parâmetro e um método Get que puxa um Objeto, verificasse
     * em relação ao objeto e aos caracteres de entrada, utilizasse de dois métodos ToString para formatação.
     *
     *
     * @param id String de identificação/chave de Time.
     * @return retorna os Campeonatos que um time participa no modelo solicitado.
     */
    public String exibeCampeonato(String id) {
        Time time = times.get(id.toLowerCase());
        if (!times.containsKey(id.toLowerCase())) {
            return "Time não cadastrado no sistema";
        }
        String saida = time.exibeToString();
        for (Campeonato chave : campeonatos.values()) {
            saida += "\n" + chave.toString();
        }
            return saida;

    }

    /**
     * Método de adicionar uma Aposta ao ArrayList de apostas, recebesse dois Strings, um int e um double como parâmetro,
     * Dois métodos Gets para puxar Objetos e um método da Classe Aposta para adição direta ao Array.
     *
     * @param id String de identificação/chave de Time.
     * @param nomeCampeonato String de identificação/chave de Campeonato.
     * @param colocacao int da colocação da aposta.
     * @param valorAposta double valor da aposta
     *
     * @return retorna status da aposta.
     */
    public String tentaSorte(String id, String nomeCampeonato, int colocacao, double valorAposta) {
        Time time = times.get(id.toLowerCase());
        Campeonato campeonato = campeonatos.get(nomeCampeonato.toLowerCase());
        MrBetAposta aposta = new MrBetAposta(time, campeonato, colocacao, valorAposta);

        if (colocacao > campeonato.getQtdParticipantes()) {
            return "APOSTA NÃO REGISTRADA!";
        }
        if (!times.containsKey(id.toLowerCase())) {
            return "TIME NÃO EXISTE!";
        }
        if (!campeonatos.containsKey(nomeCampeonato.toLowerCase())) {
            return "CAMPEONATO NÃO EXISTE!";
        }
            listaApostas.add(aposta);
            return "APOSTA REGISTRADA!";
    }

    /**
     * Método que mostra todas as apostas cadastradas, não recebe nenhum parâmetro, contém uma String e um for que varre
     * a lista de apostas e concatena um método ToString a String criada.
     *
     *
     * @return retorna todas as apostas formatas.
     */

    public String statusAposta (){
         String apostaSTR = "Apostas: \n";
        for(int i = 0;  i < listaApostas.size(); i++){
             apostaSTR += i+1 + ". " + listaApostas.get(i).apostaToString();
            }
        return apostaSTR;
}
}
