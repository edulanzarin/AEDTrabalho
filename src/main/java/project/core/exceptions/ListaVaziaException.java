package project.core.exceptions;

/**
 * Exceção lançada quando uma operação que requer elementos na lista é executada em uma lista vazia.
 */
public class ListaVaziaException extends RuntimeException {

    /**
     * Construtor que inicializa a exceção com uma mensagem padrão.
     */
    public ListaVaziaException() {
        super("A lista está vazia!");
    }
}
