
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class DocumentoControllerTest {
    DocumentoController documentoController = new DocumentoController();

    @Test
    public void criarDocumento01() {
     assertTrue(documentoController.criarDocumento("Titulo",10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void criarDocumento02() {
        documentoController.criarDocumento("",10);
    }

    @Test
    public void CriarDocumento01() {
        assertTrue(documentoController.criarDocumento("Titulo"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void CriarDocumento02() {
        documentoController.criarDocumento("");
    }

    @Test
    public void removerDocumento01() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.removerDocumento("Titulo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void removerDocumento02() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.removerDocumento("");
    }

    @Test
    public void contarElementos01() {
        documentoController.criarDocumento("Titulo",10);
        assertEquals(documentoController.contarElementos("Titulo"),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void contarElementos02() {
        documentoController.criarDocumento("Titulo",10);
        assertEquals(documentoController.contarElementos(""),0);
    }

    @Test
    public void apagarElemento01() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarTexto("Titulo","Test test",3);
        assertTrue(documentoController.apagarElemento("Titulo",1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void apagarElemento02() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarTexto("Titulo","Test test",3);
        documentoController.apagarElemento("",1);
    }

    @Test(expected = NoSuchElementException.class)
    public void apagarElemento03() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarTexto("Titulo","Test test",3);
        documentoController.apagarElemento("Titulo2",1);
    }

    @Test
    public void exibirDocumento01() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.exibirDocumento("Titulo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void exibirDocumento02() {
        documentoController.exibirDocumento("");
    }

    @Test(expected = NoSuchElementException.class)
    public void exibirDocumento03() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.exibirDocumento("Titulo2");
    }

    @Test
    public void criarTitulo01() {
        documentoController.criarDocumento("Titulo",10);
        assertEquals(documentoController.criarTitulo("Titulo","Test test",3,3,true), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void criarTitulo02() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarTitulo("","Test test",3,3,true);
    }

    @Test(expected = NoSuchElementException.class)
    public void criarTitulo03() {
        documentoController.criarTitulo("Titulo","Test test",3,3,true);
        documentoController.criarTitulo("Titulo2","Test test",3,3,true);
    }

    @Test
    public void criarTexto01() {
        documentoController.criarDocumento("Titulo",10);
        assertEquals(documentoController.criarTexto("Titulo","Test test",3),1);
    }

   @Test(expected = IllegalArgumentException.class)
    public void criarTexto02() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarTexto("","Test test",3);
    }

    @Test(expected = NoSuchElementException.class)
    public void criarTexto03() {
        documentoController.criarTexto("Titulo","Test test",3);
    }

    @Test
    public void criarLista01() {
        documentoController.criarDocumento("Titulo",10);
        assertEquals(documentoController.criarLista("Titulo","Test test",3,"/","-"),1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void criarLista02() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarLista("","Test test",3,"/","-");
    }


    @Test(expected = NoSuchElementException.class)
    public void criarLista03() {
        documentoController.criarLista("Titulo","Test test",3,"/","-");
    }

    @Test
    public void criarTermos01() {
        documentoController.criarDocumento("Titulo",10);
        assertEquals(documentoController.criarTermos("Titulo","Test test",3,"|","NENHUMA"),1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void criarTermos02() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarTermos("","Test test",3,"|","NENHUMA");
    }

    @Test(expected = NoSuchElementException.class)
    public void criarTermos03() {
        documentoController.criarTermos("Titulo","Test test",3,"|","NENHUMA");
    }

    @Test
    public void pegarRepresentacaoResumida01() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarTermos("Titulo","Test test",3,"|","NENHUMA");
        documentoController.pegarRepresentacaoResumida("Titulo",1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void pegarRepresentacaoResumida02() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarTermos("","Test test",3,"|","NENHUMA");
        documentoController.pegarRepresentacaoResumida("",1);
    }

    @Test(expected = NoSuchElementException.class)
    public void pegarRepresentacaoResumida03() {
        documentoController.pegarRepresentacaoResumida("Titulo",1);
    }

    @Test
    public void pegarRepresentacaoCompleta01() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarTermos("Titulo","Test test",3,"|","NENHUMA");
        documentoController.pegarRepresentacaoCompleta("Titulo",1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pegarRepresentacaoCompleta02() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarTermos("","Test test",3,"|","NENHUMA");
        documentoController.pegarRepresentacaoCompleta("",1);
    }

    @Test(expected = NoSuchElementException.class)
    public void pegarRepresentacaoCompleta03() {
        documentoController.pegarRepresentacaoCompleta("Titulo",1);
    }

    @Test
    public void criarAtalho01() {
        documentoController.criarDocumento("Titulo",10);
        documentoController.criarDocumento("Titulo2",10);
        documentoController.criarTermos("Titulo","Test test",3,"|","NENHUMA");
        documentoController.criarTermos("Titulo2","Test test",3,"|","NENHUMA");
        assertEquals(documentoController.criarAtalho("Titulo","Titulo2"),2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void criarAtalho02() {
        documentoController.criarDocumento("Titulo", 10);
        documentoController.criarTermos("", "Test test", 3, "|", "NENHUMA");
        documentoController.criarAtalho("","Titulo2");
    }
    @Test(expected = NoSuchElementException.class)
    public void criarAtalho03() {
        documentoController.criarAtalho("Titulo","Titulo2");
        documentoController.criarAtalho("Titulo","Titulo2");
    }
}