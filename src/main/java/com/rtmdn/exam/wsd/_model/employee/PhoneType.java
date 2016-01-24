
package com.rtmdn.exam.wsd._model.employee;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="phoneType-type" )
@XmlEnum( String.class )
public enum PhoneType
{
	@XmlEnumValue( "Cell" ) Cell, 
	@XmlEnumValue( "Home" ) Home, 
	@XmlEnumValue( "Work" ) Work;
}
