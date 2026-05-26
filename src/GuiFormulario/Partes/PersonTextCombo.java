package GuiFormulario.Partes;

import java.awt.FlowLayout;

import GuiFormulario.appComponents.AppPanel;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppTextField;
import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppComboBox;

public class PersonTextCombo extends AppPanel implements GuiConstants {

    private AppTextField txtNomePessoa;
    private AppComboBox<String> comboParentesco;

    /**
     * Construtor do PersonTextCombo.
     */
    public PersonTextCombo() {
        super(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        
        String[] parentescos = {"Father", "Mother", "Child 1", "Child 2"};
        comboParentesco = new AppComboBox<>(parentescos);
        add(comboParentesco);
        
        AppLabel lblQuem = new AppLabel("Someone else? ");
        add(lblQuem);
        
        txtNomePessoa = new AppTextField();
        add(txtNomePessoa);
    }

    /**
     * Extrai o nome digitado no campo de texto.
     */
    public String getNomePessoa() {
        return txtNomePessoa.getText().trim();
    }

    /**
     * Extrai o parentesco selecionado na ComboBox.
     */
    public String getParentesco() {
        return (String) comboParentesco.getSelectedItem();
    }

    /**
     * Define o nome da pessoa no campo de texto.
     */
    public void setNomePessoa(String nome) {
        txtNomePessoa.setText(nome != null ? nome : "");
    }

    /**
     * Define o parentesco selecionado na ComboBox.
     */
    public void setParentesco(String parentesco) {
        if (parentesco != null) {
            comboParentesco.setSelectedItem(parentesco);
        }
    }
}