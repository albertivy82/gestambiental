package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums;

public enum TipoPescaArtesanal {
    CANICO("Caniço"),
    LINHA_DE_MAO("Linha de Mão"),
    MALHADEIRA("Malhadeira"),
    TARRAFA("Tarrafa"),
    ARPÃO("Arpão"),
    MATAPI("Matapi"),
    OUTROS("Outros");

    private final String descricao;

    TipoPescaArtesanal(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
