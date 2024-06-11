package project.functions;

public class SingletonTags {
    private static final String[] SINGLETON_TAGS = {
        "meta", "base", "br", "col", "command", "embed", "hr", "img",
        "input", "link", "param", "source", "!DOCTYPE"
    };

    public boolean isSingletonTag(String tag) {
        tag = tag.replaceAll("[<>]", "");
        for (String singletonTag : SINGLETON_TAGS) {
            if (tag.equalsIgnoreCase(singletonTag)) {
                return true;
            }
        }
        return false;
    }
}
