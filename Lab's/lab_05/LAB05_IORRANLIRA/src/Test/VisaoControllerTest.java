import org.junit.Test;


import static org.junit.Assert.*;

public class VisaoControllerTest {
    DocumentoController documentoController = new DocumentoController();
    VisaoController visaoController = new VisaoController(documentoController);

    @Test
    public void criarVisaoCompleta() {
        assertEquals(visaoController.criarVisaoCompleta("Titulo"),0);
    }

    @Test
    public void criarVisaoResumida() {
        assertEquals(visaoController.criarVisaoResumida("Titulo"),0);
    }

    @Test
    public void criarVisaoPrioritaria() {
        assertEquals(visaoController.criarVisaoPrioritaria("Titulo",3),0);
    }

    @Test
    public void criarVisaoTitulo() {
        assertEquals(visaoController.criarVisaoTitulo("Titulo"),0);
    }

}