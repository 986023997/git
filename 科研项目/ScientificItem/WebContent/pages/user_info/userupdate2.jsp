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
<base href="<%=basePath%>">
<link href="<%=basePath%>css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>js/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>js/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<title>修改信息</title>
</head>
<body>
<div class="pd-20">
	
  <form action="UpdateUserServlet" method="post" class="form form-horizontal" id="form-member-add">
  
  	<%-- <input type="hidden" name="cuorseId" id="cuorseId" value=" ${map.courseId }" >
  	<input type="hidden" name="corpId" value="${map.corpId }"> --%>
  	<input type="hidden" name="User_id" value="${user.user_id}">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>员工姓名：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  placeholder="" id="User_realname"  name="User_realname" value="${user.user_realname}" readonly= >
      </div>
      <div class="col-4" id="col-4"> </div>
    </div>
    
    <%-- <div class="row cl">
      <label class="form-label col-3">性别：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" name="User_sex" value="" placeholder="${user.user_sex }"  id="User_sex"  >
      </div>
      <div class="col-4"> </div>
    </div> --%>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>性别</label>
      <div class="formControls col-5 skin-minimal">
        <div class="radio-box">
          <input type="radio" id="sex-1" name="User_sex"  value="男" datatype="*" nullmsg="请选择性别！">
          <label for="sex-1">男</label>
        </div>
        <div class="radio-box">
          <input type="radio" id="sex-2" name="User_sex" value="女">
          <label for="sex-2">女</label>
        </div>
      </div>
      <div class="col-4"> </div>
    </div>
    
    
    
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>年龄：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  placeholder="" id="User_age" name="User_age" value="${user.user_age }" datatype="*2-16" nullmsg="大于0小于100">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>邮箱：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  placeholder="" id="User_mail"  name="User_mail" value="${user.user_mail }" datatype="e" nullmsg="请输入邮箱" >
      </div>
      <div class="col-4" id="col-4"> </div>
    </div>
   
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>电话：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  placeholder="" id="User_phone"  name="User_phone" value="${user.user_phone }" datatype="m" nullmsg="请输入电话号码" >
      </div>
      <div class="col-4" id="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>住址：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  placeholder="" id="User_address"  name="User_address" value="${user.user_address }" datatype="*" nullmsg="请输入住址" >
      </div>
      <div class="col-4" id="col-4"> </div>
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