package GuiFormulario.Modelos;

import java.io.Serializable;

public class FichaDados implements Serializable {
	
	//Versao estavel para a serializacao
	private static final long serialVersionUID = 1L;
	
	
	public String tipoEntrada;
	public java.util.Date dataTarefa;
    public String nomePessoa;
    public String parentesco;
    public String tipoOcorrencia;
    public String atividade;
    public String detalhesOutros;
    public int urgencia;
    public boolean trazAgua, trazComida, trazBilhetes, trazId;
    public String coisasDiversas;
    public int numeroSerie;

}