
package com.rtmdn.exam.wsd._service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.rtmdn.exam.wsd._dao.EmployeeDao;
import com.rtmdn.exam.wsd._model.employee.Employee;

@Stateless
public class EmployeeService
{
	@EJB
	private EmployeeDao employeeDao;
	
	public Employee createEmployee( Employee employee )
	{
		return employeeDao.create(employee);
	}
	
	public Employee getEmployee( Long id )
	{
		return employeeDao.find(id, "Employee.default" );
	}
	
	public Collection<Employee> getEmployees( )
	{
		return employeeDao.list( "Employee.default" );
	}
	
	public Employee updateEmployee( Employee employee )
	{
		return employeeDao.update(employee);
	}
	
	public void deleteEmployee( Employee employee )
	{
		employeeDao.delete(employee);
	}
}
