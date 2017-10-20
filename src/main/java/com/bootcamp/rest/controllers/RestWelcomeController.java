package com.bootcamp.rest.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/hello")
public class RestWelcomeController {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Get Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }

    @POST
    @Path("/{param}")
    public Response postMsg(@PathParam("param") String msg) {

        String output = "Post Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }

    @DELETE
    @Path("/{param}")
    public Response deleteMsg(@PathParam("param") String msg) {

        String output = "Delete Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }

    @PUT
    @Path("/{param}")
    public Response putMsg(@PathParam("param") String msg) {

        String output = "Put Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/")
    public Response home() {

        String output = "Get Jersey say : index";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/{param1}/bootcamp/{param2}")
    public Response getMsg(@PathParam("param1") String msg1, @PathParam("param2") String msg2) {

        String output = "Get Jersey say : " +msg1 +" " +msg2;
        return Response.status(200).entity(output).build();
    }
}
