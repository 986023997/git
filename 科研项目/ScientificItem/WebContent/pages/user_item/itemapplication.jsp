<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("webpath", path);
%>
<base href="<%=basePath%>">    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目申报</title>
</head>
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/skin.css" rel="stylesheet" type="text/css" id="skin" />
<link href="css/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet"
	type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/layer/1.9.3/layer.js"></script>
	<script type="text/javascript" src="js/H-ui.js"></script>
	<script type="text/javascript" src="js/H-ui.admin.js"></script>


<body>
<form action="ItemApplicationServlet" method="post">
 <!-- <label class="form-label col-3"><span class="c-red">*</span></label>
 <input type="text" class="input-text" name="Item_name"><br> -->
 <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span></label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="输入要申请的项目名称" id="chapterName" name="chapterName" datatype="*2-16" nullmsg="项目名不能为空">
      </div>
      <div class="col-4" id="col-4"> </div>
    </div>
 
<!-- 申请人：<input type="text" class="input-text" name="Item_app_id"><br> -->
申请时间：<input type="text" class="input-text" name="Item_date"><br>
项目主题：<input type="text" class="input-text" name="Item_topic"><br>
项目内容：<!-- <input type="text" class="textarea" name="Item_content"><br> -->
<textarea rows="10" cols="30" class="textarea" name="Item_content"></textarea><br>
项目预报经费：<input type="text" class="input-text" name="Item_fund"><br>
<!-- 审核文件：<input type="file" class="input-text" name="Item_name"><br> -->
<input type="submit" value="申请">
</form>
</body>
</html>