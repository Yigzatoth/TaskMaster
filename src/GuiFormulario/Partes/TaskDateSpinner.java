package GuiFormulario.Partes;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppPanel;
import GuiFormulario.appComponents.AppSpinner;

/**
 * Alternativa com JSpinner para introdução de data.
 */
public class TaskDateSpinner extends AppPanel implements GuiConstants {

    private AppSpinner taskDateSpinner; // Ajusta para o teu tipo de componente real se necessário

    /**
     * Construtor do TaskDateSpinner.
     */
    public TaskDateSpinner() {
        super(new GridLayout(1, 1), false);
        setBorder(BORDER_COMPOUND_STANDARD);

        AppPanel painelInterno = new AppPanel(null, false);
        painelInterno.setLayout(new BoxLayout(painelInterno, BoxLayout.Y_AXIS));
        
        // Título centralizado no topo
        AppLabel lblTitulo = new AppLabel("Task date:");
        lblTitulo.setAlignmentX(CENTER_ALIGNMENT);

        // Inicialização do teu Spinner de data existente
        taskDateSpinner = new AppSpinner();
        taskDateSpinner.setAlignmentX(CENTER_ALIGNMENT);

        painelInterno.add(lblTitulo);
        painelInterno.add(Box.createVerticalStrut(STRUT_MEDIUM));
        painelInterno.add(taskDateSpinner);

        add(painelInterno);
    }

    public AppSpinner getTaskDateSpinner() {
        return taskDateSpinner;
    }
    
    public java.util.Date getDataTarefa() {
        return (java.util.Date) taskDateSpinner.getValue();
    }
}