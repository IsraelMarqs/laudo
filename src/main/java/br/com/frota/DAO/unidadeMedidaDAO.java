package br.com.frota.DAO;

public class unidadeMedidaDAO extends GenericModel {
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public unidadeMedidaDAO(String descricao) {
		super();
		this.descricao = descricao;
	}
	public unidadeMedidaDAO(Integer id, String descricao) {
		super.setId(id);
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "unidade_medida [id="+getId()+"descricao=" + descricao + "]";
	}
	
	
}
