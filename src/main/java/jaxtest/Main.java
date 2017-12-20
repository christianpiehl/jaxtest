package jaxtest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import jaxtest.xml.DateTime;

public class Main {

	private static final String FILENAME_XML = "filename.xml";

	public static void main(String[] args) {
		DateTime writeDateTime = createDateTime();

		marshalDateTimeXml(FILENAME_XML, writeDateTime);

		DateTime readDateTime = unmarshalDateTimeXml(FILENAME_XML);
		System.out.println(readDateTime.getDate().getDate());
	}

	private static DateTime createDateTime() {
		DateTime result = new DateTime();
		result.getDate().setDate("datum");
		result.getTime().setTime("zeit");
		return result;
	}

	private static void marshalDateTimeXml(String filename, DateTime dateTime) {
		try {
			JAXBContext context = JAXBContext.newInstance(DateTime.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(dateTime, new File(filename));
		} catch (JAXBException e) {
			// nothing to do
		}
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
