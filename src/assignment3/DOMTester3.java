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
 * @author OptimusPrime 生成复合要求的XML文件
 */
public class DOMTester3 {
	/**
	 * @param args
	 *            主方法
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
	 *            构造数据，并生成XML文件
	 */
	public static void generateXML(String sourcePath,String sourceXSD,String path) {
		boolean sourceValid=false;
		try {
			sourceValid=ValidateXMLTester.validateXML(sourcePath, sourceXSD);
		} catch (SAXException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 构造数据
		Stu[] list = new Stu[11];
		list[0] = new Stu("141250206", "周锐", "男", "1996-01-01", "311302199601015327", "18260039583");
		list[1] = new Stu("141250160", "徐江成", "男", "1996-02-02", "311302199602025327", "18260039584");
		list[2] = new Stu("141250050", "花蕾", "女", "1996-03-03", "311302199603035327", "18260039582");
		list[3] = new Stu("141250076", "李佳俊", "男", "1996-08-08", "311302199608085327", "18260039589");
		list[4] = new Stu("141250068", "梁家诚", "男", "1996-11-02", "311302199611025327", "18260039585");
		list[5] = new Stu("141250085", "罗金宏", "男", "1997-02-19", "311302199702195327", "18260032917");
		list[6] = new Stu("141250167", "杨华安", "男", "1996-04-04", "311302199604045327", "13270807992");
		list[7] = new Stu("141250036", "傅林华", "男", "1996-05-05", "311302199605055327", "18260039586");
		list[8] = new Stu("141250021", "崔忠诚", "男", "1996-06-06", "311302199606065327", "18260039587");
		list[9] = new Stu("141250075", "刘德宽", "男", "1996-07-07", "311302199607075327", "18260039588");
		if(sourceValid==true){
			list[10] = DOMReader.readXMLFile(sourcePath).get(0);
		}else{
			list[10]=null;
		}
		Map<String, String> sourceMap = getSourceMap();

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
		Element studentList = document.createElement("学生列表");
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
	 * @return 获得包含公共信息的Map结构
	 */
	public static Map<String, String> getSourceMap() {
		Map<String, String> map = new HashMap<String, String>();
		// map.put("学号", "141250027");//
		map.put("xmlns", "http://jw.nju.edu.cn/schema");
		map.put("年级", "大三");
		// map.put("姓名", "邸思诺");//
		// map.put("性别", "女");//
		// map.put("出生日期", "1996-04-01");//
		// map.put("身份证号", "311302199604015327");//
		map.put("教育背景", "本科");
		map.put("婚姻状况", "未婚");
		// map.put("手机号码", "13912993960");//-
		map.put("地址", "江苏省南京市鼓楼区汉口路22号");
		map.put("部门属性", "院");
		map.put("部门名称", "软件学院");
		map.put("部门电话", "025-89680208");
		map.put("部门编号", "125109");
		map.put("部门主管", "陈琳");
		map.put("部门描述", "以培养卓越且杰出的高素质软件工程师为目标");

		map.put("课程编号1", "25000100");
		map.put("课程编号2", "25000101");
		map.put("课程编号3", "25000102");
		map.put("课程编号4", "25000103");
		map.put("课程编号5", "25000104");

		map.put("成绩性质1", "平时成绩");
		map.put("成绩性质2", "期末成绩");
		map.put("成绩性质3", "总评成绩");

		return map;
	}

	/**
	 * 将学生实例中不同的属性插入Map中
	 * 
	 * @param map
	 * @param student
	 * @return
	 */
	public static Map<String, String> getMap(Map<String, String> map, Stu student) {
		map.put("学号", student.getStudentNo());//
		map.put("姓名", student.getName());//
		map.put("性别", student.getSex());//
		map.put("出生日期", student.getBirthDate());//
		map.put("身份证号", student.getId());//
		map.put("手机号码", student.getPhoneNum());//
		return map;
	}

	/**
	 * 通过Map来构造Sudent的Element
	 * 
	 * @param document
	 * @param map
	 * @return
	 */
	public static Element generateElement(Document document, Map<String, String> map) {
		Element student = document.createElement("学生");
		// student.setAttribute("xmlns", map.get("xmlns"));
		student.setAttribute("学号", map.get("学号"));

		Element grade = document.createElement("年级");
		grade.setTextContent(map.get("年级"));

		Element baseInfo = document.createElement("个人基本信息");
		baseInfo.setAttribute("xmlns", "http://www.nju.edu.cn/schema");

		Element name = document.createElement("姓名");
		name.setTextContent(map.get("姓名"));

		Element sex = document.createElement("性别");
		sex.setTextContent(map.get("性别"));

		Element birth = document.createElement("出生日期");
		birth.setTextContent(map.get("出生日期"));

		Element id = document.createElement("身份证号");
		id.setTextContent(map.get("身份证号"));

		Element background = document.createElement("教育背景");
		background.setTextContent(map.get("教育背景"));

		Element marital = document.createElement("婚姻状况");
		marital.setTextContent(map.get("婚姻状况"));

		Element phoneNum = document.createElement("手机号码");
		phoneNum.setTextContent(map.get("手机号码"));

		Element address = document.createElement("地址");
		address.setTextContent(map.get("地址"));

		Element department = document.createElement("部门");
		department.setAttribute("部门属性", map.get("部门属性"));
		department.setAttribute("部门名称", map.get("部门名称"));
		department.setAttribute("部门编号", map.get("部门编号"));

		Element departmentManager = document.createElement("部门主管");
		departmentManager.setTextContent(map.get("部门主管"));

		Element departmentDescription = document.createElement("部门描述");
		departmentDescription.setTextContent(map.get("部门描述"));

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
		Element courseList = document.createElement("课程成绩列表");
		// courseList.setAttribute("xmlns", "http://jw.nju.edu.cn/schema");
		List<CourseScore> csList = student.getScoreList();
//		System.out.println(student.toString());
		if(csList==null){
			return null;
		}
		for (int i = 0; i < csList.size(); i++) {
			Element courseScore = document.createElement("课程成绩");
			CourseScore cs = csList.get(i);
			courseScore.setAttribute("成绩性质", cs.getCourseAttr());
			courseScore.setAttribute("课程编号", cs.getCourseNo());

			Element score = document.createElement("成绩");

			Element studentNum = document.createElement("学号");
			studentNum.setTextContent(student.getStudentNo());
			Element concreteScore = document.createElement("得分");
			concreteScore.setTextContent(cs.getRealScore() + "");

			score.appendChild(studentNum);
			score.appendChild(concreteScore);
			courseScore.appendChild(score);

			courseList.appendChild(courseScore);
		}
		return courseList;
	}

	public static Element getCourseList(Document document, Map<String, String> map) {
		Element courseList = document.createElement("课程成绩列表");
		// courseList.setAttribute("xmlns", "http://jw.nju.edu.cn/schema");

		// 随机生成成绩
		int[][] scoreArr = new int[5][3];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 2; j++) {
				scoreArr[i][j] = (int) (60 + 40 * (Math.random() - 0.5));
			}
			scoreArr[i][2] = (int) Math.floor(scoreArr[i][0] * 0.2 + scoreArr[i][1] * 0.8);
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				Element courseScore = document.createElement("课程成绩");
				courseScore.setAttribute("成绩性质", map.get("成绩性质" + (j + 1)));
				courseScore.setAttribute("课程编号", map.get("课程编号" + (i + 1)));
				Element score = document.createElement("成绩");

				Element studentNum = document.createElement("学号");
				studentNum.setTextContent(map.get("学号"));
				Element concreteScore = document.createElement("得分");
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
