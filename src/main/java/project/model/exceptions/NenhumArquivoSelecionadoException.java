package project.model.exceptions;

/**
 * Exceção lançada quando nenhum arquivo foi selecionado para uma operação que requer um arquivo.
 */
public class NenhumArquivoSelecionadoException extends RuntimeException {

    /**
     * Constrói uma nova exceção com uma mensagem padrão.
     */
    public NenhumArquivoSelecionadoException() {
        super("Nenhum arquivo selecionado.");
    }

    /**
     * Constrói uma nova exceção com uma mensagem especificada.
     *
     * @param mensagem a mensagem detalhada.
     */
    public NenhumArquivoSelecionadoException(String mensagem) {
        super(mensagem);
    }
}
