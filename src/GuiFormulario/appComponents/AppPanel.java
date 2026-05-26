package GuiFormulario.appComponents;

import java.awt.LayoutManager;

import javax.swing.JPanel;

import GuiFormulario.Design.GuiConstants;

public class AppPanel extends JPanel implements GuiConstants {
	
    public AppPanel(LayoutManager layout) {
    	
        super(layout);
        setBorder(BORDER_BLACK_LINE);
        setOpaque(false);
    }
    
    
    public AppPanel(LayoutManager layout, boolean comBordaPreta) {
    	
        super(layout);
        if (comBordaPreta) {
            setBorder(BORDER_BLACK_LINE);
            
        }
        setOpaque(false);
    }
    
}