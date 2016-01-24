
package com.rtmdn.exam.wsd.todo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.rtmdn.jpa.dao.Persistent;

@XmlRootElement( name = "todo", namespace="http://localhost:8080/test/schema/todos" )
@XmlType( name="", propOrder={"id", "summary", "description"} )
@Entity
@javax.persistence.NamedEntityGraphs( value = { 
	@NamedEntityGraph( name = "Todo.default", includeAllAttributes = true ) 
} )
public class Todo extends Persistent
{
	@Id
	@XmlAttribute
	private Long id;

	@XmlElement
	private String summary;

	@XmlElement
	private String description;

	public Todo ( )
	{

	}

	public Todo ( Long id, String summary, String description )
	{
		this.id = id;
		this.summary = summary;
		this.description = description;
	}

	public Long getId( )
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getSummary( )
	{
		return summary;
	}

	public void setSummary( String summary )
	{
		this.summary = summary;
	}

	public String getDescription( )
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}
}
