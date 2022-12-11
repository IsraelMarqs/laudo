package br.com.frota.model;

import java.sql.Timestamp;

public class Paciente extends GenericModel{

    private String nome;
    private Timestamp dtNascimento;

    public Paciente(Integer id, String nome, Timestamp dtNascimento) {
        this.setId(id);
        this.nome = nome;
        this.dtNascimento = dtNascimento;
    }

    public Paciente(String nome, Timestamp dtNascimento) {
        super();
        this.nome = nome;
        this.dtNascimento = dtNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Timestamp dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", dtNascimento=" + dtNascimento +
                '}';
    }
}
