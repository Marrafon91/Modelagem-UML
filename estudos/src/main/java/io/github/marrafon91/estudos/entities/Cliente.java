package io.github.marrafon91.estudos.entities;

import io.github.marrafon91.estudos.entities.enums.TipoCliente;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tb_id", unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private UUID id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;

    private List<Endereco> enderecos = new ArrayList<>();

    private Set<String> telefones = new HashSet<>();

    public Cliente() {
    }

    public Cliente(UUID id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo.getCod();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }
}
