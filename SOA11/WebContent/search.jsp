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
		<div class="col-md-7 col-center-block">
			<form class="form-horizontal" role="form"
			
				action="<%=response.encodeURL(request.getContextPath()+"/ScoreClientServlet")%>" method="post">
				<div id="legend" class="form-group">
					<legend>成绩查询</legend>
				</div>
				<div class="form-group">
					<label for="studentId" class="col-sm-2 control-label">学号</label>

					<div class="col-sm-8">
						<input type="text" class="form-control" name="studentId"
							placeholder="9位学生学号" required autofocus>
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

	<!-- jQuery文件,务必在bootstrap.min.js 之前引入 -->
	<script
		src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>