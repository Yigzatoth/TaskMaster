package GuiFormulario;

import javax.swing.Box;
import javax.swing.BoxLayout;

import GuiFormulario.Controladores.SaveController;
import GuiFormulario.Design.GuiConstants;
import GuiFormulario.Partes.ButtonSelection;
import GuiFormulario.Partes.EntryComboBox;
import GuiFormulario.Partes.HeaderPanel;
import GuiFormulario.Partes.PersonTextCombo;
import GuiFormulario.Partes.SerialNumberPanel;
import GuiFormulario.Partes.TaskDateSpinner;
import GuiFormulario.Partes.ToBringMainPanel;
import GuiFormulario.Partes.UrgencySlider;
import GuiFormulario.Partes.SimNaoRegular.ActivitySectionPanel;
import GuiFormulario.appComponents.AppPanel;

/**
 * O RootPanel que estandardiza os restantes componentes.
 * Mantido minimalista: apenas instancia a árvore visual e associa o controlador externo.
 */
public class RootPanel extends AppPanel implements GuiConstants {

    // Referências privadas guardadas para uso do FormExtractor
	private HeaderPanel headerPanel;
    private EntryComboBox entryComboBox;
    private SerialNumberPanel serialNumberPanel;
    private TaskDateSpinner taskDateSpinner;
    private PersonTextCombo personTextCombo;
    private ActivitySectionPanel activitySectionPanel;
    private UrgencySlider urgencySlider;
    private ToBringMainPanel toBringMainPanel;
    private ButtonSelection buttonSelection;

    /**
     * Construtor do RootPanel.
     */
    public RootPanel() {
        super(null, false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BORDER_MAIN_PANEL);
        
        // Título do Topo
        headerPanel = new HeaderPanel();
        add(headerPanel);
        add(Box.createVerticalStrut(STRUT_LARGE));
        
        // Tipo de Entrada + Data
        AppPanel linhaSuperior = new AppPanel(new java.awt.GridLayout(1, 3, GAP_STANDARD, 0), false);
        
        entryComboBox = new EntryComboBox();
        serialNumberPanel = new SerialNumberPanel();
        taskDateSpinner = new TaskDateSpinner();
        
        linhaSuperior.add(entryComboBox);
        linhaSuperior.add(serialNumberPanel); 
        linhaSuperior.add(taskDateSpinner);
        
        add(linhaSuperior);
        add(Box.createVerticalStrut(STRUT_LARGE));
        
        // Quem + Responsável
        personTextCombo = new PersonTextCombo();
        add(personTextCombo);
        add(Box.createVerticalStrut(STRUT_LARGE));
        
        // Atividade Regular / Ocasional
        activitySectionPanel = new ActivitySectionPanel();
        add(activitySectionPanel);
        add(Box.createVerticalStrut(STRUT_LARGE)); 
        
        // Slider de Urgência
        urgencySlider = new UrgencySlider();
        add(urgencySlider);
        add(Box.createVerticalStrut(STRUT_LARGE));
        
        // Coisas Necessárias = Fixas + Diversas
        toBringMainPanel = new ToBringMainPanel();
        add(toBringMainPanel);
        add(Box.createVerticalStrut(STRUT_LARGE));  
        
        // Botões de Ação
        buttonSelection = new ButtonSelection();
        add(buttonSelection);

        // controlador isolado e associado ao botão Gravar
        SaveController controlador = new SaveController(this);
        buttonSelection.associarAcaoConsultar(controlador);
        buttonSelection.associarAcaoGravar(controlador);
        buttonSelection.associarAcaoApagar(controlador);
        
        controlador.configurarComportamentosDinamicos();
    }

    // GETTERS PÚBLICOS: FormExtractor acede aos componentes isolados
    public HeaderPanel getHeaderPanel() { return headerPanel; }
    public EntryComboBox getEntryComboBox() { return entryComboBox; }
    public SerialNumberPanel getSerialNumberPanel() { return serialNumberPanel; }
    public TaskDateSpinner getTaskDateSpinner() { return taskDateSpinner; }
    public PersonTextCombo getPersonTextCombo() { return personTextCombo; }
    public ActivitySectionPanel getActivitySectionPanel() { return activitySectionPanel; }
    public UrgencySlider getUrgencySlider() { return urgencySlider; }
    public ToBringMainPanel getToBringMainPanel() { return toBringMainPanel; }
    public ButtonSelection getButtonSelection() { return buttonSelection; }
}