package edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica;

import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TipoComida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "comidas")
    @ToString.Exclude
    private Set<CaracteristicaRole> caracteristicaRole = new HashSet<>();

    public TipoComida(String getdescription) {
        this.description = getdescription;
    }
}
