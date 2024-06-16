package project.core;

/**
 * Classe que representa um nó em um mapa de dispersão.
 *
 * @param <K> Tipo da chave do nó.
 * @param <V> Tipo da informação armazenada no nó.
 */
public class NoMapa<K, V> {
    private K chave;
    private V info;

    /**
     * Obtém a chave do nó.
     *
     * @return Chave do nó.
     */
    public K getChave() {
        return chave;
    }

    /**
     * Define a chave do nó.
     *
     * @param chave Chave a ser definida.
     */
    public void setChave(K chave) {
        this.chave = chave;
    }

    /**
     * Obtém a informação armazenada no nó.
     *
     * @return Informação armazenada no nó.
     */
    public V getInfo() {
        return info;
    }

    /**
     * Define a informação a ser armazenada no nó.
     *
     * @param info Informação a ser definida.
     */
    public void setInfo(V info) {
        this.info = info;
    }

    /**
     * Compara este nó com outro objeto para verificar se são iguais.
     *
     * @param o Objeto a ser comparado.
     * @return true se os objetos são iguais; false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoMapa<?, ?> noMapa = (NoMapa<?, ?>) o;
        return chave.equals(noMapa.chave);
    }
}
