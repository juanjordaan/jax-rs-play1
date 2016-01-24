
package com.rtmdn.exam.wsd._dao.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SynchronizationType;

import com.rtmdn.exam.wsd._dao.ProjectDao;
import com.rtmdn.exam.wsd._model.project.Project;
import com.rtmdn.jpa.dao.AbstractDao;

@Stateless
public class ProjectDaoImpl extends AbstractDao<Long, Project> implements ProjectDao
{
	@PersistenceContext( unitName="wsur2TestPU", synchronization = SynchronizationType.SYNCHRONIZED, type = PersistenceContextType.TRANSACTION )
	private EntityManager entityManager;
	
	public ProjectDaoImpl ( )
	{
		super ( );
	}
	
	@PostConstruct
	protected void postConstruct( )
	{
		super.setEntityManager ( entityManager );
	}
}
