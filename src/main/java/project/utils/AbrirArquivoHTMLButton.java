package project.utils;

import project.functions.SelecionarHTML;
import project.model.ArquivoHTML;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbrirArquivoHTMLButton implements ActionListener {
    private JFrame parentFrame;
    private JTextPane textPane;
    private SelecionarHTML selecionarArquivo;

    public AbrirArquivoHTMLButton(JFrame parentFrame, JTextPane textPane, SelecionarHTML selecionarArquivo) {
        this.parentFrame = parentFrame;
        this.textPane = textPane;
        this.selecionarArquivo = selecionarArquivo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArquivoHTML arquivoSelecionado = selecionarArquivo.selecionarArquivo(parentFrame);
        if (arquivoSelecionado != null) {
            textPane.setText(arquivoSelecionado.getNomeArquivo());
        } else {
            textPane.setText("Cancelado");
        }
    }
}
