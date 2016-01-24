package com.rtmdn.exam.wsd.hello;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class JAXBTest
{
	public static void main(String[] args) throws Exception {
      JAXBContext jc = JAXBContext.newInstance( Message.class );
      Message message = new Message ( "Hello World" );
      
      Marshaller writer = jc.createMarshaller();
      writer.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      writer.marshal( message, System.out );
  }
}
