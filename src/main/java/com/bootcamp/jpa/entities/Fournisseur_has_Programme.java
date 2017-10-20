package com.bootcamp.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tp_fournisseur_has_programme")
@Access(AccessType.FIELD)
public class Fournisseur_has_Programme implements Serializable {
    @Id
    @Column(name = "programme_id", nullable=false)
    private int programme_id;

    @Id
    @Column(name = "fournisseur_id", nullable=false)
    private int fournisseur_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "fournisseur_id", referencedColumnName = "ID")
    private Fournisseur fournisseur;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "programme_id", referencedColumnName = "ID")
    private Programme programme;

    @NotNull(message = "La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "fonds", length = 45, nullable = false)
    private String fonds;

    public Fournisseur_has_Programme() {
    }

    public Fournisseur_has_Programme(int fournisseur_id, int programme_id, Fournisseur fournisseur, Programme programme) {
        this.fournisseur_id = fournisseur_id;
        this.programme_id = programme_id;
        this.fournisseur = fournisseur;
        this.programme = programme;
    }

    public Fournisseur_has_Programme(Fournisseur fournisseur, Programme programme) {
        this.fournisseur = fournisseur;
        this.programme = programme;
    }

    public Fournisseur getFournisseur() {
        return this.fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
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