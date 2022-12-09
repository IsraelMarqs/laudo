package br.com.frota.DAO;

public class tipoExameDAO extends GenericModel {
	private String descricao, observacao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public tipoExameDAO(String descricao, String observacao) {
		super();
		this.descricao = descricao;
		this.observacao = observacao;
	}
	public tipoExameDAO(Integer id, String descricao, String observacao) {
		super.setId(id);
		this.descricao = descricao;
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "tipo_exame [id="+getId()+"descricao=" + descricao + ", observacao=" + observacao + "]";
	}
}
