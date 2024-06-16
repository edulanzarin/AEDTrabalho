package project.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação de um mapa de dispersão (hash map) utilizando listas encadeadas para tratamento de colisões.
 *
 * @param <K> Tipo da chave.
 * @param <V> Tipo do valor associado à chave.
 */
public class MapaDispersao<K, V> {
    private final int TAMANHO_INICIAL = 10;
    private List<List<Entrada<K, V>>> tabela;
    private int tamanho;

    /**
     * Construtor que inicializa o mapa de dispersão com um tamanho inicial pré-definido.
     */
    public MapaDispersao() {
        tabela = new ArrayList<>(TAMANHO_INICIAL);
        for (int i = 0; i < TAMANHO_INICIAL; i++) {
            tabela.add(new ArrayList<>());
        }
        tamanho = 0;
    }

    /**
     * Calcula o índice da tabela hash para uma chave específica.
     *
     * @param chave Chave cujo índice será calculado.
     * @return Índice calculado para a chave.
     */
    private int hash(K chave) {
        return Math.abs(chave.hashCode()) % tabela.size();
    }

    /**
     * Insere um par chave-valor no mapa de dispersão.
     * Se a chave já existe, substitui o valor associado.
     *
     * @param chave Chave a ser inserida ou atualizada.
     * @param valor Valor associado à chave.
     */
    public void inserir(K chave, V valor) {
        int indice = hash(chave);
        List<Entrada<K, V>> lista = tabela.get(indice);

        for (Entrada<K, V> entrada : lista) {
            if (entrada.getChave().equals(chave)) {
                entrada.setValor(valor);
                return;
            }
        }

        lista.add(new Entrada<>(chave, valor));
        tamanho++;
    }

    /**
     * Busca o valor associado a uma chave específica no mapa de dispersão.
     *
     * @param chave Chave cujo valor associado será buscado.
     * @return Valor associado à chave, ou null se a chave não existir no mapa.
     */
    public V buscar(K chave) {
        int indice = hash(chave);
        List<Entrada<K, V>> lista = tabela.get(indice);

        for (Entrada<K, V> entrada : lista) {
            if (entrada.getChave().equals(chave)) {
                return entrada.getValor();
            }
        }

        return null;
    }

    /**
     * Retorna um array contendo todas as chaves presentes no mapa de dispersão.
     *
     * @return Array de objetos contendo todas as chaves presentes no mapa.
     */
    public Object[] buscarTodos() {
        List<Object> elementos = new ArrayList<>();
        for (List<Entrada<K, V>> lista : tabela) {
            for (Entrada<K, V> entrada : lista) {
                elementos.add(entrada.getChave());
            }
        }
        return elementos.toArray();
    }

    /**
     * Retorna o número de pares chave-valor presentes no mapa de dispersão.
     *
     * @return Número de pares chave-valor.
     */
    public int tamanho() {
        return tamanho;
    }

    /**
     * Classe interna que representa uma entrada no mapa de dispersão.
     *
     * @param <K> Tipo da chave.
     * @param <V> Tipo do valor associado à chave.
     */
    private static class Entrada<K, V> {
        private K chave;
        private V valor;

        /**
         * Construtor que inicializa uma entrada com uma chave e um valor.
         *
         * @param chave Chave da entrada.
         * @param valor Valor associado à chave.
         */
        public Entrada(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        /**
         * Obtém a chave da entrada.
         *
         * @return Chave da entrada.
         */
        public K getChave() {
            return chave;
        }

        /**
         * Obtém o valor associado à chave da entrada.
         *
         * @return Valor associado à chave.
         */
        public V getValor() {
            return valor;
        }

        /**
         * Define o valor associado à chave da entrada.
         *
         * @param valor Novo valor a ser associado à chave.
         */
        public void setValor(V valor) {
            this.valor = valor;
        }
    }
}
