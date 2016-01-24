
package com.rtmdn.exam.wsd.hello;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/hello" )
@Stateless
public class Hello
{
	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces( MediaType.TEXT_PLAIN )
	public String sayPlainTextHello( )
	{
		return "Hello Jersey";
	}
	
	// This method is called if XML is request
	@GET
	@Produces( MediaType.TEXT_XML )
	public String sayXMLHello( )
	{
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces( MediaType.TEXT_HTML )
	public String sayHtmlHello( )
	{
		return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response sayJsonHello( )
	{
		JsonObject jsonObject = Json.createObjectBuilder().add("message", "Hello Jersey").build();
		
		return Response.ok ( jsonObject, MediaType.APPLICATION_JSON ).build ( );
	}
}
