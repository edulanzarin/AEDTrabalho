package project.functions;

public class AnalisarHTML {
    private String conteudo;

    public AnalisarHTML(String conteudo) {
        this.conteudo = conteudo;
    }

    private int contarTags() {
    int contadorTags = 0;
    for (int i = 0; i < conteudo.length(); i++) {
        if (conteudo.charAt(i) == '<') {
            contadorTags++;
        }
    }

    return contadorTags;
    }

    // public String[] retirarTags() {
    //     for (int i = 0; i < contarTags(); i++) {

    //     }
    // }

    public void empilharTags() {

    }
}
