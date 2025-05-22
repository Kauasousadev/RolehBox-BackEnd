package edu.kaua.helpencontro.models.tagsrole;

import edu.kaua.helpencontro.models.Roleh;
import edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CaracteristicaRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "g_maps_link")
    private String gMapsLink;
    @Column()
    private String instaUser;
    @Column()
    private Float minPrice;
    @Column()
    private Float maxPrice;
    @Column()
    private LocalDateTime openingHours;
    @Column()
    private LocalDateTime closingHours;

    @OneToOne
    @JoinColumn(name = "roleh_id")
    private Roleh roleh;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private TipoLocal tipoLocal;

    @ManyToMany
    @JoinTable(
            name = "comida_caracteristica",
            joinColumns = @JoinColumn(name = "caracteristica_id"),
            inverseJoinColumns = @JoinColumn(name = "comida_id")
    )
    @ToString.Exclude
    private Set<TipoComida> comidas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "musica_caracteristica",
            joinColumns = @JoinColumn(name = "caracteristica_id"),
            inverseJoinColumns = @JoinColumn(name = "musica_id")
    )
    @ToString.Exclude
    private Set<TipoMusica> musicas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "acessibilidade_caracteristica",
            joinColumns = @JoinColumn(name = "caracteristica_id"),
            inverseJoinColumns = @JoinColumn(name = "acessibilidade_id")
    )
    @ToString.Exclude
    private Set<TipoAcessibilidade> acessibilidade = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "outrasTags_caracteristica",
            joinColumns = @JoinColumn(name = "caracteristica_id"),
            inverseJoinColumns = @JoinColumn(name = "outrasTags_id")
    )
    @ToString.Exclude
    private Set<OutrasTags> outrasTags = new HashSet<>();

}