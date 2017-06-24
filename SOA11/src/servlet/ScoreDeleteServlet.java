package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ScoreDeleteServlet")
public class ScoreDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		System.out.println("ScoreDeleteServlet excute!");
		String studentId = req.getParameter("studentId");
		String courseNo = req.getParameter("courseNo");
		String scoreType = req.getParameter("scoreType");
		System.out.println("studentId:" + studentId + "-courseNo:" + courseNo + "-scoreType:" + scoreType);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
