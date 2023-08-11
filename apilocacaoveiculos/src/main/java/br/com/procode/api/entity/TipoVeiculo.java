package br.com.procode.api.entity;

public enum TipoVeiculo {

    PASSEIO("Passeio", "70.00"),
    SUV("SUV", "120.00"),
    PICAPE("Picape", "150.00"),
    VAN("Van", "180.00"),
    CAMINHAO("Caminhão", "300.00");

    private final String descricao;
    private final String valorDiaria;

    TipoVeiculo(String descricao, String valorDiaria) {
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getValorDiaria() {
        return valorDiaria;
    }
}
