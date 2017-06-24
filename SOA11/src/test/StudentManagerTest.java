package test;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import jaxb.EmailLoginType;
import stuPort.CourseScoreType;
import stuPort.DepartmentType;
import stuPort.IndividualBaseInfoType;
import stuPort.ScoreType;
import stuPort.StdManageServiceLocator;
import stuPort.StdManageServicePort;
import stuPort.StudentType;

public class StudentManagerTest {

	public static void main(String[] args) throws Exception{
	
		String studentNo[] = {"141250167","141250068"};
		String score[] = {"88","90","100"};
		String courseNo[] = {"00001","00002"};
		
		StdManageServiceLocator locator = new StdManageServiceLocator();
		StdManageServicePort port = locator.getstdManageServicePort();
		String result = null;
		
		StudentType st0 = register(studentNo[0], score[0], courseNo[0]);
		result = port.addStd(st0);
		System.out.println(result);
		File file0 = stuFile("message/insert.xml");
		
		StudentType st1 = register(studentNo[1], score[1], courseNo[1]);
		result = port.addStd(st1);
		System.out.println(result);
		
		StudentType studentType = port.queryStd("141250167");
		System.out.println(studentType.getStudentNo());
		
		StudentType st2 = register(studentNo[0], score[2], courseNo[0]);
		System.out.println(port.updateStd(st2));
		
		result = port.deleteStd("141250167");
		System.out.println(result);
	}

	private static StudentType register(String studentNo, String testScore, String courseNo){
		
		StudentType student = new StudentType();
		student.setGrade("14");
		CourseScoreType[] courses = new CourseScoreType[1];
    	ScoreType score = new ScoreType(studentNo, testScore);
    	courses[0] = new CourseScoreType(courseNo,score,"期末考试");
		student.setCourseScoreList(courses);
		student.setStudentNo(studentNo);
		DepartmentType department = new DepartmentType("xxx", "xxxxxx", "软件学院", "xxxxxxxx", "025");
		IndividualBaseInfoType info = new IndividualBaseInfoType("南京大学", "1111-11-11", department, "本科", "522123199505051011", "未婚", "yha", "13279702112", "男");
		student.setIndividualBaseInfo(info);

		return student;
	}
	
	private static File stuFile(String path){
		File file = new File("message/EmailLoginInput.xml");
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
	
	private static void recordStudent(StudentType student, File file){
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(StudentType.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(student, System.out);
			jaxbMarshaller.marshal(student, file);

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private static void recordString(String response, File file){
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
}
