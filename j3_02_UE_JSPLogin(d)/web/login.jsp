
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Login</h1>
	<form>
		<p><input type="text" name="usr" placeholder="Username"/></p>
		<p><input type="password" name="pwd" placeholder="Password"/></p>
		<p><input type="submit" name="send" value="Login"/></p>
	</form>
	
	
<jsp:useBean id="loginBean" class="beans.LoginBean" scope="session"/>	
<%
if(request.getParameter("send")!=null){ //wenn submit
	out.print("send....");
	String usr = request.getParameter("usr"); 	
	String pwd = request.getParameter("pwd");
	if(loginBean.isValid(usr, pwd)){
		loginBean.setUsername(usr);
		response.sendRedirect("welcome");
	}
	
}

%>
</body>
</html>