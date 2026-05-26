package GuiFormulario.Partes.Buttons;

import java.awt.FlowLayout;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppButton;
import GuiFormulario.appComponents.AppPanel;

/**
 * Componente autónomo para o botão de gravação.
 */
public class ButtonThree extends AppPanel implements GuiConstants {

    private AppButton btnGravar;

    public ButtonThree() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 0), false);       
        btnGravar = new AppButton("Save"); 
        add(btnGravar);
    }

    public AppButton getBtnGravar() {
        return btnGravar;
    }
}