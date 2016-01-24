package com.rtmdn.exam.wsd._dao;

import javax.ejb.Local;

import com.rtmdn.exam.wsd._model.project.Project;
import com.rtmdn.jpa.dao.Dao;

@Local
public interface ProjectDao extends Dao<Long, Project>
{

}
