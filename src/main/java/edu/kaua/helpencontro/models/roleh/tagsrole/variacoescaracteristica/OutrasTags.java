package edu.kaua.helpencontro.models.roleh.tagsrole.variacoescaracteristica;

import edu.kaua.helpencontro.models.roleh.tagsrole.CaracteristicaRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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

    @ManyToMany(mappedBy = "outrasTags")
    private Set<CaracteristicaRole> caracteristicaRole = new HashSet<>();

    public OutrasTags(String getdescription) {
        this.description = getdescription;
    }

    public void adicionarCaracteristica(CaracteristicaRole caracteristicaRole) {
        this.caracteristicaRole.add(caracteristicaRole);
        caracteristicaRole.getOutrasTags().add(this);
    }

    public void removerCaracteristica(CaracteristicaRole caracteristicaRole) {
        this.caracteristicaRole.remove(caracteristicaRole);
        caracteristicaRole.getOutrasTags().remove(this);
    }
}
