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
	
	<link rel="stylesheet" type="text/css" href="css/vehicleMessage.css">
	
  </head>
  
  <body>
    <div id="box">
  	  <!--头部内容  -->
      <div id="top">
        <a href="#">车况检查首页</a>&gt;
        <a href="#">车况检查具体信息</a>
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
   
       <div id="photo">
          <table>
             <tr>
                <th>序号</th>
                <th>拍照部位</th>
                <th>原始车况照片</th>
                <th>上传车况照片</th>
                <th>审核状态</th>
             </tr>
             <tr>
                <td>1</td>
                <td>发动机</td>
                <td>
                   <img src="images/a.jpg" /><br/>
                   <a href="#">查看大图</a>
                </td>
                 <td>
                   <img src="images/a.jpg" /><br/>
                   <a href="#">查看大图</a>
                </td>
                <td>
                  <input type="radio" name="check" />审核通过&nbsp;&nbsp;
                  <input type="radio" name="check" /> 审核未通过 
                </td>
             </tr>
            <tr>
                <td>2</td>
                <td>前方车况</td>
                 <td>
                   <img src="images/b.jpg" /><br/>
                   <a href="#">查看大图</a>
                </td>
                 <td>
                   <img src="images/b.jpg" /><br/>
                   <a href="#">查看大图</a>
                </td>
                <td>
                 <input type="radio" name="check" />审核通过&nbsp;&nbsp;
                 <input type="radio" name="check" /> 审核未通过 
                </td>
             </tr>
          </table>
       </div>
       
       
       <!--线条  -->
       <div id="xiantiao2"></div>
       
    </div>
  </body>
</html>
