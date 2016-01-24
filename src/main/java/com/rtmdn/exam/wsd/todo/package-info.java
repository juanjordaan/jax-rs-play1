@javax.xml.bind.annotation.XmlSchema(
	namespace="http://localhost:8090/rtmdn/schema/todo.xsd", 
	elementFormDefault=javax.xml.bind.annotation.XmlNsForm.QUALIFIED, 
	xmlns = { 
		/*@javax.xml.bind.annotation.XmlNs( namespaceURI = "http://www.w3.org/2001/XMLSchema", prefix = "xs" ),*/
		@javax.xml.bind.annotation.XmlNs( prefix = "rtp", namespaceURI = "http://localhost:8090/rtmdn/schema/dao.xsd" ) 
	}
)
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
package com.rtmdn.exam.wsd.todo;
