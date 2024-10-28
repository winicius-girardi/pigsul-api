package br.com.pigsul.model.entity;

public class Origem {

    private Integer idOrigem;
    private String nomeGranja;
    private String cidadeOrigem;
    private Uf ufOrigem;

    public Origem(Integer idOrigem, String nomeGranja, String cidadeOrigem, Uf ufOrigem) {
        this.idOrigem = idOrigem;
        this.nomeGranja = nomeGranja;
        this.cidadeOrigem = cidadeOrigem;
        this.ufOrigem = ufOrigem;
    }

    public Origem() {
    }

    public Integer getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(Integer idOrigem) {
        this.idOrigem = idOrigem;
    }

    public String getNomeGranja() {
        return nomeGranja;
    }

    public void setNomeGranja(String nomeGranja) {
        this.nomeGranja = nomeGranja;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public Uf getUfOrigem() {
        return ufOrigem;
    }

    public void setUfOrigem(Uf ufOrigem) {
        this.ufOrigem = ufOrigem;
    }
}
