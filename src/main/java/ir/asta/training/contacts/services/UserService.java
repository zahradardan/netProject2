package ir.asta.training.contacts.services;

import javax.servlet.ServletException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Path("/contact")

public interface UserService {
	@POST

	@Path("/save")

	@Produces(MediaType.APPLICATION_JSON)

	public ActionResult<UserEntity> save(@FormParam("username") String username, @FormParam("password") String password,
			@FormParam("isStudent") boolean isStudent);

	@POST

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/logIn")
	public ActionResult<UserEntity> load(@FormParam("password") String password,@FormParam("username") String username) throws IOException, NoSuchAlgorithmException, ServletException;

	@POST

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/edit")
	public ActionResult<UserEntity> edit(
			                             @FormParam("oldpassword") String oldpassword,
										 @FormParam("newpassword") String newpassword,
										 @FormParam("username") String username
										)throws IOException, NoSuchAlgorithmException, ServletException;


}
