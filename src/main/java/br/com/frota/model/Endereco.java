package br.com.frota.model;

public class Endereco extends GenericModel {

    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String CEP;
    private String cidade;
    private Integer laboratorio_id;

    public Endereco(Integer id, String rua, String numero, String complemento, String bairro, String CEP, String cidade, Integer laboratorio_id) {
        this.setId(id);
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
        this.laboratorio_id = laboratorio_id;
    }

    public Endereco(String rua, String numero, String complemento, String bairro, String CEP, String cidade, Integer laboratorio_id) {
        super();
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
        this.laboratorio_id = laboratorio_id;
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

    public Integer getLaboratorio_id() {
        return laboratorio_id;
    }

    public void setLaboratorio_id(Integer laboratorio_id) {
        this.laboratorio_id = laboratorio_id;
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
                ", laboratorio_id=" + laboratorio_id +
                '}';
    }
}
