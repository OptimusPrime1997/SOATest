<%@page import="entity.Score"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<title>Search</title>


<style>
.col-center-block {
	float: none;
	display: block;
	margin-left: auto;
	margin-right: auto;
}

.blank20 {
	height: 20px;
	clear: both;
	font-size: 0em;
	overflow: hidden;
}

button.link {
	font-size: 1em;
	text-align: left;
	color: blue;
	background: none;
	margin: 0;
	padding: 0;
	border: none;
	cursor: pointer;
	outline: none;
}
</style>
</head>
<body>

	<jsp:useBean id="scoreList" type="entity.ScoreList" scope="session"></jsp:useBean>
	<jsp:useBean id="item" class="entity.Score" scope="page"></jsp:useBean>


	<div class="container">
		<div class="col-md-7 col-center-block">
			<form class="form-horizontal" role="form"
				action="<%=response.encodeURL(request.getContextPath() + "/ScoreClientServlet")%>"
				method="post">
				<div id="legend" class="form-group text-center">
					<legend class="text-center">
						<h2>成绩查询</h2>
					</legend>
				</div>
				<div class="form-group">
					<label for="studentId" class="col-sm-2 control-label">学号</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="studentId"
							placeholder="9位学生学号" required autofocus>
					</div>
					<div class="col-sm-2">
						<!-- <button type="submit" class="btn btn-default">提交</button> -->
						<button type="submit" class="btn btn-success" id="loginBt">
							<span class="glyphicon glyphicon-search"></span> 搜索
						</button>
					</div>
				</div>
			</form>
			<form class="form-horizontal" role="form"
				action="<%=response.encodeURL(request.getContextPath() + "/ScoreAddServlet")%>"
				method="post">
				<div id="legend" class="form-group text-center">
					<legend class="text-center">
						<h2>新增成绩</h2>
					</legend>
				</div>
				<div class="form-group">
					<label for="studentId" class="col-sm-2 control-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="studentId"
							placeholder="9位学生学号" required autofocus>
					</div>
				</div>
				<div class="form-group">
					<label for="studentId" class="col-sm-2 control-label">课程编号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="courseNo"
							placeholder="6位课程编号" required>
					</div>
				</div>
				<div class="form-group">
					<label for="studentId" class="col-sm-2 control-label">成绩性质</label>
					<div class="col-sm-10">
						<!-- <input type="text" class="form-control" name="scoreAttr"
							placeholder="9位学生学号" required > -->
						<!-- <div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">
								平时成绩 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">平时成绩</a></li>
								<li><a href="#">期末成绩</a></li>
								<li><a href="#">总评成绩</a></li>
							</ul>
						</div> -->
						<div class="btn-group">
							<select class="form-control text-center" name="courseAttr">
								<option value="1" selected>平时成绩</option>
								<option value="2">期末成绩</option>
								<option value="3">总评成绩</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="studentId" class="col-sm-2 control-label">得&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="score"
							placeholder="课程分数范围为0~100" required>
					</div>
				</div>
				<div class="text-center center">
					<button type="submit" class="btn btn-success" id="addScoreBtn">
						<span class="glyphicon glyphicon-plus"></span> 增加成绩
					</button>
				</div>
			</form>
		</div>


		<div class="blank20"></div>
		<div class="col-xs-12 col-md-7 col-center-block">
			<table class="table table-striped ">
				<caption class="text-center">
					<h2>成绩表单列表</h2>
				</caption>

				<thead>
					<tr>
						<th class="text-center">学号</th>
						<th class="text-center">课程编号</th>
						<th class="text-center">成绩性质</th>
						<th class="text-center">得分</th>
						<th class="text-center">修改</th>
						<th class="text-center">删除</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < scoreList.getScoreList().size(); i++) {
							Score score = scoreList.getScoreList().get(i);
							pageContext.setAttribute("item", score);
					%>
					<tr>
						<td><jsp:getProperty name="item" property="studentId" /></td>
						<td><jsp:getProperty name="item" property="courseId" /></td>
						<td><jsp:getProperty name="item" property="scoreType" /></td>
						<td><jsp:getProperty name="item" property="score" /></td>
						<td><button class="link"
								onClick="javascript:window.location.href ='updatescore.jsp?studentId=<%=score.getStudentId()%>&courseId=<%=score.getCourseId()%>&scoreType=<%=score.getScoreType()%>&score=<%=score.getScore()%>'">修改成绩</button></td>
						<td><button class="link"
								onClick="deleteScore(<%=score.getStudentId()%>,<%=score.getCourseId()%>,'<%=score.getScoreType()%>')">删除成绩</button></td>
						<%-- &scoreType=<%=score.getScoreType()%> --%>
					</tr>
					<%
						}
					%>

				</tbody>
			</table>
		</div>
		<form class="hidden"
			action=<%=response.encodeURL(request.getContextPath() + "/ScoreDeleteServlet")%>
			method="post">
			<input name="studentId" id="studentId"> <input
				name="courseNo" id="courseNo"> <input name="scoreType"
				id="scoreType"> <input type="submit" id="submitBtn">
		</form>
	</div>
	<script>
		function deleteScore(studentId, courseNo, scoreType) {
			document.getElementById("studentId").value = studentId;
			document.getElementById("courseNo").value = courseNo;
			document.getElementById("scoreType").value = scoreType;
			 document.getElementById("submitBtn").click(); 
			/* with (document.getElementById("submitBtn")) {  
	             method = "post";  
	            action = "item.do?command=modify&pageNo=${itemForm.pageNo}";   
	            submit();  
	        }   */
		}
	</script>





	<!-- jQuery文件,务必在bootstrap.min.js 之前引入 -->
	<script
		src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>