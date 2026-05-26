package GuiFormulario.Partes;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import GuiFormulario.RootPanel;
import GuiFormulario.Modelos.FichaDados;
import GuiFormulario.Persistencia.HistoryManager;

public class HistoryDialog {

    public static void mostrar(RootPanel rootPanel) {
        List<FichaDados> todasFichas = HistoryManager.carregarTodasAsFichas();

        // 1. Definir a ordem de prioridade exata que queres ver no ecrã
        List<String> ordemPreferencial = Arrays.asList("Father", "Mother", "Child 1", "Child 2");

        // 2. Criar um comparador. 
        // Respeita a ordem preferencial e empurra entradas desconhecidas para o fim alfabeticamente.
        Comparator<String> comparador = (s1, s2) -> {
            int index1 = ordemPreferencial.indexOf(s1);
            int index2 = ordemPreferencial.indexOf(s2);

            if (index1 != -1 && index2 != -1) return Integer.compare(index1, index2); // Ambos na lista base
            if (index1 != -1) return -1; // S1 está na lista, aparece primeiro
            if (index2 != -1) return 1;  // S2 está na lista, aparece primeiro
            
            return s1.compareTo(s2); // Se for um parentesco novo, ordena alfabeticamente no fim
        };

        // 3. O agrupamento força o uso de um TreeMap para aplicar as regras do comparador acima
        Map<String, List<FichaDados>> fichasAgrupadas = todasFichas.stream()
            .collect(Collectors.groupingBy(f -> {
                if (f.parentesco == null || f.parentesco.trim().isEmpty()) {
                    return "Unspecified";
                }
                return f.parentesco;
            }, 
            () -> new TreeMap<>(comparador), 
            Collectors.toList()));

        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        sb.append("===============================================================================\n");
        sb.append("                                TASK HISTORY                                   \n");
        sb.append("===============================================================================\n\n");

        // Itera automaticamente por todos os grupos encontrados e gera o texto
        fichasAgrupadas.forEach((parentesco, lista) -> {
            adicionarSeccaoAoTexto(sb, parentesco.toUpperCase(), lista, sdf);
        });
        
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(rootPanel), "Task List", true);
        
        JTextArea txtArea = new JTextArea(sb.toString());
        txtArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        txtArea.setEditable(false);
        txtArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(txtArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        dialog.add(scroll);
        dialog.pack();
        dialog.setLocationRelativeTo(rootPanel);
        dialog.setVisible(true);
    }

    private static void adicionarSeccaoAoTexto(StringBuilder sb, String titulo, List<FichaDados> lista, SimpleDateFormat sdf) {
        sb.append("▶ ").append(titulo).append(" (").append(lista.size()).append(")\n");
        if (lista.isEmpty()) {
            sb.append("   [No registry]\n");
        } else {
            for (FichaDados f : lista) {
                String dataStr = (f.dataTarefa != null) ? sdf.format(f.dataTarefa) : "No date";
                sb.append(String.format("   ↳ Serial Nr.: %04d  |  Date: %s  |  Activity: %s\n", f.numeroSerie, dataStr, f.atividade));
            }
        }
        sb.append("\n-------------------------------------------------------------------------------\n\n");
    }
}