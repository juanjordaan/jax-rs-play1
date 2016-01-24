
package com.rtmdn.exam.wsd._model.project;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.rtmdn.exam.wsd._model.employee.Employee;
import com.rtmdn.jpa.dao.Persistent;

//@XmlJavaTypeAdapter(ProjectAdapter.class)
@XmlSeeAlso( value = { QualityProject.class, DesignProject.class } )
@XmlType( name="project", propOrder = { "id", "name" } )
@Entity
@Inheritance
@DiscriminatorValue( "P" )
@NamedEntityGraphs( value = { @NamedEntityGraph( name = "Project.default", includeAllAttributes = true ) } )
public class Project extends Persistent
{
	@XmlAttribute
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	protected Long id;
	
	@XmlAttribute
	protected String name;
	
	@XmlTransient
	@ManyToMany
	@JoinTable(
		joinColumns={
			@JoinColumn(name="project_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="employee_id", referencedColumnName="id") }
		)
	protected Set<Employee> employees;
	
	public Project ( )
	{
		
	}

	public Project ( String name )
	{
		super( );
		
		employees = new HashSet<Employee> ( );
		
		this.name = name;
	}

	public Long getId( )
	{
		return id;
	}

	public void setId( Long projectNo )
	{
		this.id = projectNo;
	}

	public String getName( )
	{
		return name;
	}

	public void setName( String projectName )
	{
		this.name = projectName;
	}

	public Set<Employee> getEmployees( )
	{
		return employees;
	}

	public void addEmployee( Employee employee )
	{
		if ( !getEmployees( ).contains( employee ) )
		{
			getEmployees( ).add( employee );
		}

		if ( !employee.getProjects( ).contains( this ) )
		{
			employee.getProjects( ).add( this );
		}
	}

	public String toString( )
	{
		return "[" + getClass( ).getSimpleName( ) + " no: " + getId( ) + ", name: '" + getName( ) + "']";
	}
}
