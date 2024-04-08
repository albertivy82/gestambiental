package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums;

public enum EsporteLazer {
    CAMPO_DE_FUTEBOL("Campo de Futebol"),
    QUADRA_POLIESPORTIVA("Quadra Poliesportiva"),
    SEDE_ESPORTIVA("Sede Esportiva"),
    BALNEÁRIOS("Balneários"),
    PARQUES("Parques"),
    OUTROS("Outros");

    private final String descricao;

    EsporteLazer(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
