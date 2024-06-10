package project.functions;

import project.core.ListaEncadeada;

public class SingletonTags {
    private static final String[] SINGLETON_TAGS = {
        "meta", "base", "br", "col", "command", "embed", "hr", "img",
        "input", "link", "param", "source", "!DOCTYPE"
    };
    private ListaEncadeada<String> singTagsEncontradas;

    public SingletonTags() {
        this.singTagsEncontradas = new ListaEncadeada<>();
    }

    public String[] getSingletonTags() {
        return SINGLETON_TAGS;
    }

    public void compararSingletonTags(String tag) {
        for (String singletonTag : SINGLETON_TAGS) {
            if (tag.equals(singletonTag)) {
                singTagsEncontradas.inserir(tag);
                return;
            }
        }
    }

    public ListaEncadeada<String> getSingTagsEncontradas() {
        return singTagsEncontradas;
    }

    public void contarSingletonTags() {
        for (String singletonTag : SINGLETON_TAGS) {
            int contador = singTagsEncontradas.contarOcorrencias(singletonTag);
            if (contador > 0) {
                System.out.println(singletonTag + " = " + contador);
            }
        }
    }
}
