package GuiFormulario.Partes;

import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import GuiFormulario.Design.GuiConstants;
import GuiFormulario.appComponents.AppLabel;
import GuiFormulario.appComponents.AppPanel;

public class HeaderPanel extends AppPanel implements GuiConstants {

    /**
     * Construtor do HeaderPanel.
     */
    public HeaderPanel() {
        super(new FlowLayout(FlowLayout.CENTER));
        
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String datumString = hoje.format(formatador);
        
        String tituloText = "Task/activity log - " + datumString;
        
        AppLabel lblTitel = new AppLabel(tituloText);
        lblTitel.setFont(FONT_TITLE_MAIN);
        
        add(lblTitel);
    }
}