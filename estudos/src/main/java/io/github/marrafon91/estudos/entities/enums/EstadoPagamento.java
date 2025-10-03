package io.github.marrafon91.estudos.entities.enums;

public enum EstadoPagamento {
    PEDENTE(1, "pedente"),
    QUITADO(2, "quitado"),
    CANCELADO(3, "cancelado");

    private Integer cod;
    private String descricao;

    EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (EstadoPagamento x : EstadoPagamento.values()) {
            if (cod.equals(x.getCod())) {
                return  x;
            }
        }
        throw  new IllegalArgumentException("Id invalido: " + cod);
    }
}
