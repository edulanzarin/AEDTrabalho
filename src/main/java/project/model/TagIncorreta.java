package project.model;

public class TagIncorreta {
    private int codigoErro;
    private String tagIncorreta;

    public TagIncorreta() {
        this.codigoErro = 0;
        this.tagIncorreta = null;
    }

    public TagIncorreta(int codigoErro, String tagIncorreta) {
        this.codigoErro = codigoErro;
        this.tagIncorreta = tagIncorreta;
    }

    public int getCodigoErro() {
        return codigoErro;
    }

    public void setCodigoErro(int codigoErro) {
        this.codigoErro = codigoErro;
    }

    public String getTagIncorreta() {
        return tagIncorreta;
    }

    public void setTagIncorreta(String tagIncorreta) {
        this.tagIncorreta = tagIncorreta;
    }
}
