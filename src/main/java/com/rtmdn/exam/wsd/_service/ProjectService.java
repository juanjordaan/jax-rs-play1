
package com.rtmdn.exam.wsd._service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.rtmdn.exam.wsd._dao.ProjectDao;
import com.rtmdn.exam.wsd._model.project.Project;

@Stateless
public class ProjectService
{
	@EJB
	private ProjectDao projectDao;
	
	public Project createProject( Project project )
	{
		return projectDao.create(project);
	}
	
	public Project getProject( Long id )
	{
		return projectDao.find(id, "Project.default" );
	}
	
	public Collection<Project> getProjects( )
	{
		return projectDao.list( "Project.default" );
	}
	
	public Project updateProject( Project project )
	{
		return projectDao.update(project);
	}
	
	public void deleteProject( Project project )
	{
		projectDao.delete(project);
	}
}
