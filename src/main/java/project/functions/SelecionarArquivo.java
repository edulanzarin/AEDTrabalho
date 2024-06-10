package project.functions;

import javax.swing.*;
import project.model.*;

/**
 * Interface para seleção de arquivos.
 */
public interface SelecionarArquivo {
    Arquivo selecionarArquivo(JFrame parentFrame);
    void limparSelecao();
    boolean isArquivoSelecionado();
    Arquivo getArquivo();
    String getCaminhoArquivo();
}
