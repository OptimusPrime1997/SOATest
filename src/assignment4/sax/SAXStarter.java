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
		String sourceXML = "src/assignment4/xslt/XML文档3.xml";
		String sourceXSD = "src/assignment3/ScoreList.xsd";
		String targetXML = "src/assignment4/sax/XML文档4.xml";
		
		// 验证sourceXML
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
			// 2.通过工厂对象 SAXParser创建解析器对象
			SAXParser saxParser = factory.newSAXParser();
			// 3.通过解析saxParser的parse()方法设定解析的文件和自己定义的事件处理器对象
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
