package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums;

public enum Situacao_Fundiaria {

    PROPRIETARIO("Proprietário"),
    OCUPACAO_COM_BENFEITORIA("Ocupação com benfeitoria"),
    ALUGUEL("Aluguel"),
    POSSE("Posse"),
    OUTROS("Outros");

    private final String descricao;

    Situacao_Fundiaria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
