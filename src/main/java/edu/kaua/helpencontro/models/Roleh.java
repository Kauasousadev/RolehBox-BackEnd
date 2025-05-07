package edu.kaua.helpencontro.models;

import jakarta.persistence.*;

@Entity
@Table
public class Roleh {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    //Filtros para o date

    //Faixa de preço
    @Column(nullable = false)
    private Float precoMin;

    @Column(nullable = false)
    private Float precoMax;

    // Mapeamento para características (OneToMany)
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CaracteristicaRole> caracteristicas = new ArrayList<>();
}

