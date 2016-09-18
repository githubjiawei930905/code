<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'message.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/message.css">
		
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/message.js"></script>
<script type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
  </head>
  <script type="text/javascript">
	var str = "请输入消息内容";
	$(function(){
	
		$("#contect").focus(function(){
			$(this).text("");
		});
		$("#contect").blur(function(){
			var val = $(this).text();
			if(val=="" || val == null) $(this).text(str); 
		});
		
		$("#formRight ul li:eq(0)").click(function(){
			$(this).css("background-color","#3398DB");
			$("#formRight ul li:eq(1)").css("background-color","#FFF");
			$("#gotouserstatus").val("2");
		});
		$("#formRight ul li:eq(1)").click(function(){
			$(this).css("background-color","#3398DB");
			$("#formRight ul li:eq(0)").css("background-color","#FFF");
			$("#gotouserstatus").val("1");
		});
		
		$("input[type=radio]").attr("checked",'1');
	});
</script>
  <body>
  <div id="box">
    <form action="<%=basePath %>/backstage/message/addMessage.do" method="post">
      <!-- 左边部分 -->
      <div id="formLeft">
        <input id="first" type="text" name="title" value="请填入标题" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999" /> <br/>
        <textarea id="contect" name="content" >请输入消息内容</textarea>
      </div>
      <input id="gotouserstatus" name="gotouserstatus" value="2" type="hidden">
      <input id="userid" name="userid" value="${user.userid }" type="hidden">
      <!-- 右边部分 -->
      <div id="formRight">
         <ul class="manage">
            <li>驾驶员&nbsp;</li>
            <li>管理员&nbsp;</li>
         </ul>
         <p class="select">
           <span>此消息发给</span>
           <select>
              <option value="全部">全部</option>
              <option value="第一">第一</option>
              <option value="第二">第二</option>
              <option value="第三">第三</option>
              <option value="第四">第四</option>
              <option value="第五">第五</option>
           </select>
           <span>分公司</span>
         </p>
          <p class="select">
             <img src="images/-.png">
           <select>
              <option value="全部">全部</option>
              <option value="第一">第一</option>
              <option value="第二">第二</option>
              <option value="第三">第三</option>
              <option value="第四">第四</option>
              <option value="第五">第五</option>
           </select>
           <span>分队&nbsp;</span>
         </p>
          <p class="select">
             <img src="images/-.png">
           <select>
              <option value="全部">全部</option>
              <option value="第一">第一</option>
              <option value="第二">第二</option>
              <option value="第三">第三</option>
              <option value="第四">第四</option>
              <option value="第五">第五</option>
           </select>
           <span>小队&nbsp;</span>
         </p>
         
         <!--空白快  -->
         <div id="black"></div>
         <dl>
           <dt>&nbsp;此消息是否为重要消息</dt>
           <dd id="bacRed"><input type="radio" name="Messagelevel" value="1"/>是(需要回执)</dd>
           <dd id="bacGre"><input type="radio" name="Messagelevel" value="2"/>否(不需要回执)</dd>
         </dl>
      </div>
      <div style="float:right;">
     <span style="line-height: 43px;
font-size: 20px;
font-weight: 700;"> 到期时间</span>
<input type="text" id="d241" name="expiredofvalidity" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" style="width:250px;"/> 
</div>
 <div style="float:right;">
<input type="button" value="返回" id="button" style="margin : 20px; float:right; margin-top:15px; padding:7px 40px; font-size: 26px; line-height:40px; border:1px solid #41719C;  background-color: #3888CC; text-decoration:none;  color:#fff;">
<input type="submit" value="发送" id="submit" style="margin-top:15px; padding:7px 40px; font-size: 26px; line-height:40px; border:1px solid #41719C;  background-color: #3888CC; text-decoration:none;  color:#fff;">
     </div> 
    </form>
  </div>
  </body>
</html>
