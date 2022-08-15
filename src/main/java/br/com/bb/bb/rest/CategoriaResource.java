package br.com.bb.bb.rest;

import br.com.bb.bb.models.Categoria;
import br.com.bb.bb.service.CategoriaService;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.opentracing.Traced;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Traced
public class CategoriaResource {

    @PostConstruct
    @Transactional
    public void onStart(@Observes StartupEvent event) throws Exception {
        Categoria category1 = new Categoria();
        category1.setNome("Programador");

        Categoria category2 = new Categoria();
        category2.setNome("Comerciante");

        categoriaService.createCategoria(category1);
        categoriaService.createCategoria(category2);
    }

    @Inject
    CategoriaService categoriaService;

    @GET
    @Path("/list")
    public Response listCategoria() {
        return Response
            .status(Response.Status.OK)
            .entity(categoriaService.listCategorias())
            .build();
    }

    @POST
    public Response createCategoria(@Valid Categoria categoria) throws Exception {
        return  Response.status(Response.Status.CREATED).entity(categoriaService.createCategoria(categoria)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCategoria(final @PathParam("id") long id, @Valid Categoria categoria)  {
        return Response.status(Response.Status.OK).entity(categoriaService.updateCategoria(id, categoria)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCategoria(final @PathParam("id") long id) throws Exception  {
        categoriaService.deleteCategoria(id);
        return Response.status(Response.Status.OK).build();
    }
}
