package GuiFormulario.Partes;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppComboBox;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppPanel;

/**
 * Componente independente para a seleção do tipo de entrada.
 */
public class EntryComboBox extends AppPanel implements GuiConstants {

	private AppComboBox<String> comboTipoEntrada;

	/**
	 * Construtor do EntryComboBox.
	 */
	public EntryComboBox() {
		super(new GridLayout(1, 1), false);
		setBorder(BORDER_COMPOUND_STANDARD);

		AppPanel painelInterno = new AppPanel(null, false);
		painelInterno.setLayout(new BoxLayout(painelInterno, BoxLayout.Y_AXIS));

		// Título centralizado no topo
        AppLabel lblTitulo = new AppLabel("Entry type:");
        lblTitulo.setAlignmentX(CENTER_ALIGNMENT);

        // Inicialização da ComboBox
        String[] itens = { "New entry", "Modify entry" };
        comboTipoEntrada = new AppComboBox<>(itens);
        comboTipoEntrada.setAlignmentX(CENTER_ALIGNMENT);

		painelInterno.add(lblTitulo);
		painelInterno.add(Box.createVerticalStrut(STRUT_MEDIUM));
		painelInterno.add(comboTipoEntrada);

		add(painelInterno);
	}

	// FormExtractor le a JComboBox
	public AppComboBox<String> getComboTipoEntrada() {
		return comboTipoEntrada;
	}
}