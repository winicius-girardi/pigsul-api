package br.com.pigsul.model.entity;

import java.time.LocalDate;

public class CargaRacao {

    private Integer idCargaRacao;
    private Float pesoCarga;
    private LocalDate dataEntradaCarga;
    private LocalDate dataEmissaoNota;
    private String numNotaFiscal;
    private TipoRacao tipoRacao;

    public CargaRacao(Integer idCargaRacao, Float pesoCarga,
                      LocalDate dataEntradaCarga, LocalDate dataEmissaoNota,
                      String numNotaFiscal, TipoRacao tipoRacao) {

        this.idCargaRacao = idCargaRacao;
        this.pesoCarga = pesoCarga;
        this.dataEntradaCarga = dataEntradaCarga;
        this.dataEmissaoNota = dataEmissaoNota;
        this.numNotaFiscal = numNotaFiscal;
        this.tipoRacao = tipoRacao;
    }

    public CargaRacao() {
    }

    public Integer getIdCargaRacao() {
        return idCargaRacao;
    }

    public void setIdCargaRacao(Integer idCargaRacao) {
        this.idCargaRacao = idCargaRacao;
    }

    public Float getPesoCarga() {
        return pesoCarga;
    }

    public void setPesoCarga(Float pesoCarga) {
        this.pesoCarga = pesoCarga;
    }

    public LocalDate getDataEntradaCarga() {
        return dataEntradaCarga;
    }

    public void setDataEntradaCarga(LocalDate dataEntradaCarga) {
        this.dataEntradaCarga = dataEntradaCarga;
    }

    public LocalDate getDataEmissaoNota() {
        return dataEmissaoNota;
    }

    public void setDataEmissaoNota(LocalDate dataEmissaoNota) {
        this.dataEmissaoNota = dataEmissaoNota;
    }

    public String getNumNotaFiscal() {
        return numNotaFiscal;
    }

    public void setNumNotaFiscal(String numNotaFiscal) {
        this.numNotaFiscal = numNotaFiscal;
    }

    public TipoRacao getTipoRacao() {
        return tipoRacao;
    }

    public void setTipoRacao(TipoRacao tipoRacao) {
        this.tipoRacao = tipoRacao;
    }
}

