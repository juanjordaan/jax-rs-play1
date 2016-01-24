
package com.rtmdn.exam.wsd.mapadapter;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.rtmdn.exam.wsd.mapadapter.adapter.MyMapAdapter;

@XmlRootElement( name="map-user", namespace="http://localhost:8080/test/schema/maps" )
@XmlType( name="" )
public class MapUser
{
	@XmlJavaTypeAdapter( MyMapAdapter.class )
	Map<Integer, String> map = new HashMap<Integer, String>( );

	public Map getMap( )
	{
		return map;
	}

	public void setMap( Map map )
	{
		this.map = map;
	}
}
