<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

<link rel="stylesheet" type="text/css" href="css/vehicleCheck.css">


<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/vehicleCheck.js"></script>	

  </head>
  
  <body>
    <div id="box">
       <!--上部分  -->
       <div id="top">
          <ul>
            <li style="background-color:#5B9BD5"><a>未审核</a></li>
            <li><a>已审核</a></li>
          </ul>
         <!--  <form action="#" method="post">
             <input type="submit" value="未审核 " style="width:140px; height:40px; border: 1px solid #41719C; color: #48C7F5; line-height: 40px; font-size: 28px; text-align: center; border-radius:5px 5px 5px 5px;" /> 
             <input type="submit" value="已审核" style="width:140px; height:40px; border: 1px solid #41719C; color: #48C7F5; line-height: 40px; font-size: 28px; text-align: center; border-radius:5px 5px 5px 5px;" >
          </form> -->
          <form action="#" method="post" style="margin-left: 250px;">
             <input type="text" value="请输入监督卡号或驾驶员姓名 " /> 
             <input type="submit" value="查询" style="width: 160px; height: 40px;  background-color:#203864; border: 1px #7F7F7F solid; color: white; font-weight: 700; border-radius:5px 5px 5px 5px;" >
          </form>
       </div>
       
        <div id="shenhe">
       	   <table class="shenhe">
             <tr>
               <th>序号<th>
               <th>监督卡号<th>
               <th>上传人<th>
               <th>上传时间<th>
               <th>考核状态<th>
               <th>审核人<th>
               <th>审核时间<th>
               <th>查看详情<th>
             </tr>
             <tr>
               <td>1<td>
               <td>2134567<td>
               <td>张三 <td>
               <td>20160123 14：34<td>
               <td>通过审核 <td>
               <td>101号 <td>
               <td>20160123 14：34<td>
               <td><a href="epeibao/vehicleMessage/kaoheMessage.jsp">点击查看</a><td>
             </tr>
              <tr>
               <td>2<td>
               <td>京BL1234<td>
               <td>张三 <td>
               <td>20160123 14：34<td>
               <td>未通过  <td>
               <td>101号 <td>
               <td>20160123 14：34<td>
               <td><a href="epeibao/vehicleMessage/kaoheMessage.jsp">点击查看</a><td>
             </tr>
             <tr>
               <td>3<td>
               <td>京BL1234<td>
               <td>张三 <td>
               <td>20160123 14：34<td>
               <td>通过审核 <td>
               <td>101号 <td>
               <td>20160123 14：34<td>
               <td><a href="epeibao/vehicleMessage/kaoheMessage.jsp">点击查看</a><td>
             </tr>
             <tr>
               <td>4<td>
               <td>京BL1234<td>
               <td>张三 <td>
               <td>20160123 14：34<td>
               <td>未通过  <td>
               <td>101号 <td>
               <td>20160123 14：34<td>
               <td><a href="epeibao/kaohe/kaoheMessage.jsp">点击查看</a><td>
             </tr>
             <tr>
               <td>5<td>
               <td>京BL1234<td>
               <td>张三 <td>
               <td>20160123 14：34<td>
               <td>通过审核 <td>
               <td>101号 <td>
               <td>20160123 14：34<td>
               <td><a href="epeibao/kaohe/kaoheMessage.jsp">点击查看</a><td>             </tr>
          </table>
       </div>
       
       <div id="weishenhe">
          <table class="weishenhe">
             <tr>
               <th>序号<th>
               <th>车牌号<th>
               <th>上传人<th>
               <th>上传时间<th>
               <th>车况状况<th>
               <th>审核人<th>
               <th>审核时间<th>
               <th>查看详情<th>
             </tr>
             <tr>
               <td>6<td>
               <td>京BL1234<td>
               <td>张三 <td>
               <td>20160123 14：34<td>
               <td>通过审核 <td>
               <td>101号 <td>
               <td>20160123 14：34<td>
               <td><a href="epeibao/kaohe/kaoheMessage.jsp">点击查看</a><td>
             </tr>
              <tr>
               <td>7<td>
               <td>京BL1234<td>
               <td>张三 <td>
               <td>20160123 14：34<td>
               <td>未通过  <td>
               <td>101号 <td>
               <td>20160123 14：34<td>
               <td><a href="epeibao/kaohe/kaoheMessage.jsp">点击查看</a><td>
             </tr>
             <tr>
               <td>8<td>
               <td>京BL1234<td>
               <td>张三 <td>
               <td>20160123 14：34<td>
               <td>通过审核 <td>
               <td>101号 <td>
               <td>20160123 14：34<td>
               <td><a href="epeibao/kaohe/kaoheMessage.jsp">点击查看</a><td>
             </tr>
             <tr>
               <td>9<td>
               <td>京BL1234<td>
               <td>张三 <td>
               <td>20160123 14：34<td>
               <td>未通过  <td>
               <td>101号 <td>
               <td>20160123 14：34<td>
               <td><a href="epeibao/kaohe/kaoheMessage.jsp">点击查看</a><td>
             </tr>
             <tr>
               <td>10<td>
               <td>京BL1234<td>
               <td>张三 <td>
               <td>20160123 14：34<td>
               <td>通过审核 <td>
               <td>101号 <td>
               <td>20160123 14：34<td>
               <td><a href="epeibao/kaohe/kaoheMessage.jsp">点击查看</a><td>
             </tr>
             
          </table>
       </div>
       
      
       
    </div>
  </body>
</html>
