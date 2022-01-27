package one.digitalinnovation.CadastroClientePetshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.CadastroClientePetshop.enums.PetType;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "pets")
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PetType type;

    @Column(nullable = false)
    private String nome;

    @Column
    private String idade;

    @Column(nullable = false)
    private String raca;

    @ManyToOne
    @JoinColumn(name = "fk_clientes_id", nullable = false)
    private Costumer costumer;
}
