<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>
</head>
<body>
<table border="1" align="center" cellpadding="10" width="800">
<tr>
    <th colspan="7" bgcolor="BurlyWood" >我的个人信息</th>
</tr>
<tr>
    <th bgcolor="BurlyWood">账号:</th>
    <td>${user.user_name}</td>
    <th bgcolor="BurlyWood">姓名:</th>
    <td>${user.user_realname}</td>
    <td rowspan="3" width="100"
    <p>
    <a href="https://www.so.com/s?ie=utf-8&shb=1&src=home_tab_image&q=%E4%BB%A3%E5%BA%94%E8%B1%AA"><img border="0" src="images/timg.jpg" width="300" height="250">
    </a>
    </p>>
</td>
</tr>
 
<tr>
    <th bgcolor="BurlyWood">性别</th>
    <td>${user.user_sex}</td>
    <th bgcolor="BurlyWood">部门</th>
    <td>${department_name}</td>
</tr>
 
<tr>
    <th bgcolor="BurlyWood">邮箱</th>
    <td>${user.user_mail}</td>
    <th bgcolor="BurlyWood">电话:</th>
    <td>${user.user_phone}</td>
</tr>
 
 <tr>
   <th bgcolor="BurlyWood"  >入职时间：</th>
   <td colspan="6">${user.user_date}</td>
</tr>
 
 
<tr>
   <th bgcolor="BurlyWood"  >住址：</th>
   <td colspan="6">${user.user_address}</td>
</tr>
 
 </table>
</body>
</html>