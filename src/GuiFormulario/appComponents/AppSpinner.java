package GuiFormulario.appComponents;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import GuiFormulario.Design.GuiConstants;

public class AppSpinner extends JSpinner implements GuiConstants {
	/**
     * Configuração padrão para datas (dd/MM/yyyy)
     */	
    public AppSpinner() {
        super(new SpinnerDateModel());
        configurarSpinner("dd/MM/yyyy");
    }
    /**
     * Construtor Customizado
     */    
    public AppSpinner(SpinnerModel model, String dateFormat) {
        super(model);
        configurarSpinner(dateFormat);
    }
    
    private void configurarSpinner(String dateFormat) {
    	setFont(FONT_PLAIN);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(this, dateFormat);
        
        // Aplica as cores diretamente ao campo de texto interno do Spinner
        editor.getTextField().setBackground(COLOR_NEON_PURPLE);
        editor.getTextField().setForeground(COLOR_INPUT_TEXT);
        editor.getTextField().setCaretColor(COLOR_INPUT_TEXT);
        
        setEditor(editor);
        setPreferredSize(DIMENSION_INPUT_FIELD);
    }
}