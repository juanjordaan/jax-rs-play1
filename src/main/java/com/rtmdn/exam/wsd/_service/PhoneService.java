
package com.rtmdn.exam.wsd._service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.rtmdn.exam.wsd._dao.PhoneDao;
import com.rtmdn.exam.wsd._model.employee.Phone;

@Stateless
public class PhoneService
{
	@EJB
	private PhoneDao phoneDao;
	
	public Phone createPhone( Phone phone )
	{
		return phoneDao.create(phone);
	}
	
	public Phone getPhone( Long id )
	{
		return phoneDao.find(id, "Phone.default" );
	}
	
	public Collection<Phone> getPhones( )
	{
		return phoneDao.list( "Phone.default" );
	}
	
	public Phone updatePhone( Phone phone )
	{
		return phoneDao.update(phone);
	}
	
	public void deletePhone( Phone phone )
	{
		phoneDao.delete(phone);
	}
}
