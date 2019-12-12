<!DOCTYPE html>
<html lang="en">
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>txt</title>

<link rel="stylesheet" type="text/css" href="css/style1.css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/vector.js"></script>

</head>
<body>

<div id="container">
	<div id="output">
		<div class="containerT">
			<h1>用户登录</h1>
			<p style="color: red ;font: weight:900">${msg}</p>
			<form class="form" id="entry_form" action="LoginServlet" method="post">
				<input type="text" placeholder="用户名" name="User_name" value="admin">
				<input type="password" placeholder="密码" name="User_password">
				<!-- <button type="button" id="entry_btn">登录</button> -->
				<input type="submit" id="entry_btn" value="登录">
				<div id="prompt" class="prompt"></div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
    $(function(){
        Victor("container", "output");   //登录背景函数
        $("#entry_name").focus();
        $(document).keydown(function(event){
            if(event.keyCode==13){
                $("#entry_btn").click();
            }
        });
    });
</script>
