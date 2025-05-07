package edu.kaua.helpencontro.models;

import edu.kaua.helpencontro.models.tagsrole.CaracteristicaRole;
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
    private String desc;
    @Column(nullable = false)
    private String address;
    @Column()
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "caracteristica_id")
    private CaracteristicaRole caracteristicas;

    public Roleh() {
    }

    public Roleh(String name, String desc, String address, String phoneNumber, CaracteristicaRole caracteristicas) {
        this.name = name;
        this.desc = desc;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.caracteristicas = caracteristicas;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CaracteristicaRole getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(CaracteristicaRole caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}

