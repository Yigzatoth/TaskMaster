package GuiFormulario.Partes.CoisasNecessarias;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppPanel;
import GuiFormulario.appComponents.AppScrollPane;
import GuiFormulario.appComponents.AppTextArea;

public class DiverseStuffPanel extends AppPanel implements GuiConstants {

	private JTextArea txtAreaDiversos;
	private JScrollPane scrollDiversos;

	/**
	 * Construtor do DiverseStuffPanel.
	 */
	public DiverseStuffPanel() {
    	super(new BorderLayout(), false);
        setBorder(MARGIN_DIVERSE_STUFF);
        
        AppLabel lblSubtitulo = new AppLabel("Miscellaneous:");

        Box topoBox = Box.createVerticalBox();
        topoBox.add(lblSubtitulo);
        topoBox.add(Box.createVerticalStrut(STRUT_MEDIUM));
        
        add(topoBox, BorderLayout.NORTH);

        txtAreaDiversos = new AppTextArea(3, 10);
        
        // Usa o novo componente costumizado aqui
        scrollDiversos = new AppScrollPane(txtAreaDiversos);
        add(scrollDiversos, BorderLayout.CENTER);
    }
	/**
	 * Extrai o texto digitado no campo de coisas diversas.
	 */
	public String getTextoDiversos() {
		return txtAreaDiversos.getText().trim();
	}

	/**
	 * Define o texto no campo de coisas diversas.
	 */
	public void setTextoDiversos(String texto) {
		txtAreaDiversos.setText(texto != null ? texto : "");
	}
}