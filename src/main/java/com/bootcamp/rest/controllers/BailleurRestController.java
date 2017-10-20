package com.bootcamp.rest.controllers;

import com.bootcamp.jpa.entities.Bailleur;
import com.bootcamp.jpa.repositories.BailleurRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/bailleur")
public class BailleurRestController {

    BailleurRepository bailleurRepository = new BailleurRepository("tpJpaSql");

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() throws SQLException {

        List<Bailleur> bailleurs = bailleurRepository.findAll();
        return Response.status(200).entity(bailleurs).build();
    }

    @GET
    @Path("/pers/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList(@PathParam("param") int id) throws SQLException {

        Bailleur bailleur = bailleurRepository.findOneByProperty("id", id);
        if(bailleur != null)
            return Response.status(200).entity(bailleur).build();
        else
            return Response.status(404).entity(bailleur).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Bailleur bailleur) throws SQLException {

        bailleurRepository.create(bailleur);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Bailleur bailleur) throws SQLException {

        bailleurRepository.create(bailleur);
    }
}
