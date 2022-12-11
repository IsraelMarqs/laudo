package br.com.frota.model;

public class Laudo extends GenericModel{

    private String assinaturaDigital;
    private String dtResultado;
    private String codigo;
    private Integer solicitacaoExameId;

    public Laudo(Integer id, String assinaturaDigital, String dtResultado, String codigo, Integer solicitacaoExameId) {
        this.setId(id);
        this.assinaturaDigital = assinaturaDigital;
        this.dtResultado = dtResultado;
        this.codigo = codigo;
        this.solicitacaoExameId = solicitacaoExameId;
    }

    public Laudo(String assinaturaDigital, String dtResultado, String codigo, Integer solicitacaoExameId) {
        super();
        this.assinaturaDigital = assinaturaDigital;
        this.dtResultado = dtResultado;
        this.codigo = codigo;
        this.solicitacaoExameId = solicitacaoExameId;
    }

    public String getAssinaturaDigital() {
        return assinaturaDigital;
    }

    public void setAssinaturaDigital(String assinaturaDigital) {
        this.assinaturaDigital = assinaturaDigital;
    }

    public String getDtResultado() {
        return dtResultado;
    }

    public void setDtResultado(String dtResultado) {
        this.dtResultado = dtResultado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getSolicitacaoExameId() {
        return solicitacaoExameId;
    }

    public void setSolicitacaoExameId(Integer solicitacaoExameId) {
        this.solicitacaoExameId = solicitacaoExameId;
    }

    @Override
    public String toString() {
        return "Laudo{" +
                "assinaturaDigital='" + assinaturaDigital + '\'' +
                ", dtResultado='" + dtResultado + '\'' +
                ", codigo='" + codigo + '\'' +
                ", solicitacaoExameId=" + solicitacaoExameId +
                '}';
    }
}
