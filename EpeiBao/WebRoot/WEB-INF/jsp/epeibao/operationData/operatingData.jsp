<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'operatingData.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/operatingData.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/operatingData.js"></script>
  </head>
  
  <body>
  <div id="box">
  	  <!--头部内容  -->
      <div id="top">
        <a href="#">北京中寰天畅出租车有限公司</a>&gt;
        <a href="#">第一分公司</a>&gt;
      	<a href="#">第一小队</a>&gt;
      	<a href="#">京B 74110</a>
      </div>
      
      <div id="search">
      <form action="" method="post">
            <input type="text" name="busNumOrName" value="请输入车牌号或驾驶员姓名 " class="inputText"  />
            <input type="submit" value="查询" class="inputSubmit"/>
       </form>
      </div>
      
      <!-- 显示的内容 -->
      <div id="content">
           <table>
              <tr>
                 <th>机构</th>
                 <th>采集车数</th>
                 <th>总运次</th>
                 <th>人均月收入</th>
                 <th>月行驶里程</th>
                 <th>平均空驶率</th>
              </tr>
              <tr>
                  <td>第一分公司</td>
                  <td>60/100</td>
                  <td>28</td>
                  <td>890</td>
                  <td>2000</td>
                  <td>78%</td>
              </tr>
             <tr>
                  <td>第二分公司</td>
                  <td>60/100</td>
                  <td>28</td>
                  <td>890</td>
                  <td>2000</td>
                  <td>78%</td>
              </tr>
              <tr>
                  <td>第三分公司</td>
                  <td>60/100</td>
                  <td>28</td>
                  <td>890</td>
                  <td>2000</td>
                  <td>78%</td>
              </tr>
              <tr>
                  <td>第四分公司</td>
                  <td>60/100</td>
                  <td>28</td>
                  <td>890</td>
                  <td>2000</td>
                  <td>78%</td>
              </tr>
              <tr>
                  <td>第五分公司</td>
                  <td>60/100</td>
                  <td>28</td>
                  <td>890</td>
                  <td>2000</td>
                  <td>78%</td>
              </tr>     
              
           </table>
      </div>
      

  </div>
    
  </body>
</html>
