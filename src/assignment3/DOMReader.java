package assignment3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMReader {
	public static List<Stu> readXMLFile(String path) {
		List<Stu> myStudentList = new ArrayList<Stu>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File(path));
			NodeList studentList = doc.getElementsByTagName("学生");
			for (int i = 0; i < studentList.getLength(); i++) {
				Stu student = new Stu();
				Node studentNode = studentList.item(i);
				if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
					Element studentElement = (Element) studentNode;

					student.setStudentNo(studentElement.getAttribute("学号"));

					NodeList baseList = studentElement.getElementsByTagName("个人基本信息");
					Element baseInfo = (Element) baseList.item(0);
					Element nameE = (Element) baseInfo.getElementsByTagName("姓名").item(0);
					Element sexE = (Element) baseInfo.getElementsByTagName("性别").item(0);
					Element birthE = (Element) baseInfo.getElementsByTagName("出生日期").item(0);
					Element idE = (Element) baseInfo.getElementsByTagName("身份证号").item(0);
					Element phoneNumE = (Element) baseInfo.getElementsByTagName("手机号码").item(0);
					student.setName(nameE.getTextContent());
					student.setSex(sexE.getTextContent());
					student.setBirthDate(birthE.getTextContent());
					student.setId(idE.getTextContent());
					student.setPhoneNum(phoneNumE.getTextContent());

					Element courseScoreE = (Element) studentElement.getElementsByTagName("课程成绩列表").item(0);
					NodeList courseScoreList = courseScoreE.getElementsByTagName("课程成绩");
					List<CourseScore> scoreList = new ArrayList<CourseScore>();
					for (int j = 0; j < courseScoreList.getLength(); j++) {
						Element courseScore = (Element) courseScoreList.item(j);
						if (courseScore != null) {
							String courseAttr = courseScore.getAttribute("成绩性质");
							String courseNo = courseScore.getAttribute("课程编号");
							Element scoreE = (Element) courseScore.getElementsByTagName("得分").item(0);
							int score = Integer.parseInt(scoreE.getTextContent());
							CourseScore cs = new CourseScore(courseNo, courseAttr, score);
							scoreList.add(cs);
						} else {
							System.out.println(j + "---get courseScore failed!");
						}
						student.setScoreList(scoreList);
					}
				} else {
					System.out.println("get Element Student Error！");
				}
//				System.out.println(student.toString());
				myStudentList.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return myStudentList;
	}
}
