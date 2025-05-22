package edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica;

import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TipoAcessibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "acessibilidade_caracteristica",
            joinColumns = @JoinColumn(name = "acessibilidade_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id")
    )
    private Set<CaracteristicaRole> caracteristicaRole;

    public TipoAcessibilidade(String description) {
        this.description = description;
    }
}
