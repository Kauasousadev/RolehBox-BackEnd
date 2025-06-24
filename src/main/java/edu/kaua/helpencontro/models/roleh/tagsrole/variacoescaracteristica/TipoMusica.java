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
public class TipoMusica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "musicas")
    private Set<CaracteristicaRole> caracteristicaRole = new HashSet<>();

    public TipoMusica(String getdescription) {
        this.description = getdescription;
    }

    public void adicionarCaracteristica(CaracteristicaRole caracteristicaRole) {
        this.caracteristicaRole.add(caracteristicaRole);
        caracteristicaRole.getMusicas().add(this);
    }

    public void removerCaracteristica(CaracteristicaRole caracteristicaRole) {
        this.caracteristicaRole.remove(caracteristicaRole);
        caracteristicaRole.getMusicas().remove(this);
    }
}
