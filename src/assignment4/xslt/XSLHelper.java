package assignment4.xslt;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

import assignment3.ValidateXMLTester;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class XSLHelper {
	public static void main(String[] args) {
	//第一个文件转换
		String xslPath = "src/assignment4/xslt/ScoreListTransfer.xsl";
		String xmlSourcePath = "src/assignment3/XML文档2.xml";
		String xmlTargetPath = "src/assignment4/xslt/XML文档3.xml";
		String xsdPath = "src/assignment3/ScoreList.xsd";
		try {
			transferXML(xslPath,xmlSourcePath,xmlTargetPath,xsdPath);
		} catch (IOException | URISyntaxException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//用xslpath2.0进行分组
		String xslPath1="src/assignment4/xslt/ScoreListTransfer1.xsl";
//		try {
//			transferXML(xslPath1,xmlSourcePath,xmlTargetPath,xsdPath);
//		} catch (IOException | URISyntaxException | TransformerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//用xslpath1.0进行分组
				String xslPath2="src/assignment4/xslt/ScoreListTransfer2.xsl";
//				try {
//					transferXML(xslPath2,xmlSourcePath,xmlTargetPath,xsdPath);
//				} catch (IOException | URISyntaxException | TransformerException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
		

	}
	public static void transferXML(String xslPath,String xmlSourcePath,String xmlTargetPath,String xsdPath)throws IOException, URISyntaxException, TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Source xslt = new StreamSource(new File(xslPath));

		Transformer transformer = factory.newTransformer(xslt);
		Source text = new StreamSource(new File(xmlSourcePath));
		transformer.transform(text, new StreamResult(new File(xmlTargetPath)));
		boolean isValid = false;
		try {
			isValid = ValidateXMLTester.validateXML(xmlTargetPath, xsdPath);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isValid) {
			System.out.println("Generate XML successfully!" + xmlTargetPath + " is valided!");
		} else {
			System.out.println("Generate XML successfully!" + xmlTargetPath + " is not valided!");
		}
	}
}