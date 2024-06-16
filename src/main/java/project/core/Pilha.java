package project.core;

/**
 * Interface que define o comportamento de uma pilha genérica.
 *
 * @param <T> O tipo dos elementos armazenados na pilha.
 */
public interface Pilha<T> {
    /**
     * Insere um elemento no topo da pilha.
     *
     * @param v Elemento a ser inserido.
     */
    void push(T v);

    /**
     * Remove e retorna o elemento no topo da pilha.
     *
     * @return Elemento removido do topo da pilha.
     */
    T pop();

    /**
     * Retorna o elemento no topo da pilha sem removê-lo.
     *
     * @return Elemento no topo da pilha.
     */
    T peek();

    /**
     * Verifica se a pilha está vazia.
     *
     * @return true se a pilha estiver vazia, false caso contrário.
     */
    boolean estaVazia();

    /**
     * Remove todos os elementos da pilha, deixando-a vazia.
     */
    void limpar();
}
