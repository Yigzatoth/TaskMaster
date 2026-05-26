package GuiFormulario.appComponents;

import javax.swing.JCheckBox;
import GuiFormulario.Design.GuiConstants;

public class AppCheckBox extends JCheckBox implements GuiConstants {
	
	public AppCheckBox(String text) {
		super(text);
		setFont(FONT_PLAIN);
		setOpaque(false);
		setContentAreaFilled(false); // Força a remoção do fundo nativo
		setForeground(COLOR_TEXT_MAIN); // Aplica o Amarelo Neon
	}
}