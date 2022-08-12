package br.com.bb.bb.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.opentracing.Traced;

import br.com.bb.bb.models.Cliente;
import br.com.bb.bb.service.ClienteService;

@RequestScoped
@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Traced
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @GET
    @Path("/list")
    public Response listClients() {
        return Response
            .status(Response.Status.OK)
            .entity(clienteService.listClientes())
            .build();
    }

    @POST
    public Response createClient(@Valid Cliente cliente) throws Exception {
        return  Response.status(Response.Status.CREATED).entity(clienteService.createClient(cliente)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateClient(final @PathParam("id") long id, @Valid Cliente client) throws Exception  {
        return Response.status(Response.Status.OK).entity(clienteService.updateClient(id, client)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClient(final @PathParam("id") long id) throws Exception  {
        clienteService.deleteClient(id);
        return Response.status(Response.Status.OK).build();
    }
}
