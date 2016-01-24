
package com.rtmdn.exam.wsd._facade.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBException;

@Provider
public class JAXBExceptionHandler implements ExceptionMapper<JAXBException>
{
	@Override
   public Response toResponse(JAXBException exception)
	{
       return Response
           .status( Response.Status.INTERNAL_SERVER_ERROR )
           .entity( exception.getMessage ( ) )
           .build();
   }
}
