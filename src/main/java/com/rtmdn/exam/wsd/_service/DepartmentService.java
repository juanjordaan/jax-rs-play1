
package com.rtmdn.exam.wsd._service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.rtmdn.exam.wsd._dao.DepartmentDao;
import com.rtmdn.exam.wsd._model.employee.Department;

@Stateless
public class DepartmentService
{
	@EJB
	private DepartmentDao departmentDao;
	
	public Department createDepartment( Department department )
	{
		return departmentDao.create(department);
	}
	
	public Department getDepartment( Long id )
	{
		return departmentDao.find(id, "Department.default" );
	}
	
	public Collection<Department> getDepartments( )
	{
		return departmentDao.list( "Department.default" );
	}
	
	public Department updateDepartment( Department department )
	{
		return departmentDao.update(department);
	}
	
	public void deleteDepartment( Department department )
	{
		departmentDao.delete(department);
	}
}
