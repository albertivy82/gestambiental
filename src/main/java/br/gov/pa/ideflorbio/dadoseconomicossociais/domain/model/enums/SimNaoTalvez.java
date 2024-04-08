package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums;

public enum SimNaoTalvez {
    SIM("Sim"),
    NÃO("Não"),
    TALVEZ("Talvez");

    private final String descricao;

    SimNaoTalvez(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
