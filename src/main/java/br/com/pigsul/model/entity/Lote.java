package br.com.pigsul.model.entity;

import java.time.LocalDate;

public class Lote {

    private Integer idUsuario;
    private Integer idLote;
    private LocalDate dataEntradaLote;
    private LocalDate dataSaidaLote;
    private Boolean estadoLote;
    private Integer quantidadeAnimaisAlojados;
    private Float pesoMedioAnimaisEntrada;
    private Float pesoMedioAnimaisSaida;
    private Origem origem;
    private String observacoes;
    private Integer quantidadeAnimaisSaida;

    public Lote(Integer idUsuario, Integer idLote, LocalDate dataEntradaLote,
                LocalDate dataSaidaLote, Boolean estadoLote, Integer quantidadeAnimaisAlojados,
                Float pesoMedioAnimaisEntrada, Float pesoMedioAnimaisSaida, Origem origem,
                String observacoes, Integer quantidadeAnimaisSaida) {

        this.idUsuario = idUsuario;
        this.idLote = idLote;
        this.dataEntradaLote = dataEntradaLote;
        this.dataSaidaLote = dataSaidaLote;
        this.estadoLote = estadoLote;
        this.quantidadeAnimaisAlojados = quantidadeAnimaisAlojados;
        this.pesoMedioAnimaisEntrada = pesoMedioAnimaisEntrada;
        this.pesoMedioAnimaisSaida = pesoMedioAnimaisSaida;
        this.origem = origem;
        this.observacoes = observacoes;
        this.quantidadeAnimaisSaida = quantidadeAnimaisSaida;
    }

    public Lote(Integer idUsuario,Integer idLote, LocalDate dataEntradaLote, Boolean estadoLote, Integer quantidadeAnimaisAlojados) {
        this.idUsuario=idUsuario;
        this.idLote = idLote;
        this.dataEntradaLote = dataEntradaLote;
        this.estadoLote = estadoLote;
        this.quantidadeAnimaisAlojados = quantidadeAnimaisAlojados;
    }

    public Lote() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public LocalDate getDataEntradaLote() {
        return dataEntradaLote;
    }

    public void setDataEntradaLote(LocalDate dataEntradaLote) {
        this.dataEntradaLote = dataEntradaLote;
    }

    public LocalDate getDataSaidaLote() {
        return dataSaidaLote;
    }

    public void setDataSaidaLote(LocalDate dataSaidaLote) {
        this.dataSaidaLote = dataSaidaLote;
    }

    public Boolean getEstadoLote() {
        return estadoLote;
    }

    public void setEstadoLote(Boolean estadoLote) {
        this.estadoLote = estadoLote;
    }

    public Integer getQuantidadeAnimaisAlojados() {
        return quantidadeAnimaisAlojados;
    }

    public void setQuantidadeAnimaisAlojados(Integer quantidadeAnimaisAlojados) {
        this.quantidadeAnimaisAlojados = quantidadeAnimaisAlojados;
    }

    public Float getPesoMedioAnimaisEntrada() {
        return pesoMedioAnimaisEntrada;
    }

    public void setPesoMedioAnimaisEntrada(Float pesoMedioAnimaisEntrada) {
        this.pesoMedioAnimaisEntrada = pesoMedioAnimaisEntrada;
    }

    public Float getPesoMedioAnimaisSaida() {
        return pesoMedioAnimaisSaida;
    }

    public void setPesoMedioAnimaisSaida(Float pesoMedioAnimaisSaida) {
        this.pesoMedioAnimaisSaida = pesoMedioAnimaisSaida;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getQuantidadeAnimaisSaida() {
        return quantidadeAnimaisSaida;
    }

    public void setQuantidadeAnimaisSaida(Integer quantidadeAnimaisSaida) {
        this.quantidadeAnimaisSaida = quantidadeAnimaisSaida;
    }
}
