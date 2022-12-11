package br.com.frota.model;

import java.sql.Timestamp;

public class SolicitacaoExame extends GenericModel{

    private String nmPrescito;
    private Integer consultaMedicaId;
    private Timestamp dtSolicitacao;
    private Integer habilitacaoExameId;
    private Integer exameId;

    public SolicitacaoExame(Integer id, String nmPrescito, Integer consultaMedicaId, Timestamp dtSolicitacao, Integer habilitacaoExameId, Integer exameId) {
        this.setId(id);
        this.nmPrescito = nmPrescito;
        this.consultaMedicaId = consultaMedicaId;
        this.dtSolicitacao = dtSolicitacao;
        this.habilitacaoExameId = habilitacaoExameId;
        this.exameId = exameId;
    }

    public SolicitacaoExame(String nmPrescito, Integer consultaMedicaId, Timestamp dtSolicitacao, Integer habilitacaoExameId, Integer exameId) {
        super();
        this.nmPrescito = nmPrescito;
        this.consultaMedicaId = consultaMedicaId;
        this.dtSolicitacao = dtSolicitacao;
        this.habilitacaoExameId = habilitacaoExameId;
        this.exameId = exameId;
    }

    public String getNmPrescito() {
        return nmPrescito;
    }

    public void setNmPrescito(String nmPrescito) {
        this.nmPrescito = nmPrescito;
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
                "nmPrescito='" + nmPrescito + '\'' +
                ", consultaMedicaId=" + consultaMedicaId +
                ", dtSolicitacao=" + dtSolicitacao +
                ", habilitacaoExameId=" + habilitacaoExameId +
                ", exameId=" + exameId +
                '}';
    }
}
