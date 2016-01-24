
package com.rtmdn.exam.wsd._facade;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.rtmdn.exam.wsd._facade.exception.ConstraintViolationApplicationExceptionMapper;
import com.rtmdn.exam.wsd._facade.exception.CriticalApplicationExceptionMapper;
import com.rtmdn.exam.wsd._facade.filter.ClientLoggingFilter;
import com.rtmdn.exam.wsd._facade.filter.ContainerLoggingFilter;
import com.rtmdn.exam.wsd._facade.filter.DynamicServerLoggingFilterFeature;
import com.rtmdn.exam.wsd._model.employee.Address;
import com.rtmdn.exam.wsd._model.employee.Department;
import com.rtmdn.exam.wsd._model.employee.Employee;
import com.rtmdn.exam.wsd._model.employee.Phone;
import com.rtmdn.exam.wsd._model.project.DesignProject;
import com.rtmdn.exam.wsd._model.project.Project;
import com.rtmdn.exam.wsd._model.project.QualityProject;
import com.rtmdn.exam.wsd.hello.Hello;
import com.rtmdn.exam.wsd.hello.Message;
import com.rtmdn.exam.wsd.hello.MessageResource;
import com.rtmdn.exam.wsd.jsonp.MyArrayResource;
import com.rtmdn.exam.wsd.jsonp.MyObjectResource;
import com.rtmdn.exam.wsd.todo.Todo;
import com.rtmdn.exam.wsd.todo.TodoResource;
import com.rtmdn.exam.wsd.todo.TodosResource;

@ApplicationPath( "resources" )
public class _Application extends Application
{
	Set<Class<?>> classes = new HashSet<Class<?>> ( );
	
	public Set<Class<?>> getClasses( )
	{
		classes.add ( DynamicServerLoggingFilterFeature.class );
		classes.add ( ContainerLoggingFilter.class );
		classes.add ( ClientLoggingFilter.class );
		classes.add ( ConstraintViolationApplicationExceptionMapper.class );
		classes.add ( CriticalApplicationExceptionMapper.class );

		classes.add ( Hello.class );
		classes.add ( MyObjectResource.class );
		classes.add ( MyArrayResource.class );

		classes.add ( Todo.class );
		classes.add ( TodoResource.class );
		classes.add ( TodosResource.class );

		classes.add ( AddressResource.class );
		classes.add ( DepartmentResource.class );
		classes.add ( DesignProjectResource.class );
		classes.add ( EmployeeResource.class );
		classes.add ( PhoneResource.class );
		classes.add ( ProjectResource.class );
		classes.add ( QualityProjectResource.class );

		classes.add ( Address.class );
		classes.add ( Department.class );
		classes.add ( DesignProject.class );
		classes.add ( Employee.class );
		classes.add ( Phone.class );
		classes.add ( Project.class );
		classes.add ( QualityProject.class );
		
		classes.add ( Message.class );
		classes.add ( MessageResource.class );

		return classes;
	}
}
