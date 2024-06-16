package project.core;

/**
 * Implementação de um mapa de dispersão (hash map) utilizando listas encadeadas para tratamento de colisões.
 *
 * @param <K> Tipo da chave.
 * @param <V> Tipo do valor associado à chave.
 */
public class MapaDispersao<K, V> {
    private final int TAMANHO_INICIAL = 10;
    private ListaEncadeada<ListaEncadeada<NoMapa<K, V>>> tabela;
    private int tamanho;

    /**
     * Construtor que inicializa o mapa de dispersão com um tamanho inicial pré-definido.
     */
    public MapaDispersao() {
        tabela = new ListaEncadeada<>();
        for (int i = 0; i < TAMANHO_INICIAL; i++) {
            tabela.adicionar(new ListaEncadeada<>());
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
        return Math.abs(chave.hashCode()) % TAMANHO_INICIAL;
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
        ListaEncadeada<NoMapa<K, V>> lista = tabela.getNo(indice).getInfo();

        NoLista<NoMapa<K, V>> noAtual = lista.getPrimeiro();
        while (noAtual != null) {
            NoMapa<K, V> noMapa = noAtual.getInfo();
            if (noMapa.getChave().equals(chave)) {
                noMapa.setInfo(valor);
                return;
            }
            noAtual = noAtual.getProximo();
        }

        lista.adicionar(new NoMapa<>(chave, valor));
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
        ListaEncadeada<NoMapa<K, V>> lista = tabela.getNo(indice).getInfo();

        NoLista<NoMapa<K, V>> noAtual = lista.getPrimeiro();
        while (noAtual != null) {
            NoMapa<K, V> noMapa = noAtual.getInfo();
            if (noMapa.getChave().equals(chave)) {
                return noMapa.getInfo();
            }
            noAtual = noAtual.getProximo();
        }

        return null;
    }

    /**
     * Retorna um array contendo todas as chaves presentes no mapa de dispersão.
     *
     * @return Array de objetos contendo todas as chaves presentes no mapa.
     */
    public Object[] buscarTodos() {
        ListaEncadeada<Object> elementos = new ListaEncadeada<>();
        NoLista<ListaEncadeada<NoMapa<K, V>>> noTabela = tabela.getPrimeiro();

        while (noTabela != null) {
            ListaEncadeada<NoMapa<K, V>> lista = noTabela.getInfo();
            NoLista<NoMapa<K, V>> noLista = lista.getPrimeiro();

            while (noLista != null) {
                elementos.adicionar(noLista.getInfo().getChave());
                noLista = noLista.getProximo();
            }

            noTabela = noTabela.getProximo();
        }

        return elementos.buscarTodos();
    }

    /**
     * Retorna o número de pares chave-valor presentes no mapa de dispersão.
     *
     * @return Número de pares chave-valor.
     */
    public int tamanho() {
        return tamanho;
    }
}
