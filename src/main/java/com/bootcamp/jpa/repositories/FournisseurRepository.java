package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Fournisseur;

public class FournisseurRepository extends BaseRepository<Fournisseur> {

    public FournisseurRepository(String UnitPersistence) {
        super(UnitPersistence, Fournisseur.class);
    }
}
