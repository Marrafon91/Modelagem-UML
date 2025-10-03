package io.github.marrafon91.estudos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "categorias")
@Table(name = "produto")
public class Produto  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;

    @ManyToMany
    @JoinTable(
            name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @JsonIgnore
    private List<Categoria> categorias = new ArrayList<>();


    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    public List<Pedido> getPedidos() {
        List<Pedido> lista = new ArrayList<>();
        for (ItemPedido x : itens) {
            lista.add(x.getPedido());
        }
        return lista;
    }
}
