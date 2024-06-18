package project.view;

import project.utils.MainWindow;

import javax.swing.*;

/**
 * Classe principal que inicializa a aplicação.
 */
public class Main {
    /**
     * Método principal que inicia a aplicação Swing.
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Utiliza SwingUtilities.invokeLater para garantir que a interface gráfica seja criada de forma segura
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Cria uma instância da janela principal
                MainWindow mainWindow = new MainWindow();
                // Obtém o frame da janela principal
                mainWindow.getFrame();
            }
        });
    }
}
