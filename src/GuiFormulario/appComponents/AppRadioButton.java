package GuiFormulario.appComponents;

import javax.swing.JRadioButton;
import GuiFormulario.Design.GuiConstants;

public class AppRadioButton extends JRadioButton implements GuiConstants {

	public AppRadioButton(String text) {
		super(text);
		setFont(FONT_PLAIN);
		setOpaque(false);
		setContentAreaFilled(false); // Força a remoção do fundo nativo
		setForeground(COLOR_TEXT_MAIN); // Aplica o Amarelo Neon
	}
}