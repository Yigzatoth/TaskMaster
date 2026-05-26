package GuiFormulario.appComponents;

import java.awt.Dimension;

import javax.swing.JSlider;

import GuiFormulario.Design.GuiConstants;

public class AppSlider extends JSlider implements GuiConstants{
	
	public AppSlider(int min, int max, int value) {
		super(JSlider.HORIZONTAL, min, max, value);
		setFont(FONT_PLAIN);
		setMajorTickSpacing(1);
		setPaintTicks(true);
		setPaintLabels(true);
		setPreferredSize(new Dimension(DIMENSION_INPUT_FIELD.width, 45));
		setForeground(COLOR_TEXT_MAIN); // Aplica o Amarelo Neon
		setOpaque(false);
	}

}
