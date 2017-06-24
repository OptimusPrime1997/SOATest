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
import stuPort.CourseScoreType;
import stuPort.DepartmentType;
import stuPort.IndividualBaseInfoType;
import stuPort.ScoreType;
import stuPort.StdManageServiceLocator;
import stuPort.StdManageServicePort;
import stuPort.StudentType;

public class StudentService {

	XmlService service;
	
	String studentNo[] = {"141250167","141250068"};
	String score[] = {"88","90","100"};
	String courseNo[] = {"00001","00002"};

//	public StudentService() {
//		// TODO Auto-generated constructor stub
//		service = new XmlService();
//	}
	
	public ScoreList findScoreListById(String s){
		return null;
	}
	
	public boolean updateScore(ScoreList s){
		return true;
	}
	

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
//			jaxbMarshaller.marshal(student, System.out);
			jaxbMarshaller.marshal(student, file);

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private  void recordString(String response, File file){
		JAXBContext jaxbContext1;
		try {
			jaxbContext1 = JAXBContext.newInstance(String.class);

			Marshaller jaxbMarshaller1 = jaxbContext1.createMarshaller();
			// output pretty printed
			jaxbMarshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller1.marshal(response, file);

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public static void main(String[] args){
		Score score = new Score("00001", "期末考试", "141250068", "90");
		StudentService service = new StudentService();
		service.insert(score);
	}
	






}
