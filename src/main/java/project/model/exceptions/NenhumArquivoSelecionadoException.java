package project.model.exceptions;

public class NenhumArquivoSelecionadoException extends RuntimeException {
    public NenhumArquivoSelecionadoException() {
        super("Nenhum arquivo selecionado.");
    }

    public NenhumArquivoSelecionadoException(String mensagem) {
        super(mensagem);
    }
}
