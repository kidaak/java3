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

<h1>Hallo JSP</h1>

<%
	out.print("Hallo...");
	
%>

<jsp:useBean id="personBean"   class="beans.PersonBean" scope="session" />

<%
	personBean.setName("Max");

%>

<!-- 	 Language  -->

<h1>${personBean.name}</h1> <!-- personBean.getName() -->

<ul>
	<c:forEach var="freund" items="${personBean.freunde}">
		<li>${freund}</li>
	</c:forEach>
	

</ul>

</body>
</html>