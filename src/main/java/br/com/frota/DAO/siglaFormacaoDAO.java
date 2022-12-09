package br.com.frota.DAO;

public class siglaFormacaoDAO extends GenericModel {
	private String sigla;

	public siglaFormacaoDAO(String sigla) {
		this.sigla = sigla;
	}
	public siglaFormacaoDAO(Integer id, String sigla) {
		this.sigla = sigla;
		super.setId(id);
	}

	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	@Override
	public String toString() {
		return "sigla_formacao [id="+getId()+"sigla=" + sigla + "]";
	}
}
