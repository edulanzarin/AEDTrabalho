package project.functions;

import javax.swing.*;
import java.io.File;

import project.model.ArquivoHTML;

/**
 * Implementação da interface SelecionarArquivo para seleção de arquivos HTML.
 */
public class SelecionarHTML implements SelecionarArquivo {
    private File arquivo;
    private String caminhoArquivo;

    /**
     * Abre uma janela para selecionar um arquivo HTML.
     *
     * @param parentFrame O JFrame pai para o diálogo de seleção de arquivo.
     * @return O arquivo HTML selecionado ou null se nenhum arquivo foi selecionado.
     */
    @Override
    public ArquivoHTML selecionarArquivo(JFrame parentFrame) {
        JFileChooser selecionarCaminhoArquivo = new JFileChooser();
        selecionarCaminhoArquivo.setDialogTitle("Selecionar HTML");
        selecionarCaminhoArquivo.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".html");
            }

            public String getDescription() {
                return "Arquivos HTML (*.html)";
            }
        });

        // Verifica se o usuário selecionou um arquivo
        int acaoRetornada = selecionarCaminhoArquivo.showOpenDialog(parentFrame);
        if (acaoRetornada == JFileChooser.APPROVE_OPTION) {
            arquivo = selecionarCaminhoArquivo.getSelectedFile();
            caminhoArquivo = arquivo.getAbsolutePath();
            return new ArquivoHTML(arquivo);
        }
        return null;
    }

    /**
     * Limpa a seleção atual do arquivo.
     */
    @Override
    public void limparSelecao() {
        arquivo = null;
        caminhoArquivo = null;
    }

    /**
     * Verifica se um arquivo foi selecionado.
     *
     * @return true se um arquivo foi selecionado, false caso contrário.
     */
    @Override
    public boolean isArquivoSelecionado() {
        return arquivo != null && caminhoArquivo != null;
    }

    /**
     * Obtém o arquivo selecionado.
     *
     * @return O arquivo selecionado.
     */
    @Override
    public ArquivoHTML getArquivo() {
        return arquivo != null ? new ArquivoHTML(arquivo) : null;
    }

    /**
     * Obtém o caminho absoluto do arquivo selecionado.
     *
     * @return O caminho absoluto do arquivo selecionado.
     */
    @Override
    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }
}
