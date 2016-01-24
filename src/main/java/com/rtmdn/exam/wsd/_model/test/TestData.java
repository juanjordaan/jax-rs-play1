package com.rtmdn.exam.wsd._model.test;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.rtmdn.exam.wsd._model.employee.Address;
import com.rtmdn.exam.wsd._model.employee.Department;
import com.rtmdn.exam.wsd._model.employee.Employee;
import com.rtmdn.exam.wsd._model.employee.Phone;
import com.rtmdn.exam.wsd._model.employee.PhoneType;
import com.rtmdn.exam.wsd._model.project.DesignProject;
import com.rtmdn.exam.wsd._model.project.QualityProject;
import com.rtmdn.exam.wsd._service.AddressService;
import com.rtmdn.exam.wsd._service.DepartmentService;
import com.rtmdn.exam.wsd._service.DesignProjectService;
import com.rtmdn.exam.wsd._service.EmployeeService;
import com.rtmdn.exam.wsd._service.PhoneService;
import com.rtmdn.exam.wsd._service.ProjectService;
import com.rtmdn.exam.wsd._service.QualityProjectService;

@Singleton
@Startup
public class TestData
{
	@EJB
	private AddressService addressService;
	
	@EJB
	private DepartmentService departmentService;
	
	@EJB
	private DesignProjectService designProjectService;
	
	@EJB
	private EmployeeService employeeService;
	
	@EJB
	private PhoneService phoneService;
	
	@EJB
	private ProjectService projectService;
	
	@EJB
	private QualityProjectService qualityProjectService;
	
	@PostConstruct
	protected void postConstruct( )
	{
		loadData( );
	}
	
	@PreDestroy
	protected void preDestroy( )
	{
		purgeData( );
	}
	
	private void loadData( )
	{
		Department department = departmentService.createDepartment ( new Department( "Dept 1" ) );
		QualityProject project1 = qualityProjectService.createQualityProject ( new QualityProject( "QP1", new Integer( 31 ) ) );
		DesignProject project2 = designProjectService.createDesignProject ( new DesignProject( "DP1" ) );
		
		Address address = new Address( "001 Some Street", "Some City", "Some State", "0007" );
		Phone phone = new Phone( "0827064221", PhoneType.Cell );
		
		Employee employee = new Employee( "Juan Jordaan", new Date( ), 3012.00, new byte[]{}, address, department, null );
		employee.addPhone( phone );
		employee.addProject( project1 );
		employee.addProject( project2 );
		
		employeeService.createEmployee ( employee );
	}
	
	private void purgeData( )
	{
		
	}
}
