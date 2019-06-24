package ir.asta.training.contacts.services;

import javax.servlet.ServletException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Path("/contact")

public interface UserService {
	@POST

	@Path("/save")

	@Produces(MediaType.APPLICATION_JSON)

	public ActionResult<UserEntity> save(@FormParam("username") String username, @FormParam("password") String password,
			@FormParam("isStudent") boolean isStudent,@FormParam("isTeacher")boolean isTeacher);

	@POST

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/logIn")
	public ActionResult<UserEntity> load(@FormParam("password") String password,@FormParam("username") String username) throws IOException, NoSuchAlgorithmException, ServletException;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/management")
	public ActionResult<List<UserEntity>> management();


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/del/{token}")

	public ActionResult<Integer> manager_del(@PathParam("token") String username);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/conf/{token}")

	public ActionResult<UserEntity> manager_up(@PathParam("token") String username);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/activate/{token}")

	public ActionResult<UserEntity> manager_act(@PathParam("token") String username);
}
