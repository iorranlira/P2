package agenda;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContatoTest {

    private Contato contatoBase;
    Agenda agenda = new Agenda();
    Contato contato = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");

    @Test
    void testCadastraContato01() {
        String msg = "Era pra dar Cadastrado com sucesso";
        assertEquals("CADASTRO REALIZADO", agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000"), msg);
    }

    @Test
    void testCadastraContato02() {
        String msg = "Era pra dar Cadastrado com sucesso";
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("CADASTRO REALIZADO", agenda.cadastraContato(1, "Pedro", "Silva", "(84) 98888-1111"), msg);
    }

    @Test
    void testCadastraContato03() {
        String msg = "tem que dar CONTATO JA CADASTRADO";
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("CONTATO JA CADASTRADO", agenda.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-0000"), msg);
    }

    @Test
    void testCadastraContato04() {
        String msg = "Era pra dar Cadastrado com sucesso";
        assertEquals("CADASTRO REALIZADO", agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000"), msg);
    }

    @Test
    void testCadastraContato05() {
        String msg = "Era pra dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA", agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000"), msg);
    }

    @Test
    void testCadastraContato06() {
        String msg = "Era pra dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA", agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000"), msg);
    }

    @Test
    void testCadastraContato07() {
        String msg = "Era pra dar CONTATO INVALIDO";
        assertEquals("CONTATO INVALIDO", agenda.cadastraContato(1, "Matheus", "Gaudencio", ""), msg);
    }

    @Test
    void testCadastraContato08() {
        String msg = "Era pra dar CONTATO INVALIDO";
        assertEquals("CONTATO INVALIDO", agenda.cadastraContato(1, "", "Gaudencio", "(83) 99999-0000"), msg);
    }

    @Test
    void testExibeContato01() {
        String msg = "Tem que dar nome + sobrenome + /n + telefone";
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("Matheus Gaudencio\n" + "(83) 99999-0000", agenda.exibeContato(1), msg);
    }

    @Test
    void testExibeContato02() {
        String msg = "Tem que dar nome + sobrenome";
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("Matheus Gaudencio", contato.nomeSobrenome(), msg);
    }

    @Test
    void testExibeContato03() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA!";
        assertEquals("POSIÇÃO INVÁLIDA!", agenda.exibeContato(100), msg);
    }

    @Test
    void testExibeContato04() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA", agenda.exibeContato(0), msg);
    }

    @Test
    void testExibeContato05() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA", agenda.exibeContato(101), msg);
    }

    @Test
    void testExibeContato06() {
        String msg = "Tem que dar o contato favoritado";
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        agenda.cadastraFav(1, 1);
        assertEquals("❤️ Matheus Gaudencio\n(83) 99999-0000", agenda.exibeContato(1), msg);

    }

    @Test
    void testCadastraFav01() {
        String msg = "Tem que dar CONTATO FAVORITADO";
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("CONTATO FAVORITADO NA POSIÇÃO 1!", agenda.cadastraFav(1,1) ,msg);
    }

    @Test
    void testCadastraFav02() {
        String msg = "Tem que dar Contato favoritado + posicao";
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("CONTATO FAVORITADO NA POSIÇÃO 10!", agenda.cadastraFav(1,10) ,msg);
    }

    @Test
    void testCadastraFav03() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA";
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("POSIÇÃO INVÁLIDA", agenda.cadastraFav(1,0), msg);
    }

    @Test
    void testCadastraFav04() {
        String msg = "Tem que dar Contato já cadastrado";
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        agenda.cadastraFav(1,1);
        assertEquals("CONTATO JÁ CADASTRADO", agenda.cadastraFav(1,2) ,msg);
    }

    @Test
    void testCadastraFav05() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA",agenda.cadastraFav(97,1) ,msg);
    }

    @Test
    void testCadastraFav06() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA", agenda.cadastraFav(1,11), msg);
    }

    @Test
    void testCadastraFav07() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA", agenda.cadastraFav(1, 0), msg);
    }

    @Test
    void testListaFav01() {
        String msg = "tem que dar nome + sobrenome do contato 1";
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        agenda.cadastraFav(1,1);
        assertEquals("Matheus Gaudencio", agenda.listaFav(1), msg);
    }

    @Test
    void testListaFav02() {
        String msg = "tem que dar nome + sobrenome do contato 10";
        agenda.cadastraContato(10, "Erik", "Diniz", "3333-555");
        agenda.cadastraFav(10, 10);
        assertEquals("Erik Diniz", agenda.listaFav(10), msg);
    }

    @Test
    void testListaFav03() {
        String msg = "tem que DAR NENHUM CONTATO FAVORITADO NA POSIÇÃO!";
        assertEquals("NENHUM CONTATO FAVORITADO NA POSIÇÃO!", agenda.listaFav(2), msg);
    }

    @Test
    void testListaFav04() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA", agenda.listaFav(11) ,msg);
    }

    @Test
    void testListaFav05() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA", agenda.listaFav(0) ,msg);
    }

    @Test
    void testRemoveFav01() {
        String msg = "Tem que dar string vazio";
        agenda.cadastraContato(1, "Erik", "Diniz", "3333-555");
        agenda.cadastraFav(1,1);
        assertEquals("", agenda.removeFav(1), msg);
    }

    @Test
    void testRemoveFav02() {
        String msg = "Tem que dar ''";
        agenda.cadastraContato(1, "Erik", "Diniz", "3333-555");
        agenda.cadastraFav(1,10);
        assertEquals("", agenda.removeFav(10), msg);
    }

    @Test
    void testRemoveFav03() {
        String msg = "Tem que dar NENHUM CONTATO FAVORITADO NA POSIÇÃO!";
        assertEquals("NENHUM CONTATO FAVORITADO NA POSIÇÃO!", agenda.removeFav(1), msg);
    }

    @Test
    void testRemoveFav04() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA", agenda.removeFav(0) ,msg);
    }

    @Test
    void testRemoveFav05() {
        String msg = "Tem que dar POSIÇÃO INVÁLIDA";
        assertEquals("POSIÇÃO INVÁLIDA", agenda.removeFav(11) ,msg);
    }
}