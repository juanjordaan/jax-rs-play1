@javax.xml.bind.annotation.XmlSchema(
	namespace="http://localhost:8090/rtmdn/schema/employee.xsd", 
	elementFormDefault=javax.xml.bind.annotation.XmlNsForm.QUALIFIED,
		/*attributeFormDefault=javax.xml.bind.annotation.XmlNsForm.UNQUALIFIED,*/
	xmlns = {
		/*@javax.xml.bind.annotation.XmlNs( prefix = "xs" , namespaceURI = "http://www.w3.org/2001/XMLSchema" ),*/
		/*@javax.xml.bind.annotation.XmlNs( prefix = "emp", namespaceURI = "http://localhost:8080/test/schema/Employee.xsd" ),*/
		@javax.xml.bind.annotation.XmlNs( prefix = "rtp", namespaceURI = "http://localhost:8090/rtmdn/schema/dao.xsd" )/*,
		@javax.xml.bind.annotation.XmlNs( prefix = "prj", namespaceURI = "http://localhost:8080/test/schema/project project.xsd" )*/
	}
)
@javax.xml.bind.annotation.XmlAccessorType( javax.xml.bind.annotation.XmlAccessType.FIELD )
package com.rtmdn.exam.wsd._model.employee;