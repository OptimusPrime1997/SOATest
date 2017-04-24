package assignment4.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import assignment3.ValidateXMLTester;

public class SAXStarter {
	public static void main(String[] args) {
		String sourceXML = "src/assignment4/xslt/XML�ĵ�3.xml";
		String sourceXSD = "src/assignment3/ScoreList.xsd";
		String targetXML = "src/assignment4/sax/XML�ĵ�4.xml";
		
		// ��֤sourceXML
		boolean isValid = false;
		boolean resultValid=false;
		try {
			isValid = ValidateXMLTester.validateXML(sourceXML, sourceXSD);
		} catch (SAXException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (isValid == false) {
			System.out.println(sourceXML+" is not validated");
			return;
		}

		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			// 2.ͨ���������� SAXParser��������������
			SAXParser saxParser = factory.newSAXParser();
			// 3.ͨ������saxParser��parse()�����趨�������ļ����Լ�������¼�����������
			ContentHandler handler = new ContentHandler();
			saxParser.parse(new File(sourceXML), handler);
			DOMHelper.generateXML(targetXML, handler.getMap());
			resultValid=ValidateXMLTester.validateXML(targetXML, sourceXSD);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resultValid==true){
			System.out.println(targetXML+" is validated!");
		}else{
			System.out.println(targetXML+" is not valided! error");
		}
		
	}
}
