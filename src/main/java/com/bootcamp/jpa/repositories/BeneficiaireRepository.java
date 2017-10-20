package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Beneficiaire;

public class BeneficiaireRepository extends BaseRepository<Beneficiaire> {

    public BeneficiaireRepository(String unitPersistence) {
        super(unitPersistence, Beneficiaire.class);
    }

}
