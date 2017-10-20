package com.bootcamp.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tp_bailleur_has_programme")
@Access(AccessType.FIELD)
public class Bailleur_has_Programme implements Serializable {
    @Id
    @Column(name = "bailleur_id", nullable=false)
    private int bailleur_id;

    @Id
    @Column(name = "programme_id", nullable=false)
    private int programme_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "bailleur_id", referencedColumnName = "ID")
    private Bailleur bailleur;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "programme_id", referencedColumnName = "ID")
    private Programme programme;

    @NotNull(message = "La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "fonds", length = 45, nullable = false)
    private String fonds;

    public Bailleur_has_Programme() {
    }

    public Bailleur_has_Programme(int bailleur_id, int programme_id, Bailleur bailleur, Programme programme) {
        this.bailleur_id = bailleur_id;
        this.programme_id = programme_id;
        this.bailleur = bailleur;
        this.programme = programme;
    }

    public Bailleur_has_Programme(Bailleur bailleur, Programme programme) {
        this.bailleur = bailleur;
        this.programme = programme;
    }

    public Bailleur getBailleur() {
        return this.bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }

    public Programme getProgramme() {
        return programme;
    }


    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public String getFonds() {
        return this.fonds;
    }

    public void setFonds(String fonds) {
        this.fonds = fonds;
    }
}