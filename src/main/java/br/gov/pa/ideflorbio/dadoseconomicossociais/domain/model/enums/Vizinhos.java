package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums;

public enum Vizinhos {
    LADO_ESQUERDO_LADO_DIREITO_ATRAS("Lado Esquerdo, Lado Direito, Atrás"),
    LADO_ESQUERDO_LADO_DIREITO("Lado Esquerdo, Lado Direito"),
    LADO_ESQUERDO_ATRAS("Lado Esquerdo, Atrás"),
    LADO_ESQUERDO_APENAS("Lado Esquerdo Apenas"),
    LADO_DIREITO_ATRAS("Lado Direito, Atrás"),
    LADO_DIREITO_APENAS("Lado Direito Apenas"),
    ATRAS_SOMENTE("Atrás Somente"),
    NAO_DECLARADO("Não Declarado"),
	NAO_POSSUI("Não possui");

    private final String descricao;

    Vizinhos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
