package assignment4.sax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContentHandler extends DefaultHandler {
	private Map<CourseScore, List<Score>> map;
	private CourseScore courseScore;
	private Score score;
	private List<Score> list;

	/**
	 * -1为其他 0为studentNo 1为realScore
	 */
	private int studentNoFlag = -1;
	private String studentNo;
	private int realScore;

	public ContentHandler() {
		super();
		// TODO Auto-generated constructor stub

	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		map = new HashMap<CourseScore, List<Score>>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("tns:课程成绩")) {
			String courseNo = attributes.getValue("课程编号");
			String courseAttr = attributes.getValue("成绩性质");
			courseScore = new CourseScore(courseNo, courseAttr);
			list = new ArrayList<Score>();
			map.put(courseScore, list);
		} else if (qName.equals("tns:成绩")) {
			score = new Score();
			list = map.get(courseScore);
		} else if (qName.equals("tns:学号")) {
			studentNoFlag = 0;
		} else if (qName.equals("tns:得分")) {
			studentNoFlag = 1;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if (studentNoFlag == 0) {
			studentNo = (new String(ch, start, length));
		} else if (studentNoFlag == 1) {
			int grade = Integer.parseInt(new String(ch, start, length));
			if (grade < 60) {
				realScore = grade;
				score.setRealScore(grade);
				score.setStudentNo(studentNo);
				list.add(score);
				map.put(courseScore, list);
			} else {
			}
		} else {
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName.equals("tns:学号")) {
			studentNoFlag = -1;
		} else if (qName.equals("tns:得分")) {
			studentNoFlag = -1;
		}
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		for (Map.Entry<CourseScore, List<Score>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
			System.out.println(entry.getKey() + "---" + entry.getValue().size());
		}
	}

	public Map<CourseScore, List<Score>> getMap() {
		return map;
	}

	public void setMap(Map<CourseScore, List<Score>> map) {
		this.map = map;
	}

}
