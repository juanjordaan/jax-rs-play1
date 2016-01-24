
package com.rtmdn.exam.wsd.todo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class JAXBTest
{
	public static void main(String[] args) throws Exception {
      JAXBContext jc = JAXBContext.newInstance( Todo.class );
      Todo todo = new Todo ( 1L, "blah", "blah blah" );
      
      Marshaller writer = jc.createMarshaller();
      writer.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      writer.marshal( todo, System.out );
  }
}
