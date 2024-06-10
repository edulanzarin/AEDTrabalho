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

    public boolean isSingletonTag(String tag) {
        for (String singletonTag : SINGLETON_TAGS) {
            if (tag.equals(singletonTag)) {
                return true;
            }
        }
        return false;
    }

    public ListaEncadeada<String> getSingTagsEncontradas() {
        return singTagsEncontradas;
    }
}
