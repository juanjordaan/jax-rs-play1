
package com.rtmdn.exam.wsd._facade;

import static java.lang.System.out;

import java.net.URI;

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
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.rtmdn.exam.wsd._model.project.QualityProject;
import com.rtmdn.exam.wsd._service.QualityProjectService;

@Path("project/quality")
@Stateless
public class QualityProjectResource extends ProjectApp
{
	@EJB
	private QualityProjectService qualityProjectService;
	
	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response createQualityProject( QualityProject qualityProject, @Context UriInfo uriInfo )
	{
		qualityProject = qualityProjectService.createQualityProject ( qualityProject );
		UriBuilder uriBuilder = UriBuilder.fromUri ( uriInfo.getBaseUri ( ) ).path ( QualityProjectResource.class ).path ( qualityProject.getId ( ).toString ( ) );
		
		URI uri = uriBuilder.build( );
		out.println ( "uri = " + uri );
		
		return Response.accepted ( uri ).build ( );
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
		
		return Response.ok ( ).entity ( qualityProjectService.getQualityProjects ( ) ).build ( );
	}
	
	@GET
	@Path("/{id}")
	@Produces( MediaType.APPLICATION_JSON )
	public Response getQualityProject( @PathParam(value="id") Long id )
	{
		return Response.ok ( ).entity ( qualityProjectService.getQualityProjects ( ) ).build ( );
	}
	
	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response updateQualityProject( QualityProject qualityProject )
	{
		QualityProject copy = qualityProjectService.updateQualityProject ( qualityProject );
		
		if( qualityProject.getVersion().equals( copy.getVersion( ) ) )
		{
			return Response.notModified ( ).build ( );
		}
		
		return Response.ok ( ).entity ( copy ).build ( );
	}
	
	@DELETE
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response deleteQualityProject( QualityProject qualityProject )
	{
		qualityProjectService.deleteQualityProject ( qualityProject );
		
		return Response.noContent ( ).build ( );
	}
}
