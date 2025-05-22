package edu.kaua.helpencontro.models;

import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Roleh {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "caracteristica_id")
    private CaracteristicaRole caracteristicas;

    public Roleh(String name, String description, String address, String phoneNumber, CaracteristicaRole caracteristicas) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.caracteristicas = caracteristicas;
    }
}

