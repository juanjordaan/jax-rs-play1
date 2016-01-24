
package com.rtmdn.exam.wsd.cubearticle;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class ComponentScan
{
	@XmlAttribute( name = "base-package" )
	private String basePackage;
	
	public String getBasePackage( )
	{
		return basePackage;
	}
	
	public void setBasePackage( String basePackage )
	{
		this.basePackage = basePackage;
	}
}
