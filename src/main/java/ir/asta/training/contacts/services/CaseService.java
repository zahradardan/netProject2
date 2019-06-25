package ir.asta.training.contacts.services;

import javax.servlet.ServletException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ir.asta.training.contacts.entities.Case;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import java.io.IOException;
import java.util.List;

@Path("/case")
public interface CaseService {


    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public ActionResult<Case> create(
            @FormParam("topic") String topic,
            @FormParam("refer") String refer,
            @FormParam("description") String description,
            @FormParam("username") String username
    ) throws ServletException, IOException;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getUserCases")
        public ActionResult<List<Case>> getUserCases(@FormParam("username") String username);


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getCase")
    public ActionResult<Case> getCase(@FormParam("id") String id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/filterCases")
    public ActionResult<List<Case>> filterCases(@FormParam("username") String username,@FormParam("userType")boolean userType);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/filtering")
    public ActionResult<List<Case>> filtering(@FormParam("status") String status,@FormParam("submitter")String submitter,
                                              @FormParam("responsible") String responsible);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateRefer")
    public ActionResult<Case> updateRefer(@FormParam("id") String id,@FormParam("refer") String refer);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/action")
    public ActionResult<Case> action(@FormParam("id") String id,@FormParam("status") String status);


}
