package com.bootcamp.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tp_beneficiaire_has_programme")
@Access(AccessType.FIELD)
public class Beneficiaire_has_Programme implements Serializable {
    @Id
    @Column(name = "beneficiaire_id", nullable=false)
    private int beneficiaire_id;

    @Id
    @Column(name = "programme_id", nullable=false)
    private int programme_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "beneficiaire_id", referencedColumnName = "ID")
    private Beneficiaire beneficiaire;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "programme_id", referencedColumnName = "ID")
    private Programme programme;

    @NotNull(message = "La valeur entrée ne doit pas être null. Entrez une valeur correcte")
    @Column(name = "fonds", length = 45, nullable = false)
    private String fonds;

    public Beneficiaire_has_Programme() {
    }

    public Beneficiaire_has_Programme(int beneficiaire_id, int programme_id, Beneficiaire beneficiaire, Programme programme) {
        this.beneficiaire_id = beneficiaire_id;
        this.programme_id = programme_id;
        this.beneficiaire = beneficiaire;
        this.programme = programme;
    }

    public Beneficiaire_has_Programme(Beneficiaire beneficiaire, Programme programme) {
        this.beneficiaire = beneficiaire;
        this.programme = programme;
    }

    public Beneficiaire getBeneficiaire() {
        return this.beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
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