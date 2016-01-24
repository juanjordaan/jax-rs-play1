
package com.rtmdn.exam.wsd._facade;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rtmdn.exam.wsd._model.project.Project;
import com.rtmdn.exam.wsd._service.ProjectService;

@Path("project")
@Stateless
public class ProjectResource extends ProjectApp
{
	@EJB
	private ProjectService projectService;
	
	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response createProject( Project project )
	{
		return Response.ok ( ).entity ( projectService.createProject ( project ) ).build ( );
	}
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response list( )
	{
		return Response.ok ( ).entity ( projectService.getProjects ( ) ).build ( );
	}
	
	@GET
	@Path("/{id}")
	@Produces( MediaType.APPLICATION_JSON )
	public Response getProject( @PathParam(value="id") Long id )
	{
		return Response.ok ( ).entity ( projectService.getProjects ( ) ).build ( );
	}
	
	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response updateProject( Project project )
	{
		Project copy = projectService.updateProject ( project );
		
		if( project.getVersion().equals( copy.getVersion( ) ) )
		{
			return Response.notModified ( ).build ( );
		}
		
		return Response.ok ( ).entity ( copy ).build ( );
	}
	
	@DELETE
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response deleteProject( Project project )
	{
		projectService.deleteProject ( project );
		
		return Response.noContent ( ).build ( );
	}
}
