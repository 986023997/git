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


<title>修改信息</title>
</head>
<body>
<div class="pd-20">	
  <form action="<%=basePath%>UpdatePasswordServlet"  method="post" class="form form-horizontal" id="form-member-add">
  	<%-- <input type="hidden" name="cuorseId" id="cuorseId" value=" ${map.courseId }" >
  	<input type="hidden" name="corpId" value="${map.corpId }"> --%>
  	<input type="hidden" name="User_id" value="${user.user_id}">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>旧密码：</label>
      <div class="formControls col-5">
        <input type="password" class="input-text"  placeholder="旧密码：" value="" id="oldpassword" datatype="*3-16" nullmsg="3-16位数"  name="oldpassword"> 
        <c:if test="${not empty error}">
		<p style="color: red ;font: weight:900">${error}</p>
		</c:if>
      </div>
      <div class="col-4" id="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>新密码：</label>
      <div class="formControls col-5">
        <input type="password" class="input-text"  placeholder="新密码"  value="" id="newpassword1"  name="newpassword1"  datatype="*3-16" nullmsg="3-16位数">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>重复新密码：</label>
      <div class="formControls col-5">
        <input type="password" class="input-text" value=""  placeholder="重复新密码" id="newpassword2" recheck="newpassword1" name="newpassword2"  datatype="*" nullmsg="密码不一致" >
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
<script type="text/javascript" src="<%=basePath%>js/Validform/5.3.2/Validform.js"></script>
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



