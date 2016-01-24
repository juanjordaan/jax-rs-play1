import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.rtmdn.exam.wsd.todo.Todo;

@RunWith( Arquillian.class )
public class TodoTest
{
	private Client client;
	
	@ArquillianResource
	private URL deploymentURL;
	
	@Deployment( testable = false )
	public static WebArchive createDeployment( )
	{
		WebArchive war = ShrinkWrap.create ( WebArchive.class, "test.war" );
		war.addPackages ( true, "com.rtmdn.jpa" );
		war.addPackages ( true, "com.rtmdn.exam.wsd" );
		
		war.addAsResource ( "META-INF/beans.xml", "META-INF/beans.xml" );
		war.addAsResource ( "META-INF/test-persistence.xml", "META-INF/persistence.xml" );
		war.addAsResource ( "META-INF/drop.ddl", "META-INF/drop.ddl" );
		war.addAsResource ( "META-INF/create.ddl", "META-INF/create.ddl" );
		war.addAsResource ( "META-INF/load.ddl", "META-INF/load.ddl" );
		
		war.addAsWebInfResource ( "jbossas-ds.xml", "jbossas-ds.xml" );
		
		war.addAsWebInfResource ( "hornetq-jms.xml", "hornetq-jms.xml" );
		
		war.addAsLibraries ( Maven.resolver ( ).loadPomFromFile ( "pom.xml" ).resolve ( "org.codehaus.jackson:jackson-mapper-asl" ).withoutTransitivity ( ).asSingleFile ( ) );
		
		System.out.println ( war.toString ( true ) );
		
		return war;
	}
	
	@Before
	public void setup( ) throws MalformedURLException, URISyntaxException
	{
		System.out.println( "deploymentURL = " + deploymentURL );
		
		client = ClientBuilder.newClient ( );
	}
	
	@After
	public void after( )
	{
		client.close ( );
	}

	@Test
	@InSequence( 1 )
	public void test1( ) throws Exception
	{
		Todo todo = new Todo ( 1L, "blah blah", "Initial Test" );
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		Response response = target.path ( "resources" ).path ( "todos" ).path ( todo.getId ( ).toString ( ) ).request ( MediaType.APPLICATION_XML )
			.put ( Entity.entity ( todo, MediaType.APPLICATION_XML ), Response.class );
		
		// Return code should be 201 == created resource
		System.out.println ( response.getStatus ( ) );
	}
	
	@Test
	@InSequence( 2 )
	public void test2( ) throws Exception
	{
		// Get the Todos
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		System.out.println ( target.path ( "resources" ).path ( "todos" ).request ( ).accept ( MediaType.TEXT_XML ).get ( String.class ) );
	}
	
	@Test
	@InSequence( 3 )
	public void test3( ) throws Exception
	{
		// // Get JSON for application
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		System.out.println( target.path("resources").path("todos").request().accept( MediaType.APPLICATION_JSON ).get( String.class ) );
	}
	
	@Test
	@InSequence( 4 )
	public void test4( ) throws Exception
	{
		// Get XML for application
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		System.out.println ( target.path ( "resources" ).path ( "todos" ).request ( ).accept ( MediaType.APPLICATION_XML ).get ( String.class ) );
	}
	
	@Test
	@InSequence( 5 )
	public void test5( ) throws Exception
	{
		// Get Todo with id 1
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		Response checkDelete = target.path ( "resources" ).path ( "todos/1" ).request ( ).accept ( MediaType.APPLICATION_XML ).get ( );
		
		System.out.println ( "checkDelete.getStatus ( ) = " + checkDelete.getStatus ( ) );
	}
	
	@Test
	@InSequence( 6 )
	public void test6( ) throws Exception
	{
		// Delete Todo with id 1
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		target.path ( "resources" ).path ( "todos/1" ).request ( ).delete ( );
	}
	
	@Test
	@InSequence( 7 )
	public void test7( ) throws Exception
	{
		// Get get all Todos id 1 should be deleted
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		System.out.println ( target.path ( "resources" ).path ( "todos" ).request ( ).accept ( MediaType.APPLICATION_XML ).get ( String.class ) );
	}
	
	@Test
	@InSequence( 8 )
	public void test8( ) throws Exception
	{
		// Create a Todo
		Form form = new Form ( );
		form.param ( "id", "4" );
		form.param ( "summary", "Demonstration of the client lib for forms" );
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		Response response = target.path ( "resources" ).path ( "todos" ).request ( ).post ( Entity.entity ( form, MediaType.APPLICATION_FORM_URLENCODED ), Response.class );
		System.out.println ( "Form response " + response.getStatus ( ) );
	}
	
	@Test
	@InSequence( 9 )
	public void test9( ) throws Exception
	{
		// Get all the todos, id 4 should have been created
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		System.out.println ( target.path ( "resources" ).path ( "todos" ).request ( ).accept ( MediaType.APPLICATION_XML ).get ( String.class ) );
	}
	
	/*@Test
	@InSequence( 10 )
	public void test10( ) throws Exception
	{
		System.out.println( "\n --- testGetPlain1( )" );
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		String answer = target.path ( "resources" ).path ( "todos" ).request ( ).accept ( MediaType.TEXT_PLAIN ).get ( Response.class ).toString ( );
		System.out.println ( answer );
	}*/
}
