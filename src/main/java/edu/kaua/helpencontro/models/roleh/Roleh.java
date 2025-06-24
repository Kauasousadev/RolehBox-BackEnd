package edu.kaua.helpencontro.models.roleh;

import edu.kaua.helpencontro.models.review.Review;
import edu.kaua.helpencontro.models.roleh.tagsrole.CaracteristicaRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
    @Column
    private Double rating = 0.0;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "caracteristica_id")
    private CaracteristicaRole caracteristicas;
    @Column
    @OneToMany
    private Set<Review> reviews;

    public Roleh(String name, String description, String address, String phoneNumber, CaracteristicaRole caracteristicas) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.caracteristicas = caracteristicas;
    }
}

