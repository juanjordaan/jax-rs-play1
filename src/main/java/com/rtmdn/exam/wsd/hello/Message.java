package com.rtmdn.exam.wsd.hello;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="message"/*, namespace="http://localhost:8080/test/schema/message"*/)
@XmlType(name="")
public class Message
{
	@XmlValue
	private String messageText;
	
	public Message ( )
	{
		
	}
	
	public Message ( String messageText )
	{
		this.messageText = messageText;
	}

	public String getMessageText( )
	{
		return messageText;
	}

	public void setMessageText( String messageText )
	{
		this.messageText = messageText;
	}
}
