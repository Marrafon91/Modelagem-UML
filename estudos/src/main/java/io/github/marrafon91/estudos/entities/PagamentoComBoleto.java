package io.github.marrafon91.estudos.entities;

import io.github.marrafon91.estudos.entities.enums.EstadoPagamento;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
public class PagamentoComBoleto extends Pagamento{

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(UUID id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }
}
