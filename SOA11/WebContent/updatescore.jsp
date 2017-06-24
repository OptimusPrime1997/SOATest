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
</style>
</head>
<body>
	<div class="container">
		<div class="row clearfix ">
			<div class="col-md-7 column col-center-block">
				<form class="form-horizontal" role="form"
					action="<%=response.encodeURL(request.getContextPath() + "/ScoreUpdateClientServlet")%>"
					method="post">
					<div id="legend" class="form-group">
						<legend>成绩修改</legend>
					</div>

					<div class="form-group">
						<label for="studentId" class="col-sm-2 control-label">学号</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="studentId"
								value=<%=request.getParameter("studentId")%> readonly="true" />
						</div>
					</div>
					<div class="form-group">
						<label for="courseId" class="col-sm-2 control-label">课程编号</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="courseId"
								value=<%=request.getParameter("courseId")%> readonly="true" />
						</div>
					</div>
					<div class="form-group">
						<label for="scoreType" class="col-sm-2 control-label">成绩性质</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="scoreType"
								value=<%=request.getParameter("scoreType")%> readonly="true" />
						</div>
					</div>
					<div class="form-group">
						<label for="score" class="col-sm-2 control-label">得分</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="score"
								value=<%=request.getParameter("score")%> />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>






	<!-- jQuery文件,务必在bootstrap.min.js 之前引入 -->
	<script
		src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>