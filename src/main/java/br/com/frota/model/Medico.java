package br.com.frota.model;

import java.util.List;

public class Medico extends GenericModel{

    private String CRM;
    private String nome;
    private List<Especialidade> Especialidades;

    public List<Especialidade> getEspecialidades() {
        return Especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        Especialidades = especialidades;
    }

    public Medico(Integer id, String CRM, String nome) {
        this.setId(id);
        this.CRM = CRM;
        this.nome = nome;
    }

    public Medico(String CRM, String nome) {
        super();
        this.CRM = CRM;
        this.nome = nome;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "CRM='" + CRM + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
