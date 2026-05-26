package GuiFormulario.Partes.Buttons;

import java.awt.FlowLayout;

import GuiFormulario.appComponents.AppPanel;
import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppButton;

/**
 * Componente autónomo para o botão de consulta.
 */
public class ButtonOne extends AppPanel implements GuiConstants {

    private AppButton btnConsultar;

    public ButtonOne() {
        super(new FlowLayout(FlowLayout.CENTER, 0, 0), false);
        btnConsultar = new AppButton("Check list");
        add(btnConsultar);
    }

    public AppButton getBtnConsultar() {
        return btnConsultar;
    }
}