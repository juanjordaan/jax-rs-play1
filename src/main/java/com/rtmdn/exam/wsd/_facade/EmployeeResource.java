
package com.rtmdn.exam.wsd._facade;

import static java.lang.System.out;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
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

import com.rtmdn.exam.wsd._model.employee.Employee;
import com.rtmdn.exam.wsd._service.EmployeeService;

@Path( "employee" )
@Stateless
public class EmployeeResource extends ProjectApp
{
	@EJB
	private EmployeeService employeeService;
	
	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response createEmployee( Employee employee )
	{
		return Response.ok ( ).entity ( employeeService.createEmployee ( employee ) ).build ( );
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
		
		return Response.ok ( ).entity ( employeeService.getEmployees ( ) ).build ( );
	}
	
	@GET
	@Path( "/{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getEmployee( @PathParam( value = "id" ) Long id )
	{
		return Response.ok ( ).entity ( employeeService.getEmployees ( ) ).build ( );
	}
	
	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response updateEmployee( Employee employee )
	{
		Employee copy = employeeService.updateEmployee ( employee );
		
		if ( employee.getVersion ( ).equals ( copy.getVersion ( ) ) )
		{
			return Response.notModified ( ).build ( );
		}
		
		return Response.ok ( ).entity ( copy ).build ( );
	}
	
	@DELETE
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response deleteEmployee( Employee employee )
	{
		employeeService.deleteEmployee ( employee );

		return Response.noContent ( ).build ( );
	}
	
	@OPTIONS
	@Produces( MediaType.APPLICATION_JSON )
	public Response getSupportedOperations()
	{
		return Response.ok ( ).entity ( "<operations>GET, PUT, POST, DELETE</operations>" ).build ( );
	}
}
