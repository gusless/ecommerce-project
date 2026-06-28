package com.lp1.project.domain.address;

public enum State {
    AC("AC", "Acre"),
    AL("AL", "Alagoas"),
    AP("AP", "Amapá"),
    AM("AM", "Amazonas"),
    BA("BA", "Bahia"),
    CE("CE", "Ceará"),
    DF("DF", "Distrito Federal"),
    ES("ES", "Espírito Santo"),
    GO("GO", "Goiás"),
    MA("MA", "Maranhão"),
    MT("MT", "Mato Grosso"),
    MS("MS", "Mato Grosso do Sul"),
    MG("MG", "Minas Gerais"),
    PA("PA", "Pará"),
    PB("PB", "Paraíba"),
    PR("PR", "Paraná"),
    PE("PE", "Pernambuco"),
    PI("PI", "Piauí"),
    RJ("RJ", "Rio de Janeiro"),
    RN("RN", "Rio Grande do Norte"),
    RS("RS", "Rio Grande do Sul"),
    RO("RO", "Rondônia"),
    RR("RR", "Roraima"),
    SC("SC", "Santa Catarina"),
    SP("SP", "São Paulo"),
    SE("SE", "Sergipe"),
    TO("TO", "Tocantins");

    private final String acronym;
    private final String name;

    State(String acronym, String name){
        this.acronym = acronym;
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

    public static State fromString(String value) {
        try {
            return State.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "\nEstado inválido: '" + value + "'. Use siglas válidas como RN, SP, RJ."
            );
        }
    }

    @Override
    public String toString() {
        return acronym;
    }
}
