<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'vehicleCheck.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("[name='select']").focus(function() {
			$("[name='select']").val("");
		});
		$("[name='select']").blur(function() {
			$("[name='select']").val("请输入车牌号或驾驶员姓名 ");
		});

		$("#foot>a:eq(0)").click(function() {
			alert(12);
			return false;
		});
		$("#foot>a:eq(1)").click(function() {
			alert(34);
			return false;
		});
		$("#foot>a:eq(2)").click(function() {
			alert(56);
			return false;
		});
		$("#foot>a:eq(3)").click(function() {
			alert(78);
			return false;
		});
		/* 
		 $("ul li a:eq(0)").click(function() {
		 $("li").css("background-color", "#fff");
		 $(this).parent().css("background-color", "#5B9BD5");
		 $("#shenhe").hide();
		 $("#weishenhe").show();
		 })

		 $("ul li a:eq(1)").click(function() {
		 $("li").css("background-color", "#fff");
		 $(this).parent().css("background-color", "#5B9BD5");
		 $("#shenhe").show();
		 $("#weishenhe").hide();
		 })
		 */
	});
</script>
<style>
* {
	margin: 0;
	padding: 0px;
}

#box,#foot {
	width: 1150px;
	margin-left: 10px;
}

#top {
	margin-top: 6px;
}

#top ul li,#top ul select {
	float: left;
	width: 140px;
	height: 40px;
	border: 1px solid #41719C;
	line-height: 40px;
	text-align: center;
	border-radius: 5px 5px 5px 5px;
	list-style: none;
	margin: 5px;
	color: #FFFFFF;
	font-size: 25px;
	font-weight: 700;
	background-color: #5B9BD5;
}

#top ul li select {
	color: #f00;
	font-size: 28px;
	text-decoration: none;
}

#top form {
	float: left;
	margin-top: 5px;
}

#top form input {
	width: 425px;
	height: 40px;
	font-size: 22px;
	text-align: center;
	border-radius: 5px 5px 5px 5px;
}

#weishenhe table {
	width: 1150px;
	font-size: 22px;
	text-align: center;
}

#weishenhe table tr:nth-child(2n) {
	background-color: #D2DEEF;
}

#weishenhe table tr:nth-child(2n+1) {
	background-color: #EAEFF7;
}

#weishenhe table tr td {
	color: black;
	line-height: 75px;
	height: 75px;
}

#weishenhe table tr th {
	height: 50px;
	color: white;
	text-align: center;
	background-color: #5B9BD5;
	border-bottom: 3px solid #FFFFFF;
}

#weishenhe table tr td a {
	text-decoration: none;
	color: #fff;
	background-color: #C5DDF1;
	font-size: 20px;
	border: 1px solid #41719C;
	border-radius: 5px 5px 5px 5px;
}

#shenhe {
	width: 1150px;
}

#shenhe table {
	width: 1150px;
	font-size: 22px;
	text-align: center;
}

#shenhe table tr:nth-child(2n) {
	background-color: #D2DEEF;
}

#shenhe table tr:nth-child(2n+1) {
	background-color: #EAEFF7;
}

#shenhe table tr td {
	color: black;
	text-align: center;
	height: 65px;
	line-height: 65px;
	border-bottom: 1px solid #fff;
}

#shenhe table tr th {
	color: white;
	text-align: center;
	background-color: #5B9BD5;
	height: 50px;
	line-height: 50px;
	border-bottom: 3px solid #FFFFFF;
}

#shenhe table tr td a {
	text-decoration: none;
	color: #fff;
	background-color: #C5DDF1;
	font-size: 16px;
	border: 1px solid #41719C;
	border-radius: 5px 5px 5px 5px;
}

#foot {
	margin-left: 3px;
	width: 1150px;
	height: 50px;
	background-color: #5B9BD5;
	font-size: 16px;
	color: white;
	text-align: center;
	font-size: 25px;
	font-weight: 700;
	border-bottom: 3px solid #FFFFFF;
	line-height: 50px;
	width: 1150px;
}

#foot a {
	margin: 80px;
	text-decoration: none;
	color: white;
}
</style>
</head>

<body>
	<div id="box">
		<!--上部分  -->
		<div id="top">


			<ul>
				<li><p>审核状态</p></li>
				<select>
					<option value="0">全部</option>
					<option value="1">未审核</option>
					<option value="2">未通过</option>
					<option value="3">已通过</option>
				</select>
			</ul>
			<form action="#" method="post" style="margin-left: 100px;">
				 <input
					type="submit" value="查询"
					style="width: 160px; height: 40px;  background-color:#5B9BD5; border: 1px #7F7F7F solid; color: white; font-weight: 700; border-radius:5px 5px 5px 5px;">
			</form>
		</div>

		<div id="shenhe">
			<table class="shenhe">
				<tr>
					<th>序号
					<th>
					<th>车牌号
					<th>
					<th>上传人
					<th>
					<th>上传时间
					<th>
					<th>车况状况
					<th>
					<th>审核人
					<th>
					<th>审核时间
					<th>
					<th>查看详情
					<th>
				</tr>
				<tr>
					<td>1
					<td>
					<td>京BL1234
					<td>
					<td>张三
					<td>
					<td>201<input type="text" name="select" value="请输入车牌号或驾驶员姓名 ">60123 14：34
					<td>
					<td>通过审核
					<td>
					<td>101号
					<td>
					<td>20160123 14：34
					<td>
					<td><a href="epeibao/vehicleMessage/vehicleMessage.jsp">点击查看</a>
					<td>
				</tr>
				<tr>
					<td>2
					<td>
					<td>京BL1234
					<td>
					<td>张三
					<td>
					<td>20160123 14：34
					<td>
					<td>未通过
					<td>
					<td>101号
					<td>
					<td>20160123 14：34
					<td>
					<td><a href="epeibao/vehicleMessage/vehicleMessage.jsp">点击查看</a>
					<td>
				</tr>
				<tr>
					<td>3
					<td>
					<td>京BL1234
					<td>
					<td>张三
					<td>
					<td>20160123 14：34
					<td>
					<td>通过审核
					<td>
					<td>101号
					<td>
					<td>20160123 14：34
					<td>
					<td><a href="epeibao/vehicleMessage/vehicleMessage.jsp">点击查看</a>
					<td>
				</tr>
				<tr>
					<td>4
					<td>
					<td>京BL1234
					<td>
					<td>张三
					<td>
					<td>20160123 14：34
					<td>
					<td>未通过
					<td>
					<td>101号
					<td>
					<td>20160123 14：34
					<td>
					<td><a href="epeibao/vehicleMessage/vehicleMessage.jsp">点击查看</a>
					<td>
				</tr>
				<tr>
					<td>5
					<td>
					<td>京BL1234
					<td>
					<td>张三
					<td>
					<td>20160123 14：34
					<td>
					<td>通过审核
					<td>
					<td>101号
					<td>
					<td>20160123 14：34
					<td>
					<td><a href="epeibao/vehicleMessage/vehicleMessage.jsp">点击查看</a>
					<td>
				</tr>
			</table>
		</div>
		<div id="foot">
			<a href="#">首页</a> <a href="#">上一页</a> <a href="#">下一页</a> <a
				href="#">尾页</a><span>第1页&nbsp共3页</span>
		</div>
	</div>
</body>
</html>
