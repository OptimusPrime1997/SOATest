package assignment9.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import assignment3.Stu;
import assignment9.model.CourseScoreListType;
import assignment9.model.CourseScoreType;
import assignment9.model.DepartmentType;
import assignment9.model.IndividualBaseInfoType;
import assignment9.model.ScoreType;
import assignment9.model.StudentListType;
import assignment9.model.StudentType;

public class JAXBTest {

	public static void main(String[] args) {
		StudentListType studentListType = generateStudentListType();
//		1->2
		java2Xml("src/assignment9/xml/XML文档2m.xml", studentListType,false);
//		2->3
		java2Xml("src/assignment9/xml/XML文档3m.xml", studentListType,true);
//		3->4
		CourseScoreListType courseScoreListType=xml2JavaCourseScoreList();
		java2XmlCourseScoreList("src/assignment9/xml/XML文档4m.xml", courseScoreListType);
		
	}

	/**
	 * 将Java类存为XML文件
	 * @param path
	 * @param studentListType
	 * @param sorted
	 */
	public static void java2Xml(String path, StudentListType studentListType, boolean sorted) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			if (sorted == false) {
				JAXBContext jaxbContext = JAXBContext.newInstance(StudentListType.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(studentListType, System.out);
				jaxbMarshaller.marshal(studentListType, file);
			}else{
				JAXBContext jaxbContext = JAXBContext.newInstance(CourseScoreListType.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				List<StudentType> studentTypes=studentListType.getStudent();
				List<CourseScoreType> courseScoreTypes=new ArrayList<>();
				for(StudentType type:studentTypes){
					courseScoreTypes.addAll(type.getCourseScoreList().getCourseScore());
				}
				Collections.sort(courseScoreTypes);
				CourseScoreListType courseScoreListType=new CourseScoreListType();
				courseScoreListType.setCourseScore(courseScoreTypes);
			
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(courseScoreListType, System.out);
				jaxbMarshaller.marshal(courseScoreListType, file);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 将CourseScoreList存为XML文件
	 * @param path
	 * @param type
	 */
	public static void java2XmlCourseScoreList(String path,CourseScoreListType type){
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			
				JAXBContext jaxbContext = JAXBContext.newInstance(CourseScoreListType.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				List<CourseScoreType> courseScoreTypes=type.getCourseScore();
				List<CourseScoreType> courseScores=new ArrayList<CourseScoreType>();
				for(CourseScoreType courseScoreType:courseScoreTypes){
					if(Integer.parseInt(courseScoreType.getScore().getRealScore())<60){
						courseScores.add(courseScoreType);
					}
				}
				Collections.sort(courseScores);
				CourseScoreListType courseScoreListType=new CourseScoreListType();
				courseScoreListType.setCourseScore(courseScores);
			
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(courseScoreListType, System.out);
				jaxbMarshaller.marshal(courseScoreListType, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 读取XML生成StudentListType类
	 * @return
	 */
	public static StudentListType generateStudentListType() {
		StudentListType studentList = new StudentListType();
		StudentType student0 = xml2JavaStudent();
		List<StudentType> studentTypes = generateStudentList();
		studentTypes.add(student0);
		studentList.setStudent(studentTypes);
		return studentList;
	}

	/**
	 * 构造StudentList
	 * @return
	 */
	public static List<StudentType> generateStudentList() {
		List<StudentType> studentTypes = new ArrayList<StudentType>();
		Stu[] list = new Stu[10];
		list[0] = new Stu("141250206", "周锐", "男", "1996-01-01", "311302199601015327", "18260039583");
		list[1] = new Stu("141250160", "徐江成", "男", "1996-02-02", "311302199602025327", "18260039584");
		list[2] = new Stu("141250050", "花蕾", "女", "1996-03-03", "311302199603035327", "18260039582");
		list[3] = new Stu("141250076", "李佳俊", "男", "1996-08-08", "311302199608085327", "18260039589");
		list[4] = new Stu("141250068", "梁家诚", "男", "1996-11-02", "311302199611025327", "18260039585");
		list[5] = new Stu("141250085", "罗金宏", "男", "1997-02-19", "311302199702195327", "18260032917");
		list[6] = new Stu("141250167", "杨华安", "男", "1996-04-04", "311302199604045327", "13270807992");
		list[7] = new Stu("141250036", "傅林华", "男", "1996-05-05", "311302199605055327", "18260039586");
		list[8] = new Stu("141250021", "崔忠诚", "男", "1996-06-06", "311302199606065327", "18260039587");
		list[9] = new Stu("141250075", "刘德宽", "男", "1996-07-07", "311302199607075327", "18260039588");
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].toString());
			studentTypes.add(generateStudent(list[i]));
		}
		return studentTypes;
	}

	/**
	 *构造StudentType
	 * @param s
	 * @return
	 */
	public static StudentType generateStudent(Stu s) {
		if (s == null) {
			System.out.println("s is null!");
		}
		IndividualBaseInfoType individualBaseInfoType = new IndividualBaseInfoType();
		individualBaseInfoType.setName(s.getName());
		individualBaseInfoType.setSex(s.getSex());
		individualBaseInfoType.setBirth(s.getBirthDate());
		individualBaseInfoType.setId(s.getId());
		individualBaseInfoType.setPhoneNum(s.getPhoneNum());
		DepartmentType department = new DepartmentType();
		department.setDepartmentAttribute("院");
		department.setDepartmentDescribe("以培养卓越且杰出的高素质软件工程师为目标");
		department.setDepartmentManager("陈琳");
		department.setDepartmentName("软件学院");
		department.setDepartmentNo("125109");
		individualBaseInfoType.setDepartment(department);
		individualBaseInfoType.setEducationBackground("本科");
		individualBaseInfoType.setMaritalStatus("未婚");
		individualBaseInfoType.setAddress("江苏省南京市鼓楼区汉口路22号");
		CourseScoreListType courseScoreListType = new CourseScoreListType();
		List<CourseScoreType> scores = new ArrayList<CourseScoreType>();
		String[] scoreAttrs = { "平时成绩", "期末成绩", "总评成绩" };
		String[] courseNos = { "25000100", "25000101", "25000102", "25000103", "25000104" };
		int[][] scoreArr = new int[5][3];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 2; j++) {
				scoreArr[i][j] = (int) (60 + 40 * (Math.random() - 0.5));
			}
			scoreArr[i][2] = (int) Math.floor(scoreArr[i][0] * 0.2 + scoreArr[i][1] * 0.8);
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				CourseScoreType courseScoreType = new CourseScoreType();
				ScoreType scoreType = new ScoreType();
				scoreType.setStudentNo(s.getStudentNo());
				scoreType.setRealScore(scoreArr[i][j] + "");
				courseScoreType.setScore(scoreType);
				courseScoreType.setCourseNo(courseNos[i]);
				courseScoreType.setScoreType(scoreAttrs[j]);
				scores.add(courseScoreType);
			}
		}
		courseScoreListType.setCourseScore(scores);
		StudentType studentType = new StudentType();
		studentType.setCourseScoreList(courseScoreListType);
		studentType.setGrade("大三");
		studentType.setIndividualBaseInfo(individualBaseInfoType);
		studentType.setStudentNo(s.getStudentNo());
		// studentType
		return studentType;

	}

	/**
	 * 读取Student的XML(即XML1)生成StudentType
	 * @return
	 */
	public static StudentType xml2JavaStudent() {
		File file = new File("src/assignment9/xml/XML文档1m.xml");
		JAXBContext jc = null;
		StudentType student = null;
		try {
			jc = JAXBContext.newInstance(StudentType.class);
			Unmarshaller unMarshaller = jc.createUnmarshaller();
			student = (StudentType) unMarshaller.unmarshal(file);
			System.out.println(student.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(student.toString());
		return student;
	}

	/**
	 * 读取XML(即XML2）生成StudentList
	 * @return
	 */
	public static StudentListType xml2JavaStudentList() {
		File file = new File("src/assignment9/xml/XML文档2m.xml");
		JAXBContext jc = null;
		StudentListType studentList = null;
		try {
			jc = JAXBContext.newInstance(StudentListType.class);
			Unmarshaller unMarshaller = jc.createUnmarshaller();
			studentList = (StudentListType) unMarshaller.unmarshal(file);
			System.out.println(studentList.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}
	/**
	 * 读取XML(即XML3)生成CourseScoreList
	 * @return
	 */
	public static CourseScoreListType xml2JavaCourseScoreList() {
		File file = new File("src/assignment9/xml/XML文档3m.xml");
		JAXBContext jc = null;
		CourseScoreListType courseScoreList = null;
		try {
			jc = JAXBContext.newInstance(CourseScoreListType.class);
			Unmarshaller unMarshaller = jc.createUnmarshaller();
			courseScoreList = (CourseScoreListType) unMarshaller.unmarshal(file);
			System.out.println(courseScoreList.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseScoreList;
	}

}
