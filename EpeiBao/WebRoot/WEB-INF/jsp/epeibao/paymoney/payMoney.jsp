<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'payMoney.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link rel="stylesheet" type="text/css" href="css/payMoney.css">
	

  </head>
  
  <body>
   <div id="box">
     <div id="search">
      <form action="" method="post">
            <input  type="text" name="busNumOrName" value="请输入车牌号或驾驶员姓名 " class="inputText" />
            <input type="submit" value="查询"  class="inputSubmit" />
       </form>
      </div>
      
      <!-- 显示的内容 -->
      <div id="content">
           <table>
              <tr>
                 <th>车牌号</th>
                 <th>缴费时间</th>
                 <th>缴费金额</th>
                 <th>缴费人</th>
                 <th>缴费确认人</th>
               </tr>
              <tr>
                  <td>BL1234</td>
                  <td>2016年5月13日</td>
                  <td>5175元</td>
                  <td>张三</td>
                  <td>李四</td>
              </tr>
          </table>
        </div>
   </div>      
  </body>
</html>
