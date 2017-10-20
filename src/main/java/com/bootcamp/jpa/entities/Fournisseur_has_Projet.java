package com.bootcamp.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tp_fournisseur_has_projet")
@Access(AccessType.FIELD)
public class Fournisseur_has_Projet implements Serializable {
    @Id
    @Column(name = "projet_id", nullable=false)
    private int projet_id;

    @Id
    @Column(name = "fournisseur_id", nullable=false)
    private int fournisseur_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "fournisseur_id", referencedColumnName = "ID")
    private Fournisseur fournisseur;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "programme_id", referencedColumnName = "ID")
    private Projet projet;

    @NotNull(message = "La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "fonds", length = 45, nullable = false)
    private String fonds;

    public Fournisseur_has_Projet() {
    }

    public Fournisseur_has_Projet(int fournisseur_id, int projet_id, Fournisseur fournisseur, Projet projet) {
        this.fournisseur_id = fournisseur_id;
        this.projet_id = projet_id;
        this.fournisseur = fournisseur;
        this.projet = projet;
    }

    public Fournisseur_has_Projet(Fournisseur fournisseur, Projet projet) {
        this.fournisseur = fournisseur;
        this.projet = projet;
    }

    public Fournisseur getFournisseur() {
        return this.fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Projet getProjet() {
        return projet;
    }


    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public String getFonds() {
        return this.fonds;
    }

    public void setFonds(String fonds) {
        this.fonds = fonds;
    }
}