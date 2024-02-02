package agenda;

import java.util.Objects;

/**
 * Classe Contato utilizada para implementação do programa.
 */

public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;

    /**
     * Cria um contato
     *
     * @param nome Nome do contato
     * @param sobrenome Sobrenome do contato
     * @param telefone Telefone do contato
     */

    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    /**
     * Método para pegar apenas a String nome do contato.
     *
     * @return String nome
     */

    public String getNome() {
        return nome;
    }

    /**
     * Método para pegar apenas a String Sobrenome do contato.
     *
     * @return String Sobrenome
     */

    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Método toString utilizado para retornar o Contato.
     *
     * @return Contato todos os dados do contato
     */
    public String toString(){
        return nome + " " + sobrenome + "\n" + telefone;
    }

    /**
     * Método toString utilizado para retornar o Contato.
     *
     * @return Contato nome e sobrenome do contato
     */

    public String nomeSobrenome() {
        return nome + " " + sobrenome;
    }

    /**
     * Método toString utilizado para retornar o contato quando o mesmo é favoritado.
     *
     * @return Contato Favoritado todos os dados do contato com um emoji coração.
     */

    public String nomeSobrenomeFavorito() {
        return "❤️ " + nome + " " + sobrenome + "\n" + telefone;
    }

    /**
     * Método Equals utilizado para comparar se o nome e o sobrenome são iguals.
     *
     * @param o Objeto
     * @return True ou False
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        return Objects.equals(getNome(), contato.getNome()) && Objects.equals(getSobrenome(), contato.getSobrenome());
    }

    /**
     * Método HashCode utilizado para comparar se o nome e o sobrenome são iguals.
     *
     * @return True ou False
     */

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getSobrenome());
    }
}

