package br.com.frota.model;

import java.math.BigInteger;

public class HabilitacaoExame extends GenericModel{

    private String observacao;
    private Integer custo;
    private Integer laboratorioId;
    private Integer tipoExameId;

    public HabilitacaoExame(Integer id, String observacao, Integer custo, Integer laboratorioId, Integer tipoExameId) {
        this.setId(id);
        this.observacao = observacao;
        this.custo = custo;
        this.laboratorioId = laboratorioId;
        this.tipoExameId = tipoExameId;
    }

    public HabilitacaoExame(String observacao, Integer custo, Integer laboratorioId, Integer tipoExameId) {
        super();
        this.observacao = observacao;
        this.custo = custo;
        this.laboratorioId = laboratorioId;
        this.tipoExameId = tipoExameId;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    public Integer getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Integer laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public Integer getTipoExameId() {
        return tipoExameId;
    }

    public void setTipoExameId(Integer tipoExameId) {
        this.tipoExameId = tipoExameId;
    }

    @Override
    public String toString() {
        return "HabilitacaoExame{" +
                "observacao='" + observacao + '\'' +
                ", custo=" + custo +
                ", laboratorioId=" + laboratorioId +
                ", tipoExameId=" + tipoExameId +
                '}';
    }
}
