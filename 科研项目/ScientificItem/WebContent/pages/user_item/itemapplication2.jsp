<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
           + request.getServerName() + ":" + request.getServerPort()
           + path + "/";
%>
<link href="<%=basePath%>css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>js/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>js/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>项目申报</title>
</head>
<body>
<div class="pd-20">
	
  <form action="<%=basePath%>ItemApplicationServlet"  method="post" class="form form-horizontal" id="form-member-add">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>项目名：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="输入要创建的项目名称" id="Item_name" name="Item_name" datatype="*2-16" nullmsg="项目名不能为空">
      </div>
      <div class="col-4" id="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3">申请主题</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="申请的主题"  id="Item_topic" name="Item_topic" datatype="*" nullmsg="主题不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3">项目预报经费</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="资金"  id="Item_fund" name="Item_fund" datatype="n" nullmsg="项目名不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3">申请日期</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="日期"  id="Item_date" name="Item_date" datatype="*" nullmsg="日期不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>内容</label>
      <div class="formControls col-5">
        <textarea rows="10" cols="30" class="textarea" name="Item_content" datatype="*" nullmsg="项目名不能为空"></textarea>
      </div>
      <div class="col-4"> </div>
    </div>
     
    
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
    
  </form>

</div>

<script type="text/javascript" src="<%=basePath%>js/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>js/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>js/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>js/H-ui.js"></script> 
<script type="text/javascript" src="<%=basePath%>js/H-ui.admin.js"></script>
<script type="text/javascript">
$(function(){
	var flag=false;
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	 $("#form-member-add").Validform({
		tiptype:2,
		callback:function(form){
			
			//var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			//var index = parent.layer.getFrameIndex(window.name);
			//form[0].submit();
		}
	});
	 
	 
});
</script>
</body>
</html>