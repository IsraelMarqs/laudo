package br.com.frota.model;

public class
ValorReferenciaComposicaoExame extends GenericModel{

    private String valorMinimo;
    private String valorMaximo;
    private String limitadorMinimo;
    private String limitadorMaximo;
    private Integer unidadeMedidaId;

    public ValorReferenciaComposicaoExame(Integer id, String valorMinimo, String valorMaximo, String limitadorMinimo, String limitadorMaximo, Integer unidadeMedidaId) {
        this.setId(id);
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.limitadorMinimo = limitadorMinimo;
        this.limitadorMaximo = limitadorMaximo;
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public ValorReferenciaComposicaoExame(String valorMinimo, String valorMaximo, String limitadorMinimo, String limitadorMaximo, Integer unidadeMedidaId) {
        super();
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
        this.limitadorMinimo = limitadorMinimo;
        this.limitadorMaximo = limitadorMaximo;
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public String getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(String valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(String valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public String getLimitadorMinimo() {
        return limitadorMinimo;
    }

    public void setLimitadorMinimo(String limitadorMinimo) {
        this.limitadorMinimo = limitadorMinimo;
    }

    public String getLimitadorMaximo() {
        return limitadorMaximo;
    }

    public void setLimitadorMaximo(String limitadorMaximo) {
        this.limitadorMaximo = limitadorMaximo;
    }

    public Integer getUnidadeMedidaId() {
        return unidadeMedidaId;
    }

    public void setUnidadeMedidaId(Integer unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }

    @Override
    public String toString() {
        return "ValorReferenciaComposicaoExame{" +
                "valorMinimo='" + valorMinimo + '\'' +
                ", valorMaximo='" + valorMaximo + '\'' +
                ", limitadorMinimo='" + limitadorMinimo + '\'' +
                ", limitadorMaximo='" + limitadorMaximo + '\'' +
                ", unidadeMedidaId=" + unidadeMedidaId +
                '}';
    }
}
