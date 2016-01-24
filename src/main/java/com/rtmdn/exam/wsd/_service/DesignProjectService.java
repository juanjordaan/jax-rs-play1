
package com.rtmdn.exam.wsd._service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.rtmdn.exam.wsd._dao.DesignProjectDao;
import com.rtmdn.exam.wsd._model.project.DesignProject;

@Stateless
public class DesignProjectService
{
	@EJB
	private DesignProjectDao designProjectDao;
	
	public DesignProject createDesignProject( DesignProject designProject )
	{
		return designProjectDao.create(designProject);
	}
	
	public DesignProject getDesignProject( Long id )
	{
		return designProjectDao.find(id, "DesignProject.default" );
	}
	
	public Collection<DesignProject> getDesignProjects( )
	{
		return designProjectDao.list( "DesignProject.default" );
	}
	
	public DesignProject updateDesignProject( DesignProject designProject )
	{
		return designProjectDao.update(designProject);
	}
	
	public void deleteDesignProject( DesignProject designProject )
	{
		designProjectDao.delete(designProject);
	}
}
