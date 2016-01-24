
package com.rtmdn.exam.wsd._service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.rtmdn.exam.wsd._dao.QualityProjectDao;
import com.rtmdn.exam.wsd._model.project.QualityProject;

@Stateless
public class QualityProjectService
{
	@EJB
	private QualityProjectDao qualityProjectDao;
	
	public QualityProject createQualityProject( QualityProject qualityProject )
	{
		return qualityProjectDao.create(qualityProject);
	}
	
	public QualityProject getQualityProject( Long id )
	{
		return qualityProjectDao.find(id, "QualityProject.default" );
	}
	
	public Collection<QualityProject> getQualityProjects( )
	{
		return qualityProjectDao.list( "QualityProject.default" );
	}
	
	public QualityProject updateQualityProject( QualityProject qualityProject )
	{
		return qualityProjectDao.update(qualityProject);
	}
	
	public void deleteQualityProject( QualityProject qualityProject )
	{
		qualityProjectDao.delete(qualityProject);
	}
}
