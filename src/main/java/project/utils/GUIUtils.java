package project.utils;

import project.functions.SelecionarHTML;
import project.model.Arquivo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe utilitária para criação de componentes GUI e tratamento de eventos
 */
public class GUIUtils {
    private static SelecionarHTML selecionarArquivo = new SelecionarHTML();
    private static JPanel panel;
    private static JButton button;
    private static JTextPane textPane;
    private static JTextArea textArea;
    private static JTable table;

    /**
     * Método para criar um JPanel com tamanho especificado.
     *
     * @param width  largura do painel
     * @param height altura do painel
     * @return JPanel criado
     */
    public static JPanel createPanel(int width, int height) {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    /**
     * Método para criar um JButton com tamanho e texto especificados e associado a um ActionListener.
     *
     * @param width          largura do botão
     * @param height         altura do botão
     * @param text           texto do botão
     * @param actionListener listener para eventos do botão
     * @return JButton criado
     */
    public static JButton createButton(int width, int height, String text, ActionListener actionListener) {
        button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.addActionListener(actionListener);
        return button;
    }

    /**
     * Método para criar um JLabel com tamanho especificado.
     *
     * @param width  largura do label
     * @param height altura do label
     * @return JLabel criado
     */
    public static JTextPane createTextPane(int width, int height) {
        textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension(width, height));
        textPane.setEditable(false);

        // Configura a fonte e o alinhamento do texto
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
        textPane.setFont(font);

        // Centraliza o texto horizontalmente e verticalmente
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        return textPane;
    }

    /**
     * Método para criar um JTextArea com tamanho especificado.
     *
     * @param width  largura da área de texto
     * @param height altura da área de texto
     * @return JTextArea criada
     */
    public static JTextArea createTextArea(int width, int height) {
        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(width, height));
        textArea.setEditable(false); // Para garantir que o usuário não possa editar diretamente
        return textArea;
    }

    /**
     * Método para criar uma JTable com colunas "Tag" e "Ocorrências".
     *
     * @param width  largura da tabela
     * @param height altura da tabela
     * @return JTable criada
     */
    public static JTable createTable(int width, int height) {
        String[] colunas = {"Tag", "Ocorrências"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        table = new JTable(modelo);
        table.setPreferredScrollableViewportSize(new Dimension(width, height));
        return table;
    }

    

    /**
     * Listener para o botão de analisar arquivo HTML.
     */
    public static class AnalisarArquivoHTMLButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Arquivo arquivo = selecionarArquivo.getArquivo();
            if (arquivo != null) {
                DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                modelo.addRow(new Object[]{"html", 1});
                modelo.addRow(new Object[]{"head", 1});
                modelo.addRow(new Object[]{"title", 1});
                modelo.addRow(new Object[]{"body", 1});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
                modelo.addRow(new Object[]{"div", 2});
            } else {
                // Nenhum arquivo selecionado
            }
        }
    }
}
