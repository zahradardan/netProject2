package ir.asta.training.contacts.services;

import javax.servlet.ServletException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import java.io.IOException;

@Path("/case")
public interface CaseService {

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult save(
            @FormParam("topic") String topic,
            @FormParam("refer") String refer,
            @FormParam("description") String description
            ) throws ServletException, IOException;
}
