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
			NodeList studentList = doc.getElementsByTagName("ѧ��");
			for (int i = 0; i < studentList.getLength(); i++) {
				Stu student = new Stu();
				Node studentNode = studentList.item(i);
				if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
					Element studentElement = (Element) studentNode;

					student.setStudentNo(studentElement.getAttribute("ѧ��"));

					NodeList baseList = studentElement.getElementsByTagName("���˻�����Ϣ");
					Element baseInfo = (Element) baseList.item(0);
					Element nameE = (Element) baseInfo.getElementsByTagName("����").item(0);
					Element sexE = (Element) baseInfo.getElementsByTagName("�Ա�").item(0);
					Element birthE = (Element) baseInfo.getElementsByTagName("��������").item(0);
					Element idE = (Element) baseInfo.getElementsByTagName("���֤��").item(0);
					Element phoneNumE = (Element) baseInfo.getElementsByTagName("�ֻ�����").item(0);
					student.setName(nameE.getTextContent());
					student.setSex(sexE.getTextContent());
					student.setBirthDate(birthE.getTextContent());
					student.setId(idE.getTextContent());
					student.setPhoneNum(phoneNumE.getTextContent());

					Element courseScoreE = (Element) studentElement.getElementsByTagName("�γ̳ɼ��б�").item(0);
					NodeList courseScoreList = courseScoreE.getElementsByTagName("�γ̳ɼ�");
					List<CourseScore> scoreList = new ArrayList<CourseScore>();
					for (int j = 0; j < courseScoreList.getLength(); j++) {
						Element courseScore = (Element) courseScoreList.item(j);
						if (courseScore != null) {
							String courseAttr = courseScore.getAttribute("�ɼ�����");
							String courseNo = courseScore.getAttribute("�γ̱��");
							Element scoreE = (Element) courseScore.getElementsByTagName("�÷�").item(0);
							int score = Integer.parseInt(scoreE.getTextContent());
							CourseScore cs = new CourseScore(courseNo, courseAttr, score);
							scoreList.add(cs);
						} else {
							System.out.println(j + "---get courseScore failed!");
						}
						student.setScoreList(scoreList);
					}
				} else {
					System.out.println("get Element Student Error��");
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
