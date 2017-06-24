package service;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import entity.Score;
import entity.ScoreList;


public class SoapService {

	private static final String ENV_PRE = "env";
	private static final String NJU_PRE = "nju";
	private static final String TNS_PRE = "tns";

	StudentService studentService;

	public SoapService(){
		studentService = new StudentService();
	}



	public SOAPMessage getStudentScoreById(String studentId, String tagName, String tagValue){
		MessageFactory factory;
		SOAPMessage message = null;
		SOAPEnvelope envelope = null;
		SOAPBody body = null;

		try {
			factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			message = factory.createMessage();
			envelope = message.getSOAPPart().getEnvelope();
			body = envelope.getBody();


		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if(isValidStudentId(studentId)){
			ScoreList list = studentService.findScoreListById(studentId);
			if(list.getScoreList().isEmpty()){
				createNoScoreMessage(body);
			}else{
				createScoreMessage(body, envelope, list, tagName, tagValue);
			}

		}else {
			createInValidStudentIdMessage(body);
		}

		try {
			message.saveChanges();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public SOAPMessage createInnerErrorMessage(String reason) {
		// TODO Auto-generated method stub

		MessageFactory factory;
		SOAPMessage message = null;
		SOAPEnvelope envelope = null;
		SOAPBody body = null;
		SOAPFault fault ;

		try {
			factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			message = factory.createMessage();
			envelope = message.getSOAPPart().getEnvelope();
			body = envelope.getBody();
			fault = body.addFault();
			fault.setFaultCode(fault.createQName("Sender", ENV_PRE));
			fault.setFaultString("服务器内部错误，" + reason , new Locale("zh-CN"));
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;

	}
	
	
	public SOAPMessage createScoreErrorMessage() {
		// TODO Auto-generated method stub

		MessageFactory factory;
		SOAPMessage message = null;
		SOAPEnvelope envelope = null;
		SOAPBody body = null;
		SOAPFault fault ;

		try {
			factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			message = factory.createMessage();
			envelope = message.getSOAPPart().getEnvelope();
			body = envelope.getBody();
			fault = body.addFault();
			fault.setFaultCode(fault.createQName("Sender", ENV_PRE));
			fault.setFaultString("成绩格式错误，应满足正则表达式^[0-9],^[1-9][0-9]$,^100$之一，即不大于100的自然数", new Locale("zh-CN"));
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;

	}



	private void createNoScoreMessage(SOAPBody body){
		SOAPFault fault ;

		try {
			fault = body.addFault();
			fault.setFaultCode(fault.createQName("Sender", ENV_PRE));
			fault.setFaultString("该学号成绩没有查询到", new Locale("zh-CN"));
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	private void createScoreMessage(SOAPBody body, SOAPEnvelope envelope, ScoreList list, String tagName, String tagValue){
		try {
			body.addChildElement(envelope.createName(tagName, NJU_PRE, "http://www.nju.edu.cn/schema")).addTextNode(tagValue);
			SOAPElement listElement = body.addChildElement(envelope.createName("课程成绩列表", TNS_PRE, "http://jw.nju.edu.cn/schema"));
			listElement.setAttribute("xmlns", "http://jw.nju.edu.cn/schema");
			listElement.setAttribute("xmlns:nju", "http://www.nju.edu.cn/schema");
			listElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			listElement.setAttribute("xsi:schemaLocation", "http://jw.nju.edu.cn/schema ScoreList.xsd");

			for(Score score : list.getScoreList()){
				SOAPElement cscoreElement = listElement.addChildElement(listElement.createQName("课程成绩", TNS_PRE));
				cscoreElement.setAttribute("课程编号", score.getCourseId());
				cscoreElement.setAttribute("成绩性质", score.getScoreType());
				SOAPElement scoreElement = cscoreElement.addChildElement(listElement.createQName("成绩", TNS_PRE));
				scoreElement.addChildElement(listElement.createQName("学号", TNS_PRE)).addTextNode(score.getStudentId());
				scoreElement.addChildElement(listElement.createQName("得分", TNS_PRE)).addTextNode(score.getScore());
			}





		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}



	private void createInValidStudentIdMessage(SOAPBody body){
		SOAPFault fault ;

		try {
			fault = body.addFault();
			fault.setFaultCode(fault.createQName("Sender", ENV_PRE));
			fault.setFaultString("学号格式错误，应满足正则表达式 ^\\d{9}$ ，即为9位数字", new Locale("zh-CN"));
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public SOAPMessage createStudentIdMessage(String studentId) {
		// TODO Auto-generated method stub

		MessageFactory factory;
		SOAPMessage message = null;
		SOAPEnvelope envelope = null;
		SOAPBody body = null;

		try {
			factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			message = factory.createMessage();
			envelope = message.getSOAPPart().getEnvelope();
			body = envelope.getBody();
			body.addChildElement(envelope.createName("成绩操作", NJU_PRE, "http://www.nju.edu.cn/schema")).addTextNode("成绩查询");
			body.addChildElement(envelope.createName("studentId", NJU_PRE, "http://www.nju.edu.cn/schema")).addTextNode(studentId);

		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;

	}


	public String getStudentId(SOAPMessage message){
		SOAPEnvelope envelope = null;
		SOAPBody body = null;
		SOAPElement element = null;
		String studentId = null;
		try{
			envelope = message.getSOAPPart().getEnvelope();
			body = envelope.getBody();
			Iterator iterator = body.getChildElements(envelope.createName("studentId",NJU_PRE,"http://www.nju.edu.cn/schema"));

			element = (SOAPElement) iterator.next();         
			studentId = element.getValue();
		}catch (SOAPException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studentId;
	}


	/**
	 * 创建post方式与server进行交互
	 * @param baseURL
	 * @param message
	 * @return
	 */

	public SOAPMessage getMessageFromServer(String baseURL, SOAPMessage message){

		//URL对象封装了即将访问的目标服务
		URL client = null;
		SOAPMessage returnMessage = null;
		try {
			client = new URL(baseURL);			
			HttpURLConnection conn = (HttpURLConnection) client.openConnection();
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(15000);
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			OutputStream outputStream = new BufferedOutputStream(conn.getOutputStream());
			message.writeTo(outputStream);
			outputStream.flush();
			returnMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage(null,conn.getInputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMessage = createInnerErrorMessage("操作失败");
		} 

		return returnMessage;


	}


	public ScoreList getScoreFromMessage(SOAPMessage message){
		ScoreList list = new ScoreList();

		SOAPEnvelope envelope = null;
		SOAPBody body = null;
		try {
			envelope = message.getSOAPPart().getEnvelope();
			body = envelope.getBody();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if(body.hasFault()){
			return null;
		}
		NodeList nodeList = body.getElementsByTagName("tns:课程成绩");
		for(int i = 0; i< nodeList.getLength(); i++){

			Score score = new Score();
			Element element = (Element) nodeList.item(i);

			Node scoreElement = element.getElementsByTagName("tns:成绩").item(0);
			Node idElement = ((Element)scoreElement).getElementsByTagName("tns:学号").item(0);
			Node getElement = ((Element)scoreElement).getElementsByTagName("tns:得分").item(0);

			score.setCourseId(element.getAttribute("课程编号"));
			score.setScoreType(element.getAttribute("成绩性质"));
			score.setScore(getElement.getTextContent());
			score.setStudentId(idElement.getTextContent());
			list.addScore(score);

		}

		return list;

	}


	private boolean isValidStudentId(String studentId){
		if(studentId == null)
			return false;

		if(studentId.matches("^\\d{9}$"))
			return true;
		return false;
	}
	
	
	private boolean isValidScore(String score){
		if(score == null)
			return false;

		if(score.matches("^[0-9]$") || score.matches("^[1-9][0-9]$") || score.matches("^100$"))
			return true;
		return false;
	}



	public SOAPMessage createUpdateMessage(ScoreList list) {
		// TODO Auto-generated method stub

		MessageFactory factory;
		SOAPMessage message = null;
		SOAPEnvelope envelope = null;
		SOAPBody body = null;

		try {

			factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
			message = factory.createMessage();
			envelope = message.getSOAPPart().getEnvelope();
			body = envelope.getBody();
			body.addChildElement(envelope.createName("成绩操作", NJU_PRE, "http://www.nju.edu.cn/schema")).addTextNode("更新成绩");
			SOAPElement listElement = body.addChildElement(envelope.createName("课程成绩列表", TNS_PRE, "http://jw.nju.edu.cn/schema"));
			listElement.setAttribute("xmlns", "http://jw.nju.edu.cn/schema");
			listElement.setAttribute("xmlns:nju", "http://www.nju.edu.cn/schema");
			listElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
			listElement.setAttribute("xsi:schemaLocation", "http://jw.nju.edu.cn/schema ScoreList.xsd");

			for(Score score : list.getScoreList()){
				SOAPElement cscoreElement = listElement.addChildElement(listElement.createQName("课程成绩", TNS_PRE));
				cscoreElement.setAttribute("课程编号", score.getCourseId());
				cscoreElement.setAttribute("成绩性质", score.getScoreType());
				SOAPElement scoreElement = cscoreElement.addChildElement(listElement.createQName("成绩", TNS_PRE));
				scoreElement.addChildElement(listElement.createQName("学号", TNS_PRE)).addTextNode(score.getStudentId());
				scoreElement.addChildElement(listElement.createQName("得分", TNS_PRE)).addTextNode(score.getScore());
			}





		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}



	public SOAPMessage updateStudentScore(ScoreList list) {
		// TODO Auto-generated method stub
		for(Score score : list.getScoreList()){
			if(!isValidScore(score.getScore())){
				return createScoreErrorMessage();
			}
		}
		String tagName = "成绩更新";
		String tagValue ="操作成功";
		if(!studentService.updateScore(list)){
			tagValue = "操作失败";
		}
		
		return getStudentScoreById(list.getScoreList().get(0).getStudentId(), tagName, tagValue);
				
	}



}
