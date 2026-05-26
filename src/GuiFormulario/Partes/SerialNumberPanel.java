package GuiFormulario.Partes;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.Persistencia.SerialManager;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppPanel;
import GuiFormulario.appComponents.AppTextField;

/**
 * Painel intermédio que gere a exibição estática do número de série ou o campo
 * de inserção manual, dependendo do tipo de entrada.
 */
public class SerialNumberPanel extends AppPanel implements GuiConstants {

    private CardLayout cardLayout;
    private AppPanel cardContainer;

    // Componentes dos dois cenários
    private AppLabel lblModoNova;
    private AppTextField txtModoModificar;

    public SerialNumberPanel() {
        super(new GridLayout(1, 1), false);
        setBorder(BORDER_COMPOUND_STANDARD);

        AppPanel painelPrincipal = new AppPanel(null, false);
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        // Título centralizado no topo
        AppLabel lblTitulo = new AppLabel("Serial Nr.");
        lblTitulo.setAlignmentX(CENTER_ALIGNMENT);
        painelPrincipal.add(lblTitulo);
        painelPrincipal.add(Box.createVerticalStrut(STRUT_MEDIUM));

        // Contentor dinâmico com CardLayout
        cardLayout = new CardLayout();
        cardContainer = new AppPanel(cardLayout, false);
        cardContainer.setAlignmentX(CENTER_ALIGNMENT);

        // Situacao 1: Nova Entrada (Apenas leitura) - Centralizado
        int serialAtual = SerialManager.obterProximoSerial();
        lblModoNova = new AppLabel(String.format("%04d", serialAtual));
        lblModoNova.setFont(FONT_PLAIN);
        lblModoNova.setHorizontalAlignment(SwingConstants.CENTER);
        lblModoNova.setAlignmentX(CENTER_ALIGNMENT);
        cardContainer.add(lblModoNova, "NEW");

        // Situacao 2: Modificar Entrada (Campo de texto numérico) - Centralizado
        txtModoModificar = new AppTextField();
        txtModoModificar.setAlignmentX(CENTER_ALIGNMENT);
        cardContainer.add(txtModoModificar, "MODIFY");

        painelPrincipal.add(cardContainer);
        add(painelPrincipal);

        mostrarModoNovaEntrada();
    }

    public void mostrarModoNovaEntrada() {
        // Atualiza o numero do contador
        lblModoNova.setText(String.format("%04d", SerialManager.obterProximoSerial()));
        cardLayout.show(cardContainer, "NEW");
    }

    public void mostrarModoModificar() {
        txtModoModificar.setText("");
        cardLayout.show(cardContainer, "MODIFY");
    }

    /**
     * Getter para o FormExtractor recolher o valor digitado (Modificar) ou o atual
     */
    public int getSerialNumber() {
        // Se o campo de inserção manual estiver visível, lê o que o utilizador digitou
        if (txtModoModificar.isShowing()) {
            try {
                return Integer.parseInt(txtModoModificar.getText().trim());
            } catch (NumberFormatException e) {
                return -1; // Flag de erro: digitou letras ou deixou vazio
            }
        }
        // Se estiver em modo Nova Entrada, devolve o número atual estático que está
        // guardado no ecrã
        try {
            return Integer.parseInt(lblModoNova.getText().trim());
        } catch (NumberFormatException e) {
            return SerialManager.obterProximoSerial();
        }
    }

    public AppTextField getTxtModoModificar() {
        return txtModoModificar;
    }
}