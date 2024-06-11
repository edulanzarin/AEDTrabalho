package project.functions;

import project.core.*;

public class AnalisarHTML {
    private String conteudo;
    ListaEncadeada<String> tagsLista = new ListaEncadeada<>();

    public AnalisarHTML(String conteudo) {
        this.conteudo = conteudo;
    }

    public ListaEncadeada<String> retirarTags() {
        boolean isTag = false;
        StringBuilder tagAtual = new StringBuilder();
    
        for (int i = 0; i < conteudo.length(); i++) {
            char caractereAtual = conteudo.charAt(i);
            if (caractereAtual == '<') {
                isTag = true;
                tagAtual = new StringBuilder(); 
            } else if (caractereAtual == '>') {
                isTag = false;
                if (tagAtual.length() > 0) {
                    tagsLista.inserir(tagAtual.toString());
                }
            } else if (!isTag) {
                tagAtual.append(caractereAtual);
            }
        }
    
        return tagsLista;
    }

    public ListaEncadeada<String> removerSingletonTags(ListaEncadeada<String> tagsLista) {
        SingletonTags singletonTags = new SingletonTags();
        ListaEncadeada<String> tagsNormais = new ListaEncadeada<>();
    
        for (int i = 0; i < tagsLista.getTamanho(); i++) {
            String tag = tagsLista.obterNo(i).getInfo();
            if (!singletonTags.isSingletonTag(tag)) {
                tagsNormais.inserir(tag);
            }
        }
    
        return tagsNormais;
    }
    
}
