
package com.rtmdn.exam.wsd._facade.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.ws.WebServiceException;

@Provider
public class WebServiceExceptionHandler implements ExceptionMapper<WebServiceException>
{
	@Override
   public Response toResponse( WebServiceException exception )
	{
       return Response
           .status( Response.Status.INTERNAL_SERVER_ERROR )
           .entity( exception.getMessage ( ) )
           .build();
   }
}
