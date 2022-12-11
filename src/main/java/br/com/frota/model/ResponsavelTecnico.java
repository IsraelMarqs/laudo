package br.com.frota.model;

public class ResponsavelTecnico extends GenericModel{

    private String nome;
    private String conselho;
    private String formacao;
    private String siglaFormacao;
    private Integer siglaFormacaoId;

    public ResponsavelTecnico(Integer id, String nome, String conselho, String formacao, String siglaFormacao, Integer siglaFormacaoId) {
        this.setId(id);
        this.nome = nome;
        this.conselho = conselho;
        this.formacao = formacao;
        this.siglaFormacao = siglaFormacao;
        this.siglaFormacaoId = siglaFormacaoId;
    }

    public ResponsavelTecnico(String nome, String conselho, String formacao, String siglaFormacao, Integer siglaFormacaoId) {
        super();
        this.nome = nome;
        this.conselho = conselho;
        this.formacao = formacao;
        this.siglaFormacao = siglaFormacao;
        this.siglaFormacaoId = siglaFormacaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConselho() {
        return conselho;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getSiglaFormacao() {
        return siglaFormacao;
    }

    public void setSiglaFormacao(String siglaFormacao) {
        this.siglaFormacao = siglaFormacao;
    }

    public Integer getSiglaFormacaoId() {
        return siglaFormacaoId;
    }

    public void setSiglaFormacaoId(Integer siglaFormacaoId) {
        this.siglaFormacaoId = siglaFormacaoId;
    }

    @Override
    public String toString() {
        return "ResponsavelTecnico{" +
                "nome='" + nome + '\'' +
                ", conselho='" + conselho + '\'' +
                ", formacao='" + formacao + '\'' +
                ", siglaFormacao='" + siglaFormacao + '\'' +
                ", siglaFormacaoId=" + siglaFormacaoId +
                '}';
    }
}
