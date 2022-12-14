package br.com.frota.model;

import java.sql.Timestamp;

public class SolicitacaoExame extends GenericModel{

    private String nmPrescrito;
    private Integer consultaMedicaId;
    private Timestamp dtSolicitacao;
    private Integer habilitacaoExameId;
    private Integer exameId;

    public SolicitacaoExame(Integer id, String nmPrescrito, Integer consultaMedicaId, Timestamp dtSolicitacao, Integer habilitacaoExameId, Integer exameId) {
        this.setId(id);
        this.nmPrescrito = nmPrescrito;
        this.consultaMedicaId = consultaMedicaId;
        this.dtSolicitacao = dtSolicitacao;
        this.habilitacaoExameId = habilitacaoExameId;
        this.exameId = exameId;
    }

    public SolicitacaoExame(String nmPrescrito, Integer consultaMedicaId, Timestamp dtSolicitacao, Integer habilitacaoExameId, Integer exameId) {
        super();
        this.nmPrescrito = nmPrescrito;
        this.consultaMedicaId = consultaMedicaId;
        this.dtSolicitacao = dtSolicitacao;
        this.habilitacaoExameId = habilitacaoExameId;
        this.exameId = exameId;
    }

    public String getNmPrescrito() {
        return nmPrescrito;
    }

    public void setNmPrescrito(String nmPrescrito) {
        this.nmPrescrito = nmPrescrito;
    }

    public Integer getConsultaMedicaId() {
        return consultaMedicaId;
    }

    public void setConsultaMedicaId(Integer consultaMedicaId) {
        this.consultaMedicaId = consultaMedicaId;
    }

    public Timestamp getDtSolicitacao() {
        return dtSolicitacao;
    }

    public void setDtSolicitacao(Timestamp dtSolicitacao) {
        this.dtSolicitacao = dtSolicitacao;
    }

    public Integer getHabilitacaoExameId() {
        return habilitacaoExameId;
    }

    public void setHabilitacaoExameId(Integer habilitacaoExameId) {
        this.habilitacaoExameId = habilitacaoExameId;
    }

    public Integer getExameId() {
        return exameId;
    }

    public void setExameId(Integer exameId) {
        this.exameId = exameId;
    }

    @Override
    public String toString() {
        return "SolicitacaoExame{" +
                "nmPrescito='" + nmPrescrito + '\'' +
                ", consultaMedicaId=" + consultaMedicaId +
                ", dtSolicitacao=" + dtSolicitacao +
                ", habilitacaoExameId=" + habilitacaoExameId +
                ", exameId=" + exameId +
                '}';
    }
}
