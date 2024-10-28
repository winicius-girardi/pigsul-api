package br.com.pigsul.model.entity;

import br.com.pigsul.model.enumType.UfEnum;

public class Uf {

    private UfEnum uf;
    private Integer idUf;

    public Uf(UfEnum uf, Integer idUf) {
        this.uf = uf;
        this.idUf = idUf;
    }

    public Uf(UfEnum uf) {
        this.uf = uf;
    }

    public Uf() {
    }

    public UfEnum getUf() {
        return uf;
    }

    public void setUf(UfEnum uf) {
        this.uf = uf;
    }

    public Integer getIdUf() {
        return idUf;
    }

    public void setIdUf(Integer idUf) {
        this.idUf = idUf;
    }
}
