
package com.rtmdn.exam.wsd.contactmethod;

import javax.xml.bind.annotation.XmlType;

//@XmlJavaTypeAdapter( AddressContactMethodAdapter.class )
@XmlType
public class Address extends ContactMethod
{
	private String street;

	private String city;

	public String getStreet( )
	{
		return street;
	}

	public void setStreet( String street )
	{
		this.street = street;
	}

	public String getCity( )
	{
		return city;
	}

	public void setCity( String city )
	{
		this.city = city;
	}
}
