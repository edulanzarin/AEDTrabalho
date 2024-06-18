package project.utils;

import project.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Classe MainWindow representa a janela principal da aplicação.
 */
public class MainWindow extends JFrame {
    private JFrame frame; // Janela principal da aplicação
    private JTextPane arquivoTextPane; // JTextPane para exibir o nome do arquivo selecionado
    private JTable table; // Tabela para exibir as tags e suas ocorrências
    private JTextArea descricaoTextArea; // JTextArea para exibir a descrição das tags
    private WindowFunctions windowFunctions; // Referência para as funções da janela

    /**
     * Construtor da classe MainWindow.
     * Configura a interface gráfica da janela principal.
     */
    public MainWindow() {
        // Criação do frame principal
        frame = new JFrame("Validador HTML");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Criação do painel principal onde ficarão os componentes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Criação de uma borda em cima da janela
        JLabel borderTopLabel = new JLabel();
        borderTopLabel.setPreferredSize(new Dimension(780, 10));
        mainPanel.add(borderTopLabel);

        // Criação do painel de consulta, onde ficarão os botões e o TextPane
        JPanel consultPanel = new JPanel();
        consultPanel.setPreferredSize(new Dimension(500, 30));
        consultPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;

        // Criação do TextPane onde mostrará o nome do arquivo
        arquivoTextPane = new JTextPane();
        arquivoTextPane.setPreferredSize(new Dimension(200, 30));
        arquivoTextPane.setText("Arquivo HTML");
        arquivoTextPane.setEditable(false);
        StyledDocument doc = arquivoTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        // Criação do botão para abrir o arquivo
        JButton abrirArquivoButton = new JButton("Selecionar");
        abrirArquivoButton.setPreferredSize(new Dimension(100, 30));
        abrirArquivoButton.addActionListener(this::abrirArquivo);

        // Criação do botão para analisar o arquivo
        JButton analisarArquivoButton = new JButton("Analisar");
        analisarArquivoButton.setPreferredSize(new Dimension(100, 30));
        analisarArquivoButton.addActionListener(this::analisarArquivo);

        // Parâmetros para alinhar o TextPane do arquivo selecionado
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 150, 0, 0);
        consultPanel.add(arquivoTextPane, gbc);

        // Parâmetros para alinhar o botão de abrir arquivo
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 0, 0);
        consultPanel.add(abrirArquivoButton, gbc);

        // Parâmetros para alinhar o botão de analisar
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 0, 150);
        consultPanel.add(analisarArquivoButton, gbc);

        // Adiciona o painel de consulta ao painel principal
        mainPanel.add(consultPanel);

        // Criação do painel da área de descrição de tags
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setPreferredSize(new Dimension(780, 200));
        textAreaPanel.setLayout(new GridBagLayout());

        // Criação da TextArea onde ficará a descrição das tags
        descricaoTextArea = new JTextArea();
        descricaoTextArea.setPreferredSize(new Dimension(700, 180));
        descricaoTextArea.setEditable(false);

        // Adiciona a TextArea ao JScrollPane para permitir scroll
        JScrollPane scrollPane = new JScrollPane(descricaoTextArea);
        scrollPane.setPreferredSize(new Dimension(700, 180));
        textAreaPanel.add(scrollPane);

        // Adiciona o painel de texto ao painel principal
        mainPanel.add(textAreaPanel);

        // Criação da tabela onde serão exibidas as tags e suas ocorrências
        String[] colunas = {"Tag", "Ocorrências"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        table = new JTable(modelo);
        table.setPreferredScrollableViewportSize(new Dimension(700, 160));

        // Criação do painel onde ficará a tabela
        JPanel tablePanel = new JPanel();
        tablePanel.setPreferredSize(new Dimension(780, 200));
        tablePanel.add(new JScrollPane(table));

        // Adiciona o painel da tabela ao painel principal
        mainPanel.add(tablePanel);

        // Criação de uma borda embaixo da janela
        JLabel borderBottomLabel = new JLabel();
        borderBottomLabel.setPreferredSize(new Dimension(780, 10));
        mainPanel.add(borderBottomLabel);

        // Adiciona o painel principal ao frame
        frame.add(mainPanel);
        frame.setVisible(true);

        // Inicializa as funções da janela com os componentes relevantes
        windowFunctions = new WindowFunctions(arquivoTextPane, this);
    }

    /**
     * Obtém o frame principal da janela.
     * @return Frame principal.
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Evento de clique no botão para abrir arquivo.
     * @param e Evento de ação.
     */
    private void abrirArquivo(ActionEvent e) {
        windowFunctions.abrirArquivo(e);
    }

    /**
     * Evento de clique no botão para analisar o arquivo.
     * @param e Evento de ação.
     */
    private void analisarArquivo(ActionEvent e) {
        windowFunctions.analisarArquivo(e);
    }

    /**
     * Método para adicionar tags corretas na tabela da janela principal.
     * @param tagsCorretas        Array de strings contendo as tags corretas.
     * @param ocorrenciasCorretas Array de inteiros contendo as ocorrências das tags corretas.
     */
    public void adicionarTagsCorretas(String[] tagsCorretas, int[] ocorrenciasCorretas) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setRowCount(0);

        for (int i = 0; i < tagsCorretas.length; i++) {
            Object[] row = {tagsCorretas[i], ocorrenciasCorretas[i]};
            modelo.addRow(row);
        }
    }

    /**
     * Método para adicionar tags incorretas na área de descrição da janela principal.
     * Se não houver tags incorretas, exibe "O arquivo está bem formatado.".
     * @param tagsIncorretas Array de objetos TagIncorreta contendo as tags incorretas.
     */
    public void adicionarTagsIncorretas(TagIncorreta[] tagsIncorretas) {
        if (tagsIncorretas.length == 0) {
            descricaoTextArea.setText("O arquivo está bem formatado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (TagIncorreta tagIncorreta : tagsIncorretas) {
                sb.append(tagIncorreta.getCodigoErro() == 1 ? "Tag de abertura incorreta: " : "Tag de fechamento incorreta: ");
                sb.append("<").append(tagIncorreta.getTagIncorreta()).append(">\n");
            }
            descricaoTextArea.setText(sb.toString());
        }
    }
}
