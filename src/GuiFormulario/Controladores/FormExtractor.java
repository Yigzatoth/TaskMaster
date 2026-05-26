package GuiFormulario.Controladores;

import GuiFormulario.RootPanel;
import GuiFormulario.Modelos.FichaDados;

public class FormExtractor {

    public static FichaDados extrair(RootPanel root) {
        FichaDados dados = new FichaDados();

        // Tipo de Entrada, Data e Responsável
        dados.tipoEntrada = (String) root.getEntryComboBox().getComboTipoEntrada().getSelectedItem();
        dados.dataTarefa = root.getTaskDateSpinner().getDataTarefa();
        dados.nomePessoa = root.getPersonTextCombo().getNomePessoa();
        dados.parentesco = root.getPersonTextCombo().getParentesco();

        // Condicional da Atividade Sim/Não
        if (root.getActivitySectionPanel().getPainelDecisao().isRegular()) {
            dados.tipoOcorrencia = "Regular";
            dados.atividade = root.getActivitySectionPanel().getRegularActivityPanel().getAtividadeSelecionada();
        } else {
            dados.tipoOcorrencia = "Occasional";
            dados.atividade = root.getActivitySectionPanel().getNonRegularActivityPanel().getAtividadeSelecionada();
            dados.detalhesOutros = root.getActivitySectionPanel().getNonRegularActivityPanel().getTextoOutros();
        }

        // Urgência
        dados.urgencia = root.getUrgencySlider().getValorUrgencia();

        // Coisas Necessárias
        var painelFixos = root.getToBringMainPanel().getPainelFixos();
        dados.trazAgua = painelFixos.isAguaSelected();
        dados.trazComida = painelFixos.isComidaSelected();
        dados.trazBilhetes = painelFixos.isBilhetesSelected();
        dados.trazId = painelFixos.isIdSelected();

        dados.coisasDiversas = root.getToBringMainPanel().getPainelDiversos().getTextoDiversos();

        return dados;
    }
}