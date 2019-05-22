package ir.asta.training.contacts.services;

import java.io.IOException;

import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;

import javax.ws.rs.POST;

import javax.ws.rs.Path;

import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import ir.asta.training.contacts.entities.ContactEntity;

import ir.asta.wise.core.datamanagement.ActionResult;


@Path("/myservice")
@Named("BookService")
public interface BookService {
	
	@Context public HttpServletRequest servletRequest = null;
	@Context  public HttpServletResponse servletReqsponse = null;
	
	
	@POST
	@PathParam("book")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static void callarest() throws ServletException,IOException {
		
		RequestDispatcher dispatcher = (RequestDispatcher) servletRequest.getServletContext();
		dispatcher.forward(servletRequest, servletReqsponse);
	}

}
