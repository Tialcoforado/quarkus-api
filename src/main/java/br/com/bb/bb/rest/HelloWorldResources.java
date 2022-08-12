package br.com.bb.bb.rest;

import io.opentracing.Tracer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@Path("/hello")
@RequestScoped
public class HelloWorldResources {

    @Inject
    Tracer trace;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {

        // Exemplo para adicionar tag
        if(trace != null && trace.activeSpan() != null) {
            trace.activeSpan().setTag("Tag_Hello", "Valor qualquer na chamada do HELLO");
        }

        try {
            // Simula um processamento entre 100 e 250 milisegundos
            int espera = ThreadLocalRandom.current().nextInt(100, 250);
            Thread.sleep(espera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HashMap<String, String> info = new HashMap<>();
        info.put("message", "hello world!");

        return Response.status(Response.Status.OK).entity(info).build();
    }


    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloName(@PathParam(value = "name") String name) {
        HashMap<String, String> info = new HashMap<>();
        info.put("message", "hello world! " + name);

        return Response.status(Response.Status.OK).entity(info).build();
    }

}
