package br.com.pigsul.model.entity;

import java.time.LocalDate;

public class ConsumoRacao {

    private Integer idConsumoRacao;
    private CargaRacao cargaRacao;
    private LocalDate dataInicioConsumo;
    private LocalDate dataTerminoConsumo;
    private Integer quantidadeAnimaisVivos;

    public ConsumoRacao(Integer idConsumoRacao, CargaRacao cargaRacao,
                        LocalDate dataInicioConsumo, LocalDate dataTerminoConsumo,
                        Integer quantidadeAnimaisVivos) {

        this.idConsumoRacao = idConsumoRacao;
        this.cargaRacao = cargaRacao;
        this.dataInicioConsumo = dataInicioConsumo;
        this.dataTerminoConsumo = dataTerminoConsumo;
        this.quantidadeAnimaisVivos = quantidadeAnimaisVivos;
    }

    public ConsumoRacao() {
    }

    public Integer getIdConsumoRacao() {
        return idConsumoRacao;
    }

    public void setIdConsumoRacao(Integer idConsumoRacao) {
        this.idConsumoRacao = idConsumoRacao;
    }

    public CargaRacao getCargaRacao() {
        return cargaRacao;
    }

    public void setCargaRacao(CargaRacao cargaRacao) {
        this.cargaRacao = cargaRacao;
    }

    public LocalDate getDataInicioConsumo() {
        return dataInicioConsumo;
    }

    public void setDataInicioConsumo(LocalDate dataInicioConsumo) {
        this.dataInicioConsumo = dataInicioConsumo;
    }

    public LocalDate getDataTerminoConsumo() {
        return dataTerminoConsumo;
    }

    public void setDataTerminoConsumo(LocalDate dataTerminoConsumo) {
        this.dataTerminoConsumo = dataTerminoConsumo;
    }

    public Integer getQuantidadeAnimaisVivos() {
        return quantidadeAnimaisVivos;
    }

    public void setQuantidadeAnimaisVivos(Integer quantidadeAnimaisVivos) {
        this.quantidadeAnimaisVivos = quantidadeAnimaisVivos;
    }
}
