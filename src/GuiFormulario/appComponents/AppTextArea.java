package GuiFormulario.appComponents;

import javax.swing.JTextArea;
import GuiFormulario.Design.GuiConstants;

public class AppTextArea extends JTextArea implements GuiConstants {
	
	public AppTextArea(int rows, int columns) {
		super(rows, columns);
		setFont(FONT_PLAIN);
		setLineWrap(true);
		setWrapStyleWord(true);
		setBackground(COLOR_NEON_PURPLE);
		setForeground(COLOR_INPUT_TEXT);
		setCaretColor(COLOR_INPUT_TEXT);
	}
}