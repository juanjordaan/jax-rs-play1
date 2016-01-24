
package com.rtmdn.exam.wsd.todo;

import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class TodoResource
{
	TodoDAOInterface todoDao;

	Long id;

	@Context
	UriInfo uriInfo;

	@Context
	Request request;
	
	public TodoResource ( ) throws Exception
	{
		javax.naming.Context ctx = new InitialContext ( );
		todoDao = (TodoDAOInterface) ctx.lookup ( "java:module/TodoDao!com.rtmdn.exam.wsd.todo.TodoDAOInterface" );
	}
	
	public TodoResource ( UriInfo uriInfo, Request request, Long id ) throws Exception
	{
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		
		javax.naming.Context ctx = new InitialContext ( );
		todoDao = (TodoDAOInterface) ctx.lookup ( "java:module/TodoDao!com.rtmdn.exam.wsd.todo.TodoDAOInterface" );
	}
	
	// Application integration
	@GET
	@Produces( MediaType.APPLICATION_XML )
	public Todo getTodo( )
	{
		Todo todo = todoDao.find ( id, "Todo.default" );

		if ( todo == null )
			throw new RuntimeException ( "Get: Todo with " + id + " not found" );

		return todo;
	}

	// for the browser
	@GET
	@Produces( MediaType.TEXT_XML )
	public Todo getTodoHTML( )
	{
		Todo todo = todoDao.find ( id, "Todo.default" );
		if ( todo == null )
			throw new RuntimeException ( "Get: Todo with " + id + " not found" );
		return todo;
	}

	@PUT
	@Consumes( MediaType.APPLICATION_XML )
	public Response putTodo( JAXBElement<Todo> todo )
	{
		Todo c = todo.getValue ( );
		return putAndGetResponse ( c );
	}

	@DELETE
	public void deleteTodo( )
	{
		Todo todo = todoDao.find ( id, "Todo.default" );
		
		if(todo == null)
	      throw new RuntimeException("Delete: Todo with " + id +  " not found");
		
		todoDao.delete ( id );
	}
	
	private Response putAndGetResponse( Todo todo )
	{
		Response res;
		
		if ( todoDao.contains ( todo.getId ( ) ) )
		{
			res = Response.noContent ( ).build ( );
		}
		else
		{
			res = Response.created ( uriInfo.getAbsolutePath ( ) ).build ( );
		}
		
		todoDao.create ( todo );
		
		return res;
	}
}
