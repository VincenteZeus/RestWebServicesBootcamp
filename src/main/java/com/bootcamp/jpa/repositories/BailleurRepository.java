package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Bailleur;

public class BailleurRepository extends BaseRepository<Bailleur> {

    public BailleurRepository(String unitPersistence) {
        super(unitPersistence, Bailleur.class);
    }
}
