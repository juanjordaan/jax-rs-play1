
package com.rtmdn.exam.wsd._dao.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.SynchronizationType;

import com.rtmdn.exam.wsd._dao.DesignProjectDao;
import com.rtmdn.exam.wsd._model.project.DesignProject;
import com.rtmdn.jpa.dao.AbstractDao;

@Stateless
public class DesignProjectDaoImpl extends AbstractDao<Long, DesignProject> implements DesignProjectDao
{
	@PersistenceContext( unitName="wsur2TestPU", synchronization = SynchronizationType.SYNCHRONIZED, type = PersistenceContextType.TRANSACTION )
	private EntityManager entityManager;
	
	public DesignProjectDaoImpl ( )
	{
		super ( );
	}
	
	@PostConstruct
	protected void postConstruct( )
	{
		super.setEntityManager ( entityManager );
	}
}
