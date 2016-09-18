<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'VehicleMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/kaoheMessage.css">
	
  </head>
  
  <body>
    <div id="box">
  	  <!--头部内容  -->
      <div id="top">
        <a href="#">考核查看首页</a>&gt;
        <a href="#">考核检查具体信息</a>
      </div>
      
      <!-- 显示的内容 -->
      <div id="content">
          <table>
              <tr>
                 <th>所属机构 </th>
                 <th>车牌号 </th>
                 <th>上传人</th>
                 <th>联系电话</th>
                 <th>上传时间</th>
              </tr>
              <tr>
                 <td>天畅出租公司1分公司1大队2小队</td>
                 <td>京BL1234</td>
                 <td>张三</td>
                 <td>13370189628</td>
                 <td>20160123 14：34</td>
              </tr>
          </table>
       </div>
       
       <!--线条  -->
       <div id="xiantiao1"></div>
   
       <div id="shiping">
          <table>
             <tr>
                <th>司机照片</th>
                <th>审核视频</th>
                <th>审核状态</th>
                <th>备注</th>
             </tr>
             <tr>
                <td>
                   <img src="images/a.jpg" /><br/>
                   <a href="#">查看大图</a>
                </td>
                 <td>
                   <video src="video/aaaa.mp4" autoplay="autoplay" loop="loop" controls="controls"/><br/>
                   <a href="#">查看大图</a>
                </td>
                <td>
                  <input type="radio" name="check" />审核通过&nbsp;&nbsp;
                  <input type="radio" name="check" /> 审核未通过 
                </td>
                <td style="width:120px;"></td>
             </tr>
            
          </table>
       </div>
       
       
       <!--线条  -->
       <div id="xiantiao2"></div>
       
    </div>
  </body>
</html>
