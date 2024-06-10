package project.functions;

import project.core.*;

public class AnalisarHTML {
    private String conteudo;
    ListaEncadeada<String> tagNames = new ListaEncadeada<>();

    public AnalisarHTML(String conteudo) {
        this.conteudo = conteudo;
    }

    public ListaEncadeada<String> retirarTags() {
        boolean insideTag = false;
        StringBuilder currentTagName = new StringBuilder();
    
        for (int i = 0; i < conteudo.length(); i++) {
            char currentChar = conteudo.charAt(i);
            if (currentChar == '<') {
                insideTag = true;
                currentTagName = new StringBuilder(); 
            } else if (currentChar == '>') {
                insideTag = false;
                if (currentTagName.length() > 0) {
                    tagNames.inserir(currentTagName.toString());
                }
            } else if (!insideTag) {
                currentTagName.append(currentChar);
            }
        }
    
        return tagNames;
    }

    public ListaEncadeada<String> removerSingletonTags(ListaEncadeada<String> tagNames) {
        SingletonTags singletonTags = new SingletonTags();
        ListaEncadeada<String> modifiedTagNames = new ListaEncadeada<>();
    
        // Iterate through the extracted tag names
        for (int i = 0; i < tagNames.getTamanho(); i++) {
            String tagName = tagNames.obterNo(i).getInfo();
            // Check if the tag is a singleton tag
            if (!singletonTags.isSingletonTag(tagName)) {
                // If not a singleton tag, add it to the modified list
                modifiedTagNames.inserir(tagName);
            }
        }
    
        return modifiedTagNames;
    }
    
}
