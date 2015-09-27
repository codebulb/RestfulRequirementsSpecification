package ch.codebulb.restfulrequirementsspecification.server.webservice;

import ch.codebulb.restfulrequirementsspecification.server.model.hal.BaseHalModel;
import ch.codebulb.restfulrequirementsspecification.server.service.BaseService;
import ch.codebulb.restfulrequirementsspecification.server.service.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public abstract class BaseResource<T extends BaseHalModel> {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> findAll(@Context UriInfo uri) {
        return new ArrayList<>(getService().findAll());
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public T findById(@PathParam("id") Long id) {
        return getService().findById(id);
    }
    
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Context UriInfo uri, T entity) {
        entity.removeLinks(); // cleanup HAL metadata
        try {
            entity = getService().save(entity);
            entity.addLink("edit", uri.getPath() + entity.getId()); // add HAL metadata
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (ConstraintViolationException ex) {
            return ex.getResponse();
        }
    }
    
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            getService().delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (ConstraintViolationException ex) {
            return ex.getResponse();
        }
    }
    
    protected abstract BaseService<T> getService();
}
