package GuiFormulario.Design;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

/**
 * Interface central que define a estética de toda a aplicação.
 * Se for visual, tem de estar aqui.
 */
public interface GuiConstants {


    // CORES
	Color COLOR_PRIMARY = new Color(224, 255, 255);
    Color COLOR_BACKGROUND = Color.WHITE;
    
    Color COLOR_NEON_PURPLE = new Color(157, 0, 255);
    Color COLOR_NEON_YELLOW = new Color(224, 255, 255); // Amarelo Neon Puro
    
    // Forçar todo o texto da aplicação a usar o Amarelo Neon
    Color COLOR_TEXT_MAIN = COLOR_NEON_YELLOW;
    Color COLOR_INPUT_TEXT = COLOR_NEON_YELLOW;


    // FONTES (Fallbacks iniciais)
    String CAMINHO_FONTE = "/resources/VT323-Regular.ttf";

    Font FONT_TITLE_MAIN = FontManager.carregarFonte(CAMINHO_FONTE, 26f, Font.BOLD);
    Font FONT_SECTION_HEADER = FontManager.carregarFonte(CAMINHO_FONTE, 22f, Font.BOLD);
    Font FONT_LABEL_BOLD = FontManager.carregarFonte(CAMINHO_FONTE, 20f, Font.BOLD);
    Font FONT_PLAIN = FontManager.carregarFonte(CAMINHO_FONTE, 20f, Font.PLAIN);
    Font FONT_MONO = new Font("Monospaced", Font.PLAIN, 18); // Usada no HistoryDialog

    // DIMENSÕES E ESPAÇAMENTOS
    Dimension FRAME_DEFAULT_SIZE = new Dimension(900, 900);
    Dimension DIMENSION_SECTION_ROW = new Dimension(850, 60);
    Dimension DIMENSION_INPUT_FIELD = new Dimension(200, 25);
    Dimension DIMENSION_TEXT_AREA_SMALL = new Dimension(300, 40);

    // Substitui os valores fixos no Box.createVerticalStrut()
    int STRUT_LARGE = 12;
    int STRUT_MEDIUM = 5; 

    // Gaps para FlowLayout e GridLayout
    int GAP_STANDARD = 10;
    int GAP_FLOW_SMALL = 5;

    // LAYOUTS GLOBAIS
    GridLayout LAYOUT_LINHA = new GridLayout(1, 2, GAP_STANDARD, 0);

    // BORDAS BÁSICAS
    Border BORDER_BLACK_LINE = BorderFactory.createLineBorder(COLOR_PRIMARY, 2);
    Border BORDER_MAIN_PANEL = BorderFactory.createEmptyBorder(15, 15, 15, 15);
    Border BORDER_COMPONENT_INNER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
    Border BORDER_HISTORY_PADDING = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    // BORDAS ESPECÍFICAS DOS PAINÉIS (Evitar instanciar nos painéis)
    
    // Para EntryComboBox, SerialNumberPanel, TaskDateSpinner e RegularActivityPanel
    Border BORDER_COMPOUND_STANDARD = new CompoundBorder(
        BORDER_BLACK_LINE, 
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    );

    // Para o NonRegularActivityPanel
    Border BORDER_COMPOUND_OCASIONAL = new CompoundBorder(
        BORDER_BLACK_LINE, 
        BorderFactory.createEmptyBorder(5, 10, 5, 50)
    );

    // Margens das "Coisas Necessárias"
    Border MARGIN_FIXED_STUFF = BorderFactory.createEmptyBorder(0, 60, 0, 0);
    Border MARGIN_DIVERSE_STUFF = BorderFactory.createEmptyBorder(0, 0, 10, 50);
    Border MARGIN_OUTROS_SCROLL = BorderFactory.createEmptyBorder(20, 0, 5, 5);
}