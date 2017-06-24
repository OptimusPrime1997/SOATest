package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;


import entity.Score;
import entity.ScoreList;
import service.SoapService;

/**
 * Servlet implementation class ScoreUpdateClientServlet
 */
@WebServlet("/ScoreUpdateClientServlet")
public class ScoreUpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SoapService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScoreUpdateClientServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String studentId = request.getParameter("studentId");
		String courseId = request.getParameter("courseId");
		String scoreType = request.getParameter("scoreType");
		String scoreNum = request.getParameter("score");
		ScoreList list = new ScoreList();

		Score score = new Score(courseId,scoreType, studentId, scoreNum);
		list.addScore(score);
		//生成soap消息
		SOAPMessage message = service.createUpdateMessage(list);
		try {
			System.out.println("==========ScoreUpdateClientServlet发出的soap消息 begin==========");
			message.writeTo(System.out);
			System.out.println();
			System.out.println("==========ScoreUpdateClientServlet发出的soap消息 end==========");		
			System.out.println();


		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer serverUrl = new StringBuffer();
		serverUrl.append(request.getScheme()).append("://").append(request.getServerName());
		serverUrl.append(":").append(request.getServerPort()).append(request.getContextPath()).append("/ScoreUpdateServerServlet");
		String baseURL = serverUrl.toString();

		//将soap消息转交给ScoreServerServlet，并获取返回的soap消息
		SOAPMessage returnMessage = service.getMessageFromServer(baseURL, message);
		try {
			//输出soap信息结果
			System.out.println("==========ScoreUpdateClientServlet接受的soap消息 begin==========");
			returnMessage.writeTo(System.out);
			System.out.println();
			System.out.println("==========ScoreUpdateClientServlet接受的soap消息 end==========");
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
		}

		//对获取的soap消息进行解析
		ScoreList returnList = service.getScoreFromMessage(returnMessage);


		if(returnList == null){
			try {
				response.setContentType("application/xml;charset=utf-8");
				returnMessage.writeTo(response.getOutputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else{
			//展示成绩
			request.getSession().setAttribute("scoreList", returnList);
			response.sendRedirect(request.getContextPath() + "/scoreview.jsp");
		}






	}

}
