package com.rtmdn.exam.wsd._model.project.jaxb.validation;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import static java.lang.System.err;

public class ProjectValidationEventHandler implements ValidationEventHandler
{
	@Override
	public boolean handleEvent( ValidationEvent event )
	{
		err.println( "Project Error caught: " );
		err.println( "message   : " + event.getMessage( ) );
		err.println( "severity  : " + event.getSeverity( ) );
		err.println( "exception : " + event.getLinkedException( ) );
		err.println( "Object    : " + event.getLocator().getObject() );
		
		return false;
	}
}
