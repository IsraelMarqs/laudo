package br.com.frota.DAO;

public class contatoDAO extends GenericModel {
	private String telefone;
	private Integer laboratorio_id;
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	public contatoDAO(String telefone) {
		this.telefone = telefone;
	}
	public contatoDAO(Integer id, String telefone) {
		super.setId(id);
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "contato [id="+getId()+"telefone=" + telefone + "]";
	}
	
}
