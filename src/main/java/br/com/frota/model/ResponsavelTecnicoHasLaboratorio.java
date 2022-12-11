package br.com.frota.model;

public class ResponsavelTecnicoHasLaboratorio extends GenericModel{

    private Integer responsavelTecnicoId;
    private Integer laboratorioId;

    public ResponsavelTecnicoHasLaboratorio(Integer id, Integer responsavelTecnicoId, Integer laboratorioId) {
        this.setId(id);
        this.responsavelTecnicoId = responsavelTecnicoId;
        this.laboratorioId = laboratorioId;
    }

    public ResponsavelTecnicoHasLaboratorio(Integer responsavelTecnicoId, Integer laboratorioId) {
        super();
        this.responsavelTecnicoId = responsavelTecnicoId;
        this.laboratorioId = laboratorioId;
    }

    public Integer getResponsavelTecnicoId() {
        return responsavelTecnicoId;
    }

    public void setResponsavelTecnicoId(Integer responsavelTecnicoId) {
        this.responsavelTecnicoId = responsavelTecnicoId;
    }

    public Integer getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Integer laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    @Override
    public String toString() {
        return "ResponsavelTecnicoHasLaboratorio{" +
                "responsavelTecnicoId=" + responsavelTecnicoId +
                ", laboratorioId=" + laboratorioId +
                '}';
    }
}
