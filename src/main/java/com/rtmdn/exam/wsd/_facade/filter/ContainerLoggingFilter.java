
package com.rtmdn.exam.wsd._facade.filter;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ContainerLoggingFilter implements ContainerRequestFilter, ContainerResponseFilter
{
	@Override
	public void filter( ContainerRequestContext requestContext ) throws IOException
	{
		System.out.println ( "--- ContainerRequestFilter - Start" );
		System.out.println ( requestContext.getMethod ( ) + " " + requestContext.getUriInfo ( ).getAbsolutePath ( ) );
		
		for ( String key : requestContext.getHeaders ( ).keySet ( ) )
			System.out.println ( key + ": " + requestContext.getHeaders ( ).get ( key ) );
		
		System.out.println ( "--- ContainerRequestFilter - End" );
	}

	@Override
	public void filter( ContainerRequestContext requestContext, ContainerResponseContext responseContext ) throws IOException
	{
		System.out.println ( "--- ContainerResponseFilter - Start" );
		
		for ( String key : responseContext.getHeaders ( ).keySet ( ) )
			System.out.println ( key + ": " + responseContext.getHeaders ( ).get ( key ) );
		
		//System.out.println ( "Entity-Type: " + responseContext.getEntityType ( ) );
		
		System.out.println ( "--- ContainerResponseFilter - End" );
	}
}
