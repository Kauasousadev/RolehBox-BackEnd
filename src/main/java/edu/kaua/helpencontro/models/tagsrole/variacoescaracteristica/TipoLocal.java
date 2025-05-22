package edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TipoLocal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String description;

    public TipoLocal(Long localId) {
        this.id = localId;
    }
}
