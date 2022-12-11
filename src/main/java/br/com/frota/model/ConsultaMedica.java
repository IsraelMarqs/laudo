package br.com.frota.model;

import java.sql.Timestamp;

public class ConsultaMedica extends GenericModel{

    private Timestamp dtConsulta;
    private Integer medicoId;
    private Integer pacienteId;
    private String nmAtendimento;

    public ConsultaMedica(Integer id, Timestamp dtConsulta, Integer medicoId, Integer pacienteId, String nmAtendimento) {
        this.setId(id);
        this.dtConsulta = dtConsulta;
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
        this.nmAtendimento = nmAtendimento;
    }

    public ConsultaMedica(Timestamp dtConsulta, Integer medicoId, Integer pacienteId, String nmAtendimento) {
        super();
        this.dtConsulta = dtConsulta;
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
        this.nmAtendimento = nmAtendimento;
    }

    public Timestamp getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(Timestamp dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public Integer getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Integer medicoId) {
        this.medicoId = medicoId;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNmAtendimento() {
        return nmAtendimento;
    }

    public void setNmAtendimento(String nmAtendimento) {
        this.nmAtendimento = nmAtendimento;
    }

    @Override
    public String toString() {
        return "ConsultaMedica{" +
                "dtConsulta=" + dtConsulta +
                ", medicoId=" + medicoId +
                ", pacienteId=" + pacienteId +
                ", nmAtendimento='" + nmAtendimento + '\'' +
                '}';
    }
}
