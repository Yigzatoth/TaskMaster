package GuiFormulario.appComponents;

import javax.swing.JButton;

import GuiFormulario.Design.GuiConstants;

public class AppButton extends JButton implements GuiConstants {

	public AppButton(String text) {
		super(text);
		setFocusable(false);
		setFont(FONT_PLAIN);
		setPreferredSize(DIMENSION_INPUT_FIELD);
		
		// Definições estéticas centralizadas
		setBackground(COLOR_NEON_PURPLE); // Fundo Roxo Neon
		setForeground(COLOR_TEXT_MAIN);   // Texto Amarelo Neon
	}

}
