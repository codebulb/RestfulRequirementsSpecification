package ch.codebulb.restfulrequirementsspecification.server.service;

import java.util.Arrays;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.core.Response;

public class ConstraintViolationException extends Exception {
    private final List<String> violationMessages;

    public ConstraintViolationException(List<String> violations) {
        this.violationMessages = violations;
    }
    
    public ConstraintViolationException(String violation) {
        this(Arrays.asList(violation));
    }
    
    public Response getResponse() {
        JsonArrayBuilder jsonBuilder = Json.createArrayBuilder();
        for (String violationMessage : violationMessages) {
            jsonBuilder.add(violationMessage);
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(jsonBuilder.build().toString()).build();
    }
}
