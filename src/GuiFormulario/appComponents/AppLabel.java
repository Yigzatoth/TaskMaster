package GuiFormulario.appComponents;

import java.awt.LayoutManager;

import javax.swing.JLabel;

import GuiFormulario.Design.GuiConstants;

public class AppLabel extends JLabel implements GuiConstants {

    public AppLabel(String text) {
        super(text);
        setFont(FONT_LABEL_BOLD); // fonte padrão para labels
        setForeground(COLOR_TEXT_MAIN); // Aplica o Amarelo Neon
        setOpaque(false);
    }
}
