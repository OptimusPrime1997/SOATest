package service;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import entity.ScoreList;
import entity.Score;

public class StudentService {

	XmlService service;

	public StudentService() {
		// TODO Auto-generated constructor stub
		service = new XmlService();
	}


	public ScoreList findScoreListById(String studentId){
		NodeList students = service.getStudentScoreList(studentId);
		ScoreList scoreList = new ScoreList();
		for (int i = 0; i < students.getLength(); i++) {  
			Score score = new Score();
			Element element = (Element)students.item(i);
			score.setCourseId(element.getAttribute("课程编号"));
			score.setScoreType(element.getAttribute("成绩性质"));
			score.setScore(element.getElementsByTagName("得分").item(0).getTextContent());
			score.setStudentId(element.getElementsByTagName("学号").item(0).getTextContent());
			scoreList.addScore(score);
		}  

		return scoreList;
	}
	
	
	public boolean updateScore(ScoreList list){
		
		
		return service.updateScoreXml(list);
	}
	
	






}
