package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ScoreAddServlet")
public class ScoreAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		String studentId = req.getParameter("studentId");
		String courseNo = req.getParameter("courseNo");
		String courseAttr = req.getParameter("scoreType");
		String score = req.getParameter("score");
		System.out.println(
				"studentId:" + studentId + "-courseNo:" + courseNo + "-scoreType:" + courseAttr + "-score:" + score);
	}

}
