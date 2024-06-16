package project.model;

import project.functions.SelecionarArquivo;
import project.model.exceptions.NenhumArquivoSelecionadoException;

import java.io.File;
import java.io.IOException;

/**
 * Classe ArquivoHtml representa um arquivo HTML selecionado ou a ser selecionado.
 */
public class ArquivoHtml {
    private File arquivoHtml;

    /**
     * Construtor padrão da classe.
     */
    public ArquivoHtml() {
        this.arquivoHtml = null;
    }

    /**
     * Construtor que inicializa o objeto com um caminho de arquivo.
     *
     * @param caminhoArquivo Caminho do arquivo HTML.
     */
    public ArquivoHtml(String caminhoArquivo) {
        this.arquivoHtml = new File(caminhoArquivo);
    }

    /**
     * Construtor que inicializa o objeto com um objeto File.
     *
     * @param arquivoHtml Objeto File representando o arquivo HTML.
     */
    public ArquivoHtml(File arquivoHtml) {
        this.arquivoHtml = arquivoHtml;
    }

    /**
     * Obtém o objeto File do arquivo HTML.
     *
     * @return Objeto File do arquivo HTML.
     */
    public File getArquivoHtml() {
        return arquivoHtml;
    }

    /**
     * Seleciona um arquivo HTML usando o SelecionarArquivo e define como arquivo atual.
     *
     * @throws IOException Exceção lançada se ocorrer um erro ao selecionar o arquivo.
     */
    public void selecionarArquivo() throws IOException {
        SelecionarArquivo selecionarArquivo = new SelecionarArquivo();
        try {
            File arquivoSelecionado = selecionarArquivo.selecionarArquivo();
            if (arquivoSelecionado != null) {
                this.arquivoHtml = arquivoSelecionado;
            } else {
                throw new NenhumArquivoSelecionadoException("Nenhum arquivo foi selecionado.");
            }
        } catch (NenhumArquivoSelecionadoException e) {
            System.err.println("Erro: " + e.getMessage());
            throw new IOException("Falha ao selecionar o arquivo.", e);
        }
    }

    /**
     * Obtém o nome do arquivo HTML selecionado.
     *
     * @return Nome do arquivo HTML.
     */
    public String getNomeArquivo() {
        if (isArquivo()) {
            return arquivoHtml.getName();
        }
        return null;
    }

    /**
     * Obtém o caminho absoluto do arquivo HTML selecionado.
     *
     * @return Caminho absoluto do arquivo HTML.
     */
    public String getCaminhoArquivo() {
        if (isArquivo()) {
            return arquivoHtml.getAbsolutePath();
        }
        return null;
    }

    /**
     * Verifica se um arquivo HTML foi selecionado.
     *
     * @return true se um arquivo HTML foi selecionado, false caso contrário.
     */
    public boolean isArquivo() {
        return arquivoHtml != null && arquivoHtml.isFile();
    }
}
