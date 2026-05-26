package GuiFormulario.Partes.Buttons;

import java.awt.FlowLayout;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppButton;
import GuiFormulario.appComponents.AppPanel;

/**
 * Componente autónomo para o botão de eliminação.
 */
public class ButtonTwo extends AppPanel implements GuiConstants {

    private AppButton btnApagar;

    public ButtonTwo() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 0), false);
        btnApagar = new AppButton("Delete");
        add(btnApagar);
    }

    public AppButton getBtnApagar() {
        return btnApagar;
    }
}