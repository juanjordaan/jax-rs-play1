
package com.rtmdn.exam.wsd.mapadapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType(propOrder={"key", "value"})
public class MyMapEntryType
{
	@XmlAttribute
	public Integer key;
	
	@XmlValue
	public String value;
}
