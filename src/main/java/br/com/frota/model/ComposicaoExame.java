package br.com.frota.model;

public class ComposicaoExame extends GenericModel{

    private String descricao;
    private Integer unidadeMedidaId;

    public ComposicaoExame(Integer id, String descricao, Integer unidadeMedidaId) {
        this.setId(id);
        this.descricao = descricao;
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public ComposicaoExame(String descricao, Integer unidadeMedidaId) {
        super();
        this.descricao = descricao;
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getUnidadeMedidaId() {
        return unidadeMedidaId;
    }

    public void setUnidadeMedidaId(Integer unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }

    @Override
    public String toString() {
        return "ComposicaoExame{" +
                "descricao='" + descricao + '\'' +
                ", unidadeMedidaId=" + unidadeMedidaId +
                '}';
    }
}