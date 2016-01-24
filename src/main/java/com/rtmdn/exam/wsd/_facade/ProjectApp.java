package com.rtmdn.exam.wsd._facade;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("projectapp")
@Stateless
public class ProjectApp
{
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public String message( )
	{
		return "Something";
	}
}
