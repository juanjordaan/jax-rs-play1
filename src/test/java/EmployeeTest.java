import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

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
import org.xml.sax.SAXException;

import com.rtmdn.exam.wsd._model.employee.Address;
import com.rtmdn.exam.wsd._model.employee.Department;
import com.rtmdn.exam.wsd._model.employee.Employee;
import com.rtmdn.exam.wsd._model.employee.Phone;
import com.rtmdn.exam.wsd._model.employee.PhoneType;
import com.rtmdn.exam.wsd._model.project.DesignProject;
import com.rtmdn.exam.wsd._model.project.Project;
import com.rtmdn.exam.wsd._model.project.QualityProject;
import com.rtmdn.jpa.dao.Persistent;

@RunWith( Arquillian.class )
public class EmployeeTest
{
	@ArquillianResource
	private URL deploymentURL;

	JAXBContext jc;
	Marshaller writer;
	Unmarshaller reader;

	Class<?>[] jaxbClasses = new Class<?>[] { 
		Address.class, Department.class, Employee.class, Phone.class, PhoneType.class, DesignProject.class, Project.class, QualityProject.class, Persistent.class };

	String persistentXsdFilePath = "D:/dev/exams/1Z0-897/custom/wf/parent/rest/jaxrs/jaxrs-template1/src/test/resources/schema/Persistent.xsd";
	String projectXsdFilePath = "Project.xsd";
	String employeeXsdFilePath = "Employee.xsd";
	
	String persistentXsdPath = "schema/Persistent.xsd";
	String projectXsdPath = "schema/Project.xsd";
	String employeeXsdPath = "schema/Employee.xsd";

	URL persistentXsdUrl;
	URL projectXsdUrl;
	URL employeeXsdUrl;
	
	String schemasDir = "D:/dev/exams/1Z0-897/custom/wf/parent/rest/jaxrs/jaxrs-template1/jaxb_tests/employee";
	
	/*Schema persistentSchema;
	Schema projectSchema;
	Schema employeeSchema;*/

	@Deployment( testable = false )
	public static WebArchive createDeployment( )
	{
		WebArchive war = ShrinkWrap.create( WebArchive.class, "test.war" );
		war.addPackages( true, "com.rtmdn.jpa" );
		war.addPackages( true, "com.rtmdn.exam.wsd" );

		war.addAsResource( "META-INF/beans.xml", "META-INF/beans.xml" );
		war.addAsResource( "META-INF/test-persistence.xml", "META-INF/persistence.xml" );
		war.addAsResource( "META-INF/drop.ddl", "META-INF/drop.ddl" );
		war.addAsResource( "META-INF/create.ddl", "META-INF/create.ddl" );
		war.addAsResource( "META-INF/load.ddl", "META-INF/load.ddl" );

		war.addAsWebInfResource( "jbossas-ds.xml", "jbossas-ds.xml" );

		war.addAsWebInfResource( "hornetq-jms.xml", "hornetq-jms.xml" );

		war.addAsWebResource( "schema/Persistent.xsd", "schema/Persistent.xsd" );
		war.addAsWebResource( "schema/Employee.xsd", "schema/Employee.xsd" );
		war.addAsWebResource( "schema/Project.xsd", "schema/Project.xsd" );
		
		war.addAsResource( "schema/Persistent.xsd", "Persistent.xsd" );
		war.addAsResource( "schema/Employee.xsd", "Employee.xsd" );
		war.addAsResource( "schema/Project.xsd", "Project.xsd" );

		war.addAsLibraries( Maven.resolver( ).loadPomFromFile( "pom.xml" ).resolve( "org.codehaus.jackson:jackson-mapper-asl" ).withoutTransitivity( ).asSingleFile( ) );

		System.out.println( war.toString( true ) );

		return war;
	}

	@Before
	public void setup( ) throws URISyntaxException, JAXBException, IOException
	{
		System.out.println( "deploymentURL = " + deploymentURL );
		
		persistentXsdUrl = new URL( deploymentURL.toExternalForm( ) + persistentXsdPath );
		projectXsdUrl = new URL( deploymentURL.toExternalForm( ) + projectXsdPath );
		employeeXsdUrl = new URL( deploymentURL.toExternalForm( ) + employeeXsdPath );
		
		System.out.println( "persistentXsdUrl = " + persistentXsdUrl.toExternalForm( ) );
		System.out.println( "projectXsdUrl = " + projectXsdUrl.toExternalForm( ) );
		System.out.println( "employeeXsdUrl = " + employeeXsdUrl.toExternalForm( ) );
		
		persistentXsdUrl.openConnection( );
		projectXsdUrl.openConnection( );
		employeeXsdUrl.openConnection( );
		
		jc = JAXBContext.newInstance( jaxbClasses );
		
		writer = jc.createMarshaller( );
		reader = jc.createUnmarshaller( );
	}
	
	@After
	public void after( )
	{
		
	}
	
	/*@Test
	@InSequence( 1 )
	public void test1( ) throws Exception
	{
		File outputDirectory = new File( schemasDir );
		
		// Setup schema compiler
		SchemaCompiler sc = XJC.createSchemaCompiler( );
		//sc.forcePackageName("com.xyz.schema");
		
		// Setup SAX InputSource
		//File schemaFile = new File( schemasDir+"/employee.xsd" );
		//InputSource is = new InputSource( schemaFile.toURI( ).toString( ) );
		//InputSource is = new InputSource( employeeXsdUrl.openStream( ) );
		InputSource is = new InputSource( new FileReader( persistentXsdFilePath ) );
		
		// Parse & build
		sc.parseSchema( is );
		S2JJAXBModel model = sc.bind( );
		JCodeModel jCodeModel = model.generateCode( null, null );
		jCodeModel.build( outputDirectory );
	}*/
	
	@Test
	@InSequence( 2 )
	public void test2( ) throws Exception
	{
		//Schema schema = getSchema ( new URL("http://www.w3.org/2001/XMLSchema.xsd") );
		Schema employeeSchema = getSchema( employeeXsdUrl );
		
		Department department = new Department( "Dept 1" );
		QualityProject project1 = new QualityProject( "QP1", new Integer( 31 ) );
		DesignProject project2 = new DesignProject( "DP1" );
		
		Address address = new Address( "001 Some Street", "Some City", "Some State", "0007" );
		Phone phone = new Phone( "0827064221", PhoneType.Cell );
		
		Employee employee = new Employee( "Juan Jordaan", new Date( ), 3012.00, new byte[]{}, address, department, null );
		employee.addPhone( phone );
		employee.addProject( project1 );
		employee.addProject( project2 );
		
		writer.setSchema( employeeSchema );
		writer.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		
		writer.marshal( address, System.out );
		
		writer.marshal( employee, System.out );
	}
	
	private Schema getSchema( URL url ) throws MalformedURLException, SAXException
	{
		SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
		Schema schema = schemaFactory.newSchema( url );

		return schema;
	}
}
