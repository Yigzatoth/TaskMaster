package GuiFormulario.Partes;

import java.awt.FlowLayout;

import GuiFormulario.appComponents.AppPanel;
import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppSlider;

public class UrgencySlider extends AppPanel implements GuiConstants {

    private AppSlider sliderUrgencia;

    /**
     * Construtor do UrgencySlider.
     */
    public UrgencySlider() {
        super(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        AppLabel lblUrgencia = new AppLabel("Aprox Duration");
        add(lblUrgencia);
        
        sliderUrgencia = new AppSlider(1, 10, 1);
        add(sliderUrgencia);
    }

    /**
     * Extrai o valor numérico atual selecionado no JSlider.
     */
    public int getValorUrgencia() {
        return sliderUrgencia.getValue();
    }

    /**
     * Define o valor numérico no JSlider.
     */
    public void setValorUrgencia(int valor) {
        sliderUrgencia.setValue(valor);
    }
}