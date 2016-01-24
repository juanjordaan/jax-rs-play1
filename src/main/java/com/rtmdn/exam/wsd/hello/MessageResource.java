
package com.rtmdn.exam.wsd.hello;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.apache.cxf.jaxrs.model.wadl.Description;
//import org.apache.cxf.jaxrs.model.wadl.Descriptions;
//import org.apache.cxf.jaxrs.model.wadl.DocTarget;

@Path( "/messages" )
@Stateless
public class MessageResource
{
	@GET
	@Produces( MediaType.TEXT_PLAIN )
	/*@Descriptions(value={
		@Description(value = "Requested Message", target = DocTarget.RETURN), 
		@Description(value = "message", target = DocTarget.RESPONSE),
	   @Description(value = "message", target = DocTarget.RESOURCE)
	})*/
	public Message getMessage( )
	{
		return new Message ( "Hello World" );
	}
	
	/*@Descriptions(value={
		@Description(value = "Requested Message", target = DocTarget.RETURN), 
		@Description(value = "message", target = DocTarget.RESPONSE),
	   @Description(value = "message", target = DocTarget.RESOURCE)
	})*/
	@Path("/response")
	@GET
	@Produces( MediaType.TEXT_PLAIN )
	public Response getMessageResponse( )
	{
		return Response.ok ( ).entity (new Message ( "Hello World" ) ).build ( );
	}
}
