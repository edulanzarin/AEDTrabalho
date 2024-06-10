package project;

import javax.swing.*;

import project.utils.GUIUtils;

import java.awt.*;

public class Main extends JFrame {
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    public Main() {
        frame = new JFrame("Validador HTML");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel consultPanel = GUIUtils.createPanel(500, 30);
        consultPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;

        JButton abrirArquivoButton = GUIUtils.createButton(100, 30, "Selecionar", new GUIUtils.AbrirArquivoHTMLButton(frame));
        JTextPane arquivoSelecionadoLabel = GUIUtils.createTextPane(200, 30);
        arquivoSelecionadoLabel.setText("Arquivo HTML");
        JButton analisarArquivoButton = GUIUtils.createButton(100, 30, "Analisar", new GUIUtils.AnalisarArquivoHTMLButton());

        // Label centralizado
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 150, 0, 0); 
        consultPanel.add(arquivoSelecionadoLabel, gbc);

        // Botão de abrir arquivo a esquerda
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 0, 0); 
        consultPanel.add(abrirArquivoButton, gbc);

        // Botão de analisar a direita
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 0, 150); 
        consultPanel.add(analisarArquivoButton, gbc);

        JPanel textAreaPanel = GUIUtils.createPanel(780, 200);
        JTextArea descricaoTextArea = GUIUtils.createTextArea(780, 200);
        textAreaPanel.add(descricaoTextArea);

         JPanel tablePanel = GUIUtils.createPanel(780, 200);
        JTable table = GUIUtils.createTable(780, 200);
        tablePanel.add(new JScrollPane(table));

        JLabel borderLabel = new JLabel();
        borderLabel.setPreferredSize(new Dimension(780, 10));

        mainPanel.add(consultPanel);
        mainPanel.add(textAreaPanel);
        mainPanel.add(tablePanel);
        mainPanel.add(borderLabel);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
