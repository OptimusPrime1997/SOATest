package assignment4.sax;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMHelper {
	/**
	 * @param path
	 *            构造数据，并生成XML文件
	 */
	public static void generateXML(String path, Map<CourseScore, List<Score>> map) {
		// step1:获得一个DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// step2:获得一个DocumentBuilder
		DocumentBuilder db = null;
		try {
			db = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step3:新建一个Document对象
		Document document = db.newDocument();
		// step4:创建一个根节点
		Element courseScoreList = generateElement(document, map);

		document.appendChild(courseScoreList);
		generateXMLByDom(path, document);
	}

	/**
	 * 通过Map来构造Sudent的Element
	 * 
	 * @param document
	 * @param map
	 * @return
	 */
	public static Element generateElement(Document document, Map<CourseScore, List<Score>> map) {
		Element courseScoreList = document.createElement("课程成绩列表");
		courseScoreList.setAttribute("xmlns","http://jw.nju.edu.cn/schema");
		for (Map.Entry<CourseScore, List<Score>> entry : map.entrySet()) {
			CourseScore cs = entry.getKey();
			Element courseScore = document.createElement("课程成绩");
			courseScore.setAttribute("成绩性质", cs.getScoreAttr());
			courseScore.setAttribute("课程编号", cs.getCourseNo());
			List<Score> sList = entry.getValue();
			for (Iterator<Score> t = sList.iterator(); t.hasNext();) {
				Score s = t.next();

				Element score = document.createElement("成绩");
				Element studentNum = document.createElement("学号");
				studentNum.setTextContent(s.getStudentNo());
				Element concreteScore = document.createElement("得分");
				concreteScore.setTextContent(s.getRealScore() + "");

				score.appendChild(studentNum);
				score.appendChild(concreteScore);
				courseScore.appendChild(score);
			}
			if(sList.size()>0){
				courseScoreList.appendChild(courseScore);
			}else{
			}
		}
		return courseScoreList;
	}

	/**
	 * 将Document写入指定路径的文件中
	 * 
	 * @param path
	 * @param document
	 */
	public static void generateXMLByDom(String path, Document document) {
		// step9:获得一个TransformerFactory对象
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		// step10:获得一个Transformer对象
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step11:设置Transformer对象的属性
		Properties oprops = new Properties();
		oprops.put(OutputKeys.ENCODING, "UTF-8");
		oprops.put(OutputKeys.OMIT_XML_DECLARATION, "no");
		oprops.put(OutputKeys.INDENT, "yes");
		oprops.put(OutputKeys.METHOD, "xml");
		transformer.setOutputProperties(oprops);

		DOMSource xmlSource = new DOMSource(document);
		File truepath = new File(path);
		if (!truepath.exists()) {
			try {
				truepath.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Create the " + path + " file!");
		} else {
			System.out.println("The " + path + " exists!");
		}

		// step12:建立个存储目标对象
		// Result outputTarget = new StreamResult(new File(path));
		StreamResult outputTarget = new StreamResult(new File(path));
		// step13:生成相应的xml文件
		try {
			transformer.transform(xmlSource, outputTarget);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Have written the " + path + " file!");
	}
}
