package br.com.pigsul.model.enumType;


public enum UfEnum{
    AM("Amazonas", "AM"),
    AL("Alagoas", "AL"),
    AC("Acre", "AC"),
    AP("Amapá", "AP"),
    BA("Bahia", "BA"),
    PA("Pará", "PA"),
    MT("Mato Grosso", "MT"),
    MG("Minas Gerais", "MG"),
    MS("Mato Grosso do Sul", "MS"),
    GO("Goiás", "GO"),
    MA("Maranhão", "MA"),
    RS("Rio Grande do Sul", "RS"),
    TO("Tocantins", "TO"),
    PI("Piauí", "PI"),
    SP("São Paulo", "SP"),
    RO("Rondônia", "RO"),
    RR("Roraima", "RR"),
    PR("Paraná", "PR"),
    CE("Ceará", "CE"),
    PE("Pernambuco", "PE"),
    SC("Santa Catarina", "SC"),
    PB("Paraíba", "PB"),
    RN("Rio Grande do Norte", "RN"),
    ES("Espírito Santo", "ES"),
    RJ("Rio de Janeiro", "RJ"),
    SE("Sergipe", "SE"),
    DF("Distrito Federal","DF");



    private final String nomeUf;
    private final String sigla;


    UfEnum(String nomeUf, String sigla) {
        this.nomeUf = nomeUf;
        this.sigla = sigla;
    }

    public String getNomeUf() {
        return nomeUf;
    }

    public String getSigla() {
        return sigla;
    }
}


