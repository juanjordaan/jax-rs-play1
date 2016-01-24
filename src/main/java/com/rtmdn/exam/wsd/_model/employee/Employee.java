
package com.rtmdn.exam.wsd._model.employee;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.rtmdn.exam.wsd._model.project.DesignProject;
import com.rtmdn.exam.wsd._model.project.Project;
import com.rtmdn.exam.wsd._model.project.QualityProject;
import com.rtmdn.jpa.dao.Persistent;

@XmlRootElement( name="employee" )
@XmlType( name="employee-type", propOrder = { "id", "name", "startDate", "salary", "picture", "address", "phones", "department", "projects" } )
@Entity
@NamedEntityGraphs( value = { @NamedEntityGraph( name = "Employee.default", includeAllAttributes = true ) } )
public class Employee extends Persistent// implements com.sun.xml.bind.CycleRecoverable
{
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@XmlAttribute( required = true )
	private Long id;
	
	@XmlAttribute( required = true )
	@NotNull
	private String name;
	
	@XmlAttribute( required = true )
	@Temporal( TemporalType.DATE )
	@NotNull
	private Date startDate;
	
	@XmlAttribute( required = true )
	@NotNull
	private Double salary;
	
	@Lob
	@XmlSchemaType( name="base64Binary" )
	@XmlElement( required = true, nillable=false )
	@NotNull
	private byte[] picture;
	
	@XmlElementRef(required = true )
	@OneToOne( fetch = FetchType.LAZY, cascade={CascadeType.PERSIST} )
	@NotNull
	private Address address;
	
	@XmlElementWrapper( name = "phones", nillable=true, required=true )
	@XmlElement( name = "phone" )
	@OneToMany( mappedBy = "employee", fetch = FetchType.LAZY, cascade={CascadeType.PERSIST} )
	private Set<Phone> phones;
	
	@XmlElement( required=true, nillable=false )
	@ManyToOne( fetch = FetchType.LAZY, cascade={CascadeType.PERSIST} )
	@NotNull
	private Department department;
	
	@XmlTransient
	@ManyToOne( fetch = FetchType.LAZY )
	private Employee manager;
	
	//@XmlElementWrapper( name = "directs", nillable = true, required = false )
	//@XmlElement( name = "direct" )
	@XmlTransient
	@OneToMany( mappedBy = "manager", fetch = FetchType.LAZY )
	private Set<Employee> directs;
	
	@XmlElementWrapper(name="projects")
	@XmlElements( value = {
		/*@XmlElement( name = "project", type = Project.class ),*/
		@XmlElement( name = "qualityProject", type = QualityProject.class ), 
		@XmlElement( name = "designProject", type = DesignProject.class )
	} )
	@ManyToMany( mappedBy = "employees", fetch = FetchType.LAZY )
	private Set<Project> projects;
	
	public Employee ( )
	{
		
	}
	
	public Employee ( String name, Date startDate, Double salary, byte[] picture, Address address, Department department, Employee manager )
	{
		super ( );
		
		directs = new HashSet<Employee> ( );
		projects = new HashSet<Project> ( );
		phones = new HashSet<Phone> ( );
		
		setName ( name );
		setStartDate ( startDate );
		setSalary ( salary );
		setPicture( picture );
		setAddress ( address );
		setDepartment ( department );
		setManager ( manager );
	}
	
	public Long getId( )
	{
		return id;
	}
	
	public void setId( Long id )
	{
		this.id = id;
	}
	
	public String getName( )
	{
		return name;
	}
	
	public void setName( String name )
	{
		this.name = name;
	}
	
	public Double getSalary( )
	{
		return salary;
	}
	
	public void setSalary( Double salary )
	{
		this.salary = salary;
	}
	
	public Date getStartDate( )
	{
		return startDate;
	}
	
	public void setStartDate( Date startDate )
	{
		this.startDate = startDate;
	}
	
	public byte[] getPicture( )
	{
		return picture;
	}
	
	public void setPicture( byte[] picture )
	{
		this.picture = picture;
	}
	
	public Set<Phone> getPhones( )
	{
		return phones;
	}
	
	public void setPhones( Set<Phone> phones )
	{
		this.phones = phones;
	}
	
	public void addPhone( Phone phone )
	{
		if ( !getPhones ( ).contains ( phone ) )
		{
			getPhones ( ).add ( phone );

			if ( phone.getEmployee ( ) != null )
			{
				phone.getEmployee ( ).getPhones ( ).remove ( phone );
			}
			
			phone.setEmployee ( this );
		}
	}
	
	public Department getDepartment( )
	{
		return department;
	}
	
	public void setDepartment( Department department )
	{
		if ( this.department != null )
		{
			this.department.getEmployees ( ).remove ( this );
		}
		
		this.department = department;
		this.department.addEmployee ( this );
	}
	
	public Set<Employee> getDirects( )
	{
		return directs;
	}
	
	public void setDirects( Set<Employee> directs )
	{
		this.directs = directs;
	}
	
	public void addDirect( Employee direct )
	{
		if ( !getDirects ( ).contains ( direct ) )
		{
			getDirects ( ).add ( direct );
			
			if ( direct.getManager ( ) != null )
			{
				direct.getManager ( ).getDirects ( ).remove ( direct );
			}
			
			direct.setManager ( this );
		}
	}
	
	public Employee getManager( )
	{
		return manager;
	}
	
	public void setManager( Employee manager )
	{
		this.manager = manager;
	}
	
	public Set<Project> getProjects( )
	{
		return projects;
	}
	
	public void setProjects( Set<Project> projects )
	{
		this.projects = projects;
	}
	
	public void addProject( Project project )
	{
		if ( !getProjects ( ).contains ( project ) )
		{
			getProjects ( ).add ( project );
		}
		
		if ( !project.getEmployees ( ).contains ( this ) )
		{
			project.getEmployees ( ).add ( this );
		}
	}
	
	public Address getAddress( )
	{
		return address;
	}
	
	public void setAddress( Address address )
	{
		this.address = address;
	}
	
	/*public Employee onCycleDetected( Context context )
	{
		// when a cycle is detected, let's just write out an ID
		Employee replacement = new Employee ( );
		replacement.id = this.id;

		return replacement;
	}*/
	
	public String toString( )
	{
		return "[Employee " + getId ( ) + ": name: '" + getName ( ) + "', salary: " + getSalary ( ) + ", phones: " + getPhones ( ) +
		// ", projects: " + getProjects ( ) == null ? null : getProjects ( ) +
			", managerNo: " + ((getManager ( ) == null) ? null : getManager ( ).getId ( )) + ", deptNo: " + ((getDepartment ( ) == null) ? null : getDepartment ( ).getId ( )) + "]";
	}
}
