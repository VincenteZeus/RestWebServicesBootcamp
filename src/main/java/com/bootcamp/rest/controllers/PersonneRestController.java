package com.bootcamp.rest.controllers;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.entities.Beneficiaire;
import com.bootcamp.jpa.entities.Fournisseur;
import com.bootcamp.jpa.repositories.BailleurRepository;
import com.bootcamp.jpa.repositories.BeneficiaireRepository;
import com.bootcamp.jpa.repositories.FournisseurRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/bailleur")
public class PersonneRestController {

    BailleurRepository bailleurRepository = new BailleurRepository("tpJpaSql");
    BeneficiaireRepository beneficiaireRepository = new BeneficiaireRepository("tpJpaSql");
    FournisseurRepository fournisseurRepository = new FournisseurRepository("tpJpaSql");

    @GET
    @Path("/list/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList(@PathParam("param") String type) throws SQLException {

        switch (type) {
            case "bailleurs":
                List<Bailleur> bailleurs = bailleurRepository.findAll();
                return Response.status(200).entity(bailleurs).build();

            case "beneficiaires":
                List<Beneficiaire> beneficiaires = beneficiaireRepository.findAll();
                return Response.status(200).entity(beneficiaires).build();

            case "fournisseurs":
                List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
                return Response.status(200).entity(fournisseurs).build();
        }
        return Response.status(403).entity("error").build();
    }
}
