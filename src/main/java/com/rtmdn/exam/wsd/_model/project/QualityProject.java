
package com.rtmdn.exam.wsd._model.project;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="quality-project")
@XmlType(name="quality-project-type")
@Entity
@NamedEntityGraphs(value={
	@NamedEntityGraph(name="QualityProject.default", includeAllAttributes=true )
})
@DiscriminatorValue( "QP" )
public class QualityProject extends Project
{
	@XmlElement(required=true, nillable=false)
	@Column( name="qa_rating" )
	@NotNull
	private Integer qaRating;
	
	public QualityProject ( )
	{
		super();
	}
	
	public QualityProject ( String name, Integer qaRating )
	{
		super ( name );
		
		this.qaRating = qaRating;
	}

	public Integer getQaRating( )
	{
		return qaRating;
	}
	
	public void setQaRating( Integer qaRating )
	{
		this.qaRating = qaRating;
	}
	
	public String toString( )
	{
		return super.toString ( ) + "[ rating: " + qaRating + "]";
	}
}
