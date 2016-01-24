
package com.rtmdn.exam.wsd.contactmethod.adapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.rtmdn.exam.wsd.contactmethod.Address;
import com.rtmdn.exam.wsd.contactmethod.ContactMethod;
import com.rtmdn.exam.wsd.contactmethod.Phone;

public class ContactMethodAdapter extends XmlAdapter<ContactMethodAdapter.AdaptedContactMethod, ContactMethod>
{
	@Override
	public AdaptedContactMethod marshal( ContactMethod contactMethod ) throws Exception
	{
		if ( null == contactMethod )
		{
			return null;
		}

		AdaptedContactMethod adaptedContactMethod = new AdaptedContactMethod( );

		if ( contactMethod instanceof Address )
		{
			Address address = (Address) contactMethod;
			adaptedContactMethod.street = address.getStreet( );
			adaptedContactMethod.city = address.getCity( );
		}
		else
		{
			Phone phoneNumber = (Phone) contactMethod;
			adaptedContactMethod.number = phoneNumber.getNumber( );
		}
		
		return adaptedContactMethod;
	}

	@Override
	public ContactMethod unmarshal( AdaptedContactMethod adaptedContactMethod ) throws Exception
	{
		if ( null == adaptedContactMethod )
		{
			return null;
		}

		if ( null != adaptedContactMethod.number )
		{
			Phone phoneNumber = new Phone( );
			phoneNumber.setNumber( adaptedContactMethod.number );

			return phoneNumber;
		}
		else
		{
			Address address = new Address( );
			address.setStreet( adaptedContactMethod.street );
			address.setCity( adaptedContactMethod.city );
			
			return address;
		}
	}

	public static class AdaptedContactMethod
	{
		@XmlAttribute
		public String number;

		@XmlAttribute
		public String street;

		@XmlAttribute
		public String city;
	}
}
