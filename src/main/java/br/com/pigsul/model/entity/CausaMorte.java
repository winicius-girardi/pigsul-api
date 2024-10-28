package br.com.pigsul.model.entity;

public class CausaMorte {

    private  Integer idCausaMorte;
    private  String causa;
    private  String recomendacoes;

    public CausaMorte(Integer idCausaMorte, String causa, String recomendacoes) {
        this.idCausaMorte = idCausaMorte;
        this.causa = causa;
        this.recomendacoes = recomendacoes;
    }

    public CausaMorte() {
    }

    public Integer getIdCausaMorte() {
        return idCausaMorte;
    }

    public String getCausa() {
        return causa;
    }

    public String getRecomendacoes() {
        return recomendacoes;
    }


}
