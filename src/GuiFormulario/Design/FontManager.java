package GuiFormulario.Design;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

public class FontManager {

    /**
     * Carrega uma fonte da pasta resources e aplica o tamanho e estilo desejados.
     */
    public static Font carregarFonte(String caminho, float tamanho, int estilo) {
        try (InputStream is = FontManager.class.getResourceAsStream(caminho)) {
            if (is == null) {
                System.err.println("Aesthetic Error: Font not found at " + caminho);
                return new Font("Arial", estilo, (int) tamanho); // Fallback de segurança
            }
            
            Font fonteBase = Font.createFont(Font.TRUETYPE_FONT, is);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fonteBase);
            
            return fonteBase.deriveFont(estilo, tamanho);
            
        } catch (Exception e) {
            System.err.println("Error loading font: " + e.getMessage());
            return new Font("Arial", estilo, (int) tamanho); // Fallback de segurança
        }
    }
}