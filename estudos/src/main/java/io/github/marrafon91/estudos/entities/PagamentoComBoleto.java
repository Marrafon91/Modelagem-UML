package io.github.marrafon91.estudos.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.marrafon91.estudos.entities.enums.EstadoPagamento;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class PagamentoComBoleto extends Pagamento{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private Instant dataVencimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private Instant dataPagamento;


    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(UUID id, EstadoPagamento estado, Pedido pedido, Instant dataVencimento, Instant dataPagamento) {
        super(id, estado, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }
}
