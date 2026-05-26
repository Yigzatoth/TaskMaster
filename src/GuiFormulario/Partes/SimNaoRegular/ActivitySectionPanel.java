package GuiFormulario.Partes.SimNaoRegular;

import java.awt.CardLayout;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.Partes.ActivityComboLabel;
import GuiFormulario.appComponents.AppComboBox;
import GuiFormulario.appComponents.AppPanel;

/**
 * Classe controladora autónoma que gere a linha horizontal da atividade.
 * Utiliza CardLayout para garantir que os painéis da direita se esticam
 * e aparecem corretamente desde o arranque do programa.
 */
public class ActivitySectionPanel extends AppPanel implements GuiConstants {

    private ActivityComboLabel painelDecisao;
    private RegularActivityPanel painelSim;
    private NonRegularActivityPanel painelNao;
    
    private CardLayout layoutCartas;
    private AppPanel colunaDireita;

    /**
     * Construtor do ActivitySectionPanel.
     */
    public ActivitySectionPanel() {
        super(LAYOUT_LINHA, false);

        painelDecisao = new ActivityComboLabel();
        painelSim = new RegularActivityPanel();
        painelNao = new NonRegularActivityPanel();

        add(painelDecisao);

        layoutCartas = new CardLayout();
        colunaDireita = new AppPanel(layoutCartas, false);

        colunaDireita.add(painelSim, "YES");
        colunaDireita.add(painelNao, "NO");
        add(colunaDireita);

        configurarComportamentoDinamico();
    }

    /**
     * Gere a alternância de visibilidade entre os painéis através das etiquetas do CardLayout.
     */
    private void configurarComportamentoDinamico() {
        AppComboBox<String> comboRegular = painelDecisao.getComboRegular();
        
        // Configuração Sim
        comboRegular.setSelectedIndex(0); 
        layoutCartas.show(colunaDireita, "YES");

        comboRegular.addActionListener(e -> {
            if (painelDecisao.isRegular()) {
                layoutCartas.show(colunaDireita, "YES");
            } else {
                layoutCartas.show(colunaDireita, "NO");
            }
            revalidate();
            repaint();
        });
    }
    
    public ActivityComboLabel getPainelDecisao() {
        return painelDecisao;
    }

    public RegularActivityPanel getRegularActivityPanel() {
        return painelSim;
    }

    public NonRegularActivityPanel getNonRegularActivityPanel() {
        return painelNao;
    }
    
}