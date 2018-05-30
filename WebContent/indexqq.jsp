<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	注册成功，您的注册信息为：<br/>
用户名：${user.username}<br/>
密码：${user.password}<br/>
email:${user.email}<br/>
头像：<img alt="头像" src="${user.imgurl}">
请<a href="${pageContext.request.contextPath}/index.jsp">登录</a>
</body>
</html>