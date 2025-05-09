package edu.kaua.helpencontro.models.tagsrole.variacoescaracteristica;

import jakarta.persistence.*;

@Entity
public class TipoLocal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String desc;

    public TipoLocal() {
    }

    public TipoLocal(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
