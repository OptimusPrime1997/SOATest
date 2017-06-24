<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>StudentMangement</title>
<link
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
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
	<div class="container">
		<div class="col-md-7 col-center-block">
			<form class="form-horizontal" role="form"
				action="<%=response.encodeURL(request.getContextPath() + "/LoginServlet")%>"
				method="post">
				<div id="legend" class="form-group text-center">
					<legend class="text-center">
						<h2>用户登录</h2>
					</legend>
				</div>
				<div class="form-group">
					<label for="studentId" class="col-sm-2 control-label text-center">邮箱</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="email"
							placeholder="NJU校邮" required autofocus>
					</div>
					<div class="blank20" />
				</div>
				<div class="form-group">
					<label for="studentId" class="col-sm-2 control-label text-center">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password"
							placeholder="" required>
					</div>
					<div class="blank20" />
				</div>
				<div class="col-sm-2 col-sm-offset-5">
					<!-- <button type="submit" class="btn btn-default">提交</button> -->
					<button type="submit" class="btn btn-success" id="loginBt">
						<span class="glyphicon glyphicon-search"></span> 登录
					</button>
				</div>
		</div>
		</form>
	</div>
	</div>
</body>
<!-- jQuery文件,务必在bootstrap.min.js 之前引入 -->
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>