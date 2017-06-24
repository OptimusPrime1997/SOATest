package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import service.SoapService;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/StudentScoreServlet")
public class StudentScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SoapService soapService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentScoreServlet() {
		// TODO Auto-generated constructor stub
		super();
		soapService = new SoapService();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		
		SOAPMessage message = null;
		try {
			message = soapService.getStudentScoreById(id, "成绩操作", "成绩查询");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			message = soapService.createInnerErrorMessage("查询失败");
			response.setStatus(500);
			
		}

		try {
			
			System.out.println("==========StudentScoreServlet发出的soap消息 begin==========");
			message.writeTo(System.out);
			System.out.println();
			System.out.println("==========StudentScoreServlet发出的soap消息 end==========");
			System.out.println();

			response.setContentType("application/xml;charset=utf-8");
			message.writeTo(response.getOutputStream());

		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
