package service;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.Score;
import entity.ScoreList;

public class XmlService {

	private static final String XML_URL = "Xml/XML文档2.xml";


	public NodeList getStudentScoreList(String studentId){
		String path = XmlService.class.getClassLoader().getResource(XML_URL).getPath();

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(false);

		XPathFactory factory = XPathFactory.newInstance();  
		XPath xpath = factory.newXPath();

		DocumentBuilder builder;
		Document  document = null;
		try {
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.parse(path);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
		XPathExpression expression = null;
		NodeList students = null;
		try {
			expression = xpath.compile("//学生信息[@学号 = "+ studentId + "]//课程成绩");
			students = (NodeList) expression.evaluate(document, XPathConstants.NODESET);


		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return students;
	}


	public boolean updateScoreXml(ScoreList list){
		String path = XmlService.class.getClassLoader().getResource(XML_URL).getPath();

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(false);

		XPathFactory factory = XPathFactory.newInstance();  
		XPath xpath = factory.newXPath();

		DocumentBuilder builder;
		Document  document = null;
		try {
			builder = documentBuilderFactory.newDocumentBuilder();
			document = builder.parse(path);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
		XPathExpression expression = null;
		NodeList s = null;
		try {

			for(Score score : list.getScoreList()){
				String name = "//课程成绩[@成绩性质 = '"+ score.getScoreType() + "' and @课程编号 = '" + score.getCourseId() +"']/成绩[学号 = '"+score.getStudentId() +"']";
				expression = xpath.compile(name);
				s = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
				Element element = (Element)s.item(0);
				element.getElementsByTagName("得分").item(0).setTextContent(score.getScore());
			}

		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();  

			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");  

			DOMSource source = new DOMSource(document);  
			StreamResult result = new StreamResult(new File(path));  

			transformer.transform(source, result);  
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}  

		return true;
	}




}
