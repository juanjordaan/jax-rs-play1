
package com.rtmdn.exam.wsd._facade;

import static java.lang.System.out;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import com.rtmdn.exam.wsd._model.project.DesignProject;
import com.rtmdn.exam.wsd._service.DesignProjectService;

@Path("project/design")
@Stateless
public class DesignProjectResource extends ProjectApp
{
	@EJB
	private DesignProjectService designProjectService;
	
	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response createDesignProject( DesignProject designProject )
	{
		return Response.ok ( ).entity ( designProjectService.createDesignProject ( designProject ) ).build ( );
	}
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response list( @Context UriInfo uriInfo, @Context Request request, @Context SecurityContext securityContext )
	{
		out.println ( "uriInfo.getAbsolutePath ( )  = " + uriInfo.getAbsolutePath ( ) );
		out.println ( "uriInfo.getBaseUri ( )       = " + uriInfo.getBaseUri ( ) );
		out.println ( "uriInfo.getPath ( )          = " + uriInfo.getPath ( ) );
		out.println ( "uriInfo.getRequestUri ( )    = " + uriInfo.getRequestUri ( ) );
		out.println ( "request.getMethod ( )        = " + request.getMethod ( ) );
		out.println ( "securityContext.isSecure ( ) = " + securityContext.isSecure ( ) );
		
		return Response.ok ( ).entity ( designProjectService.getDesignProjects ( ) ).build ( );
	}
	
	@GET
	@Path("/{id}")
	@Produces( MediaType.APPLICATION_JSON )
	public Response getDesignProject( @PathParam(value="id") Long id )
	{
		return Response.ok ( ).entity ( designProjectService.getDesignProjects ( ) ).build ( );
	}
	
	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response updateDesignProject( DesignProject designProject )
	{
		DesignProject copy = designProjectService.updateDesignProject ( designProject );
		
		if( designProject.getVersion().equals( copy.getVersion( ) ) )
		{
			return Response.notModified ( ).build ( );
		}
		
		return Response.ok ( ).entity ( copy ).build ( );
	}
	
	@DELETE
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response deleteDesignProject( DesignProject designProject )
	{
		designProjectService.deleteDesignProject ( designProject );
		
		return Response.noContent ( ).build ( );
	}
}
