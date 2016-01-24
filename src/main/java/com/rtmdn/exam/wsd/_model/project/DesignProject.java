
package com.rtmdn.exam.wsd._model.project;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="design-project")
@XmlType(name="design-project-type")
@Entity
@NamedEntityGraphs(value={
	@NamedEntityGraph(name="DesignProject.default", includeAllAttributes=true )
})
@DiscriminatorValue( "DP" )
public class DesignProject extends Project
{
	public DesignProject ( )
	{
		super();
	}
	
	public DesignProject ( String name )
	{
		super ( name );
	}
}
