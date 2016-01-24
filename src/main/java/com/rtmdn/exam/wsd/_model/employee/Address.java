
package com.rtmdn.exam.wsd._model.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.rtmdn.jpa.dao.Persistent;

@XmlRootElement( name="address" )
@XmlType( name="address-type", propOrder = { "id", "street", "city", "state", "zip" } )
@Entity
@NamedEntityGraphs( value = { @NamedEntityGraph( name = "Address.default", includeAllAttributes = true ) } )
public class Address extends Persistent
{
	@XmlAttribute( required = true )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@XmlAttribute( required = true )
	@NotNull
	private String street;

	@XmlAttribute( required = true )
	@NotNull
	private String city;

	@XmlAttribute( required = true )
	@NotNull
	private String state;

	@XmlAttribute( required = true )
	@NotNull
	private String zip;

	public Address ( )
	{
		
	}
	
	public Address ( String street, String city, String state, String zip )
	{
		super ( );
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Long getId( )
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getStreet( )
	{
		return street;
	}

	public void setStreet( String address )
	{
		this.street = address;
	}

	public String getCity( )
	{
		return city;
	}

	public void setCity( String city )
	{
		this.city = city;
	}

	public String getState( )
	{
		return state;
	}

	public void setState( String state )
	{
		this.state = state;
	}

	public String getZip( )
	{
		return zip;
	}

	public void setZip( String zip )
	{
		this.zip = zip;
	}

	public String toString( )
	{
		return "[Address id: " + getId ( ) + ", street: '" + getStreet ( ) + "', city: '" + getCity ( ) + "', state: '" + getState ( ) + "', zip: " + getZip ( ) + "]";
	}
}
