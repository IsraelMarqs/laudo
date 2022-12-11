package br.com.frota.model;

public class Composicao extends GenericModel {

    private Integer exameId;
    private Integer composicaoExameId;
    private Integer valorReferenciaComposicaoExameId;

    public Composicao(Integer id, Integer exameId, Integer composicaoExameId, Integer valorReferenciaComposicaoExameId) {
        this.setId(id);
        this.exameId = exameId;
        this.composicaoExameId = composicaoExameId;
        this.valorReferenciaComposicaoExameId = valorReferenciaComposicaoExameId;
    }

    public Composicao(Integer exameId, Integer composicaoExameId, Integer valorReferenciaComposicaoExameId) {
        super();
        this.exameId = exameId;
        this.composicaoExameId = composicaoExameId;
        this.valorReferenciaComposicaoExameId = valorReferenciaComposicaoExameId;
    }

    public Integer getExameId() {
        return exameId;
    }

    public void setExameId(Integer exameId) {
        this.exameId = exameId;
    }

    public Integer getComposicaoExameId() {
        return composicaoExameId;
    }

    public void setComposicaoExameId(Integer composicaoExameId) {
        this.composicaoExameId = composicaoExameId;
    }

    public Integer getValorReferenciaComposicaoExameId() {
        return valorReferenciaComposicaoExameId;
    }

    public void setValorReferenciaComposicaoExameId(Integer valorReferenciaComposicaoExameId) {
        this.valorReferenciaComposicaoExameId = valorReferenciaComposicaoExameId;
    }

    @Override
    public String toString() {
        return "Composicao{" +
                "exameId=" + exameId +
                ", composicaoExameId=" + composicaoExameId +
                ", valorReferenciaComposicaoExameId=" + valorReferenciaComposicaoExameId +
                '}';
    }
}
