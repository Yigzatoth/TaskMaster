package GuiFormulario.appComponents;

import java.awt.Component;
import javax.swing.JScrollPane;
import GuiFormulario.Design.GuiConstants;

public class AppScrollPane extends JScrollPane implements GuiConstants {

    public AppScrollPane(Component view) {
        super(view);
        // Força a janela de visualização interna a ter a mesma cor da TextArea
        getViewport().setBackground(COLOR_NEON_PURPLE);
        // Remove a borda 3D nativa do Java para um aspeto mais limpo e plano
        setBorder(null);
    }
}