package project.core;

import project.core.exceptions.*;

/**
 * Implementação da interface Pilha<T> utilizando uma lista encadeada.
 *
 * @param <T> Tipo dos elementos armazenados na pilha.
 */
public class PilhaLista<T> implements Pilha<T> {
    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    /**
     * Insere um elemento no topo da pilha.
     *
     * @param info Elemento a ser inserido.
     */
    @Override
    public void push(T info) {
        lista.adicionar(info);
    }

    /**
     * Remove e retorna o elemento no topo da pilha.
     *
     * @return Elemento removido do topo da pilha.
     */
    @Override
    public T pop() {
        T valor = peek();
        lista.retirar(valor);
        return valor;
    }

    /**
     * Retorna o elemento no topo da pilha sem removê-lo.
     *
     * @return Elemento no topo da pilha.
     * @throws PilhaVaziaException se a pilha estiver vazia.
     */
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    /**
     * Verifica se a pilha está vazia.
     *
     * @return true se a pilha estiver vazia, false caso contrário.
     */
    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    /**
     * Remove todos os elementos da pilha.
     */
    @Override
    public void limpar() {
        lista = new ListaEncadeada<>();
    }

    /**
     * Retorna a representação em string da pilha.
     *
     * @return Representação em string da pilha.
     */
    @Override
    public String toString() {
        return lista.toString();
    }
}
