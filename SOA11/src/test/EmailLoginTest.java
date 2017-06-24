package test;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.rpc.ServiceException;

import fromJAVA.EmailLoginImpl;
import fromJAVA.EmailLoginImplServiceLocator;
import jaxb.ResponseType;
import jaxb.EmailLoginType;

public class EmailLoginTest {

	public static void main(String[] args) {

		EmailLoginImplServiceLocator locator = new EmailLoginImplServiceLocator();
		EmailLoginImpl port = null;
		try {
			port = locator.getEmailLoginImplPort();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String username = "141250085@smail.nju.edu.cn";
		String password = "12345678";
		EmailLoginType emailLoginType = new EmailLoginType();
		emailLoginType.setUsername(username);
		emailLoginType.setPassword(password);
		String result = "";

		try {
			result = port.emailLogin(username, password);
			System.out.println(result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File file = new File("message/EmailLoginInput.xml");
		File file1 = new File("message/EmailLoginOutput.xml");
		if (!file.exists()) {
			try {
				file.createNewFile();
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		JAXBContext jaxbContext;
		JAXBContext jaxbContext1;
		try {
			jaxbContext = JAXBContext.newInstance(EmailLoginType.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(emailLoginType, System.out);
			jaxbMarshaller.marshal(emailLoginType, file);

			jaxbContext1 = JAXBContext.newInstance(ResponseType.class);

			Marshaller jaxbMarshaller1 = jaxbContext1.createMarshaller();
			// output pretty printed
			jaxbMarshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			ResponseType emailLoginResponseType = new ResponseType();
			emailLoginResponseType.setContent(result);
			jaxbMarshaller1.marshal(emailLoginResponseType, System.out);
			jaxbMarshaller1.marshal(emailLoginResponseType, file1);

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// result = port.addStd(student);
		// System.out.println(result);

	}
}
