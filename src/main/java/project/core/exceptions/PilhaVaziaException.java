package project.core.exceptions;

public class PilhaVaziaException extends RuntimeException {
    
    public PilhaVaziaException() {
        super("Pilha vazia.");
    }
}
