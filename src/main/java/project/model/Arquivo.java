package project.model;

import java.io.File;

/**
 * Interface para representação de um arquivo genérico.
 */
public interface Arquivo {
    File getArquivo();
    String getNomeArquivo();
}
