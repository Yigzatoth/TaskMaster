package GuiFormulario.Partes;

import java.awt.FlowLayout;

import GuiFormulario.appComponents.AppPanel;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppComboBox;

/**
 * Componente independente para verificar se a atividade é regular ou não.
 */
public class ActivityComboLabel extends AppPanel implements GuiConstants {

    private AppComboBox<String> comboRegular;

    /**
     * Construtor do ActivityComboLabel.
     */
    public ActivityComboLabel() {
        super(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        AppLabel lblPergunta = new AppLabel("Is the activity a regular occurrence? ");
        add(lblPergunta);
        
        String[] opcoes = {"Yes", "No"};
        comboRegular = new AppComboBox<>(opcoes);
        add(comboRegular);
    }

    /**
     * Método getter para expor a ComboBox. 
     */
    public AppComboBox<String> getComboRegular() {
        return comboRegular;
    }

    /**
     * Método para verificar se a opção = "Sim".
     */
    public boolean isRegular() {
        return "Yes".equals(comboRegular.getSelectedItem());
    }
}