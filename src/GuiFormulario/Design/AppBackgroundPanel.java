package GuiFormulario.Design;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Painel base de design que desenha a imagem de fundo.
 * Pode ser reaproveitado em qualquer outra janela no futuro.
 */
public class AppBackgroundPanel extends JPanel {
    
    private Image imagemFundo;

    public AppBackgroundPanel(String caminhoImagem) {
        setLayout(new BorderLayout()); // Garante que o conteúdo interior se expande
        
        // Vai buscar a imagem à pasta resources configurada anteriormente
        URL url = getClass().getResource(caminhoImagem);
        if (url != null) {
            this.imagemFundo = new ImageIcon(url).getImage();
        } else {
            System.err.println("Error: Image not found at: " + caminhoImagem);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemFundo != null) {
            // Desenha a imagem de forma a preencher sempre o tamanho atual da janela
            g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}