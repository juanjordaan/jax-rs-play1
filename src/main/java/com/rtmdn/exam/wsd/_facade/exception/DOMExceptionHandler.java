
package com.rtmdn.exam.wsd._facade.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.w3c.dom.DOMException;

@Provider
public class DOMExceptionHandler implements ExceptionMapper<DOMException>
{
	@Override
   public Response toResponse( DOMException exception )
	{
       return Response
           .status( Response.Status.INTERNAL_SERVER_ERROR )
           .entity( exception.getMessage ( ) )
           .build();
   }
}
