package GuiFormulario.Partes;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.Partes.Buttons.ButtonOne;
import GuiFormulario.Partes.Buttons.ButtonThree;
import GuiFormulario.Partes.Buttons.ButtonTwo;
import GuiFormulario.appComponents.AppPanel;

public class ButtonSelection extends AppPanel implements GuiConstants {

	private ButtonOne painelConsultar;
	private ButtonTwo painelApagar;
	private ButtonThree painelGravar;

	/**
	 * Construtor do ButtonSelection.
	 */
	public ButtonSelection() {
		super(new FlowLayout(FlowLayout.CENTER, 15, 5));

		painelConsultar = new ButtonOne();
		painelApagar = new ButtonTwo();
		painelGravar = new ButtonThree();

		add(painelConsultar);
		add(painelApagar);
		add(painelGravar);

	}

	/**
     * Associa o controlador ao botão Consultar Histórico.
     */
    public void associarAcaoConsultar(ActionListener listener) {
        painelConsultar.getBtnConsultar().addActionListener(listener);
        painelConsultar.getBtnConsultar().setActionCommand("CHECK");
    }
	
	/**
	 * Associa o controlador ao botão Gravar e define o comando de ação.
	 */
	public void associarAcaoGravar(ActionListener listener) {
		painelGravar.getBtnGravar().addActionListener(listener);
		painelGravar.getBtnGravar().setActionCommand("SAVE");
	}

	/**
	 * Associa o controlador ao botão Apagar e define o comando de ação.
	 */
	public void associarAcaoApagar(ActionListener listener) {
		// Vai buscar o JButton de dentro do teu painel customizado ButtonTwo
		// Certifica-te de que o método getBtnApagar() existe na classe ButtonTwo, ou
		// ajusta o nome.
		painelApagar.getBtnApagar().addActionListener(listener);
		painelApagar.getBtnApagar().setActionCommand("DELETE");
	}

	public ButtonTwo getPainelApagar() {
		return painelApagar;
	}

	public ButtonThree getPainelGravar() {
		return painelGravar;
	}

}
