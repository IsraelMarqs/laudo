package br.com.frota.model;

import java.sql.Timestamp;

public class ResultadoExame extends GenericModel{

    private Timestamp dtExame;
    private String valor;
    private Integer composicaoId;
    private Integer laudoId;

    public ResultadoExame(Integer id, Timestamp dtExame, String valor, Integer composicaoId, Integer laudoId) {
        this.setId(id);
        this.dtExame = dtExame;
        this.valor = valor;
        this.composicaoId = composicaoId;
        this.laudoId = laudoId;
    }

    public ResultadoExame(Timestamp dtExame, String valor, Integer composicaoId, Integer laudoId) {
        super();
        this.dtExame = dtExame;
        this.valor = valor;
        this.composicaoId = composicaoId;
        this.laudoId = laudoId;
    }

    public Timestamp getDtExame() {
        return dtExame;
    }

    public void setDtExame(Timestamp dtExame) {
        this.dtExame = dtExame;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getComposicaoId() {
        return composicaoId;
    }

    public void setComposicaoId(Integer composicaoId) {
        this.composicaoId = composicaoId;
    }

    public Integer getLaudoId() {
        return laudoId;
    }

    public void setLaudoId(Integer laudoId) {
        this.laudoId = laudoId;
    }

    @Override
    public String toString() {
        return "ResultadoExame{" +
                "dtExame=" + dtExame +
                ", valor='" + valor + '\'' +
                ", composicaoId=" + composicaoId +
                ", laudoId=" + laudoId +
                '}';
    }
}
