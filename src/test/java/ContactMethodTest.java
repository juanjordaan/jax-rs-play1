import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.rtmdn.exam.wsd.contactmethod.ContactMethod;
import com.rtmdn.exam.wsd.contactmethod.Customer;

@RunWith( Arquillian.class )
public class ContactMethodTest
{
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
	
	@Test
	public void test1 ( ) throws Exception
	{
		JAXBContext jc = JAXBContext.newInstance( Customer.class );
		
		Customer customer = null;
		
		Unmarshaller reader = jc.createUnmarshaller( );
		//File xml = new File( "jaxb_tests/contactmethod/input.xml" );
		
		StringReader sr = new StringReader( 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
			"<customer>" + 
				"<contact-method number=\"555-1111\"/>" +
				"<contact-method street=\"1 A St\" city = \"Any Town\"/>" + 
				"<contact-method number=\"555-2222\"/>" +
			"</customer>" );
		customer = (Customer) reader.unmarshal( sr );
		
		for ( ContactMethod contactMethod : customer.getContactMethods( ) )
		{
			System.out.println( contactMethod.getClass( ) );
		}
		
		Marshaller writer = jc.createMarshaller( );
		writer.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		writer.marshal( customer, System.out );
	}
	
	/*static Schema getSchema( String schemaResourceName ) throws SAXException
	{
		SchemaFactory sf = SchemaFactory.newInstance ( javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI );
		
		try
		{
			return sf.newSchema ( ContactMethodTest.class.getResource ( schemaResourceName ) );
		}
		catch ( SAXException se )
		{
			// this can only happen if there's a deployment error and the resource is missing.
			throw se;
		}
	}*/
}
