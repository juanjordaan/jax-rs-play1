
package com.rtmdn.exam.wsd.todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path( "/todos" )
@Stateless
public class TodosResource
{
	TodoDAOInterface todoDao;
	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	public TodosResource ( ) throws Exception
	{
		javax.naming.Context ctx = new InitialContext ( );
		todoDao = (TodoDAOInterface) ctx.lookup ( "java:module/TodoDao!com.rtmdn.exam.wsd.todo.TodoDAOInterface" );
	}
	
	// Return the list of todos to the user in the browser
	@GET
	@Produces( MediaType.TEXT_XML )
	public List<Todo> getTodosBrowser( )
	{
		List<Todo> todos = new ArrayList<Todo> ( );
		todos.addAll ( todoDao.list ( "Todo.default" ) );
		
		return todos;
	}
	
	// Return the list of todos for applications
	@GET
	@Produces( MediaType.APPLICATION_XML )
	public List<Todo> getTodos( )
	{
		List<Todo> todos = new ArrayList<Todo> ( );
		todos.addAll ( todoDao.list ( "Todo.default" ) );
		
		return todos;
	}
	
	// retuns the number of todos
	// Use http://localhost:8080/com.vogella.jersey.todo/rest/todos/count
	// to get the total number of records
	@GET
	@Path( "count" )
	@Produces( MediaType.TEXT_PLAIN )
	public String getCount( )
	{
		long count = todoDao.count ( );
		
		return String.valueOf ( count );
	}
	
	@POST
	@Produces( MediaType.TEXT_HTML )
	@Consumes( MediaType.APPLICATION_FORM_URLENCODED )
	public void newTodo( 
		@FormParam("id") Long id, 
		@FormParam( "summary" ) String summary, 
		@FormParam( "description" ) String description, 
		@Context HttpServletResponse servletResponse ) throws IOException
	{
		Todo todo = new Todo ( id, summary, description );
		
		todoDao.create ( todo );
		
		servletResponse.sendRedirect ( "../create_todo.html" );
	}
	
	// Defines that the next path parameter after todos is
	// treated as a parameter and passed to the TodoResources
	// Allows to type http://localhost:8080/com.vogella.jersey.todo/rest/todos/1
	// 1 will be treaded as parameter todo and passed to TodoResource
	@Path("{todo}") 
	public TodoResource getTodo(@PathParam("todo") Long id) throws Exception
	{ 
		return new TodoResource( uriInfo, request, id);
	}
}
