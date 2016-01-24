
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

import com.rtmdn.exam.wsd._model.employee.Department;
import com.rtmdn.exam.wsd._service.DepartmentService;

@Path( "department" )
@Stateless
public class DepartmentResource extends ProjectApp
{
	@EJB
	private DepartmentService departmentService;

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response createDepartment( Department department, @Context UriInfo uriInfo )
	{
		department = departmentService.createDepartment ( department );
		UriBuilder uriBuilder = UriBuilder.fromUri ( uriInfo.getBaseUri ( ) ).path ( DepartmentResource.class ).path ( department.getId ( ).toString ( ) );

		URI uri = uriBuilder.build ( );
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
		out.println ( "securityContext.getAuthenticationScheme ( ) = " + securityContext.getAuthenticationScheme ( ) );
		//out.println ( "securityContext.getUserPrincipal ( ).getName ( ) ( ) = " + securityContext.getUserPrincipal ( ).getName ( ) );

		return Response.ok ( ).entity ( departmentService.getDepartments ( ) ).build ( );
	}

	@GET
	@Path( "/{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getDepartment( @PathParam( value = "id" ) Long id )
	{
		return Response.ok ( ).entity ( departmentService.getDepartments ( ) ).build ( );
	}

	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response updateDepartment( Department department )
	{
		Department copy = departmentService.updateDepartment ( department );

		if ( department.getVersion ( ).equals ( copy.getVersion ( ) ) )
		{
			return Response.notModified ( ).build ( );
		}

		return Response.ok ( ).entity ( copy ).build ( );
	}

	@DELETE
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response deleteDepartment( Department department )
	{
		departmentService.deleteDepartment ( department );

		return Response.noContent ( ).build ( );
	}
}
