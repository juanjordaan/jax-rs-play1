
package com.rtmdn.exam.wsd._dao.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SynchronizationType;

import com.rtmdn.exam.wsd._dao.EmployeeDao;
import com.rtmdn.exam.wsd._model.employee.Employee;
import com.rtmdn.jpa.dao.AbstractDao;

@Stateless
public class EmployeeDaoImpl extends AbstractDao<Long, Employee> implements EmployeeDao
{
	@PersistenceContext( unitName="wsur2TestPU", synchronization = SynchronizationType.SYNCHRONIZED, type = PersistenceContextType.TRANSACTION )
	private EntityManager entityManager;
	
	public EmployeeDaoImpl ( )
	{
		super ( );
	}
	
	@PostConstruct
	protected void postConstruct( )
	{
		super.setEntityManager ( entityManager );
	}
}
