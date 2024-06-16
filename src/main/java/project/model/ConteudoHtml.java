package project.model;

import java.io.*;

/**
 * Classe ConteudoHtml representa o conteúdo de um arquivo HTML.
 */
public class ConteudoHtml {
    private StringBuilder conteudo;

    /**
     * Construtor padrão que inicializa o conteúdo como vazio.
     */
    public ConteudoHtml() {
        this.conteudo = new StringBuilder();
    }

    /**
     * Construtor que inicializa o conteúdo com uma string fornecida.
     * @param conteudo Conteúdo HTML inicial.
     */
    public ConteudoHtml(String conteudo) {
        this.conteudo = new StringBuilder(conteudo);
    }

    /**
     * Obtém o conteúdo HTML como uma string.
     * @return Conteúdo HTML.
     */
    public String getConteudo() {
        return conteudo.toString();
    }

    /**
     * Obtém o conteúdo de um arquivo HTML especificado.
     * @param arquivoHtml Arquivo HTML do qual o conteúdo será lido.
     * @throws IOException Exceção lançada se ocorrer um erro ao ler o arquivo.
     */
    public void obterConteudo(ArquivoHtml arquivoHtml) throws IOException {
        conteudo.setLength(0); // Limpa o conteúdo atual

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoHtml.getArquivoHtml()))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                conteudo.append(linha);
                conteudo.append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new IOException("Arquivo não encontrado: " + arquivoHtml.getCaminhoArquivo(), e);
        } catch (IOException e) {
            throw new IOException("Erro ao ler o arquivo: " + arquivoHtml.getCaminhoArquivo(), e);
        }
    }

    /**
     * Verifica se o conteúdo está vazio.
     * @return true se o conteúdo estiver vazio, false caso contrário.
     */
    public boolean estaVazio() {
        return conteudo.isEmpty();
    }
}
