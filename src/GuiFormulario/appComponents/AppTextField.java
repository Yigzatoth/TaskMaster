package GuiFormulario.appComponents;

import javax.swing.JTextField;
import GuiFormulario.Design.GuiConstants;

public class AppTextField extends JTextField implements GuiConstants {

	public AppTextField() {
		super();
		setFont(FONT_PLAIN);
		setPreferredSize(DIMENSION_INPUT_FIELD);
		setBackground(COLOR_NEON_PURPLE);
		setForeground(COLOR_INPUT_TEXT);
		setCaretColor(COLOR_INPUT_TEXT);
	}
}