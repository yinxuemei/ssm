<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 时间格式yyyy年mm月dd日 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- display表格插件引入 -->
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表显示</title>
<script type="text/javascript">
    function add(){
	window.location= "<%=basePath%>userinfo/user_add.jsp";
	}
	function delUser(){
		//判断是否选中
		var userIds=document.getElementsByName("userIds");
		var mark=false;
		for(var i =0;i<userIds.length;i++){
			if(userIds[i].checked){
				mark = true;
				break;
			}
		}
		if(mark && confirm("确定要删除用户信息！")){
			//获取表单元素对象
			var f1=document.getElementById("f1");
			f1.action='<%=basePath%>user/deleteUser.do';//改变提交目的地（url）
			f1.submit();
		} else {
			alert("请选择一个用户");
		}
	}
</script>
<style type="text/css">
.tab{ width: 90%;
	text-align: center;
	background-color: green;
}

.tab tr th { background-color: white;}

.tab tr td { background-color: white;}
</style>
</head>
<body>
	<form action="user/list.do" method="post" id="f1">
		<div align="center">

			<h1>用户信息查询</h1>
			编号：<input type="text" name="userId" /> 姓名：<input type="text"
				name="userName" /> <input type="submit" value="查询" /> <input
				type="button" value="添加" onclick="add()" /> <input type="button"
				value="删除" onclick="delUser()" />


		</div>

		<display:table  name="list" class="tab" export="true" sort="list" pagesize="10" requestURI="user/list.do">
			<display:column property="delId" title="<input type='checkbox'>" />
			<display:column property="userId" title="编号" sortable="true"/>
			<display:column property="userName" title="姓名" />
			<display:column property="userSex" title="性别" sortable="true"/>
			<display:column property="userAge" title="年龄"/>
			<display:column property="userBrithday" title="日期"/>
			<display:column value="sssswww@qq.com" autolink="true" title="电子邮件"/>
			<display:column value="http://www.baidu.com" autolink="true" title="电子邮件"/>
			<display:column href="user/loadUser.do" paramId="userId" paramProperty="userId" value="修改" title="修改" />
		</display:table>
		<%-- <table border="1" align="center" width="80%">
			<tr>
				<th></th>
				<th>编号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>生日</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list }" var="user">
				<tr>
					<td><input type="checkbox" name="userIds"
						value="${user.userId }" /></td>

					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.userAge}</td>
					<td>${user.userSex}</td>
					<td><fmt:formatDate value="${user.userBrithday }"
							pattern="yyyy年MM月dd日" /></td>
					<td><a href="user/loadUser.do?userId=${user.userId }">修改</a></td>
			</c:forEach>
		</table> --%>
	</form>
</body>
</html>