package com.rtmdn.exam.wsd.contactmethod;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Phone extends ContactMethod
{
	private String number;

	public String getNumber( )
	{
		return number;
	}

	public void setNumber( String number )
	{
		this.number = number;
	}
}
