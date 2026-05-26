package GuiFormulario.Controladores;

import GuiFormulario.RootPanel;
import GuiFormulario.Modelos.FichaDados;

public class FormInjector {

    public static void injetar(RootPanel root, FichaDados dados) {
        if (dados == null) {
            return;
        }

        // 1. Data
        root.getTaskDateSpinner().getTaskDateSpinner().setValue(dados.dataTarefa);

        // 2. Quem (Injeção direta via setters do painel)
        root.getPersonTextCombo().setNomePessoa(dados.nomePessoa);
        root.getPersonTextCombo().setParentesco(dados.parentesco);

        // 3. Atividades
        boolean ehRegular = "Regular".equalsIgnoreCase(dados.tipoOcorrencia);
        root.getActivitySectionPanel().getPainelDecisao().getComboRegular().setSelectedItem(ehRegular ? "Yes" : "No");

        if (ehRegular) {
            root.getActivitySectionPanel().getRegularActivityPanel().setAtividadeSelecionada(dados.atividade);
        } else {
            root.getActivitySectionPanel().getNonRegularActivityPanel().setAtividadeSelecionada(dados.atividade);
            root.getActivitySectionPanel().getNonRegularActivityPanel().setTextoOutros(dados.detalhesOutros);
        }

        // 4. Urgência
        root.getUrgencySlider().setValorUrgencia(dados.urgencia);

        // 5. Coisas Fixas
        var painelFixos = root.getToBringMainPanel().getPainelFixos();
        painelFixos.setAguaSelected(dados.trazAgua);
        painelFixos.setComidaSelected(dados.trazComida);
        painelFixos.setBilhetesSelected(dados.trazBilhetes);
        painelFixos.setIdSelected(dados.trazId);

        // 6. Coisas Diversas
        root.getToBringMainPanel().getPainelDiversos().setTextoDiversos(dados.coisasDiversas);
    }
}