
package com.rtmdn.exam.wsd._facade.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.xml.sax.SAXException;

@Provider
public class SAXExceptionHandler implements ExceptionMapper<SAXException>
{
	@Override
   public Response toResponse(SAXException exception)
	{
       return Response
           .status( Response.Status.INTERNAL_SERVER_ERROR )
           .entity( exception.getMessage ( ) )
           .build();
   }
}
