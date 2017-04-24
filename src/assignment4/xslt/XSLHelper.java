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
	public static void main(String[] args) throws IOException, URISyntaxException, TransformerException {
		String xslPath = "src/assignment4/xslt/ScoreListTransfer.xsl";
		String xmlSourcePath = "src/assignment4/xslt/ToTransfer.xml";
		String xmlTargetPath = "src/assignment4/xslt/XMLÎÄµµ3.xml";
		String xsdPath = "src/assignment3/ScoreList.xsd";
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