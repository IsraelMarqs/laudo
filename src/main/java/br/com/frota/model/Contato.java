package br.com.frota.model;

public class Contato extends GenericModel{

    private String telefone;
    private Integer laboratorioId;

    public Contato(Integer id, String telefone, Integer laboratorioId) {
        this.setId(id);
        this.telefone = telefone;
        this.laboratorioId = laboratorioId;
    }

    public Contato(String telefone, Integer laboratorioId) {
        super();
        this.telefone = telefone;
        this.laboratorioId = laboratorioId;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Integer laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "telefone='" + telefone + '\'' +
                ", laboratorioId=" + laboratorioId +
                '}';
    }
}
