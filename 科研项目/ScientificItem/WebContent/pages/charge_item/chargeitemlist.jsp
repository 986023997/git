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
<link href="<%=basePath%>css/H-ui.min.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>css/H-ui.admin.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>js/Hui-iconfont/1.0.1/iconfont.css"
	rel="stylesheet" type="text/css" />
<title>项目</title>
</head>
<body>
	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i> 首页
	<span class="c-gray en">&gt;</span> 部门项目管理 <span class="c-gray en">&gt;</span>
	查看所有项目<a class="btn btn-success radius r mr-20"
		style="line-height: 1.6em; margin-top: 3px"
		href="javascript:location.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="pd-20">
		<div class="text-c">

		</div>


	<div>
	<%-- <form action="<%=basePath%>QuestionBank/showAllQuestion">
	 <span>	
				课程：
				<select  id="course" name="courseId" onchange="getchapter()">
  								<option value ="">请选择</option>
  							<c:forEach items="${couses}" var="c">
  								<option value ="${c.id}">${c.courseName }</option>
  							</c:forEach>
							</select>
						<!-- 显示所有的章节 -->
							章节：<select name="chapterId" id="chapter">
  							<option value ="">请选择：</option>
							</select>
					<input  type="submit" class="btn btn-success" value="查询">
	</span>
</form> --%>
	 </div>
		
		
		
		<div class="mt-20">
	
			<table
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
				<tr>				
					</tr>
					<tr class="text-c">
						<th width="60">序号</th>
						<th width="180">项目名</th>
						<th width="180">主题</th>
						<th width="90">内容</th>
						<th width="130">资金</th>
						<th width="90">部门审核</th>
						<th width="130">审核人</th>
						<th width="90">科研审核</th>
						<th width="130">审核人</th>
						<th width="130">审核</th>
					</tr>
				</thead>

				<c:forEach items="${items}" var="que" varStatus="status">
					<tbody>
						<tr class="text-c">
							<td>${status.index+1 }</td>
							<td>${que.item_name}</td>
							<td>${que.item_topic}</td>
							<td><a title="内容" href="javascript:;" onclick="paper_edit('查看内容','ShowContentServlet?Id=${que.item_id}','','400','500')" class="ml-5" style="text-decoration: none">查看内容</a></td>
							<td>${que.item_fund}</td>
							<c:if test="${que.item_status1==0}">
								<td>待审核</td>
							</c:if>
							<c:if test="${que.item_status1==1}">
								<td>通过</td>
							</c:if>
							<c:if test="${que.item_status1 ==2 }">
								<td>拒绝</td>
							</c:if>
							<c:if test="${empty que.item_Check_id1}">
								<td>暂无</td>
							</c:if>
							<c:if test="${not empty que.item_Check_id1}">
								<td>${que.item_Check_id1}</td>
							</c:if>
							<c:if test="${que.item_status2 ==0}">
							<td>待审核</td>
							</c:if>
							<c:if test="${que.item_status2 ==1}">
								<td>通过</td>
							</c:if>
							<c:if test="${que.item_status2 ==2 }">
								<td>拒绝</td>
							</c:if>
							<c:if test="${empty que.item_Check_id2 }">
								<td>暂无</td>
							</c:if>
							<c:if test="${not empty que.item_Check_id2 }">
								<td>${que.item_Check_id2}</td>
							</c:if>
					<!-- 是否替换为课程和章节 -->
							<td class="f-14">
								<%-- <a title="修改" href="javascript:;" onclick="paper_edit('试卷修改','paper/toPaperUpdatePage?paperId=${choosePaperVO.paperId}','2','800','500')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont"></i></a> --%>
								<%-- <a title="通过" href="javascript:;" onclick="paper_edit('修改','UpdateItemUIServlet?Id=${que.item_id}','','400','500')" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont"></i></a> --%>
								<a title="通过" href="ChargeItemCheckServlet?Id=${que.item_id}&status=1" ><i class="Hui-iconfont" onclick="return confirmd()" >通过</i></a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a title="拒绝" href="ChargeItemCheckServlet?Id=${que.item_id}&status=2" ><i class="Hui-iconfont" onclick="return confirmd()" >拒绝</i></a>
							</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
			
		<%-- <c:if test="${infos.pages>1}">
	
		 <div style="text-align:center;font-size: 20px;height: 50px;">
  
      				当前 ${infos.pageNum}页,总${infos.pages}页,总 ${infos.total} 条记录 
  					<a href="<%=basePath%>QuestionBank/showAllQuestion?pagenum=1&chapterId=${chapterId}">首页</a>   
  					<c:if test="${infos.hasPreviousPage }">
   							<a href="<%=basePath%>QuestionBank/showAllQuestion?pagenum=${infos.pageNum-1}&chapterId=${chapterId}">上一页</a>
 					</c:if>
    
      
  					<c:forEach items="${infos.navigatepageNums}" var="pagenumber">
  							<a href="<%=basePath%>QuestionBank/showAllQuestion?pagenum=${pagenumber}&chapterId=${chapterId}">${pagenumber}</a> 
  					</c:forEach>
  
  
  					<c:if test="${infos.hasNextPage }">
   							<a href="<%=basePath%>QuestionBank/showAllQuestion?pagenum=${infos.pageNum+1}&chapterId=${chapterId}">下一页</a>
   					</c:if>  
    						<a href="<%=basePath%>QuestionBank/showAllQuestion?pagenum=${infos.pages}&chapterId=${chapterId}">末页</a>   
  
  </div>					
			</c:if>		 --%>
			
			
		</div>
	</div>

	<script type="text/javascript"
		src="<%=basePath%>js/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/layer/1.9.3/layer.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/laypage/1.2/laypage.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/H-ui.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/H-ui.admin.js"></script>
	<!-- 弹出层 js -->
	<script type="text/javascript">
		/*
			参数解释：
			title	标题
			url		请求的url
			id		需要操作的数据id
			w		弹出层宽度（缺省调默认值）
			h		弹出层高度（缺省调默认值）
		*/
		
	
		/*试卷修改*/
		function paper_edit(title,url,id,w,h){
			layer_show(title,url,w,h);
		}
		function confirmd() {  
            var msg = "确定执行该操作？";  
            if (confirm(msg)==true){  
                return true;  
            }else{  
                return false;  
            }  
        }  
		
		var XMLHttp;
		function createXMLHttpRequest(){
			if(window.XMLHttpRequest){
				  // code for IE7+, Firefox, Chrome, Opera, Safari						
					XMLHttp = new XMLHttpRequest();
				}else if(window.ActiveObject){	
				 // code for IE6, IE5										
					XMLHttp= new ActiveObject("Microsoft.XMLHTTP");
				}
		}
			
			function getchapter(){
				createXMLHttpRequest();
			var courseid=document.getElementById("course").value;
			if(XMLHttp!=null){
			XMLHttp.open("POST","QuestionBank/selectChapter",true);
			XMLHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
			XMLHttp.onreadystatechange=processRequest;
			XMLHttp.send("id="+courseid);
			
			}else{
				alert("不能创建XMLHttpRequest对象实例")
			}
			}
			
			function processRequest(){
				
				if(XMLHttp.readyState==4){
					if(XMLHttp.status==200){
						var  chapterSelect=	document.getElementById("chapter")
						var  chapteroption=chapterSelect.getElementsByTagName("option");
						while(chapteroption.length>1){
							
							chapter.removeChild(chapteroption[1]);
						}
						//alert(XMLHttp.responseText);
						var proArray=eval(XMLHttp.responseText);
						for(var i=0;i<proArray.length;i++){
							//alert(proArray.length);
			
							var pro=proArray[i];
							//alert(pro);
							var optionEle=document.createElement("option");
							optionEle.value=pro.chapterId;
							var textNode=document.createTextNode(pro.chapterName);
							optionEle.appendChild(textNode);
							document.getElementById("chapter").appendChild(optionEle);
								
						}
					}
				}
			}
			
			
		
		
		
		
		
		
	</script>
	
	
</body>
</html>