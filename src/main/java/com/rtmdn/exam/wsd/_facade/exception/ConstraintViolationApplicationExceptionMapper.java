
package com.rtmdn.exam.wsd._facade.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rtmdn.jpa.exception.ConstraintViolationApplicationException;

@Provider
public class ConstraintViolationApplicationExceptionMapper implements ExceptionMapper<ConstraintViolationApplicationException>
{
	@Override
   public Response toResponse(ConstraintViolationApplicationException exception)
	{
       return Response
           .status( Response.Status.NOT_ACCEPTABLE )
           .entity( exception.getMessage ( ) )
           .build();
   }
}
