import java.util.NoSuchElementException;

/**
 * Classe verificadora utilizada em DocumentoController.
 * @author Iorran Santos de Lira
 */
public class Verificador {
    /**
     * Método que testa o título.
     * @param titulo o titulo.
     */
    public void testaTitulo(String titulo) {
        if (titulo.isBlank() || titulo.isEmpty()) {
            throw new IllegalArgumentException("título inválido");
        }
    }

    /**
     * Método que testa se o Documento está cadastrado.
     * @param teste booleano, true se o Documento estiver cadastrado.
     */
    public void testaCadastro(Boolean teste) {
        if (!teste) {
            throw new NoSuchElementException("documento não cadastrado");
        }
    }

}
