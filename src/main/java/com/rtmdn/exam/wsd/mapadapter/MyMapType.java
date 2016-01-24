
package com.rtmdn.exam.wsd.mapadapter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class MyMapType
{
	public List<MyMapEntryType> entry = new ArrayList<MyMapEntryType>( );
}
