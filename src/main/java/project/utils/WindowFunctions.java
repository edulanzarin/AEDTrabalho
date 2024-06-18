package project.utils;

import project.model.*;
import project.functions.*;

import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;

/**
 * Classe WindowFunctions contém as funções de controle da janela principal.
 */
public class WindowFunctions {
    private ArquivoHtml arquivoHtml = new ArquivoHtml(); // Instância para lidar com o arquivo HTML
    private ConteudoHtml conteudoHtml = new ConteudoHtml(); // Instância para lidar com o conteúdo do arquivo HTML
    private AnalisarHtml analisador = new AnalisarHtml(); // Instância para analisar as tags HTML
    private JTextPane textPane; // TextPane para mostrar o nome do arquivo selecionado
    private MainWindow mainWindow; // Referência à janela principal

    /**
     * Construtor da classe WindowFunctions.
     * @param textPane TextPane onde será exibido o nome do arquivo selecionado.
     * @param mainWindow Referência à janela principal da aplicação.
     */
    public WindowFunctions(JTextPane textPane, MainWindow mainWindow) {
        this.textPane = textPane;
        this.mainWindow = mainWindow;
    }

    /**
     * Método para lidar com o evento de abrir arquivo.
     * @param e Evento de ação associado ao botão de abrir arquivo.
     */
    public void abrirArquivo(ActionEvent e) {
        try {
            arquivoHtml.selecionarArquivo(); // Chama o método para selecionar o arquivo HTML
            if (arquivoHtml.getArquivoHtml() != null) {
                textPane.setText(arquivoHtml.getNomeArquivo()); // Atualiza o TextPane com o nome do arquivo selecionado
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar o arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para lidar com o evento de analisar o arquivo.
     * @param e Evento de ação associado ao botão de analisar arquivo.
     */
    public void analisarArquivo(ActionEvent e) {
        try {
            if (arquivoHtml.getArquivoHtml() != null) {
                conteudoHtml.obterConteudo(arquivoHtml); // Obtém o conteúdo do arquivo HTML
                analisador.analisarTags(conteudoHtml); // Realiza a análise das tags HTML no conteúdo

                // Obtém as tags corretas, ocorrências corretas e tags incorretas
                String[] tagsCorretas = analisador.getTagsCorretas();
                int[] ocorrenciasCorretas = analisador.getOcorrenciasCorretas();
                TagIncorreta[] tagsIncorretas = analisador.getTagsIncorretas();

                // Atualiza a interface com as tags corretas e incorretas
                mainWindow.adicionarTagsCorretas(tagsCorretas, ocorrenciasCorretas);
                mainWindow.adicionarTagsIncorretas(tagsIncorretas);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao analisar o arquivo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
