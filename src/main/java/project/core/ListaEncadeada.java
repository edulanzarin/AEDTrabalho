package project.core;

import project.core.exceptions.*;

/**
 * Implementação de uma lista encadeada genérica.
 *
 * @param <T> O tipo dos elementos da lista.
 */
public class ListaEncadeada<T> {
    private NoLista<T> primeiro;
    private NoLista<T> ultimo;
    private int tamanho;

    /**
     * Construtor padrão que inicializa uma lista encadeada vazia.
     */
    public ListaEncadeada() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    /**
     * Obtém o primeiro nó da lista.
     *
     * @return O primeiro nó da lista.
     */
    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    /**
     * Adiciona um novo elemento no início da lista.
     *
     * @param info O elemento a ser adicionado.
     */
    public void adicionar(T info) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);

        if (estaVazia()) {
            ultimo = novo;
        }

        this.primeiro = novo;
        tamanho++;
    }

    /**
     * Adiciona um novo elemento no final da lista.
     *
     * @param valor O elemento a ser adicionado.
     */
    public void adicionarNoFinal(T valor) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);
        novo.setProximo(null);
        if (estaVazia())
            primeiro = novo;
        else
            ultimo.setProximo(novo);

        ultimo = novo;
        tamanho++;
    }

    /**
     * Exibe todos os elementos da lista.
     */
    public void exibir() {
        NoLista<T> p = primeiro;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return true se a lista estiver vazia, false caso contrário.
     */
    public boolean estaVazia() {
        return primeiro == null;
    }

    /**
     * Busca por um elemento na lista.
     *
     * @param info O elemento a ser buscado.
     * @return O nó que contém o elemento buscado, ou null se não encontrado.
     */
    public NoLista<T> buscar(T info) {
        NoLista<T> p = primeiro;

        while (p != null) {
            if (p.getInfo().equals(info))
                return p;
            p = p.getProximo();
        }

        return null;
    }

    /**
     * Remove um elemento da lista.
     *
     * @param info O elemento a ser removido.
     */
    public void retirar(T info) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while ((p != null) && (!p.getInfo().equals(info))) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (anterior == null)
                this.primeiro = p.getProximo();
            else
                anterior.setProximo(p.getProximo());

            if (p == ultimo) {
                ultimo = anterior;
            }
            tamanho--;
        }
    }

    /**
     * Obtém o comprimento atual da lista.
     *
     * @return O número de elementos na lista.
     */
    public int obterComprimento() {
        return tamanho;
    }

    /**
     * Obtém o último elemento da lista.
     *
     * @return O último elemento da lista.
     * @throws ListaVaziaException se a lista estiver vazia.
     */
    public T obterUltimo() {
        if (estaVazia())
            throw new ListaVaziaException();

        return ultimo.getInfo();
    }

    /**
     * Verifica se esta lista é igual a outra lista.
     *
     * @param lista A lista a ser comparada.
     * @return true se as listas forem iguais, false caso contrário.
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object lista) {
        if (this == lista)
            return true;
        if (lista == null)
            return false;
        if (getClass() != lista.getClass())
            return false;

        ListaEncadeada<T> outraLista = (ListaEncadeada<T>) lista;

        NoLista<T> p1 = this.getPrimeiro();
        NoLista<T> p2 = outraLista.getPrimeiro();

        while ((p1 != null) && (p2 != null)) {
            if (!(p1.getInfo().equals(p2.getInfo())))
                return false;

            p1 = p1.getProximo();
            p2 = p2.getProximo();
        }

        return p1 == null && p2 == null;
    }

    /**
     * Obtém o nó em uma posição específica na lista.
     *
     * @param idx A posição do nó desejado.
     * @return O nó na posição especificada.
     * @throws IndexOutOfBoundsException se o índice estiver fora dos limites da lista.
     */
    public NoLista<T> getNo(int idx) {
        if (idx < 0 || idx >= tamanho)
            throw new IndexOutOfBoundsException();

        NoLista<T> p = getPrimeiro();
        while ((p != null) && (idx > 0)) {
            idx--;
            p = p.getProximo();
        }

        if (p == null)
            throw new IndexOutOfBoundsException();

        return p;
    }

    /**
     * Cria uma nova lista encadeada invertida desta lista.
     *
     * @return Uma nova lista encadeada invertida.
     */
    public ListaEncadeada<T> criarInvertida() {
        ListaEncadeada<T> nova = new ListaEncadeada<>();

        NoLista<T> p = getPrimeiro();
        while (p != null) {
            nova.adicionar(p.getInfo());
            p = p.getProximo();
        }

        return nova;
    }

    /**
     * Limpa todos os elementos da lista, deixando-a vazia.
     */
    public void limpar() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    /**
     * Busca o índice de um elemento na lista.
     *
     * @param info O elemento a ser buscado.
     * @return O índice do elemento, ou -1 se não encontrado.
     */
    public int buscarIndice(T info) {
        NoLista<T> p = primeiro;
        int indice = 0;

        while (p != null) {
            if (p.getInfo().equals(info)) {
                return indice;
            }
            p = p.getProximo();
            indice++;
        }

        return -1;
    }

    /**
     * Retorna um vetor de objetos com todos os elementos da lista encadeada.
     *
     * @return Um vetor de objetos com todos os elementos da lista.
     */
    public Object[] buscarTodos() {
        Object[] elementos = new Object[tamanho];
        NoLista<T> p = primeiro;
        int idx = 0;

        while (p != null) {
            elementos[idx++] = p.getInfo();
            p = p.getProximo();
        }

        return elementos;
    }
}
