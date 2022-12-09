package br.com.frota.DAO;

public class materialExameDAO extends GenericModel {
	private String material, observacao;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public materialExameDAO(String material, String observacao) {
		super();
		this.material = material;
		this.observacao = observacao;
	}
	public materialExameDAO(Integer id, String material, String observacao) {
		super.setId(id);
		this.material = material;
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "material_exame [id="+getId()+"material=" + material + ", observacao=" + observacao + "]";
	}
	
}
