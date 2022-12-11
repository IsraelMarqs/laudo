package br.com.frota.model;

public class Laboratorio extends GenericModel{

    private String descricao;
    private String CNES;
    private String CNPJ;
    private String CRBM;
    private String nomeFantasia;

    public Laboratorio(Integer id, String descricao, String CNES, String CNPJ, String CRBM, String nomeFantasia) {
        this.setId(id);
        this.descricao = descricao;
        this.CNES = CNES;
        this.CNPJ = CNPJ;
        this.CRBM = CRBM;
        this.nomeFantasia = nomeFantasia;
    }

    public Laboratorio(String descricao, String CNES, String CNPJ, String CRBM, String nomeFantasia) {
        super();
        this.descricao = descricao;
        this.CNES = CNES;
        this.CNPJ = CNPJ;
        this.CRBM = CRBM;
        this.nomeFantasia = nomeFantasia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCNES() {
        return CNES;
    }

    public void setCNES(String CNES) {
        this.CNES = CNES;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCRBM() {
        return CRBM;
    }

    public void setCRBM(String CRBM) {
        this.CRBM = CRBM;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
                "descricao='" + descricao + '\'' +
                ", CNES='" + CNES + '\'' +
                ", CNPJ='" + CNPJ + '\'' +
                ", CRBM='" + CRBM + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                '}';
    }
}
