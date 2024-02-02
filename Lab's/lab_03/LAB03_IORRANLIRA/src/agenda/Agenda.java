package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_AGENDA_FAV = 10;
	private Contato[] contatos; //apenas uma simplificacao de contato
	private Contato[] listaDeFavoritos; //apenas uma simplificacao de favoritos

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.listaDeFavoritos = new Contato[TAMANHO_AGENDA_FAV];
	}

	/**
	 * Acessa a lista de contatos mantida.
	 *
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	public Contato[] getFavoritos() {
		return this.listaDeFavoritos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 *
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao - 1];

	}

	public Contato getFavoritos(int posicaoFav) {
		return listaDeFavoritos[posicaoFav - 1];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 *
	 * @param posicao   Posição do contato.
	 * @param nome      Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone  Telefone do contato.
	 */

	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if ((posicao < 1 || posicao > 100)) {
			return "POSIÇÃO INVÁLIDA";
		}
		Contato contatoNovo = new Contato(nome, sobrenome, telefone);
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				if (contatoNovo.equals(contatos[i])) {
					return "CONTATO JA CADASTRADO";
				}
			}
		}
		if (nome.length() == 0) {
			return "CONTATO INVALIDO";
		}
		if (telefone.length() == 0) {
			return "CONTATO INVALIDO";
		}
		this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
		return "CADASTRO REALIZADO";
	}

	/**
	* Exibe um contato cadastrado.
	*
	* @param posicao Posição do contato a ser exibido.
	 * @return retorna o contato da posição.
	 */

	public String exibeContato(int posicao) {
		if ((posicao < 1 || posicao > 100)) {
			return "POSIÇÃO INVÁLIDA";
		}
		if (contatos[posicao - 1] == null) {
			return "POSIÇÃO INVÁLIDA!";
		}
		for (int i = 0; i < listaDeFavoritos.length; i++) {
			if (contatos[i] != null) {
				if (contatos[posicao - 1].equals(listaDeFavoritos[i])) {
					return contatos[posicao - 1].nomeSobrenomeFavorito();
				}
			}
		}
		return contatos[posicao - 1].toString();
	}

	/**
	 * Adiciona um contato já cadastrado a uma lista de favoritos.
	 *
	 * @param posicao Posição do contato já cadastrado.
	 * @param posicaoFav Posição na lista de favoritos onde será adicionado o contato.
	 * @return Contato Favoritado Retorna uma mensagem de sucesso.
	 */

	public String cadastraFav(int posicao, int posicaoFav) {
		if ((posicaoFav < 1 || posicaoFav > 10)) {
			return "POSIÇÃO INVÁLIDA";
		}
		for (int i = 0; i < listaDeFavoritos.length; i++) {
				if (contatos[posicao - 1] == null) {
					return "POSIÇÃO INVÁLIDA";
				}
				if (listaDeFavoritos[i] != null) {
					if (contatos[posicao - 1].equals(listaDeFavoritos[i])) {
						return "CONTATO JÁ CADASTRADO";
					}
				}
			}
		this.listaDeFavoritos[posicaoFav - 1] = contatos[posicao - 1];
		return "CONTATO FAVORITADO NA POSIÇÃO " + posicaoFav + "!";
	}

	/**
	 * Exibe a Lista de Favoritos.
	 *
	 * @param posicaoFav Posição da lista onde o contato esta favoritado.
	 * @return listaDeFavoritos Retorna a lista com todos os contatos favoritados.
	 */

	public String listaFav(int posicaoFav) {
		if ((posicaoFav < 1 || posicaoFav > 10)) {
			return "POSIÇÃO INVÁLIDA";
		}
		if (listaDeFavoritos[posicaoFav - 1] == null) {
			return "NENHUM CONTATO FAVORITADO NA POSIÇÃO!";
		}
		return listaDeFavoritos[posicaoFav - 1].nomeSobrenome();
	}

	/**
	 * Remove um contato da Lista de Favoritos.
	 *
	 * @param posicaoFav Posição do contato na lista a ser removido.
	 * @return String vazia Retorna para o menu
	 */

	public String removeFav(int posicaoFav) {
		if ((posicaoFav < 1 || posicaoFav > 10)) {
			return "POSIÇÃO INVÁLIDA";
		}
		if (listaDeFavoritos[posicaoFav - 1] != null){
			this.listaDeFavoritos[posicaoFav - 1] = null;
			return "";
		}
			return "NENHUM CONTATO FAVORITADO NA POSIÇÃO!";
	}
}

