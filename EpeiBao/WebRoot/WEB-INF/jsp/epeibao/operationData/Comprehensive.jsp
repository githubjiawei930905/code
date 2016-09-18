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
	
	<link rel="stylesheet" type="text/css" href="css/Comprehensive.css">
	
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
            <input type="text" name="busNumOrName" value="请输入车牌号或驾驶员姓名 " class="inputText" />
            <input type="submit" value="查询" class="inputSubmit"/>
       </form>
      </div>
      
      <!-- 显示的内容 -->
      <div id="content">
           <table>
              <tr>
                 <th>机构</th>
                 <th>已缴费</th>
                 <th>已通过车况检查</th>
                 <th>已通过考核</th>
                 <th>已上传运营数据</th>
                 <th>车辆数</th>
              </tr>
              <tr>
                  <td>第一分公司</td>
                  <td>56</td>
                  <td>76</td>
                  <td>34</td>
                  <td>34</td>
                  <td>100</td>
              </tr>
              <tr>
                  <td>第二分公司</td>
                  <td>56</td>
                  <td>76</td>
                  <td>34</td>
                  <td>34</td>
                  <td>100</td>
              </tr>
              <tr>
                  <td>第三分公司</td>
                  <td>56</td>
                  <td>76</td>
                  <td>34</td>
                  <td>34</td>
                  <td>100</td>
              </tr>
              <tr>
                  <td>第四分公司</td>
                  <td>56</td>
                  <td>76</td>
                  <td>34</td>
                  <td>34</td>
                  <td>100</td>
              </tr>
              <tr>
                  <td>第五分公司</td>
                  <td>56</td>
                  <td>76</td>
                  <td>34</td>
                  <td>34</td>
                  <td>100</td>
              </tr>           
              
           </table>
      </div>
  
  </div>
    
  </body>
</html>
