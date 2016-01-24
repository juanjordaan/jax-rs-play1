
package com.rtmdn.exam.wsd.cubearticle;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder = { "mapping", "location" } )
public class Resources
{
	@XmlAttribute
	private String mapping;
	
	@XmlAttribute
	private String location;
	
	public String getMapping( )
	{
		return mapping;
	}

	public void setMapping( String mapping )
	{
		this.mapping = mapping;
	}

	public String getLocation( )
	{
		return location;
	}

	public void setLocation( String location )
	{
		this.location = location;
	}
}
