
package com.rtmdn.exam.wsd._facade.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rtmdn.jpa.exception.CriticalApplicationException;

@Provider
public class CriticalApplicationExceptionMapper implements ExceptionMapper<CriticalApplicationException>
{
	@Override
   public Response toResponse(CriticalApplicationException exception)
	{
       return Response
           .status( Response.Status.INTERNAL_SERVER_ERROR )
           .entity( exception.getMessage ( ) )
           .build();
   }
}
