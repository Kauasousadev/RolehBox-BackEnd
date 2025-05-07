package edu.kaua.helpencontro.models.tagsrole;

import edu.kaua.helpencontro.models.Roleh;
import jakarta.persistence.*;

@Entity
public class CaracteristicaRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoCaracteristica tipo;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roleh role;

    // Getters, setters...
}