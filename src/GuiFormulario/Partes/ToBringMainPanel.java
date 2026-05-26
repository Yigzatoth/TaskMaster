package GuiFormulario.Partes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.Partes.CoisasNecessarias.DiverseStuffPanel;
import GuiFormulario.Partes.CoisasNecessarias.FixedStuffPanel;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppPanel;

public class ToBringMainPanel extends AppPanel implements GuiConstants {

    private FixedStuffPanel painelFixos;
    private DiverseStuffPanel painelDiversos;

    /**
     * Construtor do ToBringMainPanel.
     */
    public ToBringMainPanel() {
        super(null); 
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        AppPanel painelAoCentro = new AppPanel(new FlowLayout(FlowLayout.CENTER), false);
        AppLabel lblTituloSecao = new AppLabel("Necessary Items");
        painelAoCentro.add(lblTituloSecao);
        
        add(painelAoCentro);
        add(Box.createVerticalStrut(5));

        AppPanel linhaConteudo = new AppPanel(new GridLayout(1, 2, 20, 0), false);
        
        painelFixos = new FixedStuffPanel();
        painelDiversos = new DiverseStuffPanel();

        linhaConteudo.add(painelFixos);
        linhaConteudo.add(painelDiversos);

        add(linhaConteudo, BorderLayout.CENTER);
    }
    
    public FixedStuffPanel getPainelFixos() {

        return painelFixos; 
    }

    public DiverseStuffPanel getPainelDiversos() {

        return painelDiversos;
    }
}