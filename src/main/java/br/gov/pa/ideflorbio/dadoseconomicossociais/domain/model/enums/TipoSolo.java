package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums;

public enum TipoSolo {
    VARZEA("Várzea"),
    TERRA_FIRME("Terra Firme"),
    IGAPO("Igapó");

    private final String descricao;

    TipoSolo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
