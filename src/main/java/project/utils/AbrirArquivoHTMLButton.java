package project.utils;

import project.model.Arquivo;
import project.functions.SelecionarHTML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbrirArquivoHTMLButton implements ActionListener {
    private JFrame parentFrame;
    private static JTextPane textPane;
    private static SelecionarHTML selecionarArquivo = new SelecionarHTML();

    public AbrirArquivoHTMLButton(JFrame parentFrame, JTextPane textPane) {
        this.parentFrame = parentFrame;
        this.textPane = textPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Arquivo arquivoSelecionado = selecionarArquivo.selecionarArquivo(parentFrame);
        if (arquivoSelecionado != null) {
            textPane.setText(arquivoSelecionado.getNomeArquivo());
        } else {
            textPane.setText("Cancelado");
        }
    }
}
