package br.com.albus.comum.categoria;

public enum EnumTipoCategoria {
    PRODUTO("Produto"),
    SERVICO("Serviço");

    private String value;

    private EnumTipoCategoria(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
