package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums;

public enum LimitesTerreno {
    MURO_ALVENARIA("Muro feito de Alvenaria"),
    CERCA_DE_MADEIRA("Cerca feita de madeira"),
    CERCA_DE_ARAME("Cerca feita de arame"),
    CERCA_VIVA("Cerca viva"),
    SEM_CERCA("Sem cerca");

    private final String descricao;

    LimitesTerreno(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
