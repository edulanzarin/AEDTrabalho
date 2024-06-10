package project.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementação da interface Arquivo para representação de um arquivo HTML.
 */
public class ArquivoHTML implements Arquivo {
    private File arquivo;

    public ArquivoHTML(File arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public File getArquivo() {
        return arquivo;
    }

    @Override
    public String getNomeArquivo() {
        return arquivo.getName();
    }

    public String lerHTML() throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha);
                conteudo.append("\n");
            }
        }
        return conteudo.toString();
    }
}
