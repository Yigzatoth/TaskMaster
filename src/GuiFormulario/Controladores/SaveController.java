package GuiFormulario.Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import GuiFormulario.RootPanel;
import GuiFormulario.Modelos.FichaDados;
import GuiFormulario.Partes.HistoryDialog;
import GuiFormulario.Persistencia.SaveManager;
import GuiFormulario.appComponents.AppTextField;

public class SaveController implements ActionListener {

    private RootPanel rootPanel;

    public SaveController(RootPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public void configurarComportamentosDinamicos() {
        JComboBox<String> combo = rootPanel.getEntryComboBox().getComboTipoEntrada();
        
        combo.addActionListener(e -> {
            String selecao = (String) combo.getSelectedItem();
            if ("Modify entry".equalsIgnoreCase(selecao)) {
                rootPanel.getSerialNumberPanel().mostrarModoModificar();
            } else {
                rootPanel.getSerialNumberPanel().mostrarModoNovaEntrada();
                limparFormulario();
            }
        });

        AppTextField txtSerial = rootPanel.getSerialNumberPanel().getTxtModoModificar();
        txtSerial.addActionListener(e -> {
            int serialProcurado = rootPanel.getSerialNumberPanel().getSerialNumber();
            if (serialProcurado != -1) {
                FichaDados dadosAntigos = SaveManager.carregarDados(serialProcurado);
                if (dadosAntigos != null) {
                    FormInjector.injetar(rootPanel, dadosAntigos);
                } else {
                    JOptionPane.showMessageDialog(rootPanel, 
                        "Serial number " + String.format("%04d", serialProcurado) + " not found.", 
                        "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPanel, "Please enter a valid serial number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if ("SAVE".equals(comando)) {
            executarGravacaoOuAlteracao();
        } else if ("DELETE".equals(comando)) {
            executarRemocaoComConfirmacao();
        } else if ("CHECK".equals(comando)) {
            HistoryDialog.mostrar(rootPanel); // Chama diretamente a View
        }
    }

    private void executarGravacaoOuAlteracao() {
        boolean modoModificar = rootPanel.getEntryComboBox().getComboTipoEntrada().getSelectedItem().toString().equalsIgnoreCase("Modify entry");
        
        int serialFicha = rootPanel.getSerialNumberPanel().getSerialNumber();
        if (serialFicha == -1) {
            JOptionPane.showMessageDialog(rootPanel, "Invalid or empty serial number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FichaDados dados = FormExtractor.extrair(rootPanel);
        dados.numeroSerie = serialFicha;

        boolean sucesso = SaveManager.gravarDados(dados, serialFicha);

        if (sucesso) {
            if (modoModificar) {
                JOptionPane.showMessageDialog(rootPanel, "Entry successfully modified!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPanel, "Data successfully saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            limparFormulario();
        } else {
            JOptionPane.showMessageDialog(rootPanel, "Error trying to process the save operation on disk.", "Critical Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void executarRemocaoComConfirmacao() {
        int serialFicha = rootPanel.getSerialNumberPanel().getSerialNumber();
        
        if (serialFicha == -1) {
            JOptionPane.showMessageDialog(rootPanel, "Please enter a valid serial number to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(
            rootPanel, 
            "Are you sure you want to permanently delete entry " + String.format("%04d", serialFicha) + "?", 
            "Delete Confirmation", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE
        );

        if (resposta == JOptionPane.YES_OPTION) {
            boolean apagou = SaveManager.apagarDados(serialFicha);
            if (apagou) {
                JOptionPane.showMessageDialog(rootPanel, "Entry successfully removed.", "Success", JOptionPane.INFORMATION_MESSAGE);
                limparFormulario();
            } else {
                JOptionPane.showMessageDialog(rootPanel, "Could not find or remove the file for this entry.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void limparFormulario() {
        rootPanel.getEntryComboBox().getComboTipoEntrada().setSelectedIndex(0);
        rootPanel.getSerialNumberPanel().mostrarModoNovaEntrada();

        java.awt.Component[] compQuem = rootPanel.getPersonTextCombo().getComponents();
        for (java.awt.Component c : compQuem) {
            if (c instanceof AppTextField) {
                ((AppTextField) c).setText("");
            }
            if (c instanceof JComboBox) {
                ((JComboBox<?>) c).setSelectedIndex(0);
            }
        }

        rootPanel.getActivitySectionPanel().getPainelDecisao().getComboRegular().setSelectedIndex(0);
        rootPanel.getActivitySectionPanel().getRegularActivityPanel().setPainelAtivo(false);
        rootPanel.getActivitySectionPanel().getRegularActivityPanel().setPainelAtivo(true);
        rootPanel.getActivitySectionPanel().getNonRegularActivityPanel().setPainelAtivo(false);
        rootPanel.getActivitySectionPanel().getNonRegularActivityPanel().setPainelAtivo(true);

        java.awt.Component[] compSlider = rootPanel.getUrgencySlider().getComponents();
        for (java.awt.Component c : compSlider) {
            if (c instanceof javax.swing.JSlider) {
                ((javax.swing.JSlider) c).setValue(1);
            }
        }

        java.awt.Component[] compFixos = rootPanel.getToBringMainPanel().getPainelFixos().getComponents();
        for (java.awt.Component c : compFixos) {
            if (c instanceof JCheckBox) {
                ((JCheckBox) c).setSelected(false);
            }
        }

        java.awt.Component[] compDiv = rootPanel.getToBringMainPanel().getPainelDiversos().getComponents();
        for (java.awt.Component c : compDiv) {
            if (c instanceof javax.swing.JScrollPane) {
                java.awt.Component visor = ((javax.swing.JScrollPane) c).getViewport().getView();
                if (visor instanceof JTextArea) {
                    ((JTextArea) visor).setText("");
                }
            } else if (c instanceof JTextArea) {
                ((JTextArea) c).setText("");
            }
        }
    }
}