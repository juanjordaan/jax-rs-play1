
package com.rtmdn.exam.wsd._facade.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

public class ClientLoggingFilter implements ClientRequestFilter, ClientResponseFilter
{
	@Override
	public void filter( ClientRequestContext crc ) throws IOException
	{
		System.out.println ( "<start>ClientRequestFilter" );
		System.out.println ( crc.getMethod ( ) + " " + crc.getUri ( ) );
		
		for ( Entry<String, List<Object>>  e : crc.getHeaders ( ).entrySet ( ) )
			System.out.print ( e.getKey ( ) + ": " + e.getValue ( ) );
		
		System.out.println ( "<end>ClientRequestFilter" );
	}

	@Override
	public void filter( ClientRequestContext crc, ClientResponseContext crc1 ) throws IOException
	{
		System.out.println ( "<start>ClientResponseFilter" );
		
		for ( Entry<String, List<String>> e : crc1.getHeaders ( ).entrySet ( ) )
			System.out.print ( e.getKey ( ) + ": " + e.getValue ( ) );
		
		System.out.println ( "<end>ClientResponseFilter" );
	}
}
