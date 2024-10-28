package br.com.pigsul.model.entity;

public class Obituario {

    private Integer idLote;
    private Integer idObituario;
    private Integer idCausaMorte;
    private Integer quantidadeAnimaisMortos;
    private Float pesoMedioEstimado;

    public Obituario(Integer idLote, Integer idObituario,
                     Integer idCausaMorte, Integer quantidadeAnimaisMortos,
                     Float pesoMedioEstimado) {

        this.idLote = idLote;
        this.idObituario = idObituario;
        this.idCausaMorte = idCausaMorte;
        this.quantidadeAnimaisMortos = quantidadeAnimaisMortos;
        this.pesoMedioEstimado = pesoMedioEstimado;
    }

    public Obituario(Integer idLote, Integer idCausaMorte, Integer quantidadeAnimaisMortos, Float pesoMedioEstimado) {
        this.idLote = idLote;
        this.idCausaMorte = idCausaMorte;
        this.quantidadeAnimaisMortos = quantidadeAnimaisMortos;
        this.pesoMedioEstimado = pesoMedioEstimado;
    }

    public Obituario() {
    }

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public Integer getIdObituario() {
        return idObituario;
    }

    public void setIdObituario(Integer idObituario) {
        this.idObituario = idObituario;
    }

    public Integer getIdCausaMorte() {
        return idCausaMorte;
    }

    public void setIdCausaMorte(Integer idCausaMorte) {
        this.idCausaMorte = idCausaMorte;
    }

    public Integer getQuantidadeAnimaisMortos() {
        return quantidadeAnimaisMortos;
    }

    public void setQuantidadeAnimaisMortos(Integer quantidadeAnimaisMortos) {
        this.quantidadeAnimaisMortos = quantidadeAnimaisMortos;
    }

    public Float getPesoMedioEstimado() {
        return pesoMedioEstimado;
    }

    public void setPesoMedioEstimado(Float pesoMedioEstimado) {
        this.pesoMedioEstimado = pesoMedioEstimado;
    }
}
