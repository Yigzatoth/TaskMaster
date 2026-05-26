package GuiFormulario.Partes.SimNaoRegular;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppPanel;
import GuiFormulario.appComponents.AppRadioButton;

/**
 * Construtor do RegularActivityPanel.
 */
public class RegularActivityPanel extends AppPanel implements GuiConstants {

    private JRadioButton rbDesporto, rbArte, rbTerapia;
    private ButtonGroup grupoRadio;
    
    private AppPanel painelEsquerdo;
    private AppPanel painelDireito; 

    /**
     * Construtor do RegularActivityPanel.
     */
    public RegularActivityPanel() {
        super(new GridLayout(1, 2, GAP_STANDARD, 0));
        
        setBorder(BORDER_COMPOUND_STANDARD);

        painelEsquerdo = new AppPanel(null, false);
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.Y_AXIS));

        AppLabel lblTitulo = new AppLabel("Regular Activity:");
        painelEsquerdo.add(lblTitulo);
        painelEsquerdo.add(Box.createVerticalStrut(STRUT_MEDIUM));

        rbDesporto = new AppRadioButton("Sport");
        rbArte = new AppRadioButton("Art");
        rbTerapia = new AppRadioButton("Therapy");

        grupoRadio = new ButtonGroup();
        grupoRadio.add(rbDesporto);
        grupoRadio.add(rbArte);
        grupoRadio.add(rbTerapia);

        painelEsquerdo.add(rbDesporto);
        painelEsquerdo.add(rbArte);
        painelEsquerdo.add(rbTerapia);

        painelDireito = new AppPanel(null, false);

        add(painelEsquerdo);
        add(painelDireito);
    }

    /**
     * Ativa ou desativa todos os componentes deste painel.
     */
    public void setPainelAtivo(boolean ativo) {
        rbDesporto.setEnabled(ativo);
        rbArte.setEnabled(ativo);
        rbTerapia.setEnabled(ativo);
        
        if (!ativo) {
            grupoRadio.clearSelection();
        }
    }
    
    /**
     * Extrai a atividade selecionada através dos RadioButtons.
     */
    public String getAtividadeSelecionada() {
        if (rbDesporto.isSelected()) return "Sport";
        if (rbArte.isSelected()) return "Art";
        if (rbTerapia.isSelected()) return "Therapy";
        return "None";
    }

    /**
     * Define a atividade selecionada através dos RadioButtons.
     */
    public void setAtividadeSelecionada(String atividade) {
        if ("Sport".equalsIgnoreCase(atividade)) rbDesporto.setSelected(true);
        else if ("Art".equalsIgnoreCase(atividade)) rbArte.setSelected(true);
        else if ("Therapy".equalsIgnoreCase(atividade)) rbTerapia.setSelected(true);
        else grupoRadio.clearSelection();
    }
}