package GuiFormulario;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import GuiFormulario.Design.AppBackgroundPanel;
import GuiFormulario.Design.SoundManager;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Task Master! or something like that..");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // 0. Inicia musica de fundo
        SoundManager.iniciarMusicaFundo("/resources/synthwave.wav");

        // 1. Instancia o Design de Fundo
        AppBackgroundPanel painelFundo = new AppBackgroundPanel("/resources/fundo4.png");
        
                // 2. Instancia o formulário
        RootPanel rootPanel = new RootPanel();
        
        // 3. Configura o ScrollPane para ser totalmente transparente
        JScrollPane scrollPane = new JScrollPane(rootPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        // 4. Junta tudo
        painelFundo.add(scrollPane, BorderLayout.CENTER);
        add(painelFundo, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}