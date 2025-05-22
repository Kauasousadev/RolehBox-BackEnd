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
public class OutrasTags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "outrasTags_caracteristica",
            joinColumns = @JoinColumn(name = "outrasTags_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id")
    )
    private Set<CaracteristicaRole> caracteristicaRole;

    public OutrasTags(String description) {
        this.description = description;
    }

}
