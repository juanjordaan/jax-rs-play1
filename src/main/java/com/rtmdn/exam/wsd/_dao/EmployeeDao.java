package com.rtmdn.exam.wsd._dao;

import javax.ejb.Local;

import com.rtmdn.exam.wsd._model.employee.Employee;
import com.rtmdn.jpa.dao.Dao;

@Local
public interface EmployeeDao extends Dao<Long, Employee>
{

}
