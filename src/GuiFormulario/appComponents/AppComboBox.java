package GuiFormulario.appComponents;

import javax.swing.JComboBox;
import GuiFormulario.Design.GuiConstants;

public class AppComboBox<E> extends JComboBox<E> implements GuiConstants {
	
	public AppComboBox() {
		super();
		configurarCores();
	}

	public AppComboBox(E[] items) {
        super(items);
        configurarCores();
    }
	
	private void configurarCores() {
		setFont(FONT_PLAIN);
		setPreferredSize(DIMENSION_INPUT_FIELD);
		setBackground(COLOR_NEON_PURPLE);
		setForeground(COLOR_INPUT_TEXT);
	}
}