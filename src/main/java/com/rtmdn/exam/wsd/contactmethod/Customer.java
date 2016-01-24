package com.rtmdn.exam.wsd.contactmethod;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="customer"/*,namespace="http://localhost:8080/test/schema/inherittest"*/)
@XmlType(name="")
public class Customer
{
	@XmlElement(name="contact-method")
   private List<ContactMethod> contactMethods;

	public List<ContactMethod> getContactMethods( )
	{
		return contactMethods;
	}

	public void setContactMethods( List<ContactMethod> contactMethods )
	{
		this.contactMethods = contactMethods;
	}
}
