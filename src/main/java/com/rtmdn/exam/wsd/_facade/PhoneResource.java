
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

import com.rtmdn.exam.wsd._model.employee.Phone;
import com.rtmdn.exam.wsd._service.PhoneService;

@Path("phone")
@Stateless
public class PhoneResource extends ProjectApp
{
	@EJB
	private PhoneService phoneService;
	
	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response createPhone( Phone phone )
	{
		return Response.ok ( ).entity ( phoneService.createPhone ( phone ) ).build ( );
	}
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response list( )
	{
		return Response.ok ( ).entity ( phoneService.getPhones ( ) ).build ( );
	}
	
	@GET
	@Path("/{id}")
	@Produces( MediaType.APPLICATION_JSON )
	public Response getPhone( @PathParam(value="id") Long id )
	{
		return Response.ok ( ).entity ( phoneService.getPhones ( ) ).build ( );
	}
	
	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response updatePhone( Phone phone )
	{
		Phone copy = phoneService.updatePhone ( phone );
		
		if( phone.getVersion().equals( copy.getVersion( ) ) )
		{
			return Response.notModified ( ).build ( );
		}
		
		return Response.ok ( ).entity ( copy ).build ( );
	}
	
	@DELETE
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response deletePhone( Phone phone )
	{
		phoneService.deletePhone ( phone );
		
		return Response.noContent ( ).build ( );
	}
}
