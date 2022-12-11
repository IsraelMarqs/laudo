package br.com.frota.model;

public class Endereco extends GenericModel {

    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String CEP;
    private String cidade;
    private Integer laboratorioId;

    public Endereco(Integer id, String rua, String numero, String complemento, String bairro, String CEP, String cidade, Integer laboratorioId) {
        this.setId(id);
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
        this.laboratorioId = laboratorioId;
    }

    public Endereco(String rua, String numero, String complemento, String bairro, String CEP, String cidade, Integer laboratorioId) {
        super();
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
        this.laboratorioId = laboratorioId;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Integer laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", CEP='" + CEP + '\'' +
                ", cidade='" + cidade + '\'' +
                ", laboratorioId=" + laboratorioId +
                '}';
    }
}
