
package com.rtmdn.exam.wsd.contactmethod.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.rtmdn.exam.wsd.contactmethod.Address;
import com.rtmdn.exam.wsd.contactmethod.ContactMethod;

public class AddressContactMethodAdapter extends XmlAdapter<Address, ContactMethod>
{
	@Override
	public ContactMethod unmarshal( Address address ) throws Exception
	{
		return address;
	}

	@Override
	public Address marshal( ContactMethod contactMethod ) throws Exception
	{
		Address address = new Address( );
		
		return address;
	}
}
