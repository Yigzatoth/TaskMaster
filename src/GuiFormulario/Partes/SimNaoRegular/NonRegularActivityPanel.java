package GuiFormulario.Partes.SimNaoRegular;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppPanel;
import GuiFormulario.appComponents.AppRadioButton;
import GuiFormulario.appComponents.AppScrollPane;
import GuiFormulario.appComponents.AppTextArea;

public class NonRegularActivityPanel extends AppPanel implements GuiConstants {

    private JRadioButton rbConsulta, rbBurocracia, rbOutros;
    private ButtonGroup grupoRadio;
    private JTextArea txtAreaOutros;
    private AppScrollPane scrollArea;
    
    private AppPanel painelEsquerdo;
    private AppPanel painelDireito;

    /**
     * Construtor do NonRegularActivityPanel.
     */
    public NonRegularActivityPanel() {
        super(new GridLayout(1, 2, GAP_STANDARD, 0));
        
        setBorder(BORDER_COMPOUND_OCASIONAL);

        painelEsquerdo = new AppPanel(null, false);
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.Y_AXIS));

        AppLabel lblTitulo = new AppLabel("Occasional Activity:");
        painelEsquerdo.add(lblTitulo);
        painelEsquerdo.add(Box.createVerticalStrut(STRUT_MEDIUM));

        rbConsulta = new AppRadioButton("Doctor appointment");
        rbBurocracia = new AppRadioButton("Bureaucracy");
        rbOutros = new AppRadioButton("Others");

        grupoRadio = new ButtonGroup();
        grupoRadio.add(rbConsulta);
        grupoRadio.add(rbBurocracia);
        grupoRadio.add(rbOutros);

        painelEsquerdo.add(rbConsulta);
        painelEsquerdo.add(rbBurocracia);
        painelEsquerdo.add(rbOutros);

        painelDireito = new AppPanel(null, false);
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.Y_AXIS));
        painelDireito.setBorder(MARGIN_OUTROS_SCROLL);

        txtAreaOutros = new AppTextArea(3, 10);
        
        scrollArea = new AppScrollPane(txtAreaOutros);
        scrollArea.setVisible(false);
        painelDireito.add(scrollArea);
        
        painelDireito.add(scrollArea);

        add(painelEsquerdo);
        add(painelDireito);

        rbOutros.addItemListener(e -> {
            boolean selecionado = (e.getStateChange() == ItemEvent.SELECTED);
            scrollArea.setVisible(selecionado);
            revalidate();
            repaint();
        });
    }

    /**
     * Ativa ou desativa todos os componentes deste painel.
     */
    public void setPainelAtivo(boolean ativo) {
        rbConsulta.setEnabled(ativo);
        rbBurocracia.setEnabled(ativo);
        rbOutros.setEnabled(ativo);

        if (!ativo) {
            grupoRadio.clearSelection();
            scrollArea.setVisible(false);
            txtAreaOutros.setText("");
        }
    }
    
    /**
     * Extrai a atividade ocasional selecionada.
     */
    public String getAtividadeSelecionada() {
        if (rbConsulta.isSelected()) return "Doctor appointment";
        if (rbBurocracia.isSelected()) return "Bureaucracy";
        if (rbOutros.isSelected()) return "Others";
        return "None";
    }

    /**
     * Extrai o texto detalhado escrito na JTextArea.
     */
    public String getTextoOutros() {
        return txtAreaOutros.getText().trim();
    }

    /**
     * Define a atividade ocasional selecionada.
     */
    public void setAtividadeSelecionada(String atividade) {
        if ("Medical Consultation".equalsIgnoreCase(atividade)) rbConsulta.setSelected(true);
        else if ("Bureaucracy".equalsIgnoreCase(atividade)) rbBurocracia.setSelected(true);
        else if ("Others".equalsIgnoreCase(atividade)) rbOutros.setSelected(true);
        else grupoRadio.clearSelection();
    }

    /**
     * Define o texto detalhado na JTextArea.
     */
    public void setTextoOutros(String texto) {
        txtAreaOutros.setText(texto != null ? texto : "");
    }
}