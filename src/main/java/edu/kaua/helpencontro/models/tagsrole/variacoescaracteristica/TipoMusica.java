package edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica;

import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
import jakarta.persistence.*;

@Entity
public class TipoMusica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "caracteristica_id")
    private CaracteristicaRole caracteristica;

    public TipoMusica() {
    }

    public TipoMusica(String descricao, CaracteristicaRole caracteristica) {
        this.descricao = descricao;
        this.caracteristica = caracteristica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CaracteristicaRole getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(CaracteristicaRole caracteristica) {
        this.caracteristica = caracteristica;
    }
}
