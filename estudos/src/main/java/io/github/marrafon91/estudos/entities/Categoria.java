package io.github.marrafon91.estudos.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "produtos")
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tb_id", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "tb_nome", nullable = false, length = 80)
    private String nome;


    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();


}
