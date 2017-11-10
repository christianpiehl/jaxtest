package jaxtest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import jaxtest.xml.DateTime;

public class Main {

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		DateTime writeDateTime = createDateTime();
		
		marshalDateTimeXml("", writeDateTime);
		
		DateTime readDateTime = unmarshalDateTimeXml("filename");
		
	}

	private static DateTime createDateTime() {
		DateTime result = new DateTime();
		return result;
	}

	private static void marshalDateTimeXml(String filename, DateTime dateTime) {

	}

	private static DateTime unmarshalDateTimeXml(String filename) {
		DateTime result;
		try {
			JAXBContext context = JAXBContext.newInstance(DateTime.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			result = (DateTime) unmarshaller.unmarshal(new File(filename));
		} catch (JAXBException e) {
			result = new DateTime();
		}
		return result;
	}

}
