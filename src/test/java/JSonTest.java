
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith( Arquillian.class )
public class JSonTest
{
	private Client client;
	
	@ArquillianResource
	private URL deploymentURL;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
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
	public void setup( ) throws MalformedURLException
	{
		System.out.println( "deploymentURL = " + deploymentURL );
		
		client = ClientBuilder.newClient ( );
	}
	
	@After
	public void after( )
	{
		client.close();
	}
	
	@Test
	@InSequence(1)
	public void testPost(  )
	{
		
	}
	
	@Test
	@InSequence(2)
   public void testEchoObject() throws MalformedURLException {
       JsonObject jsonObject = Json.createObjectBuilder()
           .add("apple", "red")
           .add("banana", "yellow")
           .build();

       WebTarget targetObject = client.target(URI.create(new URL(deploymentURL, "resources/object").toExternalForm()));
       JsonObject json = targetObject.request().post(Entity.entity(jsonObject, MediaType.APPLICATION_JSON), JsonObject.class);
       assertNotNull(json);
       assertFalse(json.isEmpty());
       assertTrue(json.containsKey("apple"));
       assertEquals("red", json.getString("apple"));
       assertTrue(json.containsKey("banana"));
       assertEquals("yellow", json.getString("banana"));
   }

   @Test
   @InSequence(3)
   public void testEchoArray() throws MalformedURLException {
       JsonArray jsonArray = Json.createArrayBuilder()
           .add(Json.createObjectBuilder()
               .add("apple", "red"))
           .add(Json.createObjectBuilder()
               .add("banana", "yellow"))
           .build();

       WebTarget targetArray = client.target(URI.create(new URL(deploymentURL, "resources/array").toExternalForm()));
       JsonArray json = targetArray.request().post(Entity.entity(jsonArray, MediaType.APPLICATION_JSON), JsonArray.class);
       assertNotNull(json);
       assertEquals(2, json.size());
       assertTrue(json.getJsonObject(0).containsKey("apple"));
       assertEquals("red", json.getJsonObject(0).getString("apple"));
       assertTrue(json.getJsonObject(1).containsKey("banana"));
       assertEquals("yellow", json.getJsonObject(1).getString("banana"));
   }
}
