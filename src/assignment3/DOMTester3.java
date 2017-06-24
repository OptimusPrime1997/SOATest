package assignment3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.xml.sax.SAXException;

/**
 * @author OptimusPrime ���ɸ���Ҫ���XML�ļ�
 */
public class DOMTester3 {
	/**
	 * @param args
	 *            ������
	 */
	public static void main(String[] args) {
		String path = "src/assignment3/XML3.xml";
		
		String sourcePath="src/assignment3/XML1.xml";
		String sourceXSD="src/assignment3/Student.xsd";
		generateXML(sourcePath,sourceXSD,path);
		
		String xsdPath = "src/assignment3/StudentList.xsd";
		
		boolean result = false;
		try {
			result = ValidateXMLTester.validateXML(path, xsdPath);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == true) {
			System.out.println("Generate xml file successed!");
		} else {
			System.out.println("XML is not validated!");
		}
	}

	/**
	 * @param path
	 *            �������ݣ�������XML�ļ�
	 */
	public static void generateXML(String sourcePath,String sourceXSD,String path) {
		boolean sourceValid=false;
		try {
			sourceValid=ValidateXMLTester.validateXML(sourcePath, sourceXSD);
		} catch (SAXException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ��������
		Stu[] list = new Stu[11];
		list[0] = new Stu("141250206", "����", "��", "1996-01-01", "311302199601015327", "18260039583");
		list[1] = new Stu("141250160", "�콭��", "��", "1996-02-02", "311302199602025327", "18260039584");
		list[2] = new Stu("141250050", "����", "Ů", "1996-03-03", "311302199603035327", "18260039582");
		list[3] = new Stu("141250076", "��ѿ�", "��", "1996-08-08", "311302199608085327", "18260039589");
		list[4] = new Stu("141250068", "���ҳ�", "��", "1996-11-02", "311302199611025327", "18260039585");
		list[5] = new Stu("141250085", "�޽��", "��", "1997-02-19", "311302199702195327", "18260032917");
		list[6] = new Stu("141250167", "���", "��", "1996-04-04", "311302199604045327", "13270807992");
		list[7] = new Stu("141250036", "���ֻ�", "��", "1996-05-05", "311302199605055327", "18260039586");
		list[8] = new Stu("141250021", "���ҳ�", "��", "1996-06-06", "311302199606065327", "18260039587");
		list[9] = new Stu("141250075", "���¿�", "��", "1996-07-07", "311302199607075327", "18260039588");
		if(sourceValid==true){
			list[10] = DOMReader.readXMLFile(sourcePath).get(0);
		}else{
			list[10]=null;
		}
		Map<String, String> sourceMap = getSourceMap();

		// step1:���һ��DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// step2:���һ��DocumentBuilder
		DocumentBuilder db = null;
		try {
			db = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step3:�½�һ��Document����
		Document document = db.newDocument();
		// step4:����һ�����ڵ�
		Element studentList = document.createElement("ѧ���б�");
		studentList.setAttribute("xmlns", sourceMap.get("xmlns"));
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				Map<String, String> map = getMap(sourceMap, list[i]);
				Element student = generateElement(document, map);
				Element courseList;
				if (i != list.length - 1) {
					courseList = getCourseList(document, map);
				} else {
					courseList = getMyCourseList(document, map, list[list.length-1]);
				}
				student.appendChild(courseList);
				studentList.appendChild(student);
			}
		}
		document.appendChild(studentList);
		generateXMLByDom(path, document);
	}

	/**
	 * @return ��ð���������Ϣ��Map�ṹ
	 */
	public static Map<String, String> getSourceMap() {
		Map<String, String> map = new HashMap<String, String>();
		// map.put("ѧ��", "141250027");//
		map.put("xmlns", "http://jw.nju.edu.cn/schema");
		map.put("�꼶", "����");
		// map.put("����", "ۡ˼ŵ");//
		// map.put("�Ա�", "Ů");//
		// map.put("��������", "1996-04-01");//
		// map.put("���֤��", "311302199604015327");//
		map.put("��������", "����");
		map.put("����״��", "δ��");
		// map.put("�ֻ�����", "13912993960");//-
		map.put("��ַ", "����ʡ�Ͼ��й�¥������·22��");
		map.put("��������", "Ժ");
		map.put("��������", "���ѧԺ");
		map.put("���ŵ绰", "025-89680208");
		map.put("���ű��", "125109");
		map.put("��������", "����");
		map.put("��������", "������׿Խ�ҽܳ��ĸ������������ʦΪĿ��");

		map.put("�γ̱��1", "25000100");
		map.put("�γ̱��2", "25000101");
		map.put("�γ̱��3", "25000102");
		map.put("�γ̱��4", "25000103");
		map.put("�γ̱��5", "25000104");

		map.put("�ɼ�����1", "ƽʱ�ɼ�");
		map.put("�ɼ�����2", "��ĩ�ɼ�");
		map.put("�ɼ�����3", "�����ɼ�");

		return map;
	}

	/**
	 * ��ѧ��ʵ���в�ͬ�����Բ���Map��
	 * 
	 * @param map
	 * @param student
	 * @return
	 */
	public static Map<String, String> getMap(Map<String, String> map, Stu student) {
		map.put("ѧ��", student.getStudentNo());//
		map.put("����", student.getName());//
		map.put("�Ա�", student.getSex());//
		map.put("��������", student.getBirthDate());//
		map.put("���֤��", student.getId());//
		map.put("�ֻ�����", student.getPhoneNum());//
		return map;
	}

	/**
	 * ͨ��Map������Sudent��Element
	 * 
	 * @param document
	 * @param map
	 * @return
	 */
	public static Element generateElement(Document document, Map<String, String> map) {
		Element student = document.createElement("ѧ��");
		// student.setAttribute("xmlns", map.get("xmlns"));
		student.setAttribute("ѧ��", map.get("ѧ��"));

		Element grade = document.createElement("�꼶");
		grade.setTextContent(map.get("�꼶"));

		Element baseInfo = document.createElement("���˻�����Ϣ");
		baseInfo.setAttribute("xmlns", "http://www.nju.edu.cn/schema");

		Element name = document.createElement("����");
		name.setTextContent(map.get("����"));

		Element sex = document.createElement("�Ա�");
		sex.setTextContent(map.get("�Ա�"));

		Element birth = document.createElement("��������");
		birth.setTextContent(map.get("��������"));

		Element id = document.createElement("���֤��");
		id.setTextContent(map.get("���֤��"));

		Element background = document.createElement("��������");
		background.setTextContent(map.get("��������"));

		Element marital = document.createElement("����״��");
		marital.setTextContent(map.get("����״��"));

		Element phoneNum = document.createElement("�ֻ�����");
		phoneNum.setTextContent(map.get("�ֻ�����"));

		Element address = document.createElement("��ַ");
		address.setTextContent(map.get("��ַ"));

		Element department = document.createElement("����");
		department.setAttribute("��������", map.get("��������"));
		department.setAttribute("��������", map.get("��������"));
		department.setAttribute("���ű��", map.get("���ű��"));

		Element departmentManager = document.createElement("��������");
		departmentManager.setTextContent(map.get("��������"));

		Element departmentDescription = document.createElement("��������");
		departmentDescription.setTextContent(map.get("��������"));

		baseInfo.appendChild(name);
		baseInfo.appendChild(sex);
		baseInfo.appendChild(birth);
		baseInfo.appendChild(id);
		baseInfo.appendChild(background);
		baseInfo.appendChild(marital);
		baseInfo.appendChild(phoneNum);
		baseInfo.appendChild(address);

		department.appendChild(departmentManager);
		department.appendChild(departmentDescription);

		baseInfo.appendChild(department);

		student.appendChild(grade);
		student.appendChild(baseInfo);
		return student;
	}

	public static Element getMyCourseList(Document document, Map<String, String> map, Stu student) {
		Element courseList = document.createElement("�γ̳ɼ��б�");
		// courseList.setAttribute("xmlns", "http://jw.nju.edu.cn/schema");
		List<CourseScore> csList = student.getScoreList();
//		System.out.println(student.toString());
		if(csList==null){
			return null;
		}
		for (int i = 0; i < csList.size(); i++) {
			Element courseScore = document.createElement("�γ̳ɼ�");
			CourseScore cs = csList.get(i);
			courseScore.setAttribute("�ɼ�����", cs.getCourseAttr());
			courseScore.setAttribute("�γ̱��", cs.getCourseNo());

			Element score = document.createElement("�ɼ�");

			Element studentNum = document.createElement("ѧ��");
			studentNum.setTextContent(student.getStudentNo());
			Element concreteScore = document.createElement("�÷�");
			concreteScore.setTextContent(cs.getRealScore() + "");

			score.appendChild(studentNum);
			score.appendChild(concreteScore);
			courseScore.appendChild(score);

			courseList.appendChild(courseScore);
		}
		return courseList;
	}

	public static Element getCourseList(Document document, Map<String, String> map) {
		Element courseList = document.createElement("�γ̳ɼ��б�");
		// courseList.setAttribute("xmlns", "http://jw.nju.edu.cn/schema");

		// ������ɳɼ�
		int[][] scoreArr = new int[5][3];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 2; j++) {
				scoreArr[i][j] = (int) (60 + 40 * (Math.random() - 0.5));
			}
			scoreArr[i][2] = (int) Math.floor(scoreArr[i][0] * 0.2 + scoreArr[i][1] * 0.8);
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				Element courseScore = document.createElement("�γ̳ɼ�");
				courseScore.setAttribute("�ɼ�����", map.get("�ɼ�����" + (j + 1)));
				courseScore.setAttribute("�γ̱��", map.get("�γ̱��" + (i + 1)));
				Element score = document.createElement("�ɼ�");

				Element studentNum = document.createElement("ѧ��");
				studentNum.setTextContent(map.get("ѧ��"));
				Element concreteScore = document.createElement("�÷�");
				concreteScore.setTextContent(scoreArr[i][j] + "");

				score.appendChild(studentNum);
				score.appendChild(concreteScore);
				courseScore.appendChild(score);

				courseList.appendChild(courseScore);
			}
		}
		return courseList;
	}

	/**
	 * ��Documentд��ָ��·�����ļ���
	 * 
	 * @param path
	 * @param document
	 */
	public static void generateXMLByDom(String path, Document document) {
		// step9:���һ��TransformerFactory����
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		// step10:���һ��Transformer����
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step11:����Transformer���������
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

		// step12:�������洢Ŀ�����
		// Result outputTarget = new StreamResult(new File(path));
		StreamResult outputTarget = new StreamResult(new File(path));
		// step13:������Ӧ��xml�ļ�
		try {
			transformer.transform(xmlSource, outputTarget);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Have written the " + path + " file!");
	}
}
