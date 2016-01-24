
package com.rtmdn.exam.wsd.cubearticle;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder = { "id", "className" } )
// Defines the order in which the attributes appear
public class Bean
{
	@XmlAttribute
	private String id;
	
	@XmlAttribute( name = "class" )
	private String className;
	
	public String getId( )
	{
		return id;
	}
	
	public void setId( String id )
	{
		this.id = id;
	}
	
	public String getClassName( )
	{
		return className;
	}
	
	public void setClassName( String className )
	{
		this.className = className;
	}
}
