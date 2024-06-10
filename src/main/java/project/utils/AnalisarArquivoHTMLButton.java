package project.utils;

import project.functions.SelecionarHTML;
import project.model.ArquivoHTML;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalisarArquivoHTMLButton implements ActionListener {
    private JTable table;
    private SelecionarHTML selecionarArquivo;

    public AnalisarArquivoHTMLButton(JTable table, SelecionarHTML selecionarArquivo) {
        this.table = table;
        this.selecionarArquivo = selecionarArquivo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArquivoHTML arquivo = selecionarArquivo.getArquivo();
        if (arquivo != null) {
            DefaultTableModel modelo = (DefaultTableModel) table.getModel();
            modelo.addRow(new Object[]{"html", 1});
            modelo.addRow(new Object[]{"head", 1});
            modelo.addRow(new Object[]{"title", 1});
            modelo.addRow(new Object[]{"body", 1});
            modelo.addRow(new Object[]{"div", 2});
        } else {
            // Nenhum arquivo selecionado
        }
    }
}
