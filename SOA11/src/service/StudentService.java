package service;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.rpc.ServiceException;

import entity.Score;
import entity.ScoreList;
import jaxb.EmailLoginType;
import jaxb.ResponseType;
import stuPort.CourseScoreType;
import stuPort.DepartmentType;
import stuPort.IndividualBaseInfoType;
import stuPort.ScoreType;
import stuPort.StdManageServiceLocator;
import stuPort.StdManageServicePort;
import stuPort.StudentType;

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

	XmlService service;
	
	String studentNo[] = {"141250167","141250068"};
	String score[] = {"88","90","100"};
	String courseNo[] = {"00001","00002"};

//	public StudentService() {
//		// TODO Auto-generated constructor stub
//		service = new XmlService();
//	}

	public StdManageServicePort init(){
		StdManageServiceLocator locator = new StdManageServiceLocator();
		StdManageServicePort port = null;
		try {
			port = locator.getstdManageServicePort();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return port;
	}
	
	public void insert(Score score){
		StdManageServicePort port = init();
		String result = "";
		StudentType student = register(score.getStudentId(), score.getCourseId(), score.getScoreType(), score.getScore());
		try {
			result = port.addStd(student);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		File file1 = stuFile("message/insertRequest.xml");
		recordStudent(student, file1);
		File file2 = stuFile("message/insertResponse.xml");
		recordString(result, file2);
	}
	
	public void delete(String studentNo){
		StdManageServicePort port = init();
		String result = "";
		try {
			result = port.deleteStd(studentNo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		File file1 = stuFile("message/deleteRequest.xml");
		recordString(studentNo, file1);
		File file2 = stuFile("message/deleteResponse.xml");
		recordString(result, file2);
	}
	
	public void update(Score score){
		StdManageServicePort port = init();
		String result = "";
		StudentType student = register(score.getStudentId(), score.getCourseId(), score.getScoreType(), score.getScore());
		try {
			result = port.updateStd(student);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		File file1 = stuFile("message/modifyRequest.xml");
		recordStudent(student, file1);
		File file2 = stuFile("message/modifyResponse.xml");
		recordString(result, file2);
	}
	
	public StudentType query(String studentNo){
		StdManageServicePort port = init();
		String result = "";
		StudentType student = null;
		try {
			student = port.queryStd(studentNo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		File file1 = stuFile("message/queryRequest.xml");
		recordString(studentNo, file1);
		File file2 = stuFile("message/queryResponse.xml");
		recordStudent(student, file2);
		
		return student;
	}
	
	
	
	private StudentType register(String studentNo, String courseNo, String scoreType, String testScore){
		StudentType student = new StudentType();
		student.setGrade("14");
		CourseScoreType[] courses = new CourseScoreType[1];
    	ScoreType score = new ScoreType(studentNo, testScore);
    	courses[0] = new CourseScoreType(courseNo,score,scoreType);
		student.setCourseScoreList(courses);
		student.setStudentNo(studentNo);
		DepartmentType department = new DepartmentType("xxx", "xxxxxx", "软件学院", "xxxxxxxx", "025");
		IndividualBaseInfoType info = new IndividualBaseInfoType("南京大学", "1111-11-11", department, "本科", "522123199505051011", "未婚", "yha", "13279702112", "男");
		student.setIndividualBaseInfo(info);

		return student;
	}
	
	private File stuFile(String path){
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return file;
	}
	
	private  void recordStudent(StudentType student, File file){
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(StudentType.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(student, file);

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private  void recordString(String response, File file){
		JAXBContext jaxbContext1;
		try {
			jaxbContext1 = JAXBContext.newInstance(ResponseType.class);

			Marshaller jaxbMarshaller1 = jaxbContext1.createMarshaller();
			// output pretty printed
			jaxbMarshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			ResponseType studentResponseType = new ResponseType();
			studentResponseType.setContent(response);
			jaxbMarshaller1.marshal(studentResponseType, file);

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	
	
	public static void main(String[] args){
		StudentService service = new StudentService();
		
		Score score = new Score("00001", "期末考试", "141250068", "90");
		service.insert(score);
		
		Score score1 = new Score("00001", "期末考试", "141250068", "95");
		service.update(score1);
		
		StudentType student = service.query("141250068");
		System.out.println(student.getStudentNo());
		
		service.delete("141250068");
		
	}

}
