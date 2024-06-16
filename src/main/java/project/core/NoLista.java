package project.core;

/**
 * Classe que representa um nó em uma lista encadeada.
 *
 * @param <T> Tipo de dado armazenado no nó.
 */
public class NoLista<T> {
    private T info;
    private NoLista<T> proximo;

    /**
     * Obtém a informação armazenada no nó.
     *
     * @return Informação armazenada no nó.
     */
    public T getInfo() {
        return info;
    }

    /**
     * Define a informação a ser armazenada no nó.
     *
     * @param info Informação a ser armazenada no nó.
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Obtém o próximo nó na lista encadeada.
     *
     * @return Próximo nó na lista encadeada.
     */
    public NoLista<T> getProximo() {
        return proximo;
    }

    /**
     * Define o próximo nó na lista encadeada.
     *
     * @param proximo Próximo nó na lista encadeada.
     */
    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }
}
