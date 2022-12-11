package br.com.frota.model;

public class Exame extends GenericModel {

    private Integer tipoExameId;
    private String descricao;
    private Integer materialExameId;
    private String metodo;

    public Exame(Integer id, Integer tipoExameId, String descricao, Integer materialExameId, String metodo) {
        this.setId(id);
        this.tipoExameId = tipoExameId;
        this.descricao = descricao;
        this.materialExameId = materialExameId;
        this.metodo = metodo;
    }

    public Exame(Integer tipoExameId, String descricao, Integer materialExameId, String metodo) {
        super();
        this.tipoExameId = tipoExameId;
        this.descricao = descricao;
        this.materialExameId = materialExameId;
        this.metodo = metodo;
    }

    public Integer getTipoExameId() {
        return tipoExameId;
    }

    public void setTipoExameId(Integer tipoExameId) {
        this.tipoExameId = tipoExameId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getMaterialExameId() {
        return materialExameId;
    }

    public void setMaterialExameId(Integer materialExameId) {
        this.materialExameId = materialExameId;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return "Exame{" +
                "tipoExameId=" + tipoExameId +
                ", descricao='" + descricao + '\'' +
                ", materialExameId=" + materialExameId +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}
