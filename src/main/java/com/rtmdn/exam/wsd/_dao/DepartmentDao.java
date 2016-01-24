package com.rtmdn.exam.wsd._dao;

import javax.ejb.Local;

import com.rtmdn.exam.wsd._model.employee.Department;
import com.rtmdn.jpa.dao.Dao;

@Local
public interface DepartmentDao extends Dao<Long, Department>
{

}
