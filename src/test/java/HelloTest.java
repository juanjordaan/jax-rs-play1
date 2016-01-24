
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
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

@RunWith( Arquillian.class )
public class HelloTest
{
	private Client client;

	@ArquillianResource
	private URL deploymentURL;
	
	/*@Rule
	public ExpectedException expectedException = ExpectedException.none ( );*/

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
	public void testGetPlain1( ) throws URISyntaxException
	{
		System.out.println( "\n --- testGetPlain1( )" );
		
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		String answer = target.path ( "resources" ).path ( "hello" ).request ( ).accept ( MediaType.TEXT_PLAIN ).get ( Response.class ).toString ( );
		
		System.out.println ( answer );
	}
	
	@Test
	@InSequence( 2 )
	public void testGetPlain2( ) throws URISyntaxException
	{
		System.out.println( "\n --- testGetPlain2( )" );
		
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		String answer = target.path ( "resources" ).path ( "hello" ).request ( ).accept ( MediaType.TEXT_PLAIN ).get ( String.class );
		
		System.out.println ( answer );
	}
	
	@Test
	@InSequence( 3 )
	public void testGetTextXml( ) throws URISyntaxException
	{
		System.out.println( "\n --- testGetTextXml( )" );
		
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		String answer = target.path ( "resources" ).path ( "hello" ).request ( ).accept ( MediaType.TEXT_XML ).get ( String.class );
		
		System.out.println ( answer );
	}
	
	@Test
	@InSequence( 4 )
	public void testGetTextHtml( ) throws URISyntaxException
	{
		System.out.println( "\n --- testGetTextHtml( )" );
		
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		String answer = target.path ( "resources" ).path ( "hello" ).request ( ).accept ( MediaType.TEXT_HTML ).get ( String.class );
		
		System.out.println ( answer );
	}
	
	@Test
	@InSequence( 5 )
	public void testGetJson1( ) throws URISyntaxException
	{
		System.out.println( "\n --- testGetJson1( )" );
		
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		String answer = target.path ( "resources" ).path ( "hello" ).request ( ).accept ( MediaType.APPLICATION_JSON ).get ( String.class );
		
		System.out.println ( answer );
	}
	
	@Test
	@InSequence( 6 )
	public void testGetJson2( ) throws URISyntaxException
	{
		System.out.println( "\n --- testGetJson2( )" );
		
		WebTarget target = client.target ( deploymentURL.toURI ( ) );
		JsonObject answer = target.path ( "resources" ).path ( "hello" ).request ( ).accept ( MediaType.APPLICATION_JSON ).get ( JsonObject.class );
		assertNotNull(answer);
		assertFalse(answer.isEmpty());
      
		for( Map.Entry<String, JsonValue> entry : answer.entrySet ( ) )
			System.out.println ( entry.getKey ( ) + " = " + entry.getValue ( ) );
	}
}
