package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums;

public enum MetodoTratamentoAgua {
    FERVURA("Fervura"),
    FILTRACAO("Filtração"),
    CLORACAO("Cloração"),
    OSMOSE_REVERSA("Osmose Reversa"),
    DESTILACAO("Destilação"),
    ULTRAVIOLETA("Desinfecção Ultravioleta");

    private final String descricao;

    MetodoTratamentoAgua(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static void main(String[] args) {
        for (MetodoTratamentoAgua metodo : MetodoTratamentoAgua.values()) {
            System.out.println(metodo.name() + ": " + metodo.getDescricao());
        }
    }
}
