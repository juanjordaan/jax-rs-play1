package com.rtmdn.exam.wsd._dao;

import javax.ejb.Local;

import com.rtmdn.exam.wsd._model.project.QualityProject;
import com.rtmdn.jpa.dao.Dao;

@Local
public interface QualityProjectDao extends Dao<Long, QualityProject>
{

}
