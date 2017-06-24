package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import entity.ScoreList;
import service.SoapService;

/**
 * Servlet implementation class ScoreUpdateServerServlet
 */
@WebServlet("/ScoreUpdateServerServlet")
public class ScoreUpdateServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SoapService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreUpdateServerServlet() {
        super();
        service = new SoapService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ScoreList  list = null;
		SOAPMessage returnMessage = null;
		try {
			//获取封装好soap消息
			SOAPMessage requestMessage = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage(null,request.getInputStream());
			System.out.println("==========ScoreUpdateServerServlet接受的soap消息 begin==========");
			requestMessage.writeTo(System.out);
			System.out.println();
			System.out.println("==========ScoreUpdateServerServlet接受的soap消息 end==========");
			System.out.println();

			
			
			//解析获取到的soap消息
			list = service.getScoreFromMessage(requestMessage);

			returnMessage = service.updateStudentScore(list);

		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMessage = service.createInnerErrorMessage("更新失败");
			response.setStatus(500);

		} 

		try {
			System.out.println("==========ScoreUpdateServerServlet发出的soap消息 begin==========");
			returnMessage.writeTo(System.out);
			System.out.println();
			System.out.println("==========ScoreUpdateServerServlet发出的soap消息 end==========");
			System.out.println();

			returnMessage.writeTo(response.getOutputStream());

		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
