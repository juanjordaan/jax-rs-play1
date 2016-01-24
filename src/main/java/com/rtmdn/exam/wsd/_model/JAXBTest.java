
package com.rtmdn.exam.wsd._model;

import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.rtmdn.exam.wsd._model.employee.Address;
import com.rtmdn.exam.wsd._model.employee.Department;
import com.rtmdn.exam.wsd._model.employee.Employee;
import com.rtmdn.exam.wsd._model.employee.Phone;
import com.rtmdn.exam.wsd._model.employee.PhoneType;
import com.rtmdn.exam.wsd._model.project.DesignProject;
import com.rtmdn.exam.wsd._model.project.Project;
import com.rtmdn.exam.wsd._model.project.QualityProject;

public class JAXBTest
{
	private static final Class<?>[] jaxbClasses = new Class<?>[] { 
		Address.class, Department.class, DesignProject.class, Employee.class, Phone.class, PhoneType.class, Project.class, QualityProject.class
	};
	
	public static void main( String[] args ) throws Exception
	{
		JAXBContext jc = JAXBContext.newInstance ( jaxbClasses );
		Department department = new Department( "Dept 1" );
		QualityProject project1 = new QualityProject( "QP1", new Integer( 31 ) );
		DesignProject project2 = new DesignProject( "DP1" );
		
		Address address = new Address( "001 Some Street", "Some City", "Some State", "0007" );
		Phone phone = new Phone( "0827064221", PhoneType.Cell );
		
		Employee employee = new Employee( "Juan Jordaan", new Date( ), 3012.00, new byte[]{}, address, department, null );
		employee.addPhone( phone );
		employee.addProject( project1 );
		employee.addProject( project2 );
		
		Marshaller writer = jc.createMarshaller ( );
		writer.setProperty ( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		
		writer.marshal ( address, System.out );
		
		writer.marshal ( employee, System.out );
	}
}
