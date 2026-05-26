package GuiFormulario.Partes.CoisasNecessarias;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppCheckBox;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppPanel;

public class FixedStuffPanel extends AppPanel implements GuiConstants {
    
    private JCheckBox chkAgua, chkComida, chkBilhetes, chkID;

    /**
     * Construtor do FixedStuffPanel.
     */
    public FixedStuffPanel() {
        super(null, false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        setBorder(MARGIN_FIXED_STUFF);
        
        AppLabel lblSubtitulo = new AppLabel("Fixed Items:");
        add(lblSubtitulo);
        add(Box.createVerticalStrut(STRUT_MEDIUM));

        chkAgua = new AppCheckBox("Water");
        chkComida = new AppCheckBox("Food");
        chkBilhetes = new AppCheckBox("Tickets");
        chkID = new AppCheckBox("ID");

        add(chkAgua);
        add(chkComida);
        add(chkBilhetes);
        add(chkID);
    }
    
    public boolean isAguaSelected() { return chkAgua.isSelected(); }
    public boolean isComidaSelected() { return chkComida.isSelected(); }
    public boolean isBilhetesSelected() { return chkBilhetes.isSelected(); }
    public boolean isIdSelected() { return chkID.isSelected(); }

    public void setAguaSelected(boolean selecionado) { chkAgua.setSelected(selecionado); }
    public void setComidaSelected(boolean selecionado) { chkComida.setSelected(selecionado); }
    public void setBilhetesSelected(boolean selecionado) { chkBilhetes.setSelected(selecionado); }
    public void setIdSelected(boolean selecionado) { chkID.setSelected(selecionado); }
}