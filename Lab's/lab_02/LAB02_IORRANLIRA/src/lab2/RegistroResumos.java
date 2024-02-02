package lab2;

/**
 * Representação de um Registrador de Resumos, com caratér acadêmico, que armazena uma quantidade limitada de resumos,
 * acompanhada de temas e descrições referente ao assunto.
 *
 * @author Iorran Santos de Lira
 */
public class RegistroResumos {


    /**
     * Lista de String's onde será armazenado os temas do resumo.
     */
    private String[] listaTemas;

    /**
     * Lista de String's onde será armazenado os resumos e descrições do tema.
     */
    private String[] listaResumos;

    /**
    * Inteiro usado para guardar o números de resumos adicionados a Lista de Resumos.
     */
    private int meuNumeroDeResumos;
    /**
     * Variável usada para organizar as posições dos Arrays.
     */
    private int index;

    /**
     * Constrói os arrays para armazenar os resumos e os temas, definindo o tamanho com base
     * no número de resumos e iniciando com index igual a zero.
     *
     * @param numeroDeResumos número de resumos que serão armazenados nas listas.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.listaTemas = new String[numeroDeResumos];
        this.listaResumos = new String[numeroDeResumos];
        this.meuNumeroDeResumos = numeroDeResumos;
        this.index = 0;
    }

    /**
     * Método de adicionar um novo tema e um novo resumo a um array de temas e resumos.
     * Também está incrementando a variável controle de posição dos novos elementos.
     * Além de reiniciar a variável quando o tamanho máximo for atingido.
     *
     * @param tema Tema a ser adicionado ao array.
     * @param resumo Resumo a ser adicionado ao array.
     */
    public void adiciona(String tema, String resumo) {
        this.listaTemas[index] = tema;
        this.listaResumos[index] = ": " + resumo;
        this.index++;
        if (index >= listaResumos.length - 1) {
            index = 0;
        }
    }

    /**
     * Retorna um novo Array de Strings, com de tamanho similar aos outros.
     * Array que organiza todos os resumos e classes registrados.
     * Além de verificar valores nulls nas mesmas posições.
     * @return forma uma string de resumo completa.
     */
    public String[] pegaResumos() {
        String[] novaLista = new String[meuNumeroDeResumos];
        for (int i = 0; i < listaTemas.length; i++) {
            if ((listaTemas[i] != null) || (listaResumos[i] != null)) {
                novaLista[i] = listaTemas[i] + listaResumos[i];
            }
        }
            return novaLista;
    }

    /**
     * Método utilizado para contar a quantidade de resumos presentes nos arrays.
     * Além de verificar por valores nulls nas mesma posições.
     * @return retorna o número exato de resumos.
     */
        public int conta () {
            int contador = 0;
            for (int i = 0; i < listaResumos.length; i++) {
                if ((listaTemas[i] != null) || (listaResumos[i] != null)) {
                    contador++;
                }
            }
            return contador;
        }

    /**
     * Método que retorna uma String formatada contendo a quantidade de resumos cadastrados e
     * a lista de temas correspondentes verificando valores nulls e separando com "|".
     *
     * @return retorna a String formatada.
     */
            public String imprimeResumos () {
                String saida = "";
                for (int i = 0; i < listaTemas.length; i++) {
                    if (listaTemas[i] != null) {
                        saida += listaTemas[i] + " | ";
                    }
                }
                return  "- " + conta() + " resumo(s) cadastrado(s) \n" + "- " + saida.substring(0, saida.length()-3);
            }

    /**
     * Método booleano que verifica se um tema específico está presente no array de temas.
     *
     * @param tema String utilizada para caracterizar o tema específico.
     *
     * @return retorna true se o tema estiver na lista de temas.
     */
            public boolean temResumo (String tema){
                for (int i = 0; i < listaTemas.length; i++) {
                    if (listaTemas[i] == tema) {
                        return true;
                    }
                }
                        return false;
            }
        }