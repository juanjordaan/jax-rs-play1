package com.rtmdn.exam.wsd._dao;

import javax.ejb.Local;

import com.rtmdn.exam.wsd._model.project.DesignProject;
import com.rtmdn.jpa.dao.Dao;

@Local
public interface DesignProjectDao extends Dao<Long, DesignProject>
{
	
}
