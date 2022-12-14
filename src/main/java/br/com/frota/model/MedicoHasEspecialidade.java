package br.com.frota.model;

public class MedicoHasEspecialidade{

    private Integer medicoId;
    private Integer especialidadeId;

    public MedicoHasEspecialidade(Integer medicoId, Integer especialidadeId) {

        this.medicoId = medicoId;
        this.especialidadeId = especialidadeId;
    }

    public Integer getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Integer medicoId) {
        this.medicoId = medicoId;
    }

    public Integer getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(Integer especialidadeId) {
        this.especialidadeId = especialidadeId;
    }

    @Override
    public String toString() {
        return "MedicoHasEspecialidade{" +
                "medicoId=" + medicoId +
                ", especialidadeId=" + especialidadeId +
                '}';
    }
}
