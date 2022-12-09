package br.com.frota.DAO;

public class responsavelTecnicoDAO extends GenericModel {
	private String nome, conselho;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConselho() {
		return conselho;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

	public responsavelTecnicoDAO(String nome, String conselho) {
		this.nome = nome;
		this.conselho = conselho;
	}

	public responsavelTecnicoDAO(Integer id, String nome, String conselho) {
		this.nome = nome;
		this.conselho = conselho;
		super.setId(id);
	}

	@Override
	public String toString() {
		return "responsavel_tecnico [id="+getId()+"nome=" + nome + ", conselho=" + conselho + "]";
	}

}
