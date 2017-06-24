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
import jaxb.EmailLoginType;
import util.Const;

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
		String password = "Jie!18780107043";
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

			jaxbContext1 = JAXBContext.newInstance(String.class);

			Marshaller jaxbMarshaller1 = jaxbContext1.createMarshaller();
			// output pretty printed
			jaxbMarshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller1.marshal(result, System.out);
			jaxbMarshaller1.marshal(result, file);

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		switch (result) {
		case Const.TEACHER_LOGIN:
			break;
		case Const.GRADUATE_LOGIN:

			break;
		case Const.UNDERGRADUATE_LOGIN:

			break;

		default:
			break;
		}
		// result = port.addStd(student);
		// System.out.println(result);

	}
}
