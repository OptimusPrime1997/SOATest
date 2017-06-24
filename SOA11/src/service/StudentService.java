package service;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.rpc.ServiceException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import entity.Score;
import entity.ScoreList;
import fromJAVA.EmailLoginImpl;
import fromJAVA.EmailLoginImplServiceLocator;
import jaxb.ResponseType;
import jaxb.EmailLoginType;
import util.LoginResponse;

public class StudentService implements StudentServiceInterface {

	private XmlService service;

	public StudentService() {
		// TODO Auto-generated constructor stub
		service = new XmlService();
	}

	@Override
	public ScoreList findScoreListById(String studentId) {
		NodeList students = service.getStudentScoreList(studentId);
		ScoreList scoreList = new ScoreList();
		for (int i = 0; i < students.getLength(); i++) {
			Score score = new Score();
			Element element = (Element) students.item(i);
			score.setCourseId(element.getAttribute("课程编号"));
			score.setScoreType(element.getAttribute("成绩性质"));
			score.setScore(element.getElementsByTagName("得分").item(0).getTextContent());
			score.setStudentId(element.getElementsByTagName("学号").item(0).getTextContent());
			scoreList.addScore(score);
		}

		return scoreList;
	}

	public boolean updateScore(ScoreList list) {

		return service.updateScoreXml(list);
	}

	@Override
	public LoginResponse login(EmailLoginType emailLoginType) {
		// TODO Auto-generated method stub
		EmailLoginImplServiceLocator locator = new EmailLoginImplServiceLocator();
		EmailLoginImpl port = null;
		try {
			port = locator.getEmailLoginImplPort();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = "";
		try {
			result = port.emailLogin(emailLoginType.getUsername(), emailLoginType.getPassword());
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
		LoginResponse loginResponse = null;
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
			loginResponse = LoginResponse.getLoginResponse(result);

			jaxbMarshaller1.marshal(emailLoginResponseType, System.out);
			jaxbMarshaller1.marshal(emailLoginResponseType, file1);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return loginResponse;
	}

	@Override
	public void addScore(Score score) {
		// TODO Auto-generated method stub

	}

}
