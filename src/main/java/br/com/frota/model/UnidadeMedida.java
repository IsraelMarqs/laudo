package br.com.frota.model;

public class UnidadeMedida extends GenericModel{

    private String material;
    private String observacao;

    public UnidadeMedida(Integer id, String material, String observacao) {
        this.setId(id);
        this.material = material;
        this.observacao = observacao;
    }

    public UnidadeMedida(String material, String observacao) {
        super();
        this.material = material;
        this.observacao = observacao;
    }

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

    @Override
    public String toString() {
        return "UnidadeMedida{" +
                "material='" + material + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
