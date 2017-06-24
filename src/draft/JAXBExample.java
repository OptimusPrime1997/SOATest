package draft;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import assignment9.model.StudentListType;
import assignment9.model.StudentType;

//import assignment9.ObjectFactory;
//import assignment9.学生信息;

public class JAXBExample {
	public static void main(String[] args) {
//		xml2Java3();
		xml2Java4();
	}

	public static void java2Xml() {
		Customer objectFactory = new Customer();
		objectFactory.setId(100);
		objectFactory.setName("mkyong");
		objectFactory.setAge(29);

		try {

			File file = new File("xml/file.xml");
			if (!file.exists()) {
				file.createNewFile();
			}
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(objectFactory, file);
			jaxbMarshaller.marshal(objectFactory, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void xml2Java() {
		File file = new File("xml/file.xml");
		// String xmlStr = FileUtils.readFileToString(file , "UTF-8");
		// Reader reader = new StringReader(xmlStr);
		// BufferedReader reader;
		// Result result;
		// try {
		// if(!file.exists()){
		// file.createNewFile();
		// }
		// reader = new BufferedReader(new FileReader(file));
		// Unmarshaller unmarshaller =
		// JAXBContext.newInstance(Result.class).createUnmarshaller();
		// result = (Result) unmarshaller.unmarshal(reader);
		// } catch (JAXBException | IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// List<Result.DocInfo.Field> list = result.getDocInfo().getField();
		// List<Attachment> eFileList = result.getAttachments().getAttachment();
		// for (Attachment efile : eFileList) {
		// System.out.println(efile.getFtpdir());
		// }
	}

	public static void xml2Java2() {
		// URL url = Customer.class.getResource(DIR+"address.xml");
		File file = new File("xml/file.xml");
		JAXBContext jc = null;
		Customer objectFactoryVO = null;
		try {
			jc = JAXBContext.newInstance(Customer.class);
			Unmarshaller unMarshaller = jc.createUnmarshaller();
			objectFactoryVO = (Customer) unMarshaller.unmarshal(file);
			System.out.println(objectFactoryVO.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void xml2Java3() {
		// URL url = Customer.class.getResource(DIR+"address.xml");
		File file = new File("src/assignment3/XML文档1.xml");
		JAXBContext jc = null;
		StudentType studentInfo = null;
		try {
			jc = JAXBContext.newInstance(StudentType.class);
			Unmarshaller unMarshaller = jc.createUnmarshaller();
			studentInfo = (StudentType) unMarshaller.unmarshal(file);
			System.out.println(studentInfo.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void xml2Java4() {
		// URL url = Customer.class.getResource(DIR+"address.xml");
		File file = new File("src/assignment3/XML文档2.xml");
		JAXBContext jc = null;
		StudentListType studentList = null;
		try {
			jc = JAXBContext.newInstance(StudentListType.class);
			Unmarshaller unMarshaller = jc.createUnmarshaller();
			studentList = (StudentListType) unMarshaller.unmarshal(file);
			System.out.println(studentList.toString());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}