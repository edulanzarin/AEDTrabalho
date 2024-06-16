package project.functions;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Classe SelecionarArquivo permite selecionar um arquivo HTML usando JFileChooser.
 */
public class SelecionarArquivo {
    private JFrame parentFrame;

    /**
     * Construtor vazio da classe.
     */
    public SelecionarArquivo() {
        this.parentFrame = null;
    }

    /**
     * Construtor da classe com um JFrame como argumento.
     *
     * @param parentFrame JFrame pai para o JFileChooser.
     */
    public SelecionarArquivo(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    /**
     * Obtém o JFrame pai associado ao seletor de arquivo.
     *
     * @return JFrame pai.
     */
    public JFrame getParentFrame() {
        return parentFrame;
    }

    /**
     * Define o JFrame pai associado ao seletor de arquivo.
     *
     * @param parentFrame JFrame pai.
     */
    public void setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    /**
     * Abre um JFileChooser para selecionar um arquivo HTML.
     *
     * @return Arquivo HTML selecionado.
     */
    public File selecionarArquivo() {
        JFileChooser selecionarArquivoWindow = new JFileChooser();
        selecionarArquivoWindow.setDialogTitle("Selecionar HTML");
        selecionarArquivoWindow.setFileFilter(filtrarHtml());

        int acaoRetornada = selecionarArquivoWindow.showOpenDialog(parentFrame);
        if (acaoRetornada == JFileChooser.APPROVE_OPTION) {
            return selecionarArquivoWindow.getSelectedFile();
        } else {
            return null;
        }
    }

    /**
     * Cria um filtro para exibir somente arquivos HTML no JFileChooser.
     *
     * @return Filtro para arquivos HTML.
     */
    private FileFilter filtrarHtml() {
        return new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".html");
            }

            @Override
            public String getDescription() {
                return "Arquivos HTML (*.html)";
            }
        };
    }
}
