package io.github.marrafon91.estudos.entities;

import io.github.marrafon91.estudos.entities.enums.EstadoPagamento;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
public class PagamentoComCartao extends Pagamento{

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {;
    }

    public PagamentoComCartao(UUID id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
