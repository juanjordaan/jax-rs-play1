package com.rtmdn.exam.wsd._dao;

import javax.ejb.Local;

import com.rtmdn.exam.wsd._model.employee.Phone;
import com.rtmdn.jpa.dao.Dao;

@Local
public interface PhoneDao extends Dao<Long, Phone>
{

}
