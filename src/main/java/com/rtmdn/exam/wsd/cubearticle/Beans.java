
package com.rtmdn.exam.wsd.cubearticle;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
//@XmlRootElement
public class Beans
{
	@XmlAttribute
	private Bean bean;
	
	@XmlElement( namespace = "http://www.springframework.org/schema/mvc" )
	private Resources resources;
	
	@XmlElement( name = "component-scan", namespace = "http://www.springframework.org/schema/context" )
	private ComponentScan componentScan;
	
	public Bean getBean( )
	{
		return bean;
	}
	
	public void setBean( Bean bean )
	{
		this.bean = bean;
	}
	
	public Resources getResources( )
	{
		return resources;
	}
	
	public void setResources( Resources resources )
	{
		this.resources = resources;
	}
	
	public ComponentScan getComponentScan( )
	{
		return componentScan;
	}
	
	public void setComponentScan( ComponentScan componentScan )
	{
		this.componentScan = componentScan;
	}
}
