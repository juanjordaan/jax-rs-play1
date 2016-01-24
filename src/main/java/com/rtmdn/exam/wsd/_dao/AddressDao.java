package com.rtmdn.exam.wsd._dao;

import javax.ejb.Local;

import com.rtmdn.exam.wsd._model.employee.Address;
import com.rtmdn.jpa.dao.Dao;

@Local
public interface AddressDao extends Dao<Long, Address>
{
	
}
