
package com.rtmdn.exam.wsd.contactmethod;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.rtmdn.exam.wsd.contactmethod.adapter.ContactMethodAdapter;

@XmlType
@XmlJavaTypeAdapter( ContactMethodAdapter.class )
@XmlSeeAlso( value = { Address.class, Phone.class } )
public abstract class ContactMethod
{
	
}
