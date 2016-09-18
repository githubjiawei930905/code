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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<base href="<%=basePath%>">

<title>E培宝</title>
<link href="css/epeibao.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/epeibao.js"></script>
</head>
<body>
	<div id="box">
		<!--左边部分-->
		<div id="navlleft">
			<div id="title">logo E培宝</div> 
			<ul class="nav">
				<li style="background:url(images/xinxi.png) no-repeat;"><a
					href="<%=path %>/backstage/user/home.do" target="main">信 息 总 览</a></li>
				<li style=" background:url(images/fei.png) no-repeat;"><a
					href="epeibao/paymoney/payMoney.jsp" target="main">费 用 缴 纳</a></li>
				<li style=" background:url(images/yunying.png) no-repeat;"><a
					href="epeibao/operationData/operatingData.jsp" target="main">运
						营 数 据</a></li>
				<li style=" background:url(images/zonghe.png) no-repeat;"><a
					href="epeibao/operationData/Comprehensive.jsp" target="main">综
						合 数 据</a></li>
				<li style=" background:url(images/xiaoxi.png) no-repeat;"><a
					href="<%=path %>/backstage/message/Message.do" target="main">消 息 发 布</a></li>
				<li style=" background:url(images/chekuang.png) no-repeat;"><a
					href="epeibao/vehicleMessage/vehicleCheck.jsp" target="main">车
						况 检 查</a></li>
				<li style=" background:url(images/kaohe.png) no-repeat;"><a
					href="epeibao/kaohe/kaoheCheck.jsp" target="main">考 核 检 查</a></li>
				<li style=" background:url(images/tiku.png) no-repeat;"><a
					href="epeibao/shiti/shiti.jsp" target="main">题 库 编 辑</a></li>
				<li style=" background:url(images/zidingyi.png) no-repeat;"><a
					href="me.ss" target="main">自 定 义</a></li>
			</ul>
		</div>
		<!--右边部分-->
		<div id="navlright">
			<!--top左部分-->
			<div class="topleft">
				<p class="title">北京中寰天畅出租车有限公司</p>
				<p>总经理：${user.username}</p>
				<p>运营部：李总</p>
			</div>

			<!-- 竖条图片 -->
			<div id="imgtiao">
				<img src="images/biaotiao.png " />
			</div>

			<div class="topright">
				<!--top右部分-->
				<ul class="topShezhi dlfirst">
					<li><a href="#"><img src="images/daochu.png" /><br />导出</a></li>
				</ul>
				<ul class="topShezhi">
					<li><a href="#"><img src="images/msg.png" /><br />消息</a></li>
				</ul>
				<ul class="topShezhi">
					<li><a href="#"> <img src="images/shezhi.png" /><br />设置
					</a></li>
				</ul>
				<ul class="topShezhi dlfirst">
					<li><a href="#"> <img src="images/exist.png" /><br />退出
					</a></li>
				</ul>
			</div>

			<div id="whitetiao"></div>


			<div id="content">
				<iframe scrolling="no" src="<%=path %>/backstage/user/home.do"
					name="main" width="1160px" height="590px" style="border:0;"></iframe>
			</div>


  </div>
</div>
 
</body>
</html>
