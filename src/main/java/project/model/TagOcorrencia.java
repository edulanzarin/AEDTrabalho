package project.model;

import project.core.MapaDispersao;

/**
 * Classe para contagem de ocorrências de tags e armazenamento em um MapaDispersao.
 */
public class TagOcorrencia {
    private MapaDispersao<String, Integer> tagOcorrencias;

    /**
     * Construtor padrão da classe TagOcorrencia.
     * Inicializa o MapaDispersao para tags e ocorrências.
     */
    public TagOcorrencia() {
        tagOcorrencias = new MapaDispersao<>();
    }

    /**
     * Limpa o MapaDispersao de tags e ocorrências.
     */
    public void limpar() {
        tagOcorrencias = new MapaDispersao<>();
    }

    /**
     * Conta as ocorrências de uma tag. Adiciona a tag no MapaDispersao se ela não existir; caso contrário, incrementa a ocorrência.
     *
     * @param tag A tag a ser contada.
     */
    public void contarOcorrencias(String tag) {
        Integer ocorrencias = tagOcorrencias.buscar(tag);
        if (ocorrencias == null) {
            tagOcorrencias.inserir(tag, 1);
        } else {
            tagOcorrencias.inserir(tag, ocorrencias + 1);
        }
    }

    /**
     * Obtém um vetor de Strings com as tags contidas no MapaDispersao.
     *
     * @return Vetor de Strings com as tags.
     */
    public String[] getTags() {
        Object[] tagsObject = tagOcorrencias.buscarTodos();
        String[] tags = new String[tagsObject.length];
        for (int i = 0; i < tagsObject.length; i++) {
            tags[i] = (String) tagsObject[i];
        }
        return tags;
    }

    /**
     * Obtém um vetor de inteiros com as ocorrências das tags.
     *
     * @return Vetor de inteiros com as ocorrências.
     */
    public int[] getOcorrencias() {
        Object[] tagsObject = tagOcorrencias.buscarTodos();
        int[] ocorrencias = new int[tagsObject.length];
        for (int i = 0; i < tagsObject.length; i++) {
            String tag = (String) tagsObject[i];
            ocorrencias[i] = tagOcorrencias.buscar(tag);
        }
        return ocorrencias;
    }

    /**
     * Define as tags e suas ocorrências a partir de vetores de Strings e inteiros.
     *
     * @param tags        Vetor de Strings com as tags a serem definidas.
     * @param ocorrencias Vetor de inteiros com as ocorrências a serem definidas.
     */
    public void setTagsEOcorrencias(String[] tags, int[] ocorrencias) {
        if (tags.length != ocorrencias.length) {
            throw new IllegalArgumentException("Tags e ocorrências devem ter o mesmo comprimento.");
        }
        tagOcorrencias = new MapaDispersao<>(); // Reinicia o mapa
        for (int i = 0; i < tags.length; i++) {
            tagOcorrencias.inserir(tags[i], ocorrencias[i]);
        }
    }
}
