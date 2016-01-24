
package com.rtmdn.exam.wsd._model.employee;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.rtmdn.jpa.dao.Persistent;

@XmlRootElement(name="phone" )
@XmlType( name="phone-type", propOrder = { "id", "number", "phoneType" } )
@Entity
@NamedEntityGraphs( value = { @NamedEntityGraph( name = "Phone.default", includeAllAttributes = true ) } )
public class Phone extends Persistent
{
	@XmlAttribute( required = true )
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@XmlAttribute( required = true )
	@NotNull
	private String number;

	@XmlElement( required = true, nillable=false )
	@Enumerated( EnumType.STRING )
	@NotNull
	private PhoneType phoneType;

	@XmlTransient
	@ManyToOne( fetch = FetchType.LAZY )
	private Employee employee;

	public Phone ( )
	{

	}

	public Phone ( String number, PhoneType phoneType )
	{
		super ( );
		this.number = number;
		this.phoneType = phoneType;
	}

	public Long getId( )
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getNumber( )
	{
		return number;
	}

	public void setNumber( String phoneNo )
	{
		this.number = phoneNo;
	}

	public PhoneType getPhoneType( )
	{
		return phoneType;
	}

	public void setPhoneType( PhoneType phoneType )
	{
		this.phoneType = phoneType;
	}

	public Employee getEmployee( )
	{
		return employee;
	}

	public void setEmployee( Employee employee )
	{
		this.employee = employee;
	}

	public String toString( )
	{
		return "[Phone id: " + getId ( ) + ", no: '" + getNumber ( ) + "', type: '" + getPhoneType ( ) + "']";
	}
}
