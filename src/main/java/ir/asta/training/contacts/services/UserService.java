package ir.asta.training.contacts.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

@Path("/contact")

public interface UserService {
	@POST

	@Path("/save")

	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)


	public String save(@FormParam("username") String username, @FormParam("password") String password,
			@FormParam("isStudent") boolean isStudent);

	@GET

	@Produces(MediaType.APPLICATION_JSON)

	@Path("/logIn/{password}")

	public UserEntity load(@FormParam("password") String password,@FormParam("username") String username);

}
