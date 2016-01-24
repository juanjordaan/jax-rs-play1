
package com.rtmdn.exam.wsd._service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.rtmdn.exam.wsd._dao.AddressDao;
import com.rtmdn.exam.wsd._model.employee.Address;

@Stateless
public class AddressService
{
	@EJB
	private AddressDao addressDao;
	
	public Address createAddress( Address address )
	{
		return addressDao.create(address);
	}
	
	public Address getAddress( Long id )
	{
		return addressDao.find(id, "Address.default" );
	}
	
	public Collection<Address> getAddresses( )
	{
		return addressDao.list( "Address.default" );
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Address updateAddress( Address address )
	{
		return addressDao.update(address);
	}
	
	public void deleteAddress( Address address )
	{
		addressDao.delete(address);
	}
}
