package br.com.pigsul.model.entity;

import br.com.pigsul.model.enumType.TipoRacaoEnum;

public class TipoRacao {

    private TipoRacaoEnum tipoRacao;
    private Integer idTipoRacao;

    public TipoRacao(TipoRacaoEnum tipoRacao, Integer idTipoRacao) {
        this.tipoRacao = tipoRacao;
        this.idTipoRacao = idTipoRacao;
    }

    public TipoRacao() {
    }

    public TipoRacaoEnum getTipoRacao() {
        return tipoRacao;
    }

    public void setTipoRacao(TipoRacaoEnum tipoRacao) {
        this.tipoRacao = tipoRacao;
    }

    public Integer getIdTipoRacao() {
        return idTipoRacao;
    }

    public void setIdTipoRacao(Integer idTipoRacao) {
        this.idTipoRacao = idTipoRacao;
    }

}
