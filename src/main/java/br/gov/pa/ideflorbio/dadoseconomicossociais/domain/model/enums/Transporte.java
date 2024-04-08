package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums;

public enum Transporte {
    CARRO("Carro"),
    BARCO("Barco"),
    BICICLETA("Bicicleta"),
    A_PÉ("Deslocamento a pé"),
    MOTO("Motocicleta"),
    RABETA("Rabeta"),
    OUTRO("Outros");

    private final String descricao;

    Transporte(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
