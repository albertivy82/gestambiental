package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums;

public enum Documentacao {

    RECIBO_DE_COMPRA_E_VENDA("Recibo de Compra e Venda"),
    ESCRITURA_PUBLICA("Escritura Pública"),
    ESCRITUA("Escritura"),
    CERTIDÃO("Certidão"),
    TÍTULO_DE_POSSE("Título de Posse"),
    NÃO_POSSUI("Não Possui");

    private final String descricao;

    Documentacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
