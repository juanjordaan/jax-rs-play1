
package com.rtmdn.exam.wsd._dao.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SynchronizationType;

import com.rtmdn.exam.wsd._dao.DepartmentDao;
import com.rtmdn.exam.wsd._model.employee.Department;
import com.rtmdn.jpa.dao.AbstractDao;

@Stateless
public class DepartmentDaoImpl extends AbstractDao<Long, Department> implements DepartmentDao
{
	@PersistenceContext( unitName="wsur2TestPU", synchronization = SynchronizationType.SYNCHRONIZED, type = PersistenceContextType.TRANSACTION )
	private EntityManager entityManager;
	
	public DepartmentDaoImpl ( )
	{
		super ( );
	}
	
	@PostConstruct
	protected void postConstruct( )
	{
		super.setEntityManager ( entityManager );
	}
}
