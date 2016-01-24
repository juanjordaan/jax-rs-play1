
package com.rtmdn.exam.wsd._model.employee;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.rtmdn.jpa.dao.Persistent;

@XmlRootElement( name="department" )
@XmlType( name="department-type", propOrder = { "id", "name" } )
@Entity
@NamedEntityGraphs( value = { @NamedEntityGraph( name = "Department.default", includeAllAttributes = true ) } )
public class Department extends Persistent
{
	@XmlAttribute( required = true )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@XmlAttribute( required = true )
	@NotNull
	private String name;
	
	@XmlTransient
	@OneToMany( mappedBy = "department", fetch = FetchType.LAZY )
	private Set<Employee> employees;
	
	public Department ( )
	{
		
	}
	
	public Department ( String name )
	{
		super ( );
		
		employees = new HashSet<Employee> ( );
		this.name = name;
	}

	public Long getId( )
	{
		return id;
	}

	public void setId( Long deptNo )
	{
		this.id = deptNo;
	}

	public String getName( )
	{
		return name;
	}

	public void setName( String deptName )
	{
		this.name = deptName;
	}

	public Set<Employee> getEmployees( )
	{
		return employees;
	}

	public void addEmployee( Employee employee )
	{
		this.employees.add ( employee );
	}

	public void setEmployees( Set<Employee> employees )
	{
		this.employees = employees;
	}

	public String toString( )
	{
		return "[Department no: " + getId ( ) + ", name: '" + getName ( ) + "']";
	}
}
