package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import entity.ScoreList;
import service.SoapService;

/**
 * Servlet implementation class ScoreClientServlet
 */
@WebServlet("/ScoreClientServlet")
public class ScoreClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SoapService soapService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScoreClientServlet() {
		super();
		soapService = new SoapService();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("studentId");
		if (id == null) {
			id = "141250052";
		}
		// 生成soap消息
		SOAPMessage message = soapService.createStudentIdMessage(id);

		try {
			System.out.println("==========ScoreClientServlet发出的soap消息 begin==========");
			message.writeTo(System.out);
			System.out.println();
			System.out.println("==========ScoreClientServlet发出的soap消息 end==========");
			System.out.println();

		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 构造服务端的URL
		StringBuffer serverUrl = new StringBuffer();
		serverUrl.append(request.getScheme()).append("://").append(request.getServerName());
		serverUrl.append(":").append(request.getServerPort()).append(request.getContextPath())
				.append("/ScoreServerServlet");
		String baseURL = serverUrl.toString();

		// 将soap消息转交给ScoreServerServlet，并获取返回的soap消息
		SOAPMessage returnMessage = soapService.getMessageFromServer(baseURL, message);
		try {
			// 输出soap信息结果
			System.out.println("==========ScoreClientServlet接受的soap消息 begin==========");

			returnMessage.writeTo(System.out);
			System.out.println();
			System.out.println("==========ScoreClientServlet接受的soap消息 end==========");
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
		}

		// 对获取的soap消息进行解析
		ScoreList list = soapService.getScoreFromMessage(returnMessage);
		System.out.println("List :");
		if (list == null) {
			try {
				response.setContentType("application/xml;charset=utf-8");
				returnMessage.writeTo(response.getOutputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			// 展示成绩
			request.getSession().setAttribute("scoreList", list);
//			response.sendRedirect(request.getContextPath() + "/scoreview.jsp");
			request.getRequestDispatcher(response.encodeURL("/scoreview.jsp")).forward(request, response);
		}

	}

}
