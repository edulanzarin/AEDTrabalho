package project.core.exceptions;

/**
 * Exceção lançada quando uma operação que requer elementos na pilha é executada em uma pilha vazia.
 */
public class PilhaVaziaException extends RuntimeException {

    /**
     * Construtor que inicializa a exceção com uma mensagem padrão.
     */
    public PilhaVaziaException() {
        super("Pilha vazia.");
    }
}
