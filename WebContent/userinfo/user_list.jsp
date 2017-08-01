<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath(); 

String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%> 	
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表显示</title>
<script type="text/javascript">
function add(){
	window.location= "<%=basePath %>userinfo/user_add.jsp";
}
</script>
</head>
<body>
	<div align="center">
		<form action="user/list.do" method="post">
			<h1>用户信息查询</h1>
			编号：<input type="text" name="userId" />
			 姓名：<input type="text" name="userName" /> 
			 <input type="submit" value="查询" />
			 <input type="button" value="添加" onclick="add()"/>
		</form>

	</div>

	<table border="1" align="center" width="80%">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>生日</th>
		</tr>
		<c:forEach items="${list }" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.userAge}</td>
				<td>${user.userSex}</td>
				<td><fmt:formatDate value="${user.userBrithday }"
						pattern="yyyy年MM月dd日" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>